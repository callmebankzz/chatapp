package tjc6.microMVC.utils;

import java.util.UUID;

import common.dataPacket.ARoomDataPacketAlgoCmd;
import common.dataPacket.RoomDataPacket;
import provided.datapacket.IDataPacketID;
//import tjc6.microMVC.model.GameMicroModel;
//import tjc6.microMVC.view.GameMicroView;

/**

 * Class for the game initial command.
 * 
 * @author tyrac
 *  *
 */
public class GameInitCmd extends ARoomDataPacketAlgoCmd<IGameInitMsg> {
	/**
	 * A serial version UID
	 */
	private static final long serialVersionUID = -8482781291558855217L;
	//private UUID gameUUID;
	//private GameMicroModel gameMicroModel;
	//private GameMicroView gameMicroView;

	/**
	
	* Constructor is called by the game server because that's who instantiates the game commands.
	* 	 * @param gameUUID The UUID identifying the current instance of the game server.
	 */
	public GameInitCmd(UUID gameUUID) {
		//this.gameUUID = gameUUID;
	}

	@Override
	public Void apply(IDataPacketID index, RoomDataPacket<IGameInitMsg> host, Void... params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Applies the game.
	 
	public GameMicroView apply(IDataPacketID index, RoomDataPacket<IGameInitMsg> host, Void... nu) {

		// The name and signature of the method may vary as it is defined by the API.
		getCmd2ModelAdpt().displayJComponent("Wheel of Misfortune", () -> {
			// This command is essentially the micro-controller, so there's 
			// no real need for an explicit named class for the micro-controller.
			// The typical controller's constructor code is just being written out here:

			// Instantiate the model and view components with their normal adapters.
			// The adapter code is elided here as it is game-dependent.  Use adapter names that fit the game implemenation.
			//gameMicroModel = new GameMicroModel(null, gameUUID, null);
			gameMicroView = new GameMicroView(null);

			//				// Start the model and view
			//				gameMicroModel.start();
			//				gameMicroView.start();
			//				
			//				// Create the adapter(s) to the micro-MVC.   Make as many as needed.
			//				IGameMicroAdapter gameAdpt = new IGameMicroAdapter() {
			//					// methods that access the micro-model/view
			//				};
			//				
			//				// Make the keys to the game adapters. Use an informative description string.
			//				MixedDataKey<IGameMicroAdapter> adapterKey = new MixedDataKey(gameUUID, "IGameMicroAdapter", IGameMicroAdapter.class);
			//				// Make a unique key for each adapter being stored. 
			//		
			//				// Store the adapter(s) in the local storage for other game-commands to retrieve.
			//				// The name and signature of the method may vary as it is defined by the API.
			//				getCmd2ModelAdpt().putLocalData(adapterKey, gameAdpt);  
			//				// Add as many adapters to the local storage as needed, each with their own key.

			return gameMicroView; // Return the micro-view so that it will be displayed on the client's UI.
		});
		return null;
	}
	*/
}