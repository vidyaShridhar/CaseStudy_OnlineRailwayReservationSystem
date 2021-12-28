package com.RailwayReservation.admincontactservice.service;

import java.util.List;
import java.util.Optional;

import com.RailwayReservation.admincontactservice.model.Contact;

public interface ContactService {
	
	abstract Contact addContact(Contact contact);

	abstract List<Contact> getContact();

	abstract Optional<Contact> getContactbyId(String id);

	abstract Contact updateContact(String id, Contact contact);

	abstract void deleteContact(String id);

}
