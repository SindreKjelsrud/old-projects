package oblig2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oblig2.web.entities.Car;
import oblig2.web.entities.RentalOffice;
import oblig2.web.entities.Userr;
import oblig2.web.repositories.RentalOfficeRepo;
import oblig2.web.service.NewUserService;
import oblig2.web.service.SearchService;

@Controller
public class Search {
	
	@Autowired NewUserService us; 
	@Autowired SearchService ss;
	@Autowired RentalOfficeRepo roRepo;
	
	
	
	/* TESTS SEARCH-SERVICE */

	@GetMapping("/search")
	public String get() {
		
		RentalOffice office = roRepo.findByOfficeid(1);
		List<Car> li = ss.searchOffice(office);
		
		for(Car c : li) {
			System.err.println(c.getBrand() + " " + c.getModel() + " : " + c.getRegnr());
		}		
		
		return "homeView";
	}
	
	
	
	/* TESTS NEW-USER-SERVICE USERS */
	
	@GetMapping("/adduser")
	public String getA() {
		
		String number = "99226633";
		Userr newUser = us.newUser(number, "Vendela", "Pilgaard", "passord", "morveien 69", "6969", "mordihula");
		
		return "homeView";
	}
	
	
	@GetMapping("/deluser")
	public String getD() {
		
		String number = "99226633";
		us.deleteUser(number);
		
		return "homeView";
	}
	
	
	
	
	/* TESTS CAR-RENTAL-SERVICE */
	
	@GetMapping("/getcar")
	public String get1() {
		return "";
	}
	
	@GetMapping("/iscaravailable")
	public String get2() {
		return "";
	}
	
	@GetMapping("/setAvailability")
	public String get3() {
		return "";
	}
	
	@GetMapping("/getrentaluser")
	public String get4() {
		return "";
	}
	
	@GetMapping("/getrental")
	public String get5() {
		return "";
	}
	
	@GetMapping("/getrentaloffice")
	public String get6() {
		return "";
	}
	
	@GetMapping("/newrental")
	public String get7() {
		return "";
	}
	
	@GetMapping("/deliverrental")
	public String get8() {
		return "";
	}
	
	
	
}
