package com.railwayreservation.trainbookingservice;


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

import com.railwayreservation.trainbookingservice.model.Booking;
import com.railwayreservation.trainbookingservice.repository.BookingRepository;
import com.railwayreservation.trainbookingservice.service.BookingService;


@RunWith(SpringRunner.class)
@SpringBootTest
class TrainBookingServiceApplicationTests {
	
	 @Autowired
	   private BookingService bookingService;
	   
	   @MockBean
	   private BookingRepository bookingRepository;
	   
		@Test
		public void getBookingTest() {
			when(bookingRepository.findAll()).thenReturn(Stream.of
					(new Booking("111","T10","3","10-02-2022","Banglore","Mysur"), new Booking("112","T11","4","11-02-2022","Manglore","Banglore")).collect(Collectors.toList()));
			assertEquals(2,bookingService.getBooking().size());
		}
		
		@Test
		public void addBookingTest() {
			Booking booking =new Booking("111","T10","3","10-02-2022","Banglore","Mysur");
			when(bookingRepository.save( booking)).thenReturn(booking);
		    assertEquals( booking, bookingService.addBooking( booking));
			
			}

	

}
