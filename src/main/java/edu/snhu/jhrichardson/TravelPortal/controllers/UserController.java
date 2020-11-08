/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.controllers;


import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.snhu.jhrichardson.TravelPortal.models.User;
import edu.snhu.jhrichardson.TravelPortal.services.AirlineReservationService;
import edu.snhu.jhrichardson.TravelPortal.services.UserService;

/**
 * @author john.richardson3
 *
 */
@Controller
public class UserController {
	
	private static Logger log = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AirlineReservationService aService;

	
	@ModelAttribute("usersList")
	List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}
	
	
	public UserController() {
		super();
	}
	
	@GetMapping("/userdetails")
	String getUserDetails(@RequestParam(value="customerId", required=true) UUID cuid, ModelMap model) {
		log.info("/userdetails:: The Customer ID is " + cuid.toString());
		User user = this.userService.getUserForCustomerId(cuid);
		log.info("/userdetails:: The Customer ID is from the User Object is " + user.getCustomerInfo().getCustomerId().toString());
		model.addAttribute("loggedInUser", user);
		return "userdetails";
	}
	
	@GetMapping("/dashboard/redirectFromDetails")
	String redirectToDashboard(@RequestParam(value="customerId", required=true) UUID cuid,
									ModelMap model, final RedirectAttributes redirectAttributes) {
		log.info("/userdetails/redirect:: The Customer ID is " + cuid.toString());
		User user = this.userService.getUserForCustomerId(cuid);
		log.info("/userdetails/redirect:: The Customer ID is from the User Object is " + user.getCustomerInfo().getCustomerId().toString());
		redirectAttributes.addFlashAttribute("loggedInUser", user);
		return "redirect:/dashboard";
	}
	
	
	

}
