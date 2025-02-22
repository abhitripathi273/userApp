package com.microservices.user.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3204705332368137965L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
