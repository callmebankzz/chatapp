package tjc6.microMVC.utils;

import java.util.UUID;

/**

 * Class for the initial game message.
 * @author tyrac
 *  *
 */
public class GameInitMsg implements IGameInitMsg {

	/**
	 * A generated version serial
	 */
	private static final long serialVersionUID = 1932288375152662249L;

	private UUID _mainModelID;

	/**
	
	* A constructor for the IGameInitMsg class
	 */
	public GameInitMsg(UUID mainModelID) {
		_mainModelID = mainModelID;
	}

	@Override
	/**
	 * Returns a UUID for the main model.
	 * 
	 * @return the main model UUID
	 */
	public UUID getMainModelUUID() {
		return _mainModelID;
	}

}
