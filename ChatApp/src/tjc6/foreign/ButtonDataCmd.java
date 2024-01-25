package tjc6.foreign;

import common.dataPacket.ARoomDataPacketAlgoCmd;
import common.dataPacket.ICmd2ModelAdapter;
import common.dataPacket.RoomDataPacket;
import provided.datapacket.IDataPacketID;

/**
 * A class to process the button data.
 * @author tinaw
 *
 */
public class ButtonDataCmd extends ARoomDataPacketAlgoCmd<IButtonData> {

	/**
	 * A serial version UID.
	 */
	private static final long serialVersionUID = -7829282157260475491L;

	/**
	 * A constructor for the ButtonDataCmd class
	 * @param c2mAdpt An instance of ICmd2ModelAdapter
	 */
	public ButtonDataCmd(ICmd2ModelAdapter c2mAdpt) {
		this.setCmd2ModelAdpt(c2mAdpt);
	}

	@Override
	public Void apply(IDataPacketID index, RoomDataPacket<IButtonData> host, Void... params) {
		this.getCmd2ModelAdpt().displayJComponent("", host.getData().getButtonSupplier());
		return null;
	}

}