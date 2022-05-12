package com.springboot.demo.exception;

public class MovieFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public MovieFoundException() {
		super();
	}

	public MovieFoundException(String message) {
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
		return "MovieFoundException [message=" + message + "]";
	}
}
