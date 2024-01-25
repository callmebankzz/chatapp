package tjc6.mainMVC.model;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import tjc6.miniMVC.miniController.IMiniCtrl2MiniModelAdapter;
import tjc6.miniMVC.miniController.IModel2MiniCtrlAdapter;
import tjc6.miniMVC.miniController.MiniController;
import provided.datapacket.IDataPacketID;
import provided.logger.ILogger;
import provided.logger.LogLevel;
import provided.pubsubsync.IPubSubSyncConnection;
import provided.pubsubsync.IPubSubSyncManager;
import provided.rmiUtils.IRMIUtils;
import provided.rmiUtils.RMIPortConfigWithBoundName;
import provided.rmiUtils.RMIUtils;
import common.dataPacket.AppDataPacket;
import common.dataPacket.data.IAppConnectionData;
import common.dataPacket.data.app.IConnectionSetData;
import common.dataPacket.data.app.IInviteData;
import common.dataPacket.data.app.IQuitData;
import common.dataPacket.data.app.IRequestJoinRoomData;
import common.dataPacket.data.app.IRequestRoomsData;
import common.dataPacket.data.app.ISendRoomsData;
import common.serverObj.IAppConnection;
import common.serverObj.IInitialAppConnection;
import common.serverObj.INamedAppConnection;
import common.serverObj.INamedRoomID;
import common.dataPacket.AppDataPacketAlgo;
import common.dataPacket.AAppDataPacketAlgoCmd;

/**

 * The model for the client.
 * 
 * @author ben
 * @author tyrac
 */
public class Model {

	/**
	 * The IRMIUtils in use
	 */
	private IRMIUtils _utils;

	/**
	 * The system logger in use
	 */
	private ILogger _sysLogger;

	/**
	 * The adapter from the client model to the client view
	 */
	private IModel2ViewAdapter _m2vAdpt;

	/**
	 * The RMIPortConfigWithBoundName 
	 */
	private RMIPortConfigWithBoundName _config;

	/**
	 * A mapping of UUIDs to model-to-mini-controller adapters representing a list of chatrooms 
	 * that this Chatapp instance is actively connected to
	 */
	private HashMap<UUID, IModel2MiniCtrlAdapter> _rooms = new HashMap<>();

	/**
	 * A hashset representing the users in the app.
	 */
	private HashSet<INamedAppConnection> _users = new HashSet<>();

	/**
	 * The username of a user.
	 */
	private String _username;

	/**
	 * An instance of Registry.
	 */
	private Registry _registry;

	/**
	 * An instance of IConnection
	 */
	private IAppConnection _connection;

	/**
	 * An instance of IConnection representing a stub.
	 */
	private IAppConnection _connectionStub;

	/**
	 * An instance of IInitialConnection.
	 */
	private IInitialAppConnection _initConnection;

	/**
	 * An instance of IInitialConnection representing a stub.
	 */
	private IInitialAppConnection _initConnectionStub;

	/**
	 * An INamedAppConnection
	 */
	private INamedAppConnection _namedConnection;

	/**
	 * An instance of IPubSubSyncManager.
	 */
	private IPubSubSyncManager _pubSubManager;

	/**
	 * An instance of AppDataPacketAlgo
	 */
	private AppDataPacketAlgo _visitor;

	/**
	 * The UUID for the lobby
	 */
	private UUID _lobbyUUID;
	
	/**
	 * HashSet of players in team A.
	 */
	//private HashSet<INamedAppConnection> _teamA;
	
	/**
	 * HashSet of players in team B.
	 */
	//private HashSet<INamedAppConnection> _teamB;
	
	/**
	 * A boolean to determine which team a player is on.
	 * If true, the player is assigned to team A; otherwise, they
	 * are assigned to team B.
	 */
	//private boolean _thisTeam = true;
	
	
	/**	
	 * The constructor for a ClientModel.
	 * 	 
	 * 	  @param config The RMIPortConfigWithBoundName
	 * 	  @param logger The system logger
	 * 	  @param m2vAdpt The adapter from the client model to the client view
	 */
	public Model(RMIPortConfigWithBoundName config, ILogger logger, IModel2ViewAdapter m2vAdpt) {
		this._config = config;
		this._sysLogger = logger;
		this._m2vAdpt = m2vAdpt;
		_utils = new RMIUtils(_sysLogger);

		this._visitor = new AppDataPacketAlgo(new AAppDataPacketAlgoCmd<IAppConnectionData>() {

			/**
			 * A serial version UID
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Void apply(IDataPacketID index, AppDataPacket<IAppConnectionData> host, Void... params) {
				return null;
			}

		});

		this._connection = new IAppConnection() {

			@Override
			public void sendMessage(AppDataPacket<? extends IAppConnectionData> data) throws RemoteException {
				data.execute(_visitor);

			}
		};

	}

	/**
	 * Get the internal IRMIUtils instance being used.    The discovery model start method needs the main model's IRMIUtils.
	 * ONLY call the method AFTER the model, i.e. the internal IRMIUtils, has been started!
	 * 	  
	 * @return The internal IRMIUtils instance
	 */
	public IRMIUtils getRMIUtils() {
		return this._utils;
	}

	/**
	
	 * Starts the client model by initializing the RMI system and creating a remote view adapter stub 
	 * 	 for use by an engine server.  Procedure:<br>
	 * 	 1. (DO THIS FIRST!) Use the IRMIUtils to start the RMI system, using 
	 * 	 port = IRMI_Defs.CLASS_SERVER_PORT_CLIENT.  
	 * 	 This will also automatically start the the security manager and the class file server for remote dynamic
	 * 	 class loading.<br>
	 * 	 2. Export a STUB from the client's IRemoteTaskViewAdapter RMI server object.  
	 * 	 Save this stub for use when connecting to an engine server. <br>
	 * 	  
	 */
	public void start() {
		_utils.startRMI(_config.classServerPort);

		initKnownCmds();
		try {
			_connectionStub = (IAppConnection) UnicastRemoteObject.exportObject(_connection, _config.stubPort);
			_pubSubManager = IPubSubSyncConnection.getPubSubSyncManager(_sysLogger, _utils, _config.stubPort);

		} catch (RemoteException e) {
			_sysLogger.log(LogLevel.ERROR, "Unable to export connection stub: " + e.toString());
			e.printStackTrace();
		}

		// Create a "lobby" to be able to send a message to everyone
		createChatroom(INamedRoomID.make("Lobby", _lobbyUUID));
	}

	/**
	 * Used to initialize known commands
	 */
	private void initKnownCmds() {

		/** 
		 * Command for receiving a set of IAppConnections
		 */
		_visitor.setCmd(IConnectionSetData.GetID(), new AAppDataPacketAlgoCmd<IConnectionSetData>() {

			/**
			 * Serial version UID
			 */
			private static final long serialVersionUID = -6562247343664656049L;

			@Override
			public Void apply(IDataPacketID index, AppDataPacket<IConnectionSetData> host, Void... params) {

				HashSet<INamedAppConnection> connections = host.getData().getConnectionSet();
				_m2vAdpt.addUsers(connections);

				if (_users.addAll(connections)) {

					(new Thread(() -> {
						// Create a packet that stores our list of users
						IConnectionSetData connectionSetData = IConnectionSetData.make(_users);
						AppDataPacket<IConnectionSetData> packet = new AppDataPacket<>(connectionSetData,
								_namedConnection);

						for (INamedAppConnection connection : connections) {
							try {
								// Send that packet to each user in our list
								connection.sendMessage(packet);

							} catch (RemoteException e) {
								_sysLogger.log(LogLevel.ERROR,
										"Unable to send connections to remote user: " + e.toString());
								e.printStackTrace();
							}
						}
					})).start();

					for (IModel2MiniCtrlAdapter room : _rooms.values()) {
						room.updateConnectedUsers(_users);
					}
				}
				return null;
			}
		});

		/**
		 * Command for receiving an invitation
		 */
		_visitor.setCmd(IInviteData.GetID(), new AAppDataPacketAlgoCmd<IInviteData>() {

			/**
			 * Serial version UID
			 */
			private static final long serialVersionUID = -1859821480754375353L;

			@Override
			public Void apply(IDataPacketID index, AppDataPacket<IInviteData> host, Void... params) {
				INamedRoomID namedRoomID = host.getData().getNamedRoomID();
				_sysLogger.log(LogLevel.INFO, "{IInviteData} Received INamedRoomID = " + namedRoomID);
				makeMiniMVC(namedRoomID);
				return null;
			}

		});

		/**
		 * Command for removing a specific connection
		 */
		_visitor.setCmd(IQuitData.GetID(), new AAppDataPacketAlgoCmd<IQuitData>() {

			/**
			 * Serial version UID
			 */
			private static final long serialVersionUID = 9216853296876303190L;

			@Override
			public Void apply(IDataPacketID index, AppDataPacket<IQuitData> host, Void... params) {
				_users.remove(host.getSender());
				for (IModel2MiniCtrlAdapter room : _rooms.values()) {
					room.updateConnectedUsers(_users);
				}
				return null;
			}

		});
		
		/**
		 * Command for requesting rooms.
		 */
		_visitor.setCmd(IRequestRoomsData.GetID(), new AAppDataPacketAlgoCmd<IRequestRoomsData>() {

			private static final long serialVersionUID = 3267835663840455730L;

			public Void apply(IDataPacketID index, AppDataPacket<IRequestRoomsData> host, Void... params) {

//				// The fake INamedRoomIDs to send to the requester
//				HashSet<INamedRoomID> fakeRoomsToSend = new HashSet<>();
//
//				// Build the list to send
//				for (Entry<INamedRoomID, NamedRoomID> entry : fakeToRealMap.entrySet()) {
//					if (true) {
//						fakeRoomsToSend.add(entry.getKey());
//					}
//				}
				HashSet<INamedRoomID> rooms = new HashSet<INamedRoomID>();
				
				for (IModel2MiniCtrlAdapter room : _rooms.values()) {
					rooms.add(room.getRoomID());
				}
				
				ISendRoomsData sendRoomsData = ISendRoomsData.make(rooms);

				try {
					// Send the rooms back to the sender
					host.getSender().sendMessage(new AppDataPacket<ISendRoomsData>(sendRoomsData, _namedConnection));
				} catch (RemoteException e) {
					e.printStackTrace();
				}

				return null;
			}

		});
		
		/**
		 * A command for sending room data.
		 */
		_visitor.setCmd(ISendRoomsData.GetID(), new AAppDataPacketAlgoCmd<ISendRoomsData>() {

			private static final long serialVersionUID = -3074722534186143630L;
			//private INamedAppConnection senderOfRooms;

			@Override
			public Void apply(IDataPacketID index, AppDataPacket<ISendRoomsData> host, Void... params) {
				// The rooms sent to us in the ISendRoomsData
				HashSet<INamedRoomID> sentRooms = host.getData().getChatRooms();

				// Update a display of requested rooms so you can select a room...
				_m2vAdpt.addRooms(sentRooms);
				// Save the sender to a field so you can send your room-join-request to them later
				//senderOfRooms = host.getSender();
				
				for (INamedRoomID room : sentRooms) {
					makeMiniMVC(room);
				}
				
				return null;
			}


		});
		
		/**
		 * Command for requesting to join a room.
		 */
		_visitor.setCmd(IRequestJoinRoomData.GetID(), new AAppDataPacketAlgoCmd<IRequestJoinRoomData>() {


			private static final long serialVersionUID = -1511543736022476591L;

			@Override
			public Void apply(IDataPacketID index, AppDataPacket<IRequestJoinRoomData> host, Void... params) {
				
				AppDataPacket<IInviteData> message = new AppDataPacket<IInviteData>(IInviteData.make(host.getData().getNamedRoomID()), _namedConnection);
						
				try {
					host.getSender().sendMessage(message);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				return null;
				
//				// The fake dyad of the room the sender wishes to join
//				INamedRoomID fakeDyad = host.getData().getNamedRoomID();
//
//				// Find real dyad corresponding to the fake dyad
//				for (Entry<INamedRoomID, INamedRoomID> entry : fakeToRealMap.entrySet()) {
//
//					if (entry.getKey().equals(fakeDyad)) {
//						// The real dyad of the chatroom
//						INamedRoomID realDyad = entry.getValue();
//
//						// You can add the ability to reject the request here...
//
//						// Send the invite to the real room
//						sendForceInviteMsg(host.getSender(), realDyad);
//
//						return null;
//					}
//				}
//
//				// If it's not in the map, the room no longer exists.
//				sendRejectStatusMsg(host.getSender(), host,
//						"This room no longer exists, please request the rooms again");
//
//				return null;
			}


		});

	}

	/**
	 * Stops the client model by using the IRMIUtils to stop the RMI system.
	 * This automatically stops class file server.   
	 * 	This MUST be called before exiting the system! 
	 */
	public void stop() {

		// Send quit data to all of our connections
		for (INamedAppConnection connectedUser : _users) {
			(new Thread(() -> {
				try {
					connectedUser.sendMessage(new AppDataPacket<IQuitData>(IQuitData.make(), _namedConnection));
				} catch (Exception e) {
					e.printStackTrace();
				}
			})).start();
		}

		// Unbind config
		(new Thread(() -> {
			try {
				_registry.unbind(_config.boundName);
			} catch (Exception e) {
				_sysLogger.log(LogLevel.ERROR,
						"Unable to unbind " + _config.boundName + " from registry: " + e.toString());
			}
		})).start();

		// Leave all channels upon exit
		for (IModel2MiniCtrlAdapter m2cAdpt : _rooms.values()) {
			m2cAdpt.leaveChannel();
		}

		// Stop RMI
		_utils.stopRMI();
		System.exit(0);
	}

	/**
	 * Binds an IInitialConnection object to the discovery server with the provided username.
	 * 	
	 * @param username The name of this instance, used to bind IInitialConnection
	 */
	public void startApp(String username) {
		this._username = username;

		_namedConnection = INamedAppConnection.make(_username, _connectionStub);
		_users.add(_namedConnection);

		_initConnection = new IInitialAppConnection() {

			@Override
			public void receiveNamedConnection(INamedAppConnection namedConnection) throws RemoteException {
				System.out.println(namedConnection);
				// Add this new connection to list of known users
				_users.add(namedConnection);

				// Send it our list of known users to start auto-connect process
				IConnectionSetData connectionSetData = IConnectionSetData.make(_users);
				AppDataPacket<IConnectionSetData> packet = new AppDataPacket<>(connectionSetData, _namedConnection);
				namedConnection.sendMessage(packet);

			}
		};

		try {
			_registry = _utils.getLocalRegistry();
			_sysLogger.log(LogLevel.INFO, "Local Registry = " + _registry);
		} catch (Exception e) {
			e.printStackTrace();
			stop();
		}

		try {
			_initConnectionStub = (IInitialAppConnection) UnicastRemoteObject.exportObject(_initConnection,
					_config.stubPort);
			_sysLogger.log(LogLevel.INFO, "Binding _initConnection stub to: " + _config.boundName);
			_registry.rebind(_config.boundName, _initConnectionStub);
			_sysLogger.log(LogLevel.INFO, "ChatApp ready");
		} catch (Exception e) {
			_sysLogger.log(LogLevel.ERROR, e.toString());
			e.printStackTrace();
			stop();
		}
	}

	/**
	
	 * Connects to the given remote host's Registry and retrieves the stub to the ICompute object bound 
	 * 	  to the ICompute.BOUND_NAME name in the remote Registry on port 
	 * 	  IRMI_Defs.REGISTRY_PORT.  Procedure:<br> 
	 * 	  1. Use the IRMIUtils to retrieve the remote Registry at the given IP address. <br>
	 * 	  2. Use the remote Registry to retrieve an ICompute STUB bound to the name defined by IComputer.BOUND_NAME
	 * 	  Save the reference to the IComputer stub somewhere.<br>
	 * 	  3. Use the ICompute stub to give the client's IRemoteTaskViewAdapter STUB to the remote engine server and
	 * 	    retrieve the compute engine's IRemoteTaskViewAdapter stub.  Save the retrieved stub for later use.  
	 * 	    Use the retrieved stub to send a connection status message to the remote compute engine's user interface.<br> 
	 * 	  4. Return a string indicating the success or failure of the connection attempt.
	 * 	  
	 * 	  @param remoteHost The IP address or host name of the remote server.
	 * 	  @return  A status string on the connection.
	 */
	public String connectTo(String remoteHost) {
		try {
			_sysLogger.log(LogLevel.INFO, "Locating registry at " + remoteHost + "...");
			Registry registry = _utils.getRemoteRegistry(remoteHost);
			_sysLogger.log(LogLevel.ERROR, "Found registry: " + registry);
			connectToStub((IInitialAppConnection) registry.lookup(_config.boundName));
		} catch (Exception e) {
			_sysLogger.log(LogLevel.ERROR, "Exception connecting to " + remoteHost + ": " + e);
			e.printStackTrace();
			return "No connection established!";
		}
		return "User at " + remoteHost + " added to known connections!";
	}

	/**
	 * Set the stup of the remote RMI server object
	 * 	@param computeStub The stub of the remote RMI Server object
	 */
	public void connectToStub(IInitialAppConnection newConnection) {

		(new Thread(() -> {
			try {
				newConnection.receiveNamedConnection(_namedConnection);
				
			} catch (RemoteException e) {
				_sysLogger.log(LogLevel.ERROR, "Exception retrieving named connection object from "
						+ newConnection.toString() + ": " + e.toString());
				e.printStackTrace();
			}
		})).start();

	}

	/**
	 * Creates a chatroom
	 * @param name The INamedRoomID of the chatroom.
	 */
	public void createChatroom(INamedRoomID namedRoomID) {
		makeMiniMVC(namedRoomID);
	}

	/**
	 * Creates and starts a mini-MVC representing a chatroom.
	 * 	
	 * @param room The room info to be associated with the chatroom
	 * 	@param UUID the uuid of the channel
	 */
	public void makeMiniMVC(INamedRoomID namedRoomID) {
		Runnable[] closeTabCmd = new Runnable[] { null };

		if (namedRoomID.getName().equals("Lobby")) {
			_lobbyUUID = namedRoomID.getUUID();
		}

		closeTabCmd[0] = _m2vAdpt.addMiniView(namedRoomID.getName(), () -> {

			// By instantiating the entire mini-controller inside of the Suppler.get() method, 
			// we ensure that the mini-View is instantiated and started on the GUI thread!

			MiniController miniController = new MiniController(_namedConnection, namedRoomID.getName(), namedRoomID.getUUID(),
					new IMiniCtrl2MiniModelAdapter() {

						/**
						 * Called by the mini-MVC when it has terminated and wants to have its view removed from the main MVC.
						 * @param toExit An instance of MiniController
						 */
						public void leaveRoom(MiniController toExit) {
							closeTabCmd[0].run();
							_rooms.remove(toExit.getUUID());
						}

						@Override
						public IPubSubSyncManager getPubSubManager() {
							return _pubSubManager;
						}

						@Override
						public RMIPortConfigWithBoundName getConfig() {
							return _config;
						}

						@Override
						public HashSet<INamedAppConnection> getConnectedUsers() {
							return _users;
						}

						@Override
						public String getUsername() {
							return _username;
						}

						@Override
						public INamedAppConnection getNamedConnection() {
							return _namedConnection;
						}

					});

			miniController.start();

			IModel2MiniCtrlAdapter m2cAdpt = miniController.getMiniControlAdpt();

			_sysLogger.log(LogLevel.INFO, "Adding room with UUID: " + miniController.getUUID());
			_rooms.put(miniController.getUUID(), m2cAdpt); // At this point, the UUID will be non-null

			return m2cAdpt.getMiniView();
		});
	}

	/**
	 * Gets the connected users.
	 * @return An instance of HashSet<INamedAppConnection>
	 */
	public HashSet<INamedAppConnection> getConnectedUsers() {
		return _users;
	}

	/**
	 * Gets the connected rooms.
	 * @return An instance of HashMap<UUID, IModel2MiniCtrlAdapter>
	 */
	public HashMap<UUID, IModel2MiniCtrlAdapter> getConnectedRooms() {
		return _rooms;
	}

	/**
	 * Receives a message.
	 * @param data the message being received
	 */
	public void recieveMessage(AppDataPacket<? extends IAppConnectionData> data) {
		data.execute(_visitor);

	}
	
	/**
	 * Assigns players to teams randomly.
	 */
	public void teamAssignments() {
		
	}

	/**
	 * Sends an initial message.
	 */
	public void sendInitMsg() {

		_rooms.get(_lobbyUUID).sendInitMsg();
	}

	/**
	 * Request roooms.
	 * @param itemAt the INamedAppConnection you want to request the rooms of.
	 */
	public void requestRooms(INamedAppConnection itemAt) {
		AppDataPacket<IRequestRoomsData> packet = new AppDataPacket<>(IRequestRoomsData.make(), _namedConnection);
		try {
			itemAt.sendMessage(packet);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
