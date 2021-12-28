package com.RailwayReservation.trainservice.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.RailwayReservation.trainservice.model.Train;

public interface TrainRepository extends MongoRepository<Train,String>{

/*	List<Train> findByStation(String startStation, String endStation);*/

	
	

}
