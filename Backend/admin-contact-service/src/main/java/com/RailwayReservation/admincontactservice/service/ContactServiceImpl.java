package com.RailwayReservation.admincontactservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RailwayReservation.admincontactservice.exception.ContactNotfoundException;
import com.RailwayReservation.admincontactservice.model.Contact;
import com.RailwayReservation.admincontactservice.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	//add contact
	public Contact addContact (Contact contact) {
		return contactRepository.save(contact);
	}
	
	//get all contact
	public List<Contact> getContact() {
		List<Contact> contact = contactRepository.findAll();
		return contact;
	}
	
    //get contact by id
	public Optional<Contact> getContactbyId(String id) {
		boolean isContactExist=contactRepository.existsById(id);
		if(isContactExist)
		{
			return contactRepository.findById(id);
		}
		else
		{
			throw new ContactNotfoundException();
		}
	}
	
	//update contact
	public Contact updateContact(String id, Contact contact) {
		boolean isContactExist=contactRepository.existsById(id);
		if(isContactExist)
			{
				contact.setId(id);
				contactRepository.save(contact);
				return contact;
			}
			else 
			{
				throw new ContactNotfoundException();
				
			}
	 }
	
    //delete contact
	public void deleteContact(String id) {
		boolean isContactExist=contactRepository.existsById(id);
		if(isContactExist)
		{
			contactRepository.deleteById(id);
		}
		else
		{
			throw new ContactNotfoundException();
		}
	}
}
