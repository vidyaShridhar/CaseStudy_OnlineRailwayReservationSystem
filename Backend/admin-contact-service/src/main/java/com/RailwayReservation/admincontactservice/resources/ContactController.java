package com.RailwayReservation.admincontactservice.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RailwayReservation.admincontactservice.model.Contact;
import com.RailwayReservation.admincontactservice.service.ContactService;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactservice;

	
	//Add contacts
	@PostMapping("/add")
	public String addContact(@RequestBody Contact contact) {
    contactservice.addContact(contact);
	return "Added contact with id :  " + contact.getId();
	}
	
	//Get all contacts
	@GetMapping("/findAll")
	public List<Contact> getContact(){
			return contactservice.getContact();	
	}
	
	//Get contacts by ID
	@GetMapping("/findbyId/{id}")
	public Optional<Contact> getContactbyId(@PathVariable String id){
			return contactservice.getContactbyId(id);
	}
	
	//Update Contact
	@PutMapping("/update/{id}")
	public Contact updateContact(@PathVariable String id,@RequestBody Contact contact) {
	       return contactservice.updateContact(id,contact);
	}

	//Delete contact
	@DeleteMapping("/delete/{id}")
	public String deleteContact (@PathVariable String id) {
			contactservice.deleteContact(id);
			return "Contact deleted with id : "+id;
	}
}
