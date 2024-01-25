package tjc6.miniMVC.miniModel;

import java.util.UUID;

import provided.pubsubsync.IPubSubSyncManager;
import provided.rmiUtils.RMIPortConfigWithBoundName;

/**

 * The interface for the mini-model-to-mini-controller adapter
 * @author tinaw
 *  *
 */
public interface IMiniModel2MiniCtrlAdapter {

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
	 * Gets the room's name
	 * @return An instance of String
	 */
	public String getRoomName();

	/**
	 * Gets the room's UUID
	 * @return An instance of UUID
	 */
	public UUID getUUID();

	/**
	 * Gets the username
	 * @return A string representing the username
	 */
	public String getUsername();
}
