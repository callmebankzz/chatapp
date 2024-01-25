package tjc6.miniMVC.miniController;

import java.util.HashSet;

import javax.swing.JComponent;

import tjc6.miniMVC.miniModel.MiniModel;
import common.serverObj.INamedAppConnection;
import common.serverObj.INamedRoomID;

/**
 * A model-2-mini control adapter
 * @author tinaw
 *  
 */
public interface IModel2MiniCtrlAdapter {

	/**
	 * Gets the mini-view
	 * 	 * @return An instance of JComponent
	 */
	JComponent getMiniView();

	/**
	 * Gets the mini-model
	 * @return An instnace of MiniModel
	 */
	MiniModel getMiniModel();

	/**
	 * Updates the connected users
	 * @param newUserSet A set representing the new users
	 */
	void updateConnectedUsers(HashSet<INamedAppConnection> newUserSet);

	/**
	 * Leaves the channel
	 */
	void leaveChannel();

	/**
	 * Sends an init message
	 */
	void sendInitMsg();
	
	INamedRoomID getRoomID();
}
