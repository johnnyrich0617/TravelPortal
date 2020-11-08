/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.snhu.jhrichardson.TravelPortal.models.User;
import edu.snhu.jhrichardson.TravelPortal.models.repositories.UserRepository;

/**
 * @author john.richardson3
 *
 */
@Service
public class UserService {
	
	/**
	 * Singleton Instance of the User Repository
	 */
	private UserRepository userRepo;

	public UserService() {
		super();
		this.userRepo = UserRepository.getInstance();
	}
	
	public void addNewUser(User newUser) throws IllegalArgumentException {
		if(!this.userRepo.addNewUser(newUser)) {
			throw new IllegalArgumentException("User Already Exists : " + newUser.toString());
		}
	}
	
	public void deleteUser(User user) throws IllegalArgumentException {
		if(!this.userRepo.deleteUser(user)) {
			throw new IllegalArgumentException("User does not exists : " + user.toString());
		}
	}
	
	public void updateUserData(User user) throws IllegalArgumentException {
		if(!this.userRepo.updateUser(user)) {
			throw new IllegalArgumentException("Unable to update User : " + user.toString());
		}
	}
	
	public List<User> getAllUsers(){
		return this.userRepo.getUserList();
	}
	
	public User getUserForCustomerId(UUID custId) throws IllegalArgumentException {
		User user = this.userRepo.getUserForCustomerId(custId);
		if(user == null) {
			throw new IllegalArgumentException("Unable to retrieve User for CustomerId: " + custId.toString());
		}
		return user;
	}
	
	public User getValidatedUser(String userId, String password) {
		return this.userRepo.validateUser(userId, password);
	}

}
