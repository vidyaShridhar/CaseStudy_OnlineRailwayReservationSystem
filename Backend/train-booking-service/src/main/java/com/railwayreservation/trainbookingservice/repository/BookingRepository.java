package com.railwayreservation.trainbookingservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.railwayreservation.trainbookingservice.model.Booking;

public interface BookingRepository extends MongoRepository<Booking,String>{

}
