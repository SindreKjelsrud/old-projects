package oblig1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rules")
public class RulesController {

	@GetMapping
	public String getRulesView() {
		return "rulesView";
	}
	
}
