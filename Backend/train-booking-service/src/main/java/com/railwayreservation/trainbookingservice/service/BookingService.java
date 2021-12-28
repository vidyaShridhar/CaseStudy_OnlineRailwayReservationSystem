package com.railwayreservation.trainbookingservice.service;

import java.util.List;
import java.util.Optional;

import com.railwayreservation.trainbookingservice.model.Booking;

public interface BookingService {

	abstract Booking addBooking(Booking booking);

	abstract List<Booking> getBooking();

	abstract Optional<Booking> getBookingbyId(String id);

	abstract void cancelBooking(String id);

}
