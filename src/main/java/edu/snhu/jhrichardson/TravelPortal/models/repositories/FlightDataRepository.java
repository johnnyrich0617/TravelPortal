/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models.repositories;

import java.sql.Timestamp;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import edu.snhu.jhrichardson.TravelPortal.models.AirlineFlight;
import edu.snhu.jhrichardson.TravelPortal.models.FlightSeat;
import edu.snhu.jhrichardson.TravelPortal.models.repositories.dao.FlightsDao;


/**
 * @author john.richardson3
 *
 */
@Component
public class FlightDataRepository {
	
	@Autowired
	FlightsDao fDao;
	
	private static Logger log = LogManager.getLogger(FlightDataRepository.class);
	
	private List<AirlineFlight> availableFlights;
	
	
	/**
	 * 
	 */
	public FlightDataRepository() {

	}

	public void loadAvailableFlights() {
		this.availableFlights = this.fDao.getAllFlights();
		
		for(AirlineFlight flight :  availableFlights) {
			log.info("The FlightID = " + flight.getFlightId());
			log.info("The Flight Number = " + flight.getFlightNumber());
			log.info("The Flight Carrier = " + flight.getAirline().name());
			log.info("The Flight Departure Date:Time = " + flight.getDepartureDate());
			log.info("The Flight Departure Airport = " + flight.getDepartureAirport());
			log.info("The Flight Arrival Date:Time = " + flight.getArrivalDate());
			log.info("The Flight Airport = " + flight.getArrivalAirport());
			log.info("The Flight Available Seats are " + flight.getAvailableSeats().toString());
		}
	}
		
	/**
	 * Search the flight datastore for flights based on requested date
	 * @param requestedFlightDate
	 * @return List of AirlineFlights that match the request.
	 */
	public List<AirlineFlight> searchAvailableFlights(Timestamp requestedFlightDate){
	
		return this.fDao.searchFlightByDate(requestedFlightDate);
	}
	
	/**
	 * Get All Flights
	 * @return availableFlights
	 */
	public synchronized List<AirlineFlight> getAllFlights(){
		return this.fDao.getAllFlights();
	}
	
	/**
	 * Remove a seat from flight when it is selected for reservation
	 * @param flight
	 * @param seat
	 * @return
	 */
	public synchronized boolean removeSeatFromFlight(AirlineFlight flight, FlightSeat seat) {
		if(!(this.availableFlights == null) && this.availableFlights.contains(flight)) {
			Iterator<AirlineFlight> itor = this.availableFlights.iterator();
			while(itor.hasNext()) {
				AirlineFlight listedFlight = itor.next();
				if(flight.equals(listedFlight)){
					listedFlight.removeAvailableSeat(seat);
					return true;
				}
			}
			return false;
		}else {
			return false;
		}
	}
	
	/**
	 * Add seat back to flight if not being used by reservation
	 * @param flight
	 * @param seat
	 * @return
	 */
	public synchronized boolean addSeatToFlight(AirlineFlight flight, FlightSeat seat) {
		if(!(this.availableFlights == null) && this.availableFlights.contains(flight)) {
			Iterator<AirlineFlight> itor = this.availableFlights.iterator();
			while(itor.hasNext()) {
				AirlineFlight listedFlight = itor.next();
				if(flight.equals(listedFlight)){
					listedFlight.addAvailableSeat(seat);
					return true;
				}
			}
			return false;
		}else {
			return false;
		}
	}

}
