DROP TABLE IF EXISTS users;
CREATE TABLE users(
	customer_id UUID NOT NULL, 
	user_id VARCHAR(50) NOT NULL,
	display_name VARCHAR(50) NOT NULL,
	password VARCHAR(14) NOT NULL,
	customer_first_name VARCHAR(20) NOT NULL,
	customer_last_name VARCHAR(20) NOT NULL,
	customer_middle_init VARCHAR(1),
	address_1 VARCHAR(100) NOT NULL,
	address_2 VARCHAR(100),
	city VARCHAR(50) NOT NULL,
	state VARCHAR(2) NOT NULL,
	five_digit_zip_code VARCHAR(5) NOT NULL,
	phone VARCHAR(13) NOT NULL,
	phone_type VARCHAR(4) NOT NULL,
	email VARCHAR(50) NOT NULL,
	PRIMARY KEY(customer_id)
);

DROP TABLE IF EXISTS flights;
--CREATE SEQUENCE flt_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE flights(
	flt_id_seq BIGINT auto_increment, 
	--flight_id UUID DEFAULT RANDOM_UUID(),
	flight_number VARCHAR(20) NOT NULL,
	carrier VARCHAR(20) NOT NULL,
	departure_date TIMESTAMP NOT NULL,
	departure_airport VARCHAR(3) NOT NULL,
	arrival_date TIMESTAMP NOT NULL,
	arrival_airport VARCHAR(3) NOT NULL,
	PRIMARY KEY(flt_id_seq)
);

DROP TABLE IF EXISTS flight_seats;
--CREATE SEQUENCE SEAT_SEQ START WITH 1 INCREMENT BY 1;
CREATE TABLE flight_seats(
	seat_id_seq BIGINT auto_increment,
	flight_id BIGINT NOT NULL,
	foreign key (flight_id) references flights(flt_id_seq),
	seat_number VARCHAR(3) NOT NULL,
	is_available BOOLEAN DEFAULT true NOT NULL, 
	PRIMARY KEY(seat_id_seq)
);

DROP TABLE IF EXISTS airline_reservations;
CREATE TABLE airline_reservations(
	reservation_id UUID NOT NULL,
	date_created TIMESTAMP NOT NULL,
	customer_id UUID NOT NULL,
	foreign key (customer_id) references users(customer_id),
	departure_flight_id UUID NOT NULL,
	foreign key (departure_flight_id) references flights(flt_id_seq),
	return_flight_id UUID NOT NULL,
	foreign key (return_flight_id) references flights(flt_id_seq),
	isOneWay BOOLEAN DEFAULT false NOT NULL,
	PRIMARY KEY(reservation_id)
);

DROP TABLE IF EXISTS reservation_flight_passengers;
CREATE TABLE reservation_flight_passengers(
	passenger_id UUID NOT NULL,
	reservation_id UUID NOT NULL,
	foreign key (reservation_id) references airline_reservations(reservation_id),
	flight_id UUID NOT NULL,
	foreign key (flight_id) references flights(flt_id_seq),
	seat_id UUID NOT NULL,
	foreign key (seat_id) references flight_seats(seat_id_seq),
	pass_first_name VARCHAR(20) NOT NULL,
	pass_middle_init VARCHAR(1),
	pass_last_name VARCHAR(20) NOT NULL,
	PRIMARY KEY(passenger_id)
);



