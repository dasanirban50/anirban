package com.springboot.demo.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.demo.exception.MovieFoundException;
import com.springboot.demo.exception.MovieNotFoundException;

@RestControllerAdvice
public class GeneralExceptionHandler {
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<CustomExceptionMessage> handleMovieNotFoundException(MovieNotFoundException ex){
		CustomExceptionMessage customExceptionMessage = new CustomExceptionMessage(ex.getMessage(),new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customExceptionMessage);
	}
	
	@ExceptionHandler(MovieFoundException.class)
	public ResponseEntity<CustomExceptionMessage> handleMovieFoundException(MovieFoundException ex){
		CustomExceptionMessage customExceptionMessage = new CustomExceptionMessage(ex.getMessage(),new Date());
		return ResponseEntity.status(HttpStatus.FOUND).body(customExceptionMessage);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomExceptionMessage> handleException(Exception ex){
		CustomExceptionMessage customExceptionMessage = new CustomExceptionMessage(ex.getMessage(),new Date());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customExceptionMessage);
	}

}
