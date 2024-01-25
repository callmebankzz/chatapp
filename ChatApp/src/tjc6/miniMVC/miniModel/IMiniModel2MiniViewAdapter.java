package tjc6.miniMVC.miniModel;

import java.util.HashSet;
import java.util.function.Supplier;

import javax.swing.JComponent;

import common.serverObj.INamedRoomConnection;

/**

 * The interface for the minimodel-to-miniview adapter
 * @author tinaw
 *  *
 */
public interface IMiniModel2MiniViewAdapter {

	/**
	 * Displays the message
	 * @param msg The message to be displayed
	 */
	public void displayMsg(String msg);

	/**
	 * Displays the  J component
	 * @param supplier An instance of Supplier<JComponent>
	 */
	public void displayJComponent(Supplier<JComponent> supplier);

	/**
	 * Displays the roster
	 * @param roster An instance of HashSet<IMessageReciever>
	 */
	public void displayRoster(HashSet<INamedRoomConnection> roster);

}
