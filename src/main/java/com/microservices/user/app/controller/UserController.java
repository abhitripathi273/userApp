package com.microservices.user.app.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservices.user.app.entity.User;
import com.microservices.user.app.exception.UserNotFoundException;
import com.microservices.user.app.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	Environment env;

	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable String userId) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(Long.parseLong(userId));
		if(!user.isPresent())
			throw new UserNotFoundException("User ID "+userId+" is not found in DB");
		return user.get();
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User newUser){
		User createdUser = userRepo.save(newUser);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id")
				.buildAndExpand(createdUser.getUserId())
				.toUri();
		return ResponseEntity.created(location).body(createdUser);
	}
	
	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable String userId) {
		userRepo.deleteById(Long.parseLong(userId));
	}
	
	@GetMapping("/user/port")
	public String getAllCovid19PatientEnv() {

		return "Working on port=" + env.getProperty("local.server.port") + " , "
				+ env.getProperty("config.property.name");
	}
}
