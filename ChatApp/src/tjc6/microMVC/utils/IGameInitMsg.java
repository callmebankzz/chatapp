package tjc6.microMVC.utils;

import java.util.UUID;

import common.dataPacket.data.IRoomConnectionData;
import common.dataPacket.data.room.ITextData;
import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketID;

/**

 * An interface for the initial game message.
 * 
 * @author tyrac
 *  *
 */
public interface IGameInitMsg extends IRoomConnectionData {

	/**
	 * @return the DataPacketID (host identifier) of this data type
	 */
	public static IDataPacketID GetID() {
		return DataPacketIDFactory.Singleton.makeID(ITextData.class);
	}

	/**
	 * Delegates to the static GetID() method to retrieve the DataPacketID of this object.
	 * @return the DataPacketID (host identifier) of this object
	 */
	@Override
	public default IDataPacketID getID() {
		return ITextData.GetID();
	}

	/**
	 * Factory method that constructs a concrete IGameInitMsg object.
	 * @param text text message
	 * @return concrete IGameInitMsg object
	 */
	public static IGameInitMsg make(String text) {
		return new IGameInitMsg() {

			/**
			 * A serial version UID.
			 */
			private static final long serialVersionUID = -7880120952209826763L;

			@Override
			/**
			 * Returns the UUID of the main model.
			 * 
			 * @return the UUID of the main model.
			 */
			public UUID getMainModelUUID() {
				// TODO Auto-generated method stub
				return null;
			}

		};
	}

	/**
	 * Returns the UUID of the main model.
	 * 
	 * @return the UUID of the main model.
	 */
	public UUID getMainModelUUID();

}