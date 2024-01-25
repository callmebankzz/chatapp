package tjc6.microMVC.view;

import java.util.HashSet;
import java.util.List;

import common.serverObj.INamedAppConnection;

/**
 * Interface for the micro view to model adapter.
 * 
 * @author tyrac
 */
public interface IMicroView2ModelAdapter {

    /**
	 * Sends a text message
	 * 
	 * @param message The text message to send
	 */
	void sendTextMessage(String message);

	/**
	 * Exits a game
	 */
	void exitGame();

	/**
	 * Gets the connected users
	 * 
	 * @return An instance of HashSet<INamedConnection>
	 */
	HashSet<INamedAppConnection> getConnectedUsers();

	/**
	 * Invites users
	 * 
	 * @param invitees An instance of List<INamedConnection>
	 */
	void inviteUsers(List<INamedAppConnection> invitees);

	/**
	 * Invites a user
	 * 
	 * @param invitee The user to invite
	 */
	void inviteUser(INamedAppConnection invitee);

	/**
	 * Actions taken when a gameplay button is pressed.
	 * 
	 * @param string the name of the button
	 */
	void buttonPressed(int button);
}
