package com.cactus.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String userId) {
		super("could not find user '" + userId + "'.");
	}
}
