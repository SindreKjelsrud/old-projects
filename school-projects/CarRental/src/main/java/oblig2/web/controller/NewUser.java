package oblig2.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oblig2.web.entities.Userr;
import oblig2.web.service.NewUserService;

@Controller
public class NewUser {
	
	@Autowired NewUserService us;
	
	
	

}
