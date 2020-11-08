/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models.repositories;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.snhu.jhrichardson.TravelPortal.models.User;


/**
 * @author john.richardson3
 *
 */
@Repository
public class UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private ArrayList<User> userRepository;

	/**
	 * 
	 */
	private UserRepository() {
		super();
		this.userRepository = new ArrayList<>();
		loadUsers();
	}

	private void loadUsers() {
		// TODO Auto-generated method stub
		
	}
	
	private static class UserRepositoryHelper{
		private static final UserRepository INSTANCE = new UserRepository();
	}
	
	/**
	 * 
	 * @return the AirlineReservationRepository Instance as a thread safe singleton
	 */
	public static UserRepository getInstance() {
		return UserRepositoryHelper.INSTANCE;
	}
	
	/**
	 * Is this user a valid User
	 * @param userId
	 * @param password
	 * @return true if valid
	 */
	public synchronized User validateUser(String userId, String password) {
		if(this.userRepository.isEmpty())
			return null;
		else {
			for(User user : this.userRepository) {
				if(user.getUserId().equals(userId) && user.getPassword().equals(password))
					return user;
			}
			return null;
		}
	}
	
	/**
	 * Get All Users
	 * @return userList
	 */
	public synchronized ArrayList<User> getUserList() {
		return this.userRepository;
	}
	
	/**
	 * Add a new User
	 * @param newUser
	 * @return true if successful, false if User exist or User ID exist
	 */
	public synchronized boolean addNewUser(User newUser) {
		for(User user : this.userRepository) {
			if(!this.userRepository.contains(newUser)) {
				if(user.getUserId().equals(newUser.getUserId())) {
					return false;
				}
			}
			else {
				return false;
			}
		}
		this.userRepository.add(newUser);
		return true;
	}
	/**
	 * Delete a User from the repository
	 * @param curentUser User to delete
	 * @return true if User is removed, false if User does not exist
	 */
	public synchronized boolean deleteUser(User curentUser) {
		if(this.userRepository.isEmpty())
			return false;
		
		if(this.userRepository.contains(curentUser)) {
			this.userRepository.remove(curentUser);
			return true;
		} else
			return false;
	}
	
	/**
	 * Get the User for a CustomerId
	 * @param custId
	 * @return User
	 */
	public synchronized User getUserForCustomerId(UUID custId) {
		for(User user : this.userRepository) {
			if(user.getCustomerInfo().getCustomerId().equals(custId)) {
				return user;
			}
		}
		return null;
	}
	
	/**
	 * Update the user info in the repository for this User
	 * @param updatedUser - User to update
	 * @return true if successful, false if not
	 */
	public boolean updateUser(User updatedUser) {
		for(User user : this.userRepository) {
			if(user.getCustomerInfo().getCustomerId()
					.equals(updatedUser.getCustomerInfo().getCustomerId())) {
				user.deepCopy(updatedUser);
				return true;
			}
		}
		return false;
	}

}
