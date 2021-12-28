package com.RailwayReservation.trainservice.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.RailwayReservation.trainservice.model.Train;
import com.RailwayReservation.trainservice.service.TrainService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("trains/search")
public class UserController {
	
	@Autowired
	private TrainService trainService;
	
	@GetMapping("/findAllTrains")
    public List<Train> getTrain(){
	return trainService.getTrain();
	}
	
    @GetMapping("/findAllTrains/{trainid}")
    public Optional<Train> getTrainbyId(@PathVariable String trainid){
	return trainService.getTrainbyId(trainid);
    }
    
    

}
