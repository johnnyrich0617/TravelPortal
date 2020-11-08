/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;

import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * @author john.richardson3
 *
 */
@Component
public class Passenger {

	private UUID passengerId;
	private UUID reservationId;
	private String flightId;
	private String passengerFirstName;
	private String passengerMiddleInit;
	private String passengerLastName;
	private FlightSeat seat;
	/**
	 * 
	 */
	public Passenger() {
		this.passengerId = UUID.randomUUID();
	}
	
	public UUID getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(UUID passengerId) {
		this.passengerId = passengerId;
	}

	public UUID getReservationId() {
		return reservationId;
	}
	public void setReservationId(UUID reservationId) {
		this.reservationId = reservationId;
	}

	public String getPassengerFirstName() {
		return passengerFirstName;
	}
	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}
	public String getPassengerMiddleInit() {
		return passengerMiddleInit;
	}
	public void setPassengerMiddleInit(String passengerMiddleInit) {
		this.passengerMiddleInit = passengerMiddleInit;
	}
	public String getPassengerLastName() {
		return passengerLastName;
	}
	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}
	
	/**
	 * @return the seat
	 */
	public FlightSeat getSeat() {
		return seat;
	}
	/**
	 * @param seat the seat to set
	 */
	public void setSeat(FlightSeat seat) {
		this.seat = seat;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		result = prime * result + ((passengerFirstName == null) ? 0 : passengerFirstName.hashCode());
		result = prime * result + ((passengerId == null) ? 0 : passengerId.hashCode());
		result = prime * result + ((passengerLastName == null) ? 0 : passengerLastName.hashCode());
		result = prime * result + ((passengerMiddleInit == null) ? 0 : passengerMiddleInit.hashCode());
		result = prime * result + ((reservationId == null) ? 0 : reservationId.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		if (passengerFirstName == null) {
			if (other.passengerFirstName != null)
				return false;
		} else if (!passengerFirstName.equals(other.passengerFirstName))
			return false;
		if (passengerId == null) {
			if (other.passengerId != null)
				return false;
		} else if (!passengerId.equals(other.passengerId))
			return false;
		if (passengerLastName == null) {
			if (other.passengerLastName != null)
				return false;
		} else if (!passengerLastName.equals(other.passengerLastName))
			return false;
		if (passengerMiddleInit == null) {
			if (other.passengerMiddleInit != null)
				return false;
		} else if (!passengerMiddleInit.equals(other.passengerMiddleInit))
			return false;
		if (reservationId == null) {
			if (other.reservationId != null)
				return false;
		} else if (!reservationId.equals(other.reservationId))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", reservationId=" + reservationId + ", flightId="
				+ flightId + ", passengerFirstName=" + passengerFirstName + ", passengerMiddleInit="
				+ passengerMiddleInit + ", passengerLastName=" + passengerLastName + ", seat=" + seat + "]";
	}
	
}
