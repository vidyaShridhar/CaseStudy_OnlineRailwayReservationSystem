package com.RailwayReservation.admincontactservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.RailwayReservation.admincontactservice.model.Contact;
import com.RailwayReservation.admincontactservice.repository.ContactRepository;
import com.RailwayReservation.admincontactservice.service.ContactService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminContactServiceApplicationTests {

	@Autowired
	private ContactService contactService;
	
	@MockBean
	private ContactRepository conatctRepository;

	@Test
	public void getContactTest() {
		when(conatctRepository.findAll()).thenReturn(Stream
				.of(new Contact("12","Tapan","415178261678"), new Contact("69","Riya","123656760")).collect(Collectors.toList()));
		assertEquals(2,contactService.getContact().size());
	}
		@Test
		public void addContactTest() {
			Contact contact = new Contact("999", "Pranya", "431516626262");
			when(conatctRepository.save(contact)).thenReturn(contact);
			assertEquals(contact, contactService.addContact(contact));
		
		}

}