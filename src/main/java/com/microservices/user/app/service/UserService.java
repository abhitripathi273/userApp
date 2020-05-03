package com.microservices.user.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.user.app.entity.User;
import com.microservices.user.app.exception.UserNotFoundException;
import com.microservices.user.app.repository.UserRepository;

@Service
public class UserService { 
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepo;

	public List<User> getUsers() {
		Iterable<User> userList = userRepo.findAll();
		return StreamSupport.stream(userList.spliterator(), false) 
		            .collect(Collectors.toList()); 
	}

	public User getUserById(String userId) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(Long.valueOf(userId));
		if(!user.isPresent()) {
			LOGGER.error("Unable to find the users.");
			throw new UserNotFoundException("User is not found in DB");
		}
		LOGGER.debug("user found with userId: {}",userId);
		return user.get();
	}

	public ResponseEntity<User> createUser(User newUser) {
		Long userId = generateUniqueId();
		newUser.setUserId(userId);
		User user = userRepo.save(newUser);
		LOGGER.debug("user created with userId: {}",userId);
		return new ResponseEntity(user, HttpStatus.CREATED);
	}

	public void deleteUser(String userId) {
		userRepo.deleteById(Long.valueOf(userId));
		LOGGER.debug("user deleted successfully");
	}
	
	public ResponseEntity<User> updateUser(User user){
		userRepo.save(user);
		LOGGER.debug("user updated successfully");
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	private Long generateUniqueId() {
        long uniqueUserId = -1;
        do {
        	uniqueUserId = UUID.randomUUID().getMostSignificantBits();
        } while (uniqueUserId < 0);
		String userId = String.valueOf(uniqueUserId);
		uniqueUserId = Long.valueOf(userId.substring(0, 5));
        return uniqueUserId;
    
	}
	
}
