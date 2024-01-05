package oblig1.web.interfaces;
/**
 * The Player class will have two object variables;
 * 		Integer ID
 * 		Integer boardPlacement
 * 
 * The Player class have a constructor with a parameter Integer ID,
 * and set the boardPlacement object variable to 1 as this is the place
 * where the players will start.
 * 
 * @author AmundFremming
 *
 */

public interface PlayerInterface {
	
	/**
	 * @return	The player ID.
	 */
	public Integer getID();
	
	/**
	 * @param ID  Sets the players ID.
	 */
	public void setID(Integer ID);
	
	/**
	 * @return  The players board placement.
	 */
	public Integer getBoardPlacement();
	
	/**
	 * @param boardPlacement  Sets the board placement
	 */
	public void setBoardPlacement(Integer boardPlacement);
	
	/**
	 * This method is used for connecting with js on the front end.
	 * it returns a label with player id and label after. Eks: player1label.
	 * 
	 * @return "player" + ID + "label"
	 */
	public String getPlayerLabel();
	
	/**
	 * This method is used for connecting with js on the front end.
	 * 
	 * @return "player" + ID
	 */
	public String getPlayerInfo();


}
