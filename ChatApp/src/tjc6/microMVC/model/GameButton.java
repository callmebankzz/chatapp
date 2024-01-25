package tjc6.microMVC.model;

public class GameButton {
	/**
	 * A boolean variable indicating whether the button is an elimination button or not.
	 * If true, it is an elimination button; otherwise, it is not.
	 */
	private Boolean _isBad;
	/**
	 * A boolean variable indicating the active status of the button.
	 * If true, a player is allowed to press it in the game and it responds appropriately;
	 * otherwise, the button does nothing.
	 */
	private Boolean _isActive;
	/**
	 * A String that is the button's label.
	 */
	private String _btnName;
	
	/**
	 * The constructor for a GameButton object.
	 * 
	 * @param name a String that is what the button is labeled as
	 */
	public GameButton(String name) {
		_isBad = false;
		_isActive = true;
		_btnName = name;
	}
	
	/**
	 * Returns the name of the GameButton.
	 * 
	 * @return a String that is the name of the GameButton
	 */
	public String getName() {
		return _btnName;
	}
	
	/**
	 * Sets the value of _isBad.
	 * 
	 * @param status a boolean indicating whether the GameButton is an 
	 * 		  elimination button or not
	 */
	public void setButtonStatus(Boolean status) {
		_isBad = status;
	}
	
	/**
	 * Returns the status of the button.
	 * 
	 * @return a boolean that indicates whether the button is an elimination
	 * 	       button or not
	 */
	public Boolean getButtonStatus() {
		return _isBad;
	}
	
	/**
	 * Sets the value of _isActive.
	 * 
	 * @param status a boolean indicating whether the GameButton is an 
	 * 		  active button or not
	 */
	public void setActiveStatus(Boolean status) {
		_isActive = status;
	}
	
	/**
	 * Returns the active status of the button.
	 * 
	 * @return a boolean that indicates whether the button is an active
	 * 	       button or not
	 */
	public Boolean getActiveStatus() {
		return _isActive;
	}
}
