package com.dvt.core.exception;

public class CommonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 721796992232356803L;

	private String message ;
	
	public CommonException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
