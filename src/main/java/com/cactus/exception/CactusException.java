package com.cactus.exception;

import java.lang.reflect.Method;

public class CactusException extends Exception{

	public CactusException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CactusException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String errorMsg = super.getMessage();
		return errorMsg;
	}
	
}
