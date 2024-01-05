package oblig1.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/start")
public class StartController {

	@GetMapping
	public String getStartView() {
		return "startView";
	}

	@PostMapping
	public String postStartView(@RequestParam String numPlayers, HttpSession session) {
		session.setAttribute("numPlayers", numPlayers);
		
		return "redirect:" + "game";
	}

}
