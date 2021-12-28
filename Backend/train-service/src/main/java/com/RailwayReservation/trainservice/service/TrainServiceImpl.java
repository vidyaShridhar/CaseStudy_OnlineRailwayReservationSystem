package com.RailwayReservation.trainservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.RailwayReservation.trainservice.exception.EmptyFieldException;
import com.RailwayReservation.trainservice.exception.TrainNotfoundException;
import com.RailwayReservation.trainservice.model.Train;
import com.RailwayReservation.trainservice.repository.TrainRepository;

@Service
public class TrainServiceImpl implements TrainService {
	
	@Autowired
	private TrainRepository trainRepository;
	
	public Train addTrain(Train train) throws EmptyFieldException {
		if(train.getTrainName().isEmpty() || train.getTrainName().length()==0)
		{
			throw new EmptyFieldException();
		}
			return trainRepository.save(train);
	}
	
	public List<Train> getTrain() {
		List<Train> train = trainRepository.findAll();
		return train;
	}

	public Optional<Train> getTrainbyId(String id) {
		boolean isTrainExist=trainRepository.existsById(id);
		if(isTrainExist)
		{
			return trainRepository.findById(id);
		}
		else
		{
			throw new TrainNotfoundException();
		}
	}
	
	public Train updateTrain(String trainid, Train train) {
   	 boolean isTrainExist=trainRepository.existsById(trainid);
		if(isTrainExist)
		{
			train.setTrainid(trainid);
			trainRepository.save(train);
			return train;
		}
		else 
		{
			throw new TrainNotfoundException();
			
		}
    }

	public void deleteTrain(String id) {
		boolean isTrainExist=trainRepository.existsById(id);
		if(isTrainExist)
		{
			trainRepository.deleteById(id);
		}
		else
		{
			throw new TrainNotfoundException();
		}
	}
	
/*	public List<Train> findbyStation(String startStation, String endStation ){
		return trainRepository.findByStation(startStation,endStation);
		
	}*/
	

}
