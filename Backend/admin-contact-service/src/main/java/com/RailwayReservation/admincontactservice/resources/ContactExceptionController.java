package com.RailwayReservation.admincontactservice.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.RailwayReservation.admincontactservice.exception.ContactNotfoundException;


@ControllerAdvice
public class ContactExceptionController {
	
	@ExceptionHandler(value=ContactNotfoundException.class)
	public ResponseEntity<Object> exception(ContactNotfoundException exception){
		return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
		
	}
	
}
