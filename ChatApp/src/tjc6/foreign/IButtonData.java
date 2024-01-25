package tjc6.foreign;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

import javax.swing.JButton;
import javax.swing.JComponent;

import common.dataPacket.data.IRoomConnectionData;
import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketID;

/**
 * An interface storing information about the button
 * @author tinaw
 *
 */
public interface IButtonData extends IRoomConnectionData {

	/**
	 * The host identifier.
	 */
	public static IDataPacketID ID = DataPacketIDFactory.Singleton.makeID(IButtonData.class);

	/**
	 * @return the DataPacketID (host identifier) of this data type
	 */
	public static IDataPacketID GetID() {
		return IButtonData.ID;
	}

	/**
	 * Delegates to the static GetID() method to retrieve the DataPacketID of this object.
	 * @return the DataPacketID (host identifier) of this object
	 */
	@Override
	public default IDataPacketID getID() {
		return IButtonData.GetID();
	}

	/**
	 * @return JComponent supplier contained in this data object
	 */
	public Supplier<JComponent> getButtonSupplier();

	/**
	 * Create an IButton
	 * @return a new IButtonData object
	 */
	public static IButtonData make() {
		return new IButtonData() {

			/**
			 * A serial version UID
			 */
			private static final long serialVersionUID = -826931305519937488L;

			@Override
			public Supplier<JComponent> getButtonSupplier() {
				return () -> {
					JButton button = new JButton(Integer.toString(0));

					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String newText = Integer.toString(Integer.parseInt(button.getText()) + 1);
							button.setText(newText);
						}
					});

					return button;
				};
			}
		};
	}
}