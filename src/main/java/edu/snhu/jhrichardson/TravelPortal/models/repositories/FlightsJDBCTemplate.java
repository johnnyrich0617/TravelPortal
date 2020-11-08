/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models.repositories;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import edu.snhu.jhrichardson.TravelPortal.models.AirlineFlight;
import edu.snhu.jhrichardson.TravelPortal.models.repositories.dao.FlightsDao;

/**
 * @author richa
 *
 */
@Component
public class FlightsJDBCTemplate implements FlightsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
	private static Logger log = LogManager.getLogger(FlightsJDBCTemplate.class);
	
	private String ALL_FLTS_SQL = "SELECT f.flt_id_seq, f.flight_number, f.carrier, f.departure_date, f.departure_airport, f.arrival_date, f.arrival_airport, ARRAY_AGG(s.seat_id_seq ORDER BY s.seat_id_seq) AS \"SeatIDs\", ARRAY_AGG(s.seat_number ORDER BY s.seat_id_seq) AS \"Seats\" "
			+ "FROM flights f "
			+ "JOIN flight_seats s "
			+ "ON f.flt_id_seq = s.flight_id AND s.is_available = true "
			+ "GROUP BY f.flt_id_seq, f.flight_number, f.carrier, f.departure_date "
			+ "ORDER BY f.flt_id_seq";
	
	private String FLT_BY_ID_SQL = "SELECT f.flt_id_seq, f.flight_number, f.carrier, f.departure_date, f.departure_airport, f.arrival_date, f.arrival_airport, ARRAY_AGG(s.seat_id_seq ORDER BY s.seat_id_seq) AS \"SeatIDs\", ARRAY_AGG(s.seat_number ORDER BY s.seat_id_seq) AS \"Seats\" "
			+ "FROM flights f "
			+ "JOIN flight_seats s "
			+ "ON f.flt_id_seq = s.flight_id AND s.is_available = true "
			+ "WHERE f.flt_id_seq IN (:ids) "
			+ "GROUP BY f.flt_id_seq, f.flight_number, f.carrier, f.departure_date "
			+ "ORDER BY f.flt_id_seq";
	
	private String UPDATE_FLT_SEAT_SQL = "UPDATE flight_seats SET is_available = :AVILABLE WHERE seat_id_seq IN (:IDS)";
	
	private String SRCH_FLTS_BY_DATE_SQL = "SELECT f.flt_id_seq, f.flight_number, f.carrier, f.departure_date, f.departure_airport, f.arrival_date, f.arrival_airport, ARRAY_AGG(s.seat_id_seq ORDER BY s.seat_id_seq) AS \"SeatIDs\", ARRAY_AGG(s.seat_number ORDER BY s.seat_id_seq) AS \"Seats\" "
			+ "FROM flights f "
			+ "JOIN flight_seats s "
			+ "ON f.flt_id_seq = s.flight_id AND s.is_available = true "
			+ "WHERE f.departure_date >= :REQUESTED_DATE "
			+ "GROUP BY f.flt_id_seq, f.flight_number, f.carrier, f.departure_date "
			+ "ORDER BY f.flt_id_seq";

	@Override
	public List<AirlineFlight> getAllFlights() {
		return this.jdbcTemplate.query(ALL_FLTS_SQL, new FlightsRowMapper());
	}

	@Override
	public AirlineFlight getFlightById(Integer id) {
		List<Integer> ids = new ArrayList<>();
		ids.add(id);
		SqlParameterSource parameters = new MapSqlParameterSource("ids", ids);
		List<AirlineFlight> fltList = namedJdbcTemplate.query(FLT_BY_ID_SQL, parameters, new FlightsRowMapper());
		//There can be only one
		if(fltList.get(0) != null) {
			return fltList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<AirlineFlight> getFltsByIds(List<Integer> fltIds) {	
		SqlParameterSource parameters = new MapSqlParameterSource("ids", fltIds);
		return namedJdbcTemplate.query(FLT_BY_ID_SQL, parameters, new FlightsRowMapper());
	}

	@Override
	public void updateFltSeat(Integer seat_id, boolean isAvailable) {
		List<Integer> ids = new ArrayList<>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("AVAILABLE", isAvailable);
		parameters.addValue("IDS", ids.add(seat_id));
		namedJdbcTemplate.update(UPDATE_FLT_SEAT_SQL, parameters);
	}

	@Override
	public void updateFlightSeats(List<Integer> seat_ids, boolean isAvailable) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("AVAILABLE", isAvailable);
		parameters.addValue("IDS", seat_ids);
		namedJdbcTemplate.update(UPDATE_FLT_SEAT_SQL, parameters);
	}

	@Override
	public boolean fltHasSeats(Integer flt_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Integer, Boolean> fltsHaveSeats(List<Integer> flt_ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AirlineFlight> searchFlightByDate(Timestamp searchDate) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("REQUESTED_DATE", searchDate);
		return namedJdbcTemplate.query(SRCH_FLTS_BY_DATE_SQL, parameters, new FlightsRowMapper());
	}

}
