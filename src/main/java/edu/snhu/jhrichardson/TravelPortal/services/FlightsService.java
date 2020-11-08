/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.snhu.jhrichardson.TravelPortal.models.repositories.FlightDataRepository;

/**
 * @author john.richardson3
 *
 */
@Service
public class FlightsService {

	@Autowired
	FlightDataRepository frepo;

	/**
	 * 
	 */
	public FlightsService() {
		
	}
	
	public void loadFlights() {
		this.frepo.loadAvailableFlights();
	}
	

}
