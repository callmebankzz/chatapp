package tjc6.mainMVC.view;

import common.serverObj.INamedAppConnection;
import common.serverObj.INamedRoomID;

/**

 * Adapter from the client's view to its model
 *  *
 */
public interface IView2ModelAdapter {

	/**
	
	* Manually connect to the remote system at the given IP address.
	* 	 * 
	* 	 * @param remoteIP The IP address to connect to
	* 	 * @return A connection status message
	 */
	String connectTo(String remoteIP);

	/**
	
	* Shut down the RMI and quit the application.
	 */
	void quit();

	/**
	
	* Makes a chatroom
	* 	 * @param name The name of the chatroom.
	 */
	void makeChatroom(INamedRoomID namedRoomID);

	/**
	
	* Starts the chatapp
	* 	 * @param username The name of the instance.
	 */
	void startChatApp(String username);

	/**
	
	* Sends an initialization message
	 */
	void sendInitMsg();

	void requestRooms(INamedAppConnection itemAt);
}
