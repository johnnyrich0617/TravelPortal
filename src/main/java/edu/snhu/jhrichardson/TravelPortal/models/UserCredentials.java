package edu.snhu.jhrichardson.TravelPortal.models;

import org.springframework.stereotype.Component;

@Component
public class UserCredentials {
	
	private String userId = null;
	private String password = null;

	public UserCredentials() {
		super();
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the passsword
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param passsword the passsword to set
	 */
	public void setPassword(String passsword) {
		this.password = passsword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		UserCredentials other = (UserCredentials) obj;
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
		builder.append("UserCredentials [userId=").append(userId).append(", passsword=").append(password).append("]");
		return builder.toString();
	}
}
