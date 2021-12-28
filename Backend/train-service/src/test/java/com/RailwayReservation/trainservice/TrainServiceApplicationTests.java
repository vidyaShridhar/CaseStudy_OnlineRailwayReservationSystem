package com.RailwayReservation.trainservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.RailwayReservation.trainservice.exception.EmptyFieldException;
import com.RailwayReservation.trainservice.model.Train;
import com.RailwayReservation.trainservice.repository.TrainRepository;
import com.RailwayReservation.trainservice.service.TrainService;


@RunWith(SpringRunner.class)
@SpringBootTest
class TrainServiceApplicationTests {
	

	@Autowired
	private TrainService trainService;
	
	@MockBean
	private TrainRepository trainRepository;
	
	@Test
	public void addTrainTest() throws EmptyFieldException {
		Train train = new Train("877","Sonarpur Local","Sealdah","Sonarpur","1:00PM","200");
		when(trainRepository.save(train)).thenReturn(train);
		assertEquals(train,trainService.addTrain(train));
	}

	@Test
	public void getTrainTest() {
		when(trainRepository.findAll()).thenReturn(Stream
				.of(new Train("12","Howrah local","Bandel","Howrah","1:00PM","200"), new Train("12","Jagannath Express","Howrah","Puri","1:00PM","200")).collect(Collectors.toList()));
		assertEquals(2,trainService.getTrain().size());
	}
	
	/*@Test
	public void getTrainbyId() {
		String id="20";
		when(trainRepository.findById(id))
		      .thenReturn(Stream.of((new Train("12","Howrah local","Bandel","Howrah")).collect(Collectors.toList()));
		assertEquals(id,trainService.getTrainbyId(id));
	}
	
	@Test
	public void deleteTrainTest() {
		Train train = new Train("12","Howrah local","Bandel","Howrah");
		trainService.deleteTrain(train);
		verify(trainRepository, times(1)).delete(train);
		
	}*/
	
}
