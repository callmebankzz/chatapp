package tjc6.miniMVC.miniView;

import java.util.HashSet;
import java.util.List;

import common.serverObj.INamedAppConnection;

/**

 * The interface for mini-view to mini-model adapter
 * @author tinaw
 *  *
 */
public interface IMiniView2MiniModelAdapter {

	/**
	
	* Sends a text message
	* 	 * @param message The text message to send
	 */
	void sendTextMessage(String message);

	/**
	
	* Sends an IButtonData.
	 */
	void sendButton();

	/**
	
	* Sends an IPanelData.
	 */
	void sendPanel();

	/**
	
	* Leaves a room
	 */
	void leaveRoom();

	/**
	 * Gets the connected users
	 * @return An instance of HashSet<INamedConnection>
	 */
	HashSet<INamedAppConnection> getConnectedUsers();

	/**
	
	* Invites users
	* 	 * @param invitees An instance of List<INamedConnection>
	 */
	void inviteUsers(List<INamedAppConnection> invitees);

	/**
	
	* Invites a user
	* 	 * @param invitee The user to invite
	 */
	void inviteUser(INamedAppConnection invitee);
}
