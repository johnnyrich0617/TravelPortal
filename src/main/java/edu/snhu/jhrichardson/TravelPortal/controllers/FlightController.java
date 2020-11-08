/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.snhu.jhrichardson.TravelPortal.services.FlightsService;

/**
 * @author richa
 *
 */
@Controller
public class FlightController {
	
	@Autowired
	FlightsService fservice;
	
	@GetMapping("/flights")
	String getFlights() {
		this.fservice.loadFlights();
		return "SUCCESS";
	}

}
