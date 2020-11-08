/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * @author john.richardson3
 *
 */
@Component
public abstract class Reservation {
	/**
	 * The UUID for this reservation
	 */
	private UUID reservationId;
	
	/**
	 * Date this reservation was created
	 */
	private Date dateCreated;
	
	/**
	 * The owner of this reservation
	 */
	private CustomerContact cContact;
	
	/**
	 * 
	 */
	public Reservation() {
		this.reservationId = UUID.randomUUID();
		this.dateCreated = new Date();
	}
	
	public UUID getReservationId() {
		return this.reservationId;
	}

	/**
	 * @return the cContact
	 */
	public CustomerContact getcContact() {
		return cContact;
	}

	/**
	 * @param cContact the cContact to set
	 */
	public void setcContact(CustomerContact cContact) {
		this.cContact = cContact;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cContact == null) ? 0 : cContact.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((reservationId == null) ? 0 : reservationId.hashCode());
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
		Reservation other = (Reservation) obj;
		if (cContact == null) {
			if (other.cContact != null)
				return false;
		} else if (!cContact.equals(other.cContact))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (reservationId == null) {
			if (other.reservationId != null)
				return false;
		} else if (!reservationId.equals(other.reservationId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [reservationId=");
		builder.append(reservationId);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", cContact=");
		builder.append(cContact);
		builder.append("]");
		return builder.toString();
	}
	
	

}
