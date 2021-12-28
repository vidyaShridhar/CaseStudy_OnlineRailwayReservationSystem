package com.RailwayReservation.trainservice.resources;

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
import com.RailwayReservation.trainservice.exception.EmptyFieldException;
import com.RailwayReservation.trainservice.model.Train;
import com.RailwayReservation.trainservice.service.TrainService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/trains")
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	
	//Add train
	@PostMapping("/add")
	public String addTrain(@RequestBody Train train) throws EmptyFieldException {
		trainService.addTrain(train);
		return "Added train with ID:" + train.getTrainid();
	}
	
	//get all train
	@GetMapping("/findAll")
	public List<Train> getTrain(){
		return trainService.getTrain();
	}
	
	//get train by id
	@GetMapping("/findbyId/{trainid}")
	public Optional<Train> getTrainbyId(@PathVariable String trainid){
		return trainService.getTrainbyId(trainid);
	}
		
	
	//update train
	@PutMapping("/update/{trainid}")
	public Train updateTrain(@PathVariable("trainid") String trainid,@RequestBody Train train ) {
		return trainService.updateTrain(trainid, train);
	
		
	}
	
	//delete train
	 @DeleteMapping("/delete/{trainid}")
	 public String deleteTrain (@PathVariable String trainid) {
		 trainService.deleteTrain(trainid);
		 return "Train deleted with id : "+trainid;
		 
	}
	 
	/* @GetMapping("/find/{startStation}/{endStation}")
	    public List<Train> findbyStation(@PathVariable String startStation,@PathVariable String endStation ) {
	    	return trainService.findbyStation(startStation, endStation);
	    }*/
	    
}
