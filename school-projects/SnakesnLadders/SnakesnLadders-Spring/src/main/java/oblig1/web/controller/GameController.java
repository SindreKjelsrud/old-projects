package oblig1.web.controller;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import antlr.collections.List;
import oblig1.web.model.Game;
import oblig1.web.model.Player;
import oblig1.web.util.ShortcutRepository;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired ShortcutRepository scRepo;
	private Game game;

	@GetMapping
	public String getGameView(HttpSession session, RedirectAttributes ra) {		
		int num;
		
		try {
			num = Integer.parseInt((String) session.getAttribute("numPlayers"));
		} catch(Exception e) {
			ra.addFlashAttribute("redirectMessage", "Not a valid number!");
			return "redirect:" + "start";
		}
		
		if(num < 2 || num > 6) {
			ra.addFlashAttribute("redirectMessage", "Not a valid number!");
			return "redirect:" + "start";
		}
		
		game = new Game(num);
		session.setAttribute("numPlayers", game.getPlayerQueue().size());
		session.setAttribute("playersInPlay", game.getPlayerQueue().stream().toList());
		session.setAttribute("playersTurn", game.getPlayerQueue().peek().getID());
		updatePlayersFrom(game.getPlayerQueue(), session);
		updatePlayersTo(game.getPlayerQueue(), session);
		
						
		return "gameView";
	}
	
	@PostMapping
	public String postGameView(HttpSession session) {
		
		updatePlayersFrom(game.getPlayerQueue(), session);
		game.rollDice();
		updatePlayersTo(game.getPlayerQueue(), session);
		
		session.setAttribute("dice", game.getDice().getDiceNumber());
		session.setAttribute("playersTurn", game.getPlayerQueue().peek().getID());
		
		return "gameView";
	}
	
	public void updatePlayersFrom(Queue<Player> players, HttpSession session) {
		for(int i = 0; i < players.size(); i++) {						
			Player p = players.remove();
			int num = p.getID(); 
			String s = "player" + num + "from";
			session.setAttribute(s, p.getBoardPlacement());
			players.add(p);
		}
	}
	
	public void updatePlayersTo(Queue<Player> players, HttpSession session) {
		for(int i = 0; i < players.size(); i++) {						
			Player p = players.remove();
			int num = p.getID(); 
			String s = "player" + num + "to";
			session.setAttribute(s, p.getBoardPlacement());
			players.add(p);
		}
	}
	
}
