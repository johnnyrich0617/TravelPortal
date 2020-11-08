/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;


import java.util.UUID;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * @author john.richardson3
 *
 */
@Component
public class CustomerContact {

	
	UUID customerId = null;
	
	@NotEmpty(message="First Name: Is required")
	String customerFirstName = null;
	
	@Size(min=0, max=1, message="Middle Initial: Must be 1 character only")
	String customerMiddleInit = null;
	
	@NotEmpty(message="Last Name: Is required")
	String customerLastName = null;
	
	@NotEmpty(message="Address1: Is required")
	String address1 = null;
	
	String address2 = null;
	
	@NotEmpty(message="City: Is required")
	String city = null;
	
	@NotEmpty(message="State: is required")
	@Size(min=2, max=2, message="State: Must be 2 character State abrieviation")
	String state = null;
	
	@NotEmpty(message="Five Digit Zip Code: Is required")
	@Size(min=5, max=5, message="Zip Code must be the five-digit zode")
	String fiveDigitZipCode = null;
	
	@NotEmpty(message="Phone: Is required")
	String phone = null;
	
	@NotEmpty(message="Email: Is required")
	@Email(message="Email: Must be a valid formatted email address")
	String email = null;
	
	PhoneType phoneType = PhoneType.CELL;
	
	/**
	 * 
	 */
	
	public CustomerContact() {
		this.customerId = UUID.randomUUID();
	}

//	/**
//	 * @param customerFirstName
//	 * @param customerMiddleInit
//	 * @param customerLastName
//	 * @param address1
//	 * @param address2
//	 * @param city
//	 * @param fiveDigitZipCode
//	 * @param phone
//	 * @param email
//	 * @param phoneType
//	 */
//	public CustomerContact(String customerFirstName, String customerMiddleInit, String customerLastName,
//			String address1, String address2, String city, String fiveDigitZipCode, String phone, String email,
//			PhoneType phoneType) {
//		super();
//		this.customerFirstName = customerFirstName;
//		this.customerMiddleInit = customerMiddleInit;
//		this.customerLastName = customerLastName;
//		this.address1 = address1;
//		this.address2 = address2;
//		this.city = city;
//		this.fiveDigitZipCode = fiveDigitZipCode;
//		this.phone = phone;
//		this.email = email;
//		this.phoneType = phoneType;
//	}

	/**
	 * Get the Customer ID
	 * @return customerId
	 */
	public UUID getCustomerId() {
		return customerId;
	}
	
	/**
	 * @return the customerFirstName
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	
	/**
	 * @param customerFirstName the customerFirstName to set
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	/**
	 * @return the customerMiddleInit
	 */
	public String getCustomerMiddleInit() {
		return customerMiddleInit;
	}

	/**
	 * @param customerMiddleInit the customerMiddleInit to set
	 */
	public void setCustomerMiddleInit(String customerMiddleInit) {
		this.customerMiddleInit = customerMiddleInit;
	}

	/**
	 * @return the customerLastName
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * @param customerLastName the customerLastName to set
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the fiveDigitZipCode
	 */
	public String getFiveDigitZipCode() {
		return fiveDigitZipCode;
	}

	/**
	 * @param fiveDigitZipCode the fiveDigitZipCode to set
	 */
	public void setFiveDigitZipCode(String fiveDigitZipCode) {
		this.fiveDigitZipCode = fiveDigitZipCode;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneType
	 */
	public PhoneType getPhoneType() {
		return phoneType;
	}

	/**
	 * @param phoneType the phoneType to set
	 */
	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((customerFirstName == null) ? 0 : customerFirstName.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerLastName == null) ? 0 : customerLastName.hashCode());
		result = prime * result + ((customerMiddleInit == null) ? 0 : customerMiddleInit.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fiveDigitZipCode == null) ? 0 : fiveDigitZipCode.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((phoneType == null) ? 0 : phoneType.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		CustomerContact other = (CustomerContact) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (customerFirstName == null) {
			if (other.customerFirstName != null)
				return false;
		} else if (!customerFirstName.equals(other.customerFirstName))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerLastName == null) {
			if (other.customerLastName != null)
				return false;
		} else if (!customerLastName.equals(other.customerLastName))
			return false;
		if (customerMiddleInit == null) {
			if (other.customerMiddleInit != null)
				return false;
		} else if (!customerMiddleInit.equals(other.customerMiddleInit))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fiveDigitZipCode == null) {
			if (other.fiveDigitZipCode != null)
				return false;
		} else if (!fiveDigitZipCode.equals(other.fiveDigitZipCode))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (phoneType != other.phoneType)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerContact [customerId=");
		builder.append(customerId);
		builder.append(", customerFirstName=");
		builder.append(customerFirstName);
		builder.append(", customerMiddleInit=");
		builder.append(customerMiddleInit);
		builder.append(", customerLastName=");
		builder.append(customerLastName);
		builder.append(", address1=");
		builder.append(address1);
		builder.append(", address2=");
		builder.append(address2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", fiveDigitZipCode=");
		builder.append(fiveDigitZipCode);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phoneType=");
		builder.append(phoneType);
		builder.append("]");
		return builder.toString();
	}

	
}
