package tjc6.microMVC.model;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

import javax.swing.Timer;

//import common.serverObj.INamedAppConnection;
import provided.logger.ILogger;
import provided.logger.LogLevel;

/**
 * A class used to build the game Don't Press the Button.
 * 
 * @author tyrac
 *  
 */
public class GameMicroModel {
	
	/**
	 * The system logger.
	 */
	private ILogger _sysLogger;
	/**
	 * A Timer object.
	 */
	private Timer _timer = new Timer(1000, (e)-> timerTick());
	/**
	 * The time that the timer counts down from.
	 */
	private int _time = 20;
	
	
	//private HashSet<INamedAppConnection> _teamA;
	//private HashSet<INamedAppConnection> _teamB;
	
	/**
	 * A boolean to determine which team a player is on.
	 * If true, the player is assigned to team A; otherwise, they
	 * are assigned to team B.
	 */
	//private boolean _thisTeam = true;
	
	/**
	 * An arraylist containing all 195 buttons associated with the game.
	 */
	private ArrayList<GameButton> _gameButtons = new ArrayList<GameButton>();
	
	/**
	 * The micro model-to-view adapter.
	 */
	private IMicroModel2ViewAdapter _m2vAdpt;
	
	
	/**
	 * Constructor for the micro model.
	 * 
	 * @param _sysLogger the system logger
	 * @param uuid the uuid
	 * @param m2vAdpt a model to view adapter
	 */
	public GameMicroModel(ILogger sysLogger, UUID uuid, IMicroModel2ViewAdapter m2vAdpt) {
		// assign the system logger
		_sysLogger = sysLogger;
		// Make gameplay buttons
		makeButtons();
		// Assign elimination buttons
		assignElimButtons();
	}

	/**
	 * Starts the micro model.
	 * 
	 * @return an UUID
	 */
	public UUID start() {
		_timer.start();
		return null;
	}
	
	/**
	 * Decrements the time on the timer.
	 */
	public void timerTick() {
		_time--;
		
		if (_time == 0) {
			// TODO: eliminate this player
			_sysLogger.log(LogLevel.INFO, "You have been eliminated due to failing to press a button within 20 seconds.");
		}
		_m2vAdpt.updateTimer(_time);
	}
	
	/**
	 * Makes all the buttons for gameplay and adds them to hashset of GameButtons.
	 */
	public void makeButtons() {
		for (int i = 1; i <= 195; i++) {
			_gameButtons.add(new GameButton("btn" + Integer.toString(i)));
		}
	}
	
	/**
	 * Assign the elimination buttons.
	 */
	public void assignElimButtons() {
		// TODO: Make this team specific once you learn how to make teams, if time permits.
		Random rand = new Random();
		int upperbound = 196;
		
		// Assign 30 random elimination buttons
		int i = 0;
		while (i < 30) {
			int randInt = rand.nextInt(upperbound);
			if (_gameButtons.get(randInt).getButtonStatus() == false) {
				_gameButtons.get(randInt).setButtonStatus(true);
				i++;
			}
		}
		
	}

	/**
	 * 
	 * @param button
	 */
	public void buttonPressed(int button) {
		if (_gameButtons.get(button-1).getActiveStatus() == true) {
			_time = 20;
			_gameButtons.get(button-1).setActiveStatus(false);
			if (_gameButtons.get(button-1).getButtonStatus() == true) {
				// remove player from the roster
				// tell the view to flash the content pane red
				_m2vAdpt.changePanelColor(_gameButtons.get(button-1).getButtonStatus());
			}
			else {
				// tell the view to flash the content pane green
				_m2vAdpt.changePanelColor(_gameButtons.get(button-1).getButtonStatus());
			}
			
		}
		else {
			// TODO: Figure out how to only have the timer restart if the button is an active button.
			_sysLogger.log(LogLevel.INFO, "This button has already been pressed.");
			return;
		}
	}
	
	/**
	 * Exits the game.
	 */
	public void exitGame()
    {
		// stop the timer
		_timer.stop();
        // Send game update of who the winner is
		// close the game (with exit game button?)
    }
	
}
