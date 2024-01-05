package oblig1.web.interfaces;

import oblig1.web.util.Shortcut;

/**
 * This class have one object variable EntityManagerFactory emf.
 * The constructor has no parameters and only instantiates the emf.
 * Snakes will be represented with false, and ladders with true
 * 
 * @author AmundFremming
 *
 */

public interface ShortcutDAOInterface {

	/**
	 * Makes a query to the database with the players board placement as an argument.
	 * If a shortcut starts from the players placement a Shortcut Object will be returned,
	 * if no match the method returns NULL.
	 * 
	 * @param boardPlacement
	 * @return Shortcut
	 */
	public Shortcut shortcutAt(Integer boardPlacement);
	
	
}
