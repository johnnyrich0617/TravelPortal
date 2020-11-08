/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models.repositories;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import edu.snhu.jhrichardson.TravelPortal.models.AirlineFlight;
import edu.snhu.jhrichardson.TravelPortal.models.FlightSeat;

/**
 * @author richa
 *
 */
public class FlightsRowMapper implements RowMapper<AirlineFlight> {
	
	private static Logger log = LogManager.getLogger(FlightsRowMapper.class);

	@Override
	public AirlineFlight mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ArrayList<FlightSeat> fltSeats = new ArrayList<>();
		
		Array seatarray = rs.getArray("SeatIDs");
		Array seatNumbersarray = rs.getArray("Seats");
		
		/*
		 * The seatIds and seatNumber Arrays have been sorted in the query
		 * now we need to hash them together as FlightSeat
		 */
		ResultSet seatIdSet =  seatarray.getResultSet();
		ResultSet seatNumberSet =  seatNumbersarray.getResultSet();
		int i=0;
		while(seatIdSet.next() && seatNumberSet.next()) {
			log.info("ADDING SEAT ID : " + seatIdSet.getInt(2) + " WITH SEAT NUMBER: " + seatNumberSet.getString(2));
			fltSeats.add(i, new FlightSeat(seatIdSet.getInt(2), rs.getInt("flt_id_seq" ), seatNumberSet.getString(2)));
			i++;
		}
		
		log.info("NOW CREATING NEW FIGHT>>>>>>>>>>>>>>>>>>>>> " + rs.getString("flight_number"));

		AirlineFlight flight = new AirlineFlight(
				rs.getInt("flt_id_seq"), 
				rs.getString("flight_number"),
				rs.getString("carrier"),
				rs.getTimestamp("departure_date"),
				rs.getString("departure_airport"),
				rs.getTimestamp("arrival_date"),
				rs.getString("arrival_airport")
				);
		
		flight.setAvailableSeats(fltSeats);
		
		return flight;		
	}

}
