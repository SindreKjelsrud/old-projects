package oblig1.web.JUnit.test;

/*
 * This test class will also test that all data in the database is correct
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import oblig1.web.util.Shortcut;
import oblig1.web.util.ShortcutDAO;

public class ShortcutDAOTest {
	
	/* TestData */
	private ShortcutDAO dao;
	
	@BeforeEach()
	public void setup() {
		dao = new ShortcutDAO();
	}
	
	@Test
	@DisplayName("Checks if the queries return a Shortcut object, with no NULL values")
	public void testQueries() {
		
	}
	
	// -------- SNAKES ---------
	
	@Test
	@DisplayName("Tests that shortcut 32 query is correct")
	public void testGetSnake32() {
		Shortcut shortcut = dao.shortcutAt(32);
		assertTrue(shortcut != null && shortcut.getTo() == 6 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 74 query is correct")
	public void testGetSnake74() {
		Shortcut shortcut = dao.shortcutAt(74);
		assertTrue(shortcut != null && shortcut.getTo() == 22 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 86 query is correct")
	public void testGetSnake86() {
		Shortcut shortcut = dao.shortcutAt(86);
		assertTrue(shortcut != null && shortcut.getTo() == 51 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 99 query is correct")
	public void testGetSnake99() {
		Shortcut shortcut = dao.shortcutAt(99);
		assertTrue(shortcut != null && shortcut.getTo() == 39 && !shortcut.isLadder());
	}
	
	// -------- LADDERS ---------
	
	@Test
	@DisplayName("Tests that ladder 9 query is correct")
	public void testGetLadder9() {
		Shortcut shortcut = dao.shortcutAt(9);
		assertTrue(shortcut != null && shortcut.getTo() == 31 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 16 query is correct")
	public void testGetLadder16() {
		Shortcut shortcut = dao.shortcutAt(16);
		assertTrue(shortcut != null && shortcut.getTo() == 45 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 18 query is correct")
	public void testGetLadder18() {
		Shortcut shortcut = dao.shortcutAt(18);
		assertTrue(shortcut != null && shortcut.getTo() == 64 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 48 query is correct")
	public void testGetLadder48() {
		Shortcut shortcut = dao.shortcutAt(48);
		assertTrue(shortcut != null && shortcut.getTo() == 66 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 50 query is correct")
	public void testGetLadder50() {
		Shortcut shortcut = dao.shortcutAt(50);
		assertTrue(shortcut != null && shortcut.getTo() == 93 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 63 query is correct")
	public void testGetLadder63() {
		Shortcut shortcut = dao.shortcutAt(63);
		assertTrue(shortcut != null && shortcut.getTo() == 81 && shortcut.isLadder());
	}
	
}
