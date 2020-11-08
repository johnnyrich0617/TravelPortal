/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models.repositories;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import edu.snhu.jhrichardson.TravelPortal.models.AirlineReservation;


/**
 * @author john.richardson3
 *
 */
@Repository
public class AirlineReservationRepository {
	
	private ArrayList<AirlineReservation> fReservations;

	/**
	 * 
	 */
	private AirlineReservationRepository() {
		this.fReservations = new ArrayList<>();
		loadSavedReservations();
	}

	private void loadSavedReservations() {
		// TODO load reservations from file system	
	}
	
	/**
	 * Private Thread Safe Inner Class Helper
	 * @author john.richardson3
	 *
	 */
	private static class AirlineReservationRepositoryHelper{
		private static final AirlineReservationRepository INSTANCE = new AirlineReservationRepository();
	}
	
	/**
	 * 
	 * @return the AirlineReservationRepository Instance as a thread safe singleton
	 */
	public static AirlineReservationRepository getInstance() {
		return AirlineReservationRepositoryHelper.INSTANCE;
	}
	
	/**
	 * Add a New reservation for a customer
	 * @param res
	 */
	public synchronized void addNewReservation(AirlineReservation res) {
		if(!this.fReservations.contains(res))
			this.fReservations.add(res);
	}
	
	/**
	 * remove a Reservation for a customer
	 * @param res
	 */
	public synchronized void deleteReservation(AirlineReservation res) {
		if(this.fReservations.contains(res))
			this.fReservations.remove(res);
	}
	
	/**
	 * Delete a Reservation for a given reservationId
	 * @param resId
	 */
	public synchronized void deleteReservation(UUID resId) {
		for(AirlineReservation res : this.fReservations) {
			if(res.getReservationId().equals(resId)) {
				this.fReservations.remove(res);
				break;
			}
		}
	}
	
	/**
	 * Get all reservations for a customer
	 * @param ownerId
	 * @return
	 */
	public synchronized ArrayList<AirlineReservation> getReservationsForOwnerId(UUID ownerId) {
		ArrayList<AirlineReservation> ownerRes = new ArrayList<>();
		for(AirlineReservation res : this.fReservations) {
			if(res.getcContact().getCustomerId().equals(ownerId)) {
				ownerRes.add(res);
			}
		}
		return ownerRes;
	}
	
	/**
	 * Get a particular Reservation for a reservation ID
	 * @param resId
	 * @return
	 */
	public synchronized AirlineReservation getReservation(UUID resId) {
		AirlineReservation theResToReturn = null;
		for(AirlineReservation res : this.fReservations) {
			if(res.getReservationId().equals(resId))
				theResToReturn = res;
			break;
		}
		return theResToReturn;
	}
	
}
