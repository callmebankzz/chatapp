package tjc6.miniMVC.miniView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.function.Supplier;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import common.serverObj.INamedAppConnection;
import provided.logger.ILoggerControl;
import provided.logger.LogLevel;
import provided.utils.view.TabbedPanel;


/**

 * A mini view for a single chatroom.
 * 
 * @author ben
 * @author tyrac
 */
public class MiniView extends JPanel {

	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = -1118864218508147715L;

	/**
	 * The adapter to the mini-model
	 */
	private IMiniView2MiniModelAdapter _v2mAdpt;

	/**
	 * The main panel to be added to the main View's tabbed panel
	 */
	private final JPanel _pnlMain = new JPanel();

	/**
	 * A panel to hold the room roster and exit button
	 */
	private final JPanel _pnlUserCtrl = new JPanel();

	/**
	 * A panel to hold the exit button (to avoid resizing)
	 */
	private final JPanel _pnlExit = new JPanel();

	/**
	 * A panel to hold the message field and send button
	 */
	private final JPanel _pnlMessage = new JPanel();

	/**
	 * A panel to display past messages and send new messages
	 */
	private final JPanel _pnlMessageCtrl = new JPanel();

	/**
	 * A text field to enter a message to be sent
	 */
	private final JTextField _messageField = new JTextField();

	/**
	 * A scrollable pane for displaying a list of past messages
	 */
	private final JScrollPane _spDisplay = new JScrollPane();

	/**
	 * A text area to hold past messages
	 */
	private final JTextArea _taDisplay = new JTextArea();

	/**
	 * A scrollable pane for displaying a list of connected users
	 */
	private final JScrollPane _spUsers = new JScrollPane();

	/**
	 * A text area to hold connected users
	 */
	private final JTextArea _taUsers = new JTextArea();

	/**
	 * A split pane to display the roster of users alongside messages
	 */
	private final JSplitPane _splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, _pnlUserCtrl, _pnlMessageCtrl);

	/**
	 * A button to leave the chatroom
	 */
	private final JButton _btnLeaveRoom = new JButton("Exit Chatroom");

	/**
	 * A button to send the currently-entered message
	 */
	private final JButton _btnSendMsg = new JButton("Send");

	/**
	 * A button to send a game invitation.
	 */
	private final JButton _btnSendPanel = new JButton("Send Panel");

	/**
	 * A panel for the top
	 */
	private final TabbedPanel _tabbedPanel = new TabbedPanel("New Tabbed Panel");

	/**
	 * A panel for attachments
	 */
	private final JPanel _attachmentsPnl = new JPanel();

	/**
	 * A panel for inviting users
	 */
	private final JPanel _pnlInvite = new JPanel();

	/**
	 * The list of available users to invite
	 */
	private final JList<INamedAppConnection> _availableUsersLst = new JList<>();

	/**
	 * The invite button
	 */
	private final JButton _btnInvite = new JButton("Add User");

	/**
	 * A control panel for inviting users
	 */
	private final JPanel _pnlInviteCtrl = new JPanel();

	/**
	 * A button to send
	 */
	private final JButton _btnSendBtn = new JButton("Send Button");

	/**
	 * The constructor for a MiniView.
	 * 	  
	 * @param v2mAdpt An adapter to this MiniView's corresponding MiniModel
	 */
	public MiniView(IMiniView2MiniModelAdapter v2mAdpt) {
		this._v2mAdpt = v2mAdpt;
		initGUI();
	}

	/**
	 * Initialize the GUI.
	 */
	private void initGUI() {

		_tabbedPanel.getTabbedPane().addTab("Messaging", _splitPane);
		_tabbedPanel.getTabbedPane().addTab("Add Users", _pnlInvite);
		_tabbedPanel.getTabbedPane().addTab("Attachments", _attachmentsPnl);
		//_tabbedPanel.getTabbedPane().addTab("Gaming", new GameMicroView((IMicroView2ModelAdapter) _v2mAdpt));

		_pnlInvite.setLayout(new GridLayout(0, 1, 0, 0));

		_pnlInvite.add(_availableUsersLst);

		_pnlInvite.add(_pnlInviteCtrl);
		_pnlInviteCtrl.add(_btnInvite);
		_btnInvite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.inviteUser(_availableUsersLst.getSelectedValue());
			}
		});

		_pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		_pnlMessageCtrl.setLayout(new GridLayout(0, 1, 0, 0));
		_pnlUserCtrl.setLayout(new GridLayout(2, 1, 0, 0));
		_pnlMessage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		_taUsers.setEditable(false);

		_taUsers.setBorder(new TitledBorder(null, "Users", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_taDisplay.setEditable(false);
		_taDisplay.setBorder(new TitledBorder(null, "Messages", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		_taUsers.setRows(20);
		_taDisplay.setRows(20);
		_taUsers.setColumns(18);
		_taDisplay.setColumns(58);
		_messageField.setColumns(30);

		_spUsers.setViewportView(_taUsers);
		_spDisplay.setViewportView(_taDisplay);

		_splitPane.setDividerSize(4);

		_pnlUserCtrl.add(_spUsers);
		_pnlUserCtrl.add(_pnlExit);
		_pnlMessage.add(_messageField);
		_pnlMessage.add(_btnSendMsg);
		_pnlMessageCtrl.add(_spDisplay);
		_pnlMessageCtrl.add(_pnlMessage);
		_btnSendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.sendButton();
			}
		});

		_pnlMessage.add(_btnSendBtn);
		_pnlMessage.add(_btnSendPanel);

		_pnlExit.add(_btnLeaveRoom);

		_pnlMain.add(_tabbedPanel);

		_btnLeaveRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.leaveRoom();
			}
		});

		_btnSendMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (_messageField.getText() != null && _messageField.getText() != "") {
					_v2mAdpt.sendTextMessage(_messageField.getText());
				}
			}
		});

		_btnSendPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.sendPanel();
			}
		});

	}

	/**
	
	* Start the view.
	 */
	public void start() {
		HashSet<INamedAppConnection> connectedUsersSet = _v2mAdpt.getConnectedUsers();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				_availableUsersLst
						.setListData(connectedUsersSet.toArray(new INamedAppConnection[connectedUsersSet.size()]));

			}
		});

		setVisible(true);

	}

	/**
	
	* Append the given message with a newline to the text area.
	* 	 * 
	* 	 * @param msg The message to display
	 */
	public void append(String msg) {
		_taDisplay.append(msg + "\n");
	}

	/**
	
	 * Add the JComponent retrieved from the provided supplier to the attachment
	 * panel.
	 * 	  
	 * @param supplier The supplier of a JComponent
	 */
	public void displayComponent(Supplier<JComponent> supplier) {
		_attachmentsPnl.add(supplier.get());
		_tabbedPanel.getTabbedPane().addTab("test", supplier.get());
		validate();
	}

	/**
	
	* Displays the roster
	* 	 * @param roster The roster to be displayed
	 */
	public void displayRoster(String roster) {
		ILoggerControl.getSharedLogger().log(LogLevel.DEBUG, "Displaying roster: " + roster);

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				_taUsers.setText(roster);
				ILoggerControl.getSharedLogger().log(LogLevel.DEBUG, "Displayed roster");
			}
		});

	}

	public JComponent getMainPnl() {
		return _pnlMain;
	}

	public void updateAvailableUsers(HashSet<INamedAppConnection> users) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				_availableUsersLst.setListData(users.toArray(new INamedAppConnection[users.size()]));

			}
		});
	}

}
