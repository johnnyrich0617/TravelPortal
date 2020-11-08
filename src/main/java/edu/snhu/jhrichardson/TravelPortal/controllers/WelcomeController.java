/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.snhu.jhrichardson.TravelPortal.models.PhoneType;
import edu.snhu.jhrichardson.TravelPortal.models.User;
import edu.snhu.jhrichardson.TravelPortal.models.UserCredentials;
import edu.snhu.jhrichardson.TravelPortal.services.UserService;

import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;

/**
 * @author john.richardson3
 *
 */
@Controller
public class WelcomeController {

	private static Logger logger = LogManager.getLogger(WelcomeController.class);
	
	@Autowired
	UserService userService;
	
	@ModelAttribute("allPhoneTypes")
	List<PhoneType> getAllTypes() {
		return Arrays.asList(PhoneType.ALL);
	}
	
	public WelcomeController() {
		super();
	}
	
	@GetMapping("/")
	public String loginPage(@ModelAttribute("userCredentials") UserCredentials userCreds, ModelMap model) {
		logger.info("Starting New Login");
		return "welcome";
	}
	
	@PostMapping("/login")
	String loginUser(@ModelAttribute("userCredentials") UserCredentials userCreds, 
			ModelMap model, final RedirectAttributes redirectAttributes) {
		
		User vaidatedUser = userService.getValidatedUser(userCreds.getUserId(), userCreds.getPassword());
		if(vaidatedUser != null) {
			logger.info("Retrieved Valid User for Log In : " + vaidatedUser.toString());
			//model.remove("userCredentials");
			//model.addAttribute("loggedInUser", vaidatedUser);
			//return "portalmain";
			redirectAttributes.addFlashAttribute("loggedInUser", vaidatedUser);
			return "redirect:dashboard";
		}
		else {
			logger.info("Error Logging In with User Credentials, User does not exist!  UserCredentials : " + userCreds.toString());
			model.addAttribute("error", true);
			return "welcome";
		}	
	}
	
	@GetMapping("/register")
	String registerNewUser(@ModelAttribute("newUser") User newUser, ModelMap model ) {
		logger.info("Starting New User Registration");
		return "createuserform";
	}
	
	@PostMapping("/createuser")
	String newUser(@ModelAttribute("newUser") @Valid User newUser, BindingResult result, ModelMap model ) {
		//there maybe field errors if so return back to form
		if(result.hasErrors()) {
			return "createuserform";
		}
		try {
			logger.info("Creating New User from registration");
			this.userService.addNewUser(newUser);
			//redirect the user back to the login page for full log in
			return "redirect:/";
		}catch(IllegalArgumentException iae) {
			logger.info("Create New User from registration has failed" + iae.getMessage());
			model.addAttribute("userAddErr", true);
			//may need custom error page for this.
			return "createuserform";
		}
	}
	
	
	
//	
//	@RequestMapping({"/", "/login"})
//	public String showWelcome(final ModelMap model) {	
//		model.put("lable", "Log In to Travel Service");
//		model.put("title", "SNHU Travel Portal");
//		model.put("welcomemsg", "Welcome to the SNHU Travel Portal");
//		return "welcome";	
//	}

}
