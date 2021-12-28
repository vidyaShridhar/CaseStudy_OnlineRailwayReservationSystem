package com.RailwayReservation.admincontactservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.RailwayReservation.admincontactservice.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {
	

}
