package tjc6.microMVC.controller;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import javax.swing.JComponent;
import common.serverObj.INamedAppConnection;
import common.serverObj.INamedRoomConnection;
import provided.logger.ILogger;
import provided.logger.ILoggerControl;
import provided.logger.LogLevel;
import tjc6.microMVC.model.GameMicroModel;
import tjc6.microMVC.model.IMicroModel2ViewAdapter;
import tjc6.microMVC.view.GameMicroView;
import tjc6.microMVC.view.IMicroView2ModelAdapter;
//import tjc6.miniMVC.miniController.IMiniCtrl2ModelAdapter;

public class GameMicroController {

	/**
	 * Constant for the max amount of teams allowed in a game.
	 */
	//private static final int MAX_TEAMS = 2;

	/**
	 * An instance of ILogger
	 */
	private ILogger _sysLogger = ILoggerControl.getSharedLogger();

	/**
	 * An instance of MicroModel
	 */
	private GameMicroModel _model;

	/**
	 * An instance of MicroView
	 */
	private GameMicroView _view;

	/**
	 * An instance of UUID
	 */
	private UUID _UUID;

	/**
	 * An instance of an IMicroView2ModelAdapter
	 */
	IMicroView2ModelAdapter _v2mAdpt;

	/**
	 * An instance of an IMicroModel2ViewAdapter
	 */
	IMicroModel2ViewAdapter _m2vAdpt;

	/**
	 * A constructor for the MiniController class
	 * 	  @param roomName An instance of IRoom
	 * 	  @param uuid An instance of UUID
	 * 	  @param miniCtrl2ModelAdpt An instance of IMiniCtrl2ModelAdapter
	 */
	public GameMicroController(UUID uuid, IMicroView2ModelAdapter v2mAdpt, IMicroModel2ViewAdapter m2vAdpt) {

		_v2mAdpt = v2mAdpt;

		_m2vAdpt = m2vAdpt;

		_UUID = uuid;

		_sysLogger.setLogLevel(LogLevel.DEBUG);

		_model = new GameMicroModel(_sysLogger, uuid, new IMicroModel2ViewAdapter() {

			/**
			 * Displays the message
			 * @param msg The message to display
			 */
			public void displayMsg(String msg) {
				_view.append(msg);
			}

			@Override
			public void displayComponent(Supplier<JComponent> supplier) {
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

			@Override
			public void updateTimer(int second) {
				// TODO Auto-generated method stub
				_view.updateTimer(second);
			}

			@Override
			public void changePanelColor(Boolean buttonStatus) {
				_view.changePanelColor(buttonStatus);
			}

		});

		_view = new GameMicroView(new IMicroView2ModelAdapter() {

			@Override
			public void sendTextMessage(String message) {
				
			}

			@Override
			public void exitGame() {
				
				_model.exitGame();
				_view.exitGame();
			}

			@Override
			public HashSet<INamedAppConnection> getConnectedUsers() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void inviteUsers(List<INamedAppConnection> invitees) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void inviteUser(INamedAppConnection invitee) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void buttonPressed(int button) {
				_model.buttonPressed(button);
				
			}
			
		});

	}

	/**
	 * Starts the miniMVC
	 */
	public void start() {
		_UUID = _model.start();
		_view.start();
	}

	/**
	 * Gets the UUID
	 * @return An instnace of UUID
	 */
	public UUID getUUID() {
		return _UUID;
	}
	
}
