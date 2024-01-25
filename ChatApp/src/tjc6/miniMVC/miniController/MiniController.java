package tjc6.miniMVC.miniController;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import javax.swing.JComponent;

import tjc6.miniMVC.miniModel.IMiniModel2MiniCtrlAdapter;
import tjc6.miniMVC.miniModel.IMiniModel2MiniViewAdapter;
import tjc6.miniMVC.miniModel.MiniModel;
import tjc6.miniMVC.miniView.IMiniView2MiniModelAdapter;
import tjc6.miniMVC.miniView.MiniView;
import common.dataPacket.AppDataPacket;
import common.dataPacket.data.app.IInviteData;
import common.serverObj.INamedAppConnection;
import common.serverObj.INamedRoomConnection;
import common.serverObj.INamedRoomID;
import provided.logger.ILogger;
import provided.logger.ILoggerControl;
import provided.logger.LogLevel;
import provided.pubsubsync.IPubSubSyncManager;
import provided.rmiUtils.RMIPortConfigWithBoundName;

/**

 * Controller for the miniMVC
 * @author tinaw
 *  *
 */
public class MiniController {

	/**
	 * An instance of ILogger
	 */
	private ILogger _sysLogger = ILoggerControl.getSharedLogger();

	/**
	 * An instance of IMiniCtrl2ModelAdapter
	 */
	private IMiniCtrl2MiniModelAdapter _c2mAdpt;

	/**
	 * An instance of IModel2MiniCtrlAdapter
	 */
	private IModel2MiniCtrlAdapter _m2cAdpt;

	/**
	 * An instance of MiniModel
	 */
	private MiniModel _model;

	/**
	 * An instance of MiniView
	 */
	private MiniView _view;

	/**
	 * An instance of String
	 */
	private String _roomName;

	/**
	 * An instance of String
	 */
	private String _username;

	/**
	 * An instance of UUID
	 */
	private UUID _UUID;

	/**
	
	* An instance of ICmd2ModelAdapter.
	 */
	//private ICmd2ModelAdapter _cmd2ModelAdpt;

	/**
	 * A constructor for the MiniController class
	 * @param roomName An instance of IRoom
	 * @param uuid An instance of UUID
	 * @param miniCtrl2ModelAdpt An instance of IMiniCtrl2ModelAdapter
	 */
	public MiniController(INamedAppConnection namedConnection, String roomName, UUID uuid,
			IMiniCtrl2MiniModelAdapter miniCtrl2ModelAdpt) { //, ICmd2ModelAdapter cmd2ModelAdpt) {

		MiniController self = this;

		_roomName = roomName;

		_UUID = uuid;

		_c2mAdpt = miniCtrl2ModelAdpt;

		//_cmd2ModelAdpt = cmd2ModelAdpt;

		_username = _c2mAdpt.getUsername();

		_sysLogger.setLogLevel(LogLevel.DEBUG);

		_model = new MiniModel(namedConnection, _sysLogger, new IMiniModel2MiniViewAdapter() {

			/**
			 * Displays the message
			 * @param msg The message to display
			 */
			public void displayMsg(String msg) {
				_view.append(msg);
			}

			@Override
			public void displayJComponent(Supplier<JComponent> supplier) {
				_view.displayComponent(supplier);
			}

			@Override
			public void displayRoster(HashSet<INamedRoomConnection> roster) {
				_sysLogger.log(LogLevel.DEBUG, "New roster to be displayed: " + roster.toString());

				String strRoster = "";
				for (INamedRoomConnection member : roster) {
					strRoster += member.toString() + "\n";
				}

				_view.displayRoster(strRoster);
				_sysLogger.log(LogLevel.DEBUG, "Updated roster in MiniView");

			}

		}, new IMiniModel2MiniCtrlAdapter() {

			@Override
			public IPubSubSyncManager getPubSubManager() {
				return _c2mAdpt.getPubSubManager();
			}

			@Override
			public RMIPortConfigWithBoundName getConfig() {
				return _c2mAdpt.getConfig();
			}

			@Override
			public String getRoomName() {
				return _roomName;
			}

			@Override
			public UUID getUUID() {
				return _UUID;
			}

			@Override
			public String getUsername() {
				return _username;
			}

		});

		_view = new MiniView(new IMiniView2MiniModelAdapter() {

			@Override
			public void sendTextMessage(String message) {
				_model.sendTextMessage(message);
				_view.append("Sent message: " + message);
			}

			@Override
			public void leaveRoom() {
				_model.leaveChannel();
				_c2mAdpt.leaveRoom(self);
			}

			@Override
			public HashSet<INamedAppConnection> getConnectedUsers() {
				return _c2mAdpt.getConnectedUsers();
			}

			@Override
			public void inviteUsers(List<INamedAppConnection> invitees) {
				for (INamedAppConnection invitee : invitees) {
					_sysLogger.log(LogLevel.INFO, "Inviting user to channel with UUID: " + _UUID);
					inviteUser(invitee);
				}

			}

			@Override
			public void inviteUser(INamedAppConnection invitee) {
				Thread T = new Thread(() -> {
					try {
						_sysLogger.log(LogLevel.INFO, "Inviting user to channel with UUID: " + _UUID);

						IInviteData inviteData = IInviteData.make(INamedRoomID.make(_roomName, _UUID)); // Static make() method was removed from IInviteData for some reason.
						AppDataPacket<IInviteData> packet = new AppDataPacket<>(inviteData,
								_c2mAdpt.getNamedConnection());

						invitee.sendMessage(packet);

					} catch (RemoteException e) {
						_sysLogger.log(LogLevel.ERROR,
								"Unable to send invite to " + invitee.toString() + ": " + e.toString());
						e.printStackTrace();
					}
				});

				T.start();
			}

			@Override
			public void sendButton() {
				_model.sendButton();
			}

			@Override
			public void sendPanel() {
				_model.sendPanel();
			}

		});

		_m2cAdpt = new IModel2MiniCtrlAdapter() {

			/**
			 * Gets the miniView
			 * @return An instance of JComponent
			 */
			public JComponent getMiniView() {
				return _view.getMainPnl();
			}

			/**
			 * Gets the miniModel
			 * @return An instance of MiniModel
			 */
			public MiniModel getMiniModel() {
				return _model;
			}

			@Override
			public void updateConnectedUsers(HashSet<INamedAppConnection> newUserSet) {
				_view.updateAvailableUsers(newUserSet);

			}

			@Override
			public void leaveChannel() {
				_model.leaveChannel();
			}

			@Override
			public void sendInitMsg() {
				_model.sendInitMsg();

			}

			@Override
			public INamedRoomID getRoomID() {
				// TODO Auto-generated method stub
				return _model.getRoomID();
			}

		};

	}

	/**
	
	* Starts the miniMVC
	 */
	public void start() {
		_UUID = _model.start();
		_view.start();
	}

	/**
	
	* Gets the mini-control adapter
	* 	 * @return An instance of IModel2MiniCtrlAdapter
	 */
	public IModel2MiniCtrlAdapter getMiniControlAdpt() {
		return _m2cAdpt;
	}

	/**
	
	* Gets the UUID
	* 	 * @return An instnace of UUID
	 */
	public UUID getUUID() {
		return _UUID;
	}

}
