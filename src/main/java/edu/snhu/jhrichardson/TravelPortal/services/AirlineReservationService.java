/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.snhu.jhrichardson.TravelPortal.models.AirlineReservation;
import edu.snhu.jhrichardson.TravelPortal.models.CustomerContact;
import edu.snhu.jhrichardson.TravelPortal.models.repositories.AirlineReservationRepository;


/**
 * @author john.richardson3
 *
 */
@Service
public class AirlineReservationService {
	
	@Autowired
	AirlineReservationRepository repo;
	
	private static Logger logger = LogManager.getLogger(AirlineReservationService.class);

	/**
	 * 
	 */
	public AirlineReservationService() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTestResponse(UUID custNumber) {
		logger.info("The requesting Customer Number is: " + custNumber.toString());
		return "This came from the AirlineReservationSerive";
	}
	
	public List<AirlineReservation> getUserReservations(UUID custNumber) {
		List<AirlineReservation> aList = this.repo.getReservationsForOwnerId(custNumber);
		return aList;
	}
	
	public AirlineReservation getReservation(UUID resId) {
		return this.repo.getReservation(resId);
	}
	
	public void deleteReservation(UUID resId) {
		this.repo.deleteReservation(resId);
	}
	
	public AirlineReservation newReservation(CustomerContact contactInfo) {
		logger.info("Creating new Blank Reservation for User: " + contactInfo.getCustomerId().toString());
		AirlineReservation res = new AirlineReservation();
		res.setcContact(contactInfo);
		return res;
	}
	
	public boolean addCustomerReservation(AirlineReservation res) {
		this.repo.addNewReservation(res);
		return true;
	}

}
