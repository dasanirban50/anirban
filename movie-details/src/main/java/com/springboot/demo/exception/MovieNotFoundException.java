package com.springboot.demo.exception;

public class MovieNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public MovieNotFoundException() {
		super();
	}

	public MovieNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MovieNotFoundException [message=" + message + "]";
	}
}
