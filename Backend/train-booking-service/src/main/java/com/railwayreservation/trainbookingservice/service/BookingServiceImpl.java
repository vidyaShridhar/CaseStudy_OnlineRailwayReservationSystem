package com.railwayreservation.trainbookingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.railwayreservation.trainbookingservice.exception.BookingNotfoundException;
import com.railwayreservation.trainbookingservice.model.Booking;
import com.railwayreservation.trainbookingservice.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	

	
	@Autowired
	private BookingRepository bookingRepository;
	
	//add booking
	public Booking addBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	//get all booking
	public List<Booking> getBooking() {
		List<Booking> booking = bookingRepository.findAll();
		return booking;
	}

	//get booking by id
	public Optional<Booking> getBookingbyId(String id) {
		boolean isBookingExist=bookingRepository.existsById(id);
		if(isBookingExist)
		{
			return bookingRepository.findById(id);
		}
		else
		{
			throw new BookingNotfoundException();
		}
	}
	
    
	//cancel booking
	public void cancelBooking(String id) {
		boolean isBookingExist=bookingRepository.existsById(id);
		if(isBookingExist)
		{
			bookingRepository.deleteById(id);
		}
		else
		{
			throw new BookingNotfoundException();
		}
	}	
	
		
	
}
