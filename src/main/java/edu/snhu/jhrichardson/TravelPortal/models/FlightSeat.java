/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;

import java.util.Objects;

/**
 * @author john.richardson3
 *
 */
public class FlightSeat {

	private Integer seatId;
	private Integer flightId;
	private String seatNumber;
	
	
	public FlightSeat() {}
	
	public FlightSeat(Integer seatId, Integer flightId, String seatNumber) {
		this.flightId = flightId;
		this.seatId = seatId;
		this.seatNumber = seatNumber;
	}
	
	/**
	 * @return the seatId
	 */
	public Integer getSeatId() {
		return seatId;
	}

	/**
	 * @param seatId the seatId to set
	 */
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	/**
	 * @return the flightId
	 */
	public Integer getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	/**
	 * @return the seatNumber
	 */
	public String getSeatNumber() {
		return seatNumber;
	}
	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(flightId, seatId, seatNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof FlightSeat))
			return false;
		FlightSeat other = (FlightSeat) obj;
		return Objects.equals(flightId, other.flightId) && Objects.equals(seatId, other.seatId) 
				&& Objects.equals(seatNumber, other.seatNumber);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlightSeat [seatId=");
		builder.append(seatId);
		builder.append(", flightId=");
		builder.append(flightId);
		builder.append(", seatNumber=");
		builder.append(seatNumber);
		builder.append("]");
		return builder.toString();
	}
}
