/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models.repositories.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import edu.snhu.jhrichardson.TravelPortal.models.AirlineFlight;

/**
 * @author richa
 *
 */
public interface FlightsDao {
	
	/**
	 * Data Access Methods
	 */
	
	public List<AirlineFlight> getAllFlights();
	
	public AirlineFlight getFlightById(Integer id);
	
	public List<AirlineFlight> getFltsByIds(List<Integer> fltIds);
	
	public void updateFltSeat(Integer seat_id, boolean isAvailable);
	
	public void updateFlightSeats(List<Integer> flt_ids, boolean isAvailable);
	
	public boolean fltHasSeats(Integer flt_id);
	
	public Map<Integer, Boolean> fltsHaveSeats(List<Integer> flt_ids);
	
	public List<AirlineFlight> searchFlightByDate(Timestamp searchDate);

}
