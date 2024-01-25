package tjc6.miniMVC.miniController;

import java.util.HashSet;

import common.serverObj.INamedAppConnection;
import provided.pubsubsync.IPubSubSyncManager;
import provided.rmiUtils.RMIPortConfigWithBoundName;

/**

 * A control-to-model adapter for the miniMVC.
 * @author tinaw
 *  *
 */
public interface IMiniCtrl2MiniModelAdapter {

	/**
	 * Called by a MiniController when it wants to exit the chatroom it represents and 
	 * have its view removed from the main-MVC.
	 * 
	 * @param toExit The MiniController to remove (this)
	 */
	void leaveRoom(MiniController toExit);

	/**
	 * Gets the PubSubManager
	 * @return An instance of IPubSubSyncManager
	 */
	public IPubSubSyncManager getPubSubManager();

	/**
	 * Gets the config
	 * @return An instance of RMIPortConfigWithBoundName
	 */
	public RMIPortConfigWithBoundName getConfig();

	/**
	 * Gets the connected user
	 * @return An instance of HashSet<INamedConnection>
	 */
	public HashSet<INamedAppConnection> getConnectedUsers();

	/**
	 * Gets the username
	 * @return A string representing the username
	 */
	public String getUsername();

	/**
	 * Gets the named connection
	 * @return An instance of INamedAppConnection
	 */
	public INamedAppConnection getNamedConnection();

}
