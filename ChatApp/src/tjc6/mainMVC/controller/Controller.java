package tjc6.mainMVC.controller;

import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import tjc6.mainMVC.view.View;
import tjc6.mainMVC.view.IView2ModelAdapter;
import common.serverObj.IInitialAppConnection;
import common.serverObj.INamedAppConnection;
import common.serverObj.INamedRoomID;
import tjc6.mainMVC.model.IModel2ViewAdapter;
import tjc6.mainMVC.model.Model;
import provided.config.impl.AppConfigChooser;
import provided.discovery.IEndPointData;
import provided.discovery.impl.model.DiscoveryModel;
import provided.discovery.impl.model.IDiscoveryModelToViewAdapter;
import provided.discovery.impl.view.DiscoveryPanel;
import provided.discovery.impl.view.IDiscoveryPanelAdapter;
import provided.logger.ILogger;
import provided.logger.ILoggerControl;
import provided.logger.LogLevel;
import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIPortConfigWithBoundName;

/**

 * The controller of the client.
 * 
 * @author ben
 */
public class Controller {

	/**
	 * The system logger
	 */
	private ILogger _sysLogger = ILoggerControl.getSharedLogger();

	/**
	 * The client model
	 */
	private Model _model;

	/**
	 * The client view
	 */
	private View _view;

	/**
	 * The discovery server UI panel for the view
	 */
	private DiscoveryPanel<IEndPointData> _discPnl;

	/**
	 * A self-contained model to handle the discovery server. MUST be started after the main 
	 * model as it requires the IRMIUtils from the model!
	 */
	private DiscoveryModel<IInitialAppConnection> _discModel;

	/**
	 * The AppConfig.
	 */
	private RMIPortConfigWithBoundName _appConfig;

	/**
	 * The AppConfigChooser
	 */
	private AppConfigChooser<RMIPortConfigWithBoundName> _appConfigChooser = new AppConfigChooser<RMIPortConfigWithBoundName>(
			0,
			new RMIPortConfigWithBoundName("AppA", IRMI_Defs.STUB_PORT_EXTRA, IRMI_Defs.CLASS_SERVER_PORT_EXTRA,
					"BoundNameA"),
			new RMIPortConfigWithBoundName("AppB", IRMI_Defs.STUB_PORT_SERVER, IRMI_Defs.CLASS_SERVER_PORT_SERVER,
					"BoundNameB"),
			new RMIPortConfigWithBoundName("AppC", IRMI_Defs.STUB_PORT_CLIENT, IRMI_Defs.CLASS_SERVER_PORT_CLIENT,
					"BoundNameC"));

	/**
	
	* Constructor for the controller.
	 */
	public Controller() {
		_sysLogger.setLogLevel(LogLevel.DEBUG);

		// Initialize app config
		_appConfig = _appConfigChooser.choose();

		_discPnl = new DiscoveryPanel<IEndPointData>(new IDiscoveryPanelAdapter<IEndPointData>() {

			/**
			 * watchOnly is ignored b/c discovery model configured for watchOnly = true
			 */
			@Override
			public void connectToDiscoveryServer(String category, boolean watchOnly,
					Consumer<Iterable<IEndPointData>> endPtsUpdateFn) {
				_discModel.connectToDiscoveryServer(category, endPtsUpdateFn);
			}

			@Override
			public void connectToEndPoint(IEndPointData selectedValue) {
				_discModel.connectToEndPoint(selectedValue);
			}

		}, true, true);

		_discModel = new DiscoveryModel<IInitialAppConnection>(_sysLogger,
				new IDiscoveryModelToViewAdapter<IInitialAppConnection>() {

					@Override
					public void addStub(IInitialAppConnection stub) {
						_model.connectToStub(stub);
					}

				});

		_model = new Model(_appConfig, _sysLogger, new IModel2ViewAdapter() {

			@Override
			public void displayMsg(String msg) {
				_view.append(msg);
			}

			@Override
			public Runnable addMiniView(String name, Supplier<JComponent> supplier) {
				return _view.addMiniView(name, supplier);
			}

			@Override
			public void addUsers(HashSet<INamedAppConnection> connections) {
				// TODO Auto-generated method stub
				_view.addUsers(connections);
			}

			@Override
			public void addRooms(HashSet<INamedRoomID> sentRooms) {
				// TODO Auto-generated method stub
				_view.addRooms(sentRooms);
			}

		});

		_view = new View(new IView2ModelAdapter() {

			@Override
			public String connectTo(String remoteIP) {
				return _model.connectTo(remoteIP);
			}

			@Override
			public void quit() {
				_model.stop();
			}

			/**
			 * Creates a chatroom
			 * @param name The name of the chatroom.
			 */
			public void makeChatroom(INamedRoomID namedRoomID) {
				_model.createChatroom(namedRoomID);
			}

			/**
			 * Starts the chatroom 
			 * @param username The username
			 */
			public void startChatApp(String username) {
				_discModel.start(_model.getRMIUtils(), username, _appConfig.boundName);
				_model.startApp(username);
			}

			@Override
			public void sendInitMsg() {
				_model.sendInitMsg();

			}

			@Override
			public void requestRooms(INamedAppConnection itemAt) {
				// TODO Auto-generated method stub
				_model.requestRooms(itemAt);
			}

		});

	}

	/**
	
	* Starts the view, then the model + discovery panel + discovery model. The discovery panel is added to 
	* 	 * the main view after the discovery model starts.
	 */
	public void start() {
		_model.start();
		_discPnl.start();
		_discModel.start(_model.getRMIUtils(), _appConfig.name, _appConfig.boundName);
		_view.addCtrlComponent(_discPnl);
		_view.start();
	}

	/**
	
	* Run the app.
	* 	 * 
	* 	 * @param args NU
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			/**
			 * Runs the app.
			 */
			public void run() {
				(new Controller()).start();
			}
		});
	}

}
