package tjc6.mainMVC.model;

import java.util.HashSet;
import java.util.function.Supplier;

import javax.swing.JComponent;

import common.serverObj.INamedAppConnection;
import common.serverObj.INamedRoomID;

/**

 * The model-to-view adapter.
 * @author tinaw
 *  *
 */
public interface IModel2ViewAdapter {

	/**
	 * Display the given message on the view
	 * @param msg The message to display
	 */
	void displayMsg(String msg);

	/**
	 * Creates a new chatroom. Defo needs some more parameters...
	 * @param name The name of the chatroom.
	 * @param supplier An instnace of Supplier containing JComponents
	 * 
	 * @return A runnable that removes this chatroom from the main view
	 */
	Runnable addMiniView(String name, Supplier<JComponent> supplier);

	void addUsers(HashSet<INamedAppConnection> connections);

	void addRooms(HashSet<INamedRoomID> sentRooms);
}
