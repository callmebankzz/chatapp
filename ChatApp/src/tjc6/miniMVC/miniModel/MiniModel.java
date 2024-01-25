package tjc6.miniMVC.miniModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import javax.swing.JComponent;

import tjc6.foreign.ButtonDataCmd;
import tjc6.foreign.IButtonData;
import tjc6.foreign.IMapsData;
import tjc6.foreign.IPanelData;
import tjc6.foreign.MapsDataCmd;
import tjc6.foreign.PanelDataCmd;
import tjc6.microMVC.utils.GameInitMsg;
import tjc6.microMVC.utils.IGameInitMsg;
import common.dataPacket.ARoomDataPacketAlgoCmd;
import common.dataPacket.ICmd2ModelAdapter;
import common.dataPacket.RoomDataPacket;
import common.dataPacket.RoomDataPacketAlgo;
import common.dataPacket.data.IRoomConnectionData;
import common.dataPacket.data.room.ICmdData;
import common.dataPacket.data.room.ICmdRequestData;
import common.dataPacket.data.room.IPacketListData;
import common.dataPacket.data.room.ITextData;
import common.dataPacket.data.status.IErrorStatusData;
import common.dataPacket.data.status.IFailureStatusData;
import common.dataPacket.data.status.IRejectStatusData;
import common.serverObj.INamedAppConnection;
import common.serverObj.INamedRoomConnection;
import common.serverObj.INamedRoomID;
import common.serverObj.IRoomConnection;
import provided.datapacket.IDataPacketID;
import provided.logger.ILogger;
import provided.logger.LogLevel;
import provided.mixedData.MixedDataDictionary;
import provided.mixedData.MixedDataKey;
import provided.pubsubsync.IPubSubSyncChannelUpdate;
import provided.pubsubsync.IPubSubSyncUpdater;

/**

 * Model for the miniMVC
 * @author tinaw
 * @author tyrac
 */
public class MiniModel {

	/**
	 * Adapter from mini-model to mini-view
	 */
	private IMiniModel2MiniViewAdapter _m2vAdpt;

	/**
	 * Adapter from mini-model to mini-controller
	 */
	private IMiniModel2MiniCtrlAdapter _mm2cAdpt;

	/**
	 * The system logger in use
	 */
	private ILogger _sysLogger;

	/**
	 * The RMI Server instance that receives inbound messages (datapackets) for the room
	 */
	private IRoomConnection _msgRecvr;

	/**
	 * A stub of the local MessageReceiver
	 */
	private IRoomConnection _msgRecvrStub;

	/**
	 * An instance of an INamedAppConnection object.
	 */
	private INamedAppConnection namedAppConnection;

	/**
	 * A name-stub dyad
	 */
	private INamedRoomConnection _namedMsgRecvr;

	/**
	 * The extended visitor instance that processes the inbound messages (datapackets)
	 */
	private RoomDataPacketAlgo _msgProcessor;

	/**
	 * A set of IMessageReceiver stubs representing the room roster. Used for sending
	 * outbound messages.
	 */
	private HashSet<INamedRoomConnection> _roster = new HashSet<>();

	/**
	 * The command-to-mini-model adapter to be installed in any received commands
	 */
	private ICmd2ModelAdapter _cmd2mAdpt;

	/**
	 * The PubSubSync channel associated with this chatroom
	 */
	private IPubSubSyncChannelUpdate<HashSet<INamedRoomConnection>> _channel;

	/**
	 * A mapping from unknown message IDs to a list of unprocessed messages
	 */
	private ConcurrentHashMap<IDataPacketID, List<RoomDataPacket<? extends IRoomConnectionData>>> _buffer = new ConcurrentHashMap<>();

	/**
	 * A mixed data dictionary used to store scores/votings/etc
	 */
	private MixedDataDictionary mixedDataDictionary = new MixedDataDictionary();

	/**
	 * Main model server id
	 */
	private UUID _mainModelID = UUID.randomUUID();

	/**
	 * Creates a new MiniModel.
	 *  	 
	 * 	@param sysLogger The logger in use
	 * 	@param m2vAdpt The mini-model to mini-view adapter
	 * 	@param mm2cAdpt The mini-model to mini-control adapter
	 */
	public MiniModel(INamedAppConnection namedAppConnection, ILogger sysLogger, IMiniModel2MiniViewAdapter m2vAdpt,
			IMiniModel2MiniCtrlAdapter mm2cAdpt) {

		this._m2vAdpt = m2vAdpt;
		this._mm2cAdpt = mm2cAdpt;
		this._sysLogger = sysLogger;
		this.namedAppConnection = namedAppConnection;

		_msgProcessor = new RoomDataPacketAlgo(new ARoomDataPacketAlgoCmd<IRoomConnectionData>() {

			/**
			 * Serial version UID.
			 */
			private static final long serialVersionUID = -3635742386793192074L;

			/**
			 * Default command for an unknown message type.
			 */
			@Override
			public Void apply(IDataPacketID index, RoomDataPacket<IRoomConnectionData> host, Void... params) {
				(new Thread(() -> {

					/* Add unknown message to buffer */
					if (_buffer.containsKey(host.getData().getID())) {
						_buffer.get(host.getData().getID()).add(host);
					} else {
						_buffer.put(host.getData().getID(), Arrays.asList(host));
					}

					/* Send request for unknown cmd to sender */
					_sysLogger.log(LogLevel.DEBUG, "Sending RequestCmdMessage!");
					IDataPacketID unknownCmdID = host.getData().getID();

					ICmdRequestData requestCmdData = ICmdRequestData.make(unknownCmdID);
					RoomDataPacket<ICmdRequestData> packet = new RoomDataPacket<>(requestCmdData, _namedMsgRecvr);

					try {
						host.getSender().sendMessage(packet);
					} catch (RemoteException e) {
						_sysLogger.log(LogLevel.ERROR, "Unable to deliver ICmdRequestData to "
								+ host.getSender().toString() + ": " + e.toString());
						e.printStackTrace();
					}

				})).start();

				return null;
			}
		});

		this._cmd2mAdpt = new ICmd2ModelAdapter() {

			@Override
			public void displayText(String text) {
				_m2vAdpt.displayMsg(text);
			}

			@Override
			public Runnable displayJComponent(String label, Supplier<JComponent> component) {
				// Ignoring label for now unless we need it later
				_m2vAdpt.displayJComponent(component);
				//TODO: figure out what this should return instead.
				return null;
			}

			@Override
			public String getUsername() {
				return _mm2cAdpt.getUsername();
			}

			@Override
			public String getRoomName() {
				return _mm2cAdpt.getRoomName();
			}

			@Override
			public <T extends IRoomConnectionData> void sendMessageToRoom(T data) {
 				// Send message to everyone in roster
				for (INamedRoomConnection connection : _roster)
					this.sendMessageToDyad(data, connection);
			}

			@Override
			public <T extends IRoomConnectionData> void sendMessageToDyad(T data, INamedRoomConnection dyad) {
				// We are choosing not to implement this command because we believe it enables bad security practices and we fundamentally disagree with its inclusion.
			}

			@Override
			public String getAPIKey() {
				// TODO Auto-generated method stub
				return "AIzaSyBJi9s51y_A3CSQTG5ZBt9s_7ZWDLR-ig0";
			}

			@Override
			public <T> T putLocalData(MixedDataKey<T> key, T value) {
				return mixedDataDictionary.put(key, value);
			}

			@Override
			public <T> T getLocalData(MixedDataKey<T> key) {
				return mixedDataDictionary.get(key);
			}

			@Override
			public Set<MixedDataKey<?>> getLocalDataKeys(UUID id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ILogger getLocalLogger() {
				// TODO Auto-generated method stub
				return null;
			}

		};

		this._msgRecvr = new IRoomConnection() {

			@Override
			public void sendMessage(RoomDataPacket<? extends IRoomConnectionData> data) throws RemoteException {
				(new Thread(() -> {
					data.execute(_msgProcessor);
				})).start();
			}

		};
	}

	/**
	 * Starts the MiniModel. Creates a new PubSubSync update channel or subscribes to an existing channel as needed.
	 * 	 
	 * @return The UUID of the channel associated with this chatroom
	 */
	public UUID start() {
		initKnownMsgCmds();

		if (_mm2cAdpt.getUUID() == null) { /* Creating new channel */
			_channel = _mm2cAdpt.getPubSubManager().createChannel(_mm2cAdpt.getRoomName(),
					new HashSet<INamedRoomConnection>(), (pubSubSyncData) -> {
						//_roster = pubSubSyncData.getData();
						_roster.clear();
						_roster.addAll(pubSubSyncData.getData());
						_sysLogger.log(LogLevel.DEBUG,
								"Received updated roster: " + _roster.toString() + ", updating roster in MiniView");
						_m2vAdpt.displayRoster(_roster);
					}, (statusMsg) -> {
						_m2vAdpt.displayMsg(statusMsg);
					});
			_sysLogger.log(LogLevel.INFO,
					"Created channel " + _channel.getFriendlyName() + " with UUID: " + _channel.getChannelID());
		} else { /* Subscribing to existing channel */
			_channel = _mm2cAdpt.getPubSubManager().subscribeToUpdateChannel(_mm2cAdpt.getUUID(), (pubSubSyncData) -> {
				//_roster = pubSubSyncData.getData();
				_roster.clear();
				_roster.addAll(pubSubSyncData.getData());
				_sysLogger.log(LogLevel.DEBUG,
						"Received updated roster: " + _roster.toString() + ", updating roster in MiniView");
				_m2vAdpt.displayRoster(_roster);
			}, (statusMsg) -> {
				_m2vAdpt.displayMsg(statusMsg);
			});
			_sysLogger.log(LogLevel.INFO,
					"Subscribed to channel " + _channel.getFriendlyName() + " with UUID: " + _channel.getChannelID());
		}

		try {
			_msgRecvrStub = (IRoomConnection) UnicastRemoteObject.exportObject(_msgRecvr,
					_mm2cAdpt.getConfig().stubPort);
		} catch (Exception e) {
			_sysLogger.log(LogLevel.ERROR,
					"Unable to export IRoomConnection stub in room " + _mm2cAdpt.getRoomName() + ": " + e.toString());
			e.printStackTrace();
		}

		_namedMsgRecvr = INamedRoomConnection.make(_mm2cAdpt.getUsername(), _msgRecvrStub, namedAppConnection);

		_channel.update(IPubSubSyncUpdater.makeSetAddFn(_namedMsgRecvr));
		_sysLogger.log(LogLevel.DEBUG, "Added self to roster.");

		return _channel.getChannelID();
	}

	/**
	 * Adds commands to the local MessageVisitor corresponding to message types known
	 * by this chatapp.
	 */
	private void initKnownMsgCmds() {

		/**
		 * Command for ICmdData
		 */
		_msgProcessor.setCmd(ICmdData.GetID(), new ARoomDataPacketAlgoCmd<ICmdData<? extends IRoomConnectionData>>() {

			/**
			 * Serial version UID
			 */
			private static final long serialVersionUID = -4126596411118855624L;

			@Override
			public Void apply(IDataPacketID index, RoomDataPacket<ICmdData<? extends IRoomConnectionData>> host,
					Void... params) {
				host.getData().getAlgoCmd().setCmd2ModelAdpt(_cmd2mAdpt);

				_msgProcessor.setCmd(host.getData().getUnknownMsgID(), host.getData().getAlgoCmd());

				if (_buffer.containsKey(host.getData().getUnknownMsgID())) {
					for (RoomDataPacket<? extends IRoomConnectionData> unprocessed : _buffer
							.get(host.getData().getUnknownMsgID())) {
						unprocessed.execute(_msgProcessor);
					}
					_buffer.remove(host.getData().getUnknownMsgID());
				}
				
				return null;

			}

		});
		
		/**
		 * A command for packet list data.
		 */
		_msgProcessor.setCmd(IPacketListData.GetID(), new ARoomDataPacketAlgoCmd<IPacketListData>() {

			private static final long serialVersionUID = -5058974098707382955L;

			@Override
			public Void apply(IDataPacketID index, RoomDataPacket<IPacketListData> host, Void... params) {
				// The data packets sent to us in the IPacketListData
				IPacketListData data = (IPacketListData) host.getData();

			        // Go through each data packet in order and execute it.
			        for (RoomDataPacket<IRoomConnectionData> packet : data.getPackets()) {
			                packet.execute(_msgProcessor);
			        }
				return null;
			}

		});


		/**
		 * Command for IRequestCmdMessage
		 */
		_msgProcessor.setCmd(ICmdRequestData.GetID(), new ARoomDataPacketAlgoCmd<ICmdRequestData>() {

			/**
			 * Serial version UID
			 */
			private static final long serialVersionUID = 5227911023245326890L;

			@Override
			public Void apply(IDataPacketID index, RoomDataPacket<ICmdRequestData> host, Void... params) {
				IDataPacketID cmdID = host.getData().getUnknownMsgID();

				// Send rejection status if requesting well-known message type
				if (cmdID == ICmdData.GetID() || cmdID == ICmdRequestData.GetID() || cmdID == ITextData.GetID()
						|| cmdID == IErrorStatusData.GetID() || cmdID == IFailureStatusData.GetID()
						|| cmdID == IRejectStatusData.GetID()) {

					IRejectStatusData<ICmdRequestData> rejectData = IRejectStatusData.make(host,
							"Rejected: Refusing to send command to process well-known message type.");

					(new Thread(() -> {
						try {
							host.getSender().sendMessage(new RoomDataPacket<IRejectStatusData<ICmdRequestData>>(
									rejectData, host.getSender()));
						} catch (RemoteException e) {
							_sysLogger.log(LogLevel.ERROR, "Unable to deliver rejection status message to "
									+ host.getSender().getName() + ": " + e.toString());
							e.printStackTrace();
						}
					})).start();
				}

				// Send message containing command
				if (_msgProcessor.getCmd(
						cmdID) != null) { /* Check that our local message visitor has a command for this message before sending command */
					@SuppressWarnings("unchecked")
					ARoomDataPacketAlgoCmd<? extends IRoomConnectionData> desiredCmd = (ARoomDataPacketAlgoCmd<? extends IRoomConnectionData>) _msgProcessor
							.getCmd(cmdID);

					ICmdData<? extends IRoomConnectionData> cmdData = ICmdData.make(cmdID, desiredCmd);

					(new Thread(() -> {
						try {
							host.getSender().getStub()
									.sendMessage(new RoomDataPacket<ICmdData<? extends IRoomConnectionData>>(cmdData,
											_namedMsgRecvr));
						} catch (RemoteException e) {
							_sysLogger.log(LogLevel.ERROR,
									"Unable to deliver CmdData to " + host.toString() + ": " + e.toString());
							e.printStackTrace();
						}
					})).start();

					// Command requested is unknown, send failure status to sender
				} else {
					IFailureStatusData<ICmdRequestData> failureData = IFailureStatusData.make(host,
							"Failure: Requesting command unknown to this user.");

					(new Thread(() -> {
						try {
							host.getSender().sendMessage(new RoomDataPacket<IFailureStatusData<ICmdRequestData>>(
									failureData, host.getSender()));
						} catch (RemoteException e) {
							_sysLogger.log(LogLevel.ERROR, "Unable to deliver failure status message to "
									+ host.getSender().getName() + ": " + e.toString());
							e.printStackTrace();
						}
					})).start();
				}

				return null;
			}

		});

		/**
		 * Command for Error Status Message
		 */
		_msgProcessor.setCmd(IErrorStatusData.GetID(),
				new ARoomDataPacketAlgoCmd<IErrorStatusData<? extends IRoomConnectionData>>() {

					/**
					 * Serial version UID
					 */
					private static final long serialVersionUID = 4344416050910254445L;

					@Override
					public Void apply(IDataPacketID index,
							RoomDataPacket<IErrorStatusData<? extends IRoomConnectionData>> host, Void... params) {
						_sysLogger.log(LogLevel.ERROR, host.getData().getStatusMsg());
						return null;
					}

				});

		/**
		 * Command for Failure Status Message
		 */
		_msgProcessor.setCmd(IFailureStatusData.GetID(),
				new ARoomDataPacketAlgoCmd<IFailureStatusData<? extends IRoomConnectionData>>() {

					/**
					 * Serial version UID
					 */
					private static final long serialVersionUID = -5929579308925673828L;

					@Override
					public Void apply(IDataPacketID index,
							RoomDataPacket<IFailureStatusData<? extends IRoomConnectionData>> host, Void... params) {
						_sysLogger.log(LogLevel.ERROR, host.getData().getStatusMsg());
						return null;
					}

				});

		/**
		 * Command for Rejection Status Message
		 */
		_msgProcessor.setCmd(IRejectStatusData.GetID(),
				new ARoomDataPacketAlgoCmd<IRejectStatusData<? extends IRoomConnectionData>>() {

					/**
					 * Serial version UID
					 */
					private static final long serialVersionUID = -7540055269140124514L;

					@Override
					public Void apply(IDataPacketID index,
							RoomDataPacket<IRejectStatusData<? extends IRoomConnectionData>> host, Void... params) {
						_sysLogger.log(LogLevel.ERROR, host.getData().getStatusMsg());
						return null;
					}

				});

		/**
		 * Command for Text Message
		 */
		_msgProcessor.setCmd(ITextData.GetID(), new ARoomDataPacketAlgoCmd<ITextData>() {

			/**
			 * Serial version UID
			 */
			private static final long serialVersionUID = 7770262001220815897L;

			@Override
			public Void apply(IDataPacketID index, RoomDataPacket<ITextData> host, Void... params) {
				MiniModel.this._m2vAdpt.displayMsg(host.getSender().getName() + ": " + host.getData().getText());
				return null;
			}

		});
		
		
		/**
		 * Commands for not well-known message types.
		 */

		/**
		 * Command for ButtonMessage
		 */
		_msgProcessor.setCmd(IButtonData.GetID(), new ButtonDataCmd(_cmd2mAdpt));
		/**
		 * Command for PanelMessage
		 */
		_msgProcessor.setCmd(IPanelData.GetID(), new PanelDataCmd(_cmd2mAdpt));
		/**
		 * Command for MapsMessage
		 */
		_msgProcessor.setCmd(IMapsData.GetID(), new MapsDataCmd(_cmd2mAdpt));

	}

	/**
	 * Sends a message
	 * 
	 * @param message the message to be sent
	 */
	public void sendMessage(IRoomConnectionData message) {
		(new Thread(() -> { /* Dispatch new thread to avoid seizing mini model */
			RoomDataPacket<? extends IRoomConnectionData> packet = new RoomDataPacket<>(message, _namedMsgRecvr);
			for (INamedRoomConnection user : _roster) {
				try {
					//if (!user.equals(_namedMsgRecvr)) /* Send message to everyone but yourself */
					user.sendMessage(packet);
				} catch (RemoteException e) {
					_sysLogger.log(LogLevel.ERROR,
							"Unable to send message to " + user.toString() + ": " + e.toString());
					e.printStackTrace();
				}
			}
		})).start();

	}

	/**
	 * Sends a text message.
	 * 	
	 * @param message The text message to send
	 */
	public void sendTextMessage(String message) {
		ITextData textData = ITextData.make(message);
		sendMessage(textData);
	}

	/**
	 * Sends a button message.
	 */
	public void sendButton() {
		IButtonData buttonData = IButtonData.make();
		sendMessage(buttonData);
	}

	/**
	 * Sends a panel message.
	 */
	public void sendPanel() {
		IPanelData panelData = IPanelData.make();
		sendMessage(panelData);
	}
	
	/**
	 * Sends a maps message.
	 */
	public void sendMaps() {
		IMapsData mapsData = IMapsData.make();
		sendMessage(mapsData);
	}

	/**
	 * Removes self from roster and unsubscribes from PubSubSync channel.
	 */
	public void leaveChannel() {
		_channel.update(IPubSubSyncUpdater.makeSetRemoveFn(_namedMsgRecvr));
		_channel.unsubscribe();
	}

	/**
	 * Sends an init message
	 */
	public void sendInitMsg() {
		sendMessage((IGameInitMsg) new GameInitMsg(_mainModelID));
	}

	/**
	 * Get the room ID.
	 * @return the INamedRoomID of the room.
	 */
	public INamedRoomID getRoomID() {
		// TODO Auto-generated method stub
		return INamedRoomID.make("Room", _mainModelID);
	}

}
