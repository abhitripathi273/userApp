package com.microservices.user.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservices.user.app.entity.User;
import com.microservices.user.app.exception.UserNotFoundException;
import com.microservices.user.app.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	Environment env;

	@GetMapping("/users")
	@HystrixCommand(groupKey="UserMicroService", fallbackMethod="getUsersFallback")
	public List<User> getUsers() throws UserNotFoundException{
		System.out.println("getUsers");
		return userService.getUsers();
	}
	
	@GetMapping("/user/{userId}")
	@HystrixCommand(groupKey="UserMicroService", fallbackMethod="getUserByIdFallback", commandKey = "getUserById")
	public User getUserById(@PathVariable String userId) throws UserNotFoundException {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/user")
	@ResponseStatus
	public ResponseEntity<User> createUser(@RequestBody User newUser) throws JsonProcessingException{
		return userService.createUser(newUser);
	}
	
	@PutMapping("/update_user")
	@ResponseStatus
	public ResponseEntity<User> updateUser(@RequestBody User user) throws JsonProcessingException{
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
	}
	
	@GetMapping("/user/port")
	public String getAllCovid19PatientEnv() {
		return "Working on port=" + env.getProperty("local.server.port") + " , "
				+ env.getProperty("config.property.name");
	}
	
	/**
	 * Gets the user by id fallback.
	 *
	 * @param userId
	 *            the user id
	 * @return the user by id fallback
	 */
	public User getUserByIdFallback(String userId, Throwable throwable) {
		if(throwable instanceof UserNotFoundException){
			System.out.println("Unable to find the user " + userId);
		}else if(throwable instanceof Exception){
			System.out.println("System is down!");
		}
		return new User();
	}

	/**
	 * Gets the users fallback.
	 *
	 * @return the users fallback
	 */
	public List<User> getUsersFallback(Throwable throwable) {
		if(throwable instanceof UserNotFoundException){
			System.out.println("Unable to find the users");
		}else if(throwable instanceof Exception){
			System.out.println("System is down!");
		}
		return new ArrayList<User>();
	}
}
