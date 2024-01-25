package tjc6.foreign;

import common.dataPacket.data.IRoomConnectionData;
import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketID;
import provided.mixedData.IMixedDataDictionary;

/**
 * An interface storing information about the maps
 * @author tyrac
 *
 */
public interface IMapsData extends IRoomConnectionData {

	/**
	 * The host identifier.
	 */
	public static IDataPacketID ID = DataPacketIDFactory.Singleton.makeID(IMapsData.class);
	
	/**
	 * An IMixedDataDictionary representing the options to render the map with
	 */
	public static final IMixedDataDictionary _mdataDict = null;

	/**
	 * @return the DataPacketID (host identifier) of this data type
	 */
	public static IDataPacketID GetID() {
		return IMapsData.ID;
	}

	/**
	 * Delegates to the static GetID() method to retrieve the DataPacketID of this object.
	 * @return the DataPacketID (host identifier) of this object
	 */
	@Override
	public default IDataPacketID getID() {
		return IMapsData.GetID();
	}


	/**
	 * Create an IButton
	 * @return a new IMapsData object
	 */
	public static IMapsData make() {
		return new IMapsData() {

			/**
			 * A serial version UID
			 */
			private static final long serialVersionUID = -7019318274990686506L;


		};
	}
}
