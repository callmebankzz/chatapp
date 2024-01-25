package tjc6.mainMVC.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.function.Supplier;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import common.serverObj.INamedAppConnection;
import common.serverObj.INamedRoomID;
import provided.logger.ILoggerControl;
import provided.utils.view.TabbedPanel;
import javax.swing.JComboBox;

/**

 * The main view for the client.
 * 
 * @author ben
 * @author tyrac
 */
public class View extends JFrame {

	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = 190283953475672847L;

	/**
	 * The adapter to the model
	 */
	private IView2ModelAdapter _v2mAdpt;

	/**
	 * The default remote host reference
	 */
	private static final String DEFAULT_REMOTE_HOST = "localhost";

	/**
	 * The default room name
	 */
	private static final String DEFAULT_ROOM_NAME = "roomname";

	/**
	 * The default username
	 */
	private static final String DEFAULT_USERNAME = "username";

	/**
	 * Main panel with controls
	 */
	private final JPanel _pnlControl = new JPanel();

	/**
	 * Tabbed panel for showing connected chatrooms
	 */
	private final TabbedPanel _pnlRooms = new TabbedPanel("Chatrooms", ILoggerControl.getSharedLogger(), false);

	/**
	 * The remote server's IP address info input text field
	 */
	private JTextField _tfRemoteHost;

	/**
	 * Panel for remote host config
	 */
	private JPanel _remoteHostPnl;

	/**
	 * The connect button
	 */
	private JButton _btnConnect;

	/**
	 * The scrollbars for the text area
	 */
	private final JScrollPane _spDisplay = new JScrollPane();

	/**
	 * Message display text area
	 */
	private final JTextArea _taDisplay = new JTextArea();

	/**
	 * Button to manually quit the client
	 */
	private final JButton _btnQuit = new JButton("Quit");

	/**
	 * The panel to create a room
	 */
	private JPanel _createRoomPnl;

	/**
	 * The text field for the room name
	 */
	private JTextField _tfRoomName;
	
	/**
	 * The INamedRoomID of the room
	 */
	private INamedRoomID _namedRoomID;

	/**
	 * A button to create a room
	 */
	private JButton _btnCreateRoom;

	/**
	 * The control panel
	 */
	private JPanel _appCtrlPnl;

	/**
	 * The text field for the username
	 */
	private JTextField _tfUsername;

	/**
	 * The panel for quitting and launching
	 */
	private JPanel _LaunchQuitPnl;

	/**
	 * The launch button
	 */
	private JButton _btnLaunch;

	/**
	 * A boolean representing whether a chatroom has been launched.
	 */
	private boolean _launchFlag = false;
	private JPanel pnlButtons;
	private JButton btnSendInitMessages;
	private JButton btnRequestRooms;
	private JComboBox<INamedAppConnection> dropDownList;
	private JComboBox<INamedRoomID> dropDownRoomsList;

	/**
	 * The constructor for the client's view.
	 * 	
	 * @param v2mAdpt  a view to model adapter client
	 */
	public View(IView2ModelAdapter v2mAdpt) {
		this._v2mAdpt = v2mAdpt;
		initGUI();
	}

	/**
	 * Initialize the GUI.
	 */
	private void initGUI() {
		setTitle("Chatapp");
		setBounds(100, 100, 990, 622);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnRequestRooms = new JButton("Request Rooms");
		btnRequestRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.requestRooms(dropDownList.getItemAt(dropDownList.getSelectedIndex()));
			}
		});
		
		dropDownRoomsList = new JComboBox<INamedRoomID>();
		_pnlControl.add(dropDownRoomsList);
		
		dropDownList = new JComboBox<INamedAppConnection>();
		_pnlControl.add(dropDownList);
		_pnlControl.add(btnRequestRooms);

		_appCtrlPnl = new JPanel();
		_pnlControl.add(_appCtrlPnl);
		_appCtrlPnl
				.setBorder(new TitledBorder(null, "App Control", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_appCtrlPnl.setLayout(new GridLayout(2, 1, 0, 0));

		_tfUsername = new JTextField(DEFAULT_USERNAME);
		_appCtrlPnl.add(_tfUsername);
		_tfUsername.setColumns(10);

		_LaunchQuitPnl = new JPanel();
		_appCtrlPnl.add(_LaunchQuitPnl);
		_LaunchQuitPnl.setLayout(new GridLayout(0, 2, 0, 0));

		_btnLaunch = new JButton("Launch");
		_btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.startChatApp(_tfUsername.getText());
				_launchFlag = true;
			}
		});
		_LaunchQuitPnl.add(_btnLaunch);
		_LaunchQuitPnl.add(_btnQuit);
		_btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.quit();
			}
		});

		_remoteHostPnl = new JPanel();
		_remoteHostPnl
				.setBorder(new TitledBorder(null, "Remote Host", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_pnlControl.add(_remoteHostPnl);
		_remoteHostPnl.setLayout(new GridLayout(2, 1, 0, 0));
		_tfRemoteHost = new JTextField(DEFAULT_REMOTE_HOST);
		_remoteHostPnl.add(_tfRemoteHost);
		_tfRemoteHost.setToolTipText("The IP address of the remote user");
		_tfRemoteHost.setPreferredSize(new Dimension(100, 25));
		{
			_btnConnect = new JButton();
			_remoteHostPnl.add(_btnConnect);
			_btnConnect.setToolTipText("Click to connect to the remote user");
			_btnConnect.setText("Connect");
			_btnConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (_launchFlag == true)
						connect();
				}
			});
		}
		_tfRemoteHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (_launchFlag == true)
					connect();
			}
		});

		getContentPane().add(_pnlControl, BorderLayout.NORTH);

		_createRoomPnl = new JPanel();
		_createRoomPnl
				.setBorder(new TitledBorder(null, "New Chatroom", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_pnlControl.add(_createRoomPnl);
		_createRoomPnl.setLayout(new GridLayout(2, 1, 0, 0));

		_namedRoomID = INamedRoomID.make(DEFAULT_ROOM_NAME, null);
		
		_tfRoomName = new JTextField(_namedRoomID.getName());
				//new JTextField(DEFAULT_ROOM_NAME);
		_createRoomPnl.add(_tfRoomName);
		_tfRoomName.setColumns(10);

		_btnCreateRoom = new JButton("Create Room");
		_btnCreateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (_launchFlag == true)
					_v2mAdpt.makeChatroom(_namedRoomID);
			}
		});
		_createRoomPnl.add(_btnCreateRoom);

		getContentPane().add(_pnlRooms, BorderLayout.CENTER);

		pnlButtons = new JPanel();
		_pnlRooms.add(pnlButtons, BorderLayout.SOUTH);

		btnSendInitMessages = new JButton("Send Init Messages");
		pnlButtons.add(btnSendInitMessages);

		_taDisplay.setRows(20);
		_spDisplay.setViewportView(_taDisplay);

		btnSendInitMessages.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.sendInitMsg();
			}

		});

	}

	/**
	 * Append the given message with a newline to the text area.
	 * 	 
	 * @param msg The message to display
	 */
	public void append(String msg) {
		_taDisplay.append(msg + '\n');
	}

	/**
	 * Start the view.
	 */
	public void start() {
		setVisible(true);
		//setResizable(false);
	}

	/**
	 * Have the model connect to the remote server.
	 */
	private void connect() {
		String remoteIP = _tfRemoteHost.getText();
		append("Attempting to connect to " + remoteIP + "...\n");
		append("[Connection status] " + _v2mAdpt.connectTo(remoteIP) + '\n');
	}

	/**
	 * Add the given component to the control panel, then revalidate and pack the frame.
	 * 
	 * @param comp The component to add
	 */
	public void addCtrlComponent(JComponent comp) {
		_pnlControl.add(comp);
		validate();
		pack();
		setSize(new Dimension(1000, 800));
	}

	/**
	
	* Installs the provided miniView into a new tab within the chatroom display panel
	* 	 * labeled with the provided room name.
	* 	 * 
	* 	 * @param roomName The name of the chatroom to be added (the label of the new tab)
	* 	 * @param supplier The supplier of the MiniView to be installed
	 */
	public Runnable addMiniView(String roomName, Supplier<JComponent> supplier) {
		return _pnlRooms.addComponentFac(roomName, supplier);
	}

	/**
	 * Add users to a drop down list
	 * @param connections the users you want to add to the drop down list
	 */
	public void addUsers(HashSet<INamedAppConnection> connections) {
		// TODO Auto-generated method stub
		for (INamedAppConnection connection : connections) {
			dropDownList.insertItemAt(connection, 0);
		}
	}
	
	/**
	 * Add rooms to a drop down list.
	 * @param rooms the rooms you want to add to the drop down list
	 */
	public void addRooms(HashSet<INamedRoomID> rooms) {
		for (INamedRoomID room : rooms) {
			dropDownRoomsList.insertItemAt(room, 0);
		}
	}
}
