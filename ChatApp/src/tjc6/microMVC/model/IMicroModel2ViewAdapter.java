package tjc6.microMVC.model;

import java.util.HashSet;
import java.util.function.Supplier;

import javax.swing.JComponent;

import common.serverObj.INamedRoomConnection;

/**
 * Interface for the micro model to view adapter.
 * 
 * @author tyrac
 *  *
 */
public interface IMicroModel2ViewAdapter {
	/**
	 * Displays the message
	 * @param msg The message to be displayed
	 */
	public void displayMsg(String msg);

	/**
	 * Displays the component
	 * @param supplier An instance of Supplier<JComponent>
	 */
	public void displayComponent(Supplier<JComponent> supplier);

	/**
	 * Displays the roster
	 * @param roster An instance of HashSet<IMessageReciever>
	 */
	public void displayRoster(HashSet<INamedRoomConnection> roster);
	
	/**
	 * 
	 * @param second
	 */
	public void updateTimer(int second);

	/**
	 * 
	 * @param buttonStatus
	 */
	public void changePanelColor(Boolean buttonStatus);

}
