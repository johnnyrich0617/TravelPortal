/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * @author john.richardson3
 *
 */
@Component
public class User implements Serializable {
	
	private static final long serialVersionUID = -1078131355442488780L;
	
	@NotEmpty(message="User Name: is a required field")
	private String userId = null;
	
	@NotEmpty(message="Display Name: is a required field")
	private String displayName = null;
	
	@NotEmpty(message="Password: is a required field")
	@Size(min=7, max=14, message="Password must be at least 7 but less then 15 characters in lenghth")
	private String password = null;
	
	@Valid
	private CustomerContact customerInfo = null;

	
	public User() {
		super();
		this.customerInfo = new CustomerContact();
	}
	
//	public User(String userId, String displayName, String password) {
//		super();
//		this.userId = userId;
//		this.displayName = displayName;
//		this.password = password;
//	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the customerInfo
	 */
	public CustomerContact getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * @param customerInfo the customerInfo to set
	 */
	public void setCustomerInfo(CustomerContact customerInfo) {
		this.customerInfo = customerInfo;
	}

	/**
	 * @param uid the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}


	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Will update everything for this user except
	 * User.userId and the user.customerInfo.customerId
	 * @param user to copy.
	 */
	public void deepCopy(User user) {
		this.setPassword(user.getPassword());
		this.setDisplayName(user.getDisplayName());
		CustomerContact cc = this.getCustomerInfo();
		cc.setAddress1(user.getCustomerInfo().getAddress1());
		cc.setAddress2(user.getCustomerInfo().getAddress2());
		cc.setCity(user.getCustomerInfo().getCity());
		cc.setCustomerFirstName(user.getCustomerInfo().getCustomerFirstName());
		cc.setCustomerLastName(user.getCustomerInfo().getCustomerLastName());
		cc.setCustomerMiddleInit(user.getCustomerInfo().getCustomerMiddleInit());
		cc.setEmail(user.getCustomerInfo().getEmail());
		cc.setFiveDigitZipCode(user.getCustomerInfo().getFiveDigitZipCode());
		cc.setPhone(user.getCustomerInfo().getPhone());
		cc.setPhoneType(user.getCustomerInfo().getPhoneType());
		this.setCustomerInfo(cc);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerInfo == null) ? 0 : customerInfo.hashCode());
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		User other = (User) obj;
		if (customerInfo == null) {
			if (other.customerInfo != null)
				return false;
		} else if (!customerInfo.equals(other.customerInfo))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=").append(userId).append(", displayName=").append(displayName)
				.append(", password=").append(password).append(", customerInfo=").append(customerInfo).append("]");
		return builder.toString();
	}
	
	
}


	