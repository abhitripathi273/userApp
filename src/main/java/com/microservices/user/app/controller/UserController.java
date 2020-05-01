package com.microservices.user.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservices.user.app.entity.User;
import com.microservices.user.app.exception.UserNotFoundException;
import com.microservices.user.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	Environment env;

	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable String userId) throws UserNotFoundException {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/user")
	@ResponseStatus
	public ResponseEntity<User> createUser(@RequestBody User newUser) throws JsonProcessingException{
		return userService.createUser(newUser);
	}
	
	@PostMapping("/update_user")
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
}
