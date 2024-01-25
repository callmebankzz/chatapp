package tjc6.foreign;

import java.util.function.Supplier;

import javax.swing.JComponent;

import common.dataPacket.ARoomDataPacketAlgoCmd;
import common.dataPacket.ICmd2ModelAdapter;
import common.dataPacket.RoomDataPacket;
import provided.datapacket.IDataPacketID;
import provided.mixedData.IMixedDataDictionary;
import provided.owlMaps.control.IOwlMapControl;
import provided.owlMaps.map.IMapOptions;
//import provided.owlMaps.map.IOwlMap;

/**
 * A class to process the maps data
 * @author tyrac
 *
 */
public class MapsDataCmd extends ARoomDataPacketAlgoCmd<IMapsData> {

	/**
	 * A serial version UID.
	 */
	private static final long serialVersionUID = -7829282157260475491L;

	/**
	 * A constructor for the ButtonDataCmd class
	 * @param c2mAdpt An instance of ICmd2ModelAdapter
	 */
	public MapsDataCmd(ICmd2ModelAdapter c2mAdpt) {
		this.setCmd2ModelAdpt(c2mAdpt);
	}

	@Override
	/**
	 * Apply method for the map command.
	 */
	public Void apply(IDataPacketID index, RoomDataPacket<IMapsData> host, Void... params) {

		// Options to render the map with
		IMixedDataDictionary mapOptions = IMapOptions.makeDefault(); /* extract dictionary from host's data */;

		// Declare the entire map in the factory but do NOT run it yet
		Supplier<JComponent> mapFactory = IOwlMapControl.makeMapFactory(getCmd2ModelAdpt().getAPIKey(), mapOptions,
				(owlMapControl) -> {

					// Your initial processing of the map here...

					//IOwlMap map = owlMapControl.getMap(); // map is not available until now

					// Your map control initializations here...
					
				}, getCmd2ModelAdpt().getLocalLogger());

		// Display the map on the view
		getCmd2ModelAdpt().displayJComponent("New Map", mapFactory);

		return null;
	}

}
