package com.RailwayReservation.trainservice.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.RailwayReservation.trainservice.exception.EmptyFieldException;
import com.RailwayReservation.trainservice.exception.TrainNotfoundException;

@ControllerAdvice
public class TrainExceptionController {
	
	@ExceptionHandler(value=TrainNotfoundException.class)
	public ResponseEntity<Object> exception(TrainNotfoundException exception){
		return new ResponseEntity<>("Train not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=EmptyFieldException.class)
	public ResponseEntity<Object> exception(EmptyFieldException exception){
		return new ResponseEntity<>("Field not found", HttpStatus.NOT_FOUND);
		
	}
}
