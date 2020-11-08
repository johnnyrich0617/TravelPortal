/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.stereotype.Component;

/**
 * @author john.richardson3
 *
 */
@Component
public class AirlineFlight {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

	//private String flightId = null;
	private Integer flightId = null;
	private String flightNumber = null;
	private Carrier airline = null;
	private Timestamp departureDate = null;
	private String departureAirport = null;
	private Timestamp arrivalDate = null;
	private String arrivalAirport = null;
	
	private ArrayList<FlightSeat> availableSeats;
	/**
	 * 
	 */
	public AirlineFlight() {
		this.availableSeats = new ArrayList<>();
	}
	
	public AirlineFlight(Integer flightId, String flightNumber, 
						String carrier, Timestamp departureDate, 
						String departureAirport, Timestamp arrivalDate,
						String arrivalAirport) {
		
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.airline = Carrier.forName(carrier);
		this.departureDate = departureDate;
		this.departureAirport = departureAirport;
		this.arrivalDate = arrivalDate;
		this.arrivalAirport = arrivalAirport;
		this.availableSeats = new ArrayList<>();
	}
		
	/**
	 * @return the flightId
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	/**
	 * @return the airline
	 */
	public Carrier getAirline() {
		return airline;
	}
	/**
	 * @param airline the airline to set
	 */
	public void setAirline(Carrier airline) {
		this.airline = airline;
	}
	/**
	 * @return the departureDate
	 */
	public Timestamp getDepartureDate() {
		return departureDate;
	}
	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * @return the departureAirport
	 */
	public String getDepartureAirport() {
		return departureAirport;
	}
	/**
	 * @param departureAirport the departureAirport to set
	 */
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	/**
	 * @return the arrivalDate
	 */
	public Timestamp getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * @return the arrivalAirport
	 */
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	/**
	 * @param arrivalAirport the arrivalAirport to set
	 */
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	/**
	 * 
	 * @return the arrival date-time as String
	 */
	public String getArrivalDateTime() {
		return AirlineFlight.sdf.format(this.arrivalDate);
	}
	
	/**
	 * 
	 * @return the departure data-time as String
	 */
	public String getDepartureDataTime() {
		return AirlineFlight.sdf.format(this.departureDate);
	}
	
	/**
	 * @return the availableSeats
	 */
	public ArrayList<FlightSeat> getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(ArrayList<FlightSeat> availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public void removeAvailableSeat(FlightSeat seat) {
		if(this.availableSeats.contains(seat)) {
			this.availableSeats.remove(seat);
		}
	}
	
	public void addAvailableSeat(FlightSeat seat) {
		if(!this.availableSeats.contains(seat)) {
			this.availableSeats.add(seat);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(airline, arrivalAirport, arrivalDate, availableSeats, departureAirport, departureDate,
				flightId, flightNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AirlineFlight))
			return false;
		AirlineFlight other = (AirlineFlight) obj;
		return airline == other.airline && Objects.equals(arrivalAirport, other.arrivalAirport)
				&& Objects.equals(arrivalDate, other.arrivalDate)
				&& Objects.equals(availableSeats, other.availableSeats)
				&& Objects.equals(departureAirport, other.departureAirport)
				&& Objects.equals(departureDate, other.departureDate) && Objects.equals(flightId, other.flightId)
				&& Objects.equals(flightNumber, other.flightNumber);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirlineFlight [flightId=");
		builder.append(flightId);
		builder.append(", flightNumber=");
		builder.append(flightNumber);
		builder.append(", airline=");
		builder.append(airline);
		builder.append(", departureDate=");
		builder.append(departureDate);
		builder.append(", departureAirport=");
		builder.append(departureAirport);
		builder.append(", arrivalDate=");
		builder.append(arrivalDate);
		builder.append(", arrivalAirport=");
		builder.append(arrivalAirport);
		builder.append(", availableSeats=");
		builder.append(availableSeats);
		builder.append("]");
		return builder.toString();
	}

}
