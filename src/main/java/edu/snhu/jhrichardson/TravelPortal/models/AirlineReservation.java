/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;

import java.util.ArrayList;


import org.springframework.stereotype.Component;

/**
 * @author john.richardson3
 *
 */
@Component
public class AirlineReservation extends Reservation {

	private AirlineFlight departureFlight = null;
	private AirlineFlight returnFlight = null;
	private boolean isOneWay = false;
	
	
//	/**
//	 * The flight manifest entries for this reservation
//	 * contains the AirlineFlight.flightNumber and a mapping of
//	 * The passenger for this
//	 *  reservation with seat assignments
//	 *  <Passenger, String (seat location)>
//	 */
//	private HashMap<String, HashMap<Passenger, String>> flightManifestEntries;
	
	private ArrayList<Passenger> reservationManifest;
	
	/**
	 * Default Constructor
	 */
	public AirlineReservation() {
		super();
		this.reservationManifest = new ArrayList<>();
	}
	
	
	/**
	 * @return the departureFlight
	 */
	public AirlineFlight getDepartureFlight() {
		return departureFlight;
	}

	/**
	 * @param departureFlight the departureFlight to set
	 */
	public void setDepartureFlight(AirlineFlight departureFlight) {
		this.departureFlight = departureFlight;
	}

	/**
	 * @return the returnFlight
	 */
	public AirlineFlight getReturnFlight() {
		return returnFlight;
	}

	/**
	 * @param returnFlight the returnFlight to set
	 */
	public void setReturnFlight(AirlineFlight returnFlight) {
		this.returnFlight = returnFlight;
	}

	/**
	 * @return the isOneWay
	 */
	public boolean isOneWay() {
		return isOneWay;
	}

	/**
	 * @param isOneWay the isOneWay to set
	 */
	public void setOneWay(boolean isOneWay) {
		this.isOneWay = isOneWay;
	}

	public ArrayList<Passenger> getReservationManifest() {
		return reservationManifest;
	}

	public void setReservationManifest(ArrayList<Passenger> reservationManifest) {
		this.reservationManifest = reservationManifest;
	}

	public void addFlightManifestEntry(Passenger passenger) {
		
		this.reservationManifest.add(passenger);
	}
	
	public void removePassengerManifestEntries(Passenger passenger) {
		
		this.reservationManifest.remove(passenger);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((departureFlight == null) ? 0 : departureFlight.hashCode());
		result = prime * result + (isOneWay ? 1231 : 1237);
		result = prime * result + ((reservationManifest == null) ? 0 : reservationManifest.hashCode());
		result = prime * result + ((returnFlight == null) ? 0 : returnFlight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirlineReservation other = (AirlineReservation) obj;
		if (departureFlight == null) {
			if (other.departureFlight != null)
				return false;
		} else if (!departureFlight.equals(other.departureFlight))
			return false;
		if (isOneWay != other.isOneWay)
			return false;
		if (reservationManifest == null) {
			if (other.reservationManifest != null)
				return false;
		} else if (!reservationManifest.equals(other.reservationManifest))
			return false;
		if (returnFlight == null) {
			if (other.returnFlight != null)
				return false;
		} else if (!returnFlight.equals(other.returnFlight))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirlineReservation [departureFlight=");
		builder.append(departureFlight);
		builder.append(", returnFlight=");
		builder.append(returnFlight);
		builder.append(", isOneWay=");
		builder.append(isOneWay);
		builder.append(", reservationManifest=");
		builder.append(reservationManifest);
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
