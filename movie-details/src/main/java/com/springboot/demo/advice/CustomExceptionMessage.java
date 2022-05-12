package com.springboot.demo.advice;

import java.util.Date;

public class CustomExceptionMessage {
	
	private String message;
	private Date today;
	public CustomExceptionMessage() {
		super();
	}
	public CustomExceptionMessage(String message, Date today) {
		super();
		this.message = message;
		this.today = today;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}
	@Override
	public String toString() {
		return "CustomExceptionMessage [message=" + message + ", today=" + today + "]";
	}
}
