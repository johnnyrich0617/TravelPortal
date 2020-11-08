/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.controllers;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import edu.snhu.jhrichardson.TravelPortal.models.AirlineReservation;
import edu.snhu.jhrichardson.TravelPortal.models.User;
import edu.snhu.jhrichardson.TravelPortal.services.AirlineReservationService;
import edu.snhu.jhrichardson.TravelPortal.services.UserService;

/**
 * @author john.richardson3
 *
 */
@Controller
public class ReservationController {
	
	private static Logger log = LogManager.getLogger(ReservationController.class);
	
	@Autowired
	AirlineReservationService aService;
	
	@Autowired 
	UserService uService;
	

	/**
	 * 
	 */
	public ReservationController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/dashboard/view")
	String getReservationDetails(@RequestParam(value="customerId", required=true) UUID cuid, 
									@RequestParam(value="resId", required=true) UUID resId, 
									ModelMap model) {
		
		log.info("/dashboard/view::The Requested CusomerId is " + cuid.toString());
		log.info("/dashboard/view::The requested ReservationId is: " + resId.toString());
	
		AirlineReservation res = this.aService.getReservation(resId);
		User user = this.uService.getUserForCustomerId(cuid);
		log.info("/dashboard/view::The request is for User Named: " + user.getDisplayName() + 
				" with customer number: " + user.getCustomerInfo().getCustomerId().toString());
		if(res == null) {
			model.addAttribute("loggedInUser", user);
			model.addAttribute("resService", this.aService);
			model.addAttribute("error", "No Resveration Found for the requested ReservationId: " + resId.toString());
			return "portalmain";
		}
		else {
			model.addAttribute("loggedInUser", user);
			model.addAttribute("resService", this.aService);
			model.addAttribute("reservation", res);
			return "reservationdetails";
		}
		
	}
	
	@DeleteMapping("/dashboard/delete")
	String deleteReservation(@RequestParam(value="customerId", required=true) UUID cuid, 
									@RequestParam(value="resId", required=true) UUID resId, 
									ModelMap model) {
		log.info("/dashboard/delete::The Requested CusomerId is " + cuid.toString());
		log.info("/dashboard/delete::The requested ReservationId is: " + resId.toString());
		this.aService.deleteReservation(resId);
		User user = this.uService.getUserForCustomerId(cuid);
		log.info("/dashboard/delete::The request is for User Named: " + user.getDisplayName() + 
				" with customer number: " + user.getCustomerInfo().getCustomerId().toString());
		model.addAttribute("loggedInUser", user);
		model.addAttribute("resService", this.aService);
		return "portalmain";
	}
	
	@GetMapping("/dashboard")
	String getUserReservations(@ModelAttribute("loggedInUser") User user, ModelMap model) {
		
		if(user != null && user.getUserId() != null && user.getDisplayName() != null) {
			log.info("/dashboard::The logged in User from ModelAttribute is " + user.getUserId() + " : " + user.getDisplayName() + " : " +user.getCustomerInfo().getCustomerId().toString());
			
			if(((this.aService.getUserReservations(user.getCustomerInfo().getCustomerId()) == null )) 
					|| this.aService.getUserReservations(user.getCustomerInfo().getCustomerId()).isEmpty()) {
				model.addAttribute("noreservations", true);
			}
					
			model.addAttribute("resService", this.aService);
			model.addAttribute("loggedInUser", user);
			model.addAttribute("newres", false);
		}
		else {
			log.info("LoggerInUser is not Valid.........trying to retrieve from the attached model");
			return "error";
		}
		return "portalmain";
	}
	
	@GetMapping("/new/reservation")
	String getReservationForm(@RequestParam(value="customerId", required=true) UUID cuid, ModelMap model) {
		log.info("/new/reservation::The Requested CusomerId is " + cuid.toString());
		User user = this.uService.getUserForCustomerId(cuid);
		log.info("/new/reservation::The logged in User is " + user.getUserId() + " : " + user.getDisplayName() + " : " + user.getCustomerInfo().getCustomerId().toString());
		AirlineReservation res = this.aService.newReservation(user.getCustomerInfo());
		model.addAttribute("reservation", res);
		model.addAttribute("loggedInUser", user);
		model.addAttribute("resService", this.aService);
		model.addAttribute("newres", true);
		return "portalmain";
	}
}
