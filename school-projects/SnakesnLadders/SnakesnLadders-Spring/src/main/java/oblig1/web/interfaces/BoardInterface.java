package oblig1.web.interfaces;

/**
 * The board class contains two object variables:
 * 		Integer [][] matrix
 * 		Queue<Player> gameQueue
 * 
 * The class will need a constructor that sets the matrix variable to a 
 * new 10x10 2D array, and sets the the game queue with the players to a queue object.
 * 		
 * 
 * @author AdrianBerget, DennisOsmani
 *
 */

public interface BoardInterface {
	
	/**
	 * Writes out the current state of the board in the console
	 */
	public void printBoard();
	
	
	/**
	 * Resets the board to its original state without players inside the board,
	 * intended to be used before updateBoard() for each move
	 */
	public void clearBoard();
	
	
	/**
	 * Used after clearBoard() each time a player makes a move.
	 * Checks board placement for each player in the playersQueue
	 * and places them on the board based on this
	 */
	public void updateBoard();
	
	/**
	 * Used to get the element placed in the board matrix at
	 * the specified row and column
	 * @param row
	 * @param column
	 * @return
	 */
	public int getValueAtIndex(int row, int column);
	
	/**
	 * Used to get the index of the where the element is in the board matrix
	 * at the specified position pos
	 * @param pos
	 * @return
	 */
	public String getIndexFromPosition(int pos);

}
