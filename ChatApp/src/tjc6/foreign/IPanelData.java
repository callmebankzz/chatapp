package tjc6.foreign;

import java.awt.Color;
import java.util.function.Supplier;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;

import common.dataPacket.data.IRoomConnectionData;
import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketID;

/**
 * An interface storing information about the Panel
 * @author tinaw
 *
 */
public interface IPanelData extends IRoomConnectionData {

	/**
	 * The host identifier.
	 */
	public static IDataPacketID ID = DataPacketIDFactory.Singleton.makeID(IPanelData.class);

	/**
	 * @return the DataPacketID (host identifier) of this data type
	 */
	public static IDataPacketID GetID() {
		return IPanelData.ID;
	}

	/**
	 * Delegates to the static GetID() method to retrieve the DataPacketID of this object.
	 * @return the DataPacketID (host identifier) of this object
	 */
	@Override
	public default IDataPacketID getID() {
		return IPanelData.GetID();
	}

	/**
	 * @return JComponent supplier contained in this data object
	 */
	public Supplier<JComponent> getPanelSupplier();

	/**
	 * Create an IPanel
	 * @return a new IPanelData object
	 */
	public static IPanelData make() {
		return new IPanelData() {

			/**
			 * A serial version UID
			 */
			private static final long serialVersionUID = -826931305519937488L;

			@Override
			public Supplier<JComponent> getPanelSupplier() {
				return () -> {
					JPanel panel = new JPanel();
					panel.setBackground(Color.pink);
					panel.add(new JButton("Does Nothing"));

					return panel;
				};
			}
		};
	}
}