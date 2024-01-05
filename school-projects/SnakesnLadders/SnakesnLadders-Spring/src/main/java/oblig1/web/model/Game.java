package oblig1.web.model;

import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;

import oblig1.web.interfaces.GameInterface;
import oblig1.web.util.Shortcut;
import oblig1.web.util.ShortcutDAO;
import oblig1.web.util.ShortcutRepository;

public class Game implements GameInterface {

	private ShortcutDAO dao;
	private boolean canRollAgain;
	private Integer sixesRolled;
	private LinkedBlockingQueue<Player> playerQueue;
	private Dice dice;
	private Board board;
	
	public Game(int numPlayers) {
		this.dice = new Dice();
		this.canRollAgain = false;
		this.sixesRolled = 0;
		this.playerQueue = new LinkedBlockingQueue<>();
		generatePlayersAndQueue(numPlayers, playerQueue);
		this.board = new Board(playerQueue);
		this.dao = new ShortcutDAO();
	}
	
	public void generatePlayersAndQueue(int numPlayers, LinkedBlockingQueue<Player> playerQueue) {
		System.out.println("GENERATING GAME ...");
		
		int playerID = 1;
		for(int i = 0; i < numPlayers; i++) {
			playerQueue.add(new Player(playerID));
			playerID++;
		}
		
		System.out.println("Player" + playerQueue.peek().getID() + "´s turn to roll the dice!");
	}
	
	@Override
	public void backToStart() {
		playerQueue.peek().setBoardPlacement(1);
		nextPlayer();
	}

	@Override
	public void nextPlayer() {
		if(canRollAgain) {
			canRollAgain = false;
			return;
		}
		
		Player backInQueue = playerQueue.poll();
		playerQueue.add(backInQueue);
		sixesRolled = 0;
		canRollAgain = false;
		
		System.out.println("Player" + playerQueue.peek().getID() + "´s turn!");
	}

	@Override
	public void newGame() {
		this.canRollAgain = false;
		this.sixesRolled = 0;
		this.playerQueue = new LinkedBlockingQueue<>();
		generatePlayersAndQueue(playerQueue.size(), playerQueue);
		this.board = new Board(playerQueue);
	}

	@Override
	public boolean finishedGame() {
		return playerQueue.size() == 1;
	} 

	@Override
	public void clearSixesRolled() {
		this.sixesRolled = 0;
	}

	@Override
	public void rollDice() {
		if(finishedGame()) return;
		
		int diceNum = dice.rollDice();
		Player player = playerQueue.peek();
		
		System.out.println("Player" + player.getID() + " rolled: " + diceNum);
		
		if(diceNum == 6 && sixesRolled >= 2) {
			System.err.println(
					"Player" + player.getID() + 
					" has thrown 3 sixes in a row, being moved back to start..."
					);
			System.out.println("You can roll again!");
			backToStart();
		} else {
			if(diceNum == 6) {
				sixesRolled++;
				canRollAgain = true;
				System.out.println("You can roll again!");
			}
			
			/* Checks if a player lands on board placement over 100 */
			int playerPlacement = player.getBoardPlacement();
			if(playerPlacement + diceNum > 100) {
				System.out.println("Player" + player.getID() + ": cant move past placement 100, player stays");
			} else if(playerPlacement + diceNum == 100) {
				System.err.println("Player" + player.getID() + " FINISHED!!");
				playerQueue.remove();
			} else {
				System.out.println("Player" + player.getID() + " moved from " + player.getBoardPlacement() + " to " + (player.getBoardPlacement() + diceNum));
				player.setBoardPlacement(player.getBoardPlacement() + diceNum);
			}
			
		}
		
		checkForLaddersAndSnakes();
		nextPlayer();
		board.updateBoard();
		board.printBoard();
		
		System.out.println();
	}
	
	private void checkForLaddersAndSnakes() {
		Player player = playerQueue.peek();
		
		int placement = playerQueue.peek().getBoardPlacement();
		Shortcut shortcut = dao.shortcutAt(placement);
		if(shortcut != null) {
			String type = shortcut.isLadder() ? "Ladder" : "Snake";
			System.out.println("Player" + player.getID() + " landed on a " + type + ". Moving from " + shortcut.getFrom() + " to " + shortcut.getTo());
			player.setBoardPlacement(shortcut.getTo());
			if(shortcut.getTo() == 100) {
				System.err.println("Player" + player.getID() + " FINISHED!!");
				playerQueue.remove();
			}
		}
	}

	public ShortcutDAO getDao() {
		return dao;
	}

	public void setDao(ShortcutDAO dao) {
		this.dao = dao;
	}

	public boolean isCanRollAgain() {
		return canRollAgain;
	}
	

	public Integer getSixesRolled() {
		return sixesRolled;
	}

	public void setSixesRolled(Integer sixesRolled) {
		this.sixesRolled = sixesRolled;
	}

	public void setCanRollAgain(boolean canRollAgain) {
		this.canRollAgain = canRollAgain;
	}

	public LinkedBlockingQueue<Player> getPlayerQueue() {
		return playerQueue;
	}

	public void setPlayerQueue(LinkedBlockingQueue<Player> playerQueue) {
		this.playerQueue = playerQueue;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
