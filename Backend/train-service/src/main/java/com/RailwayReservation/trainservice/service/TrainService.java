package com.RailwayReservation.trainservice.service;

import java.util.List;
import java.util.Optional;

import com.RailwayReservation.trainservice.exception.EmptyFieldException;
import com.RailwayReservation.trainservice.model.Train;

public interface TrainService {

	abstract Train addTrain(Train train) throws EmptyFieldException;

	abstract List<Train> getTrain();

	abstract Optional<Train> getTrainbyId(String trainid);

	abstract Train updateTrain(String trainid, Train train);

	abstract void deleteTrain(String trainid);
	
/*	public List<Train> findbyStation(String startStation,String endStation);*/

}
