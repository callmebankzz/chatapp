package tjc6.foreign;

import common.dataPacket.ARoomDataPacketAlgoCmd;
import common.dataPacket.ICmd2ModelAdapter;
import common.dataPacket.RoomDataPacket;
import provided.datapacket.IDataPacketID;

/**
 * A class to process the Panel data.
 * @author tyrac
 *
 */
public class PanelDataCmd extends ARoomDataPacketAlgoCmd<IPanelData> {

	/**
	 * A serial version UID.
	 */
	private static final long serialVersionUID = -7829282157260475491L;

	/**
	 * A constructor for the PanelDataCmd class
	 * @param c2mAdpt An instance of ICmd2ModelAdapter
	 */
	public PanelDataCmd(ICmd2ModelAdapter c2mAdpt) {
		this.setCmd2ModelAdpt(c2mAdpt);
	}

	@Override
	public Void apply(IDataPacketID index, RoomDataPacket<IPanelData> host, Void... params) {
		this.getCmd2ModelAdpt().displayJComponent("", host.getData().getPanelSupplier());
		return null;
	}

}