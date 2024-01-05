package oblig1.web.JUnit.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import oblig1.web.model.*;

public class GameTest {
	
	private Game game;
	private Player player1, player2, player3, player4;
	private LinkedBlockingQueue <Player> gameQueue;

	@BeforeEach
	public void setup() {
		
		Game game = new Game(4);
		
		gameQueue = game.getPlayerQueue();
		
		player1 = gameQueue.poll();
		player2 = gameQueue.poll();
		player3 = gameQueue.poll();
		player4 = gameQueue.poll();
		
	}
	
	@Test
	@DisplayName("Tests if the game genereates the correct players and queue")
	public void testGeneratePlayersAndQueue() {
		game.generatePlayersAndQueue(4, gameQueue);
		
		assertEquals(game.getPlayerQueue().size(), 4);
		
		assertEquals(gameQueue.poll(), player1);
		assertEquals(gameQueue.poll(), player2);
		assertEquals(gameQueue.poll(), player3);
		assertEquals(gameQueue.poll(), player4);
		assertEquals(gameQueue.poll(), null);
	}
	
	@Test
	@DisplayName("Tests if the head of the queue is set back to the start")
	public void testBackToStart() {
		gameQueue.peek().setBoardPlacement(4);
		game.backToStart();
		
		assertEquals(game.getPlayerQueue().peek(), player2);
		gameQueue.poll();
		gameQueue.poll();
		gameQueue.poll();
		assertEquals(gameQueue.peek().getBoardPlacement(), 1);
		
	}
	
	@Test
	@DisplayName("Tests if the right player is in head of queue after using the method")
	public void testNextPlayer() {
		game.nextPlayer();
		
		assertEquals(player2, gameQueue.peek());
		assertEquals(game.isCanRollAgain(), false);
		assertEquals(game.getSixesRolled(), 0);
		
		gameQueue.poll();
		gameQueue.poll();
		gameQueue.poll();
		
		assertEquals(player1, gameQueue.peek());
	}
	
	@Test
	@DisplayName("Tests of the dice roll method")
	public void testRollDice() {
		
	}
	
	
	
}