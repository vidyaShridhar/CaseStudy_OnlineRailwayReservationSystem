package com.userlogin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bookings")
public class Booking {
	
	@Id
	private String id;
	private String trainid;
	private String numofseats;
	private String date;
	private String startStation;
	private String endStation;

	
	public Booking() {
		
	}

	public Booking(String id, String trainid, String numofseats, String date, String startStation, String endStation) {
		super();
		this.id = id;
		this.trainid = trainid;
		this.numofseats = numofseats;
		this.date = date;
		this.startStation = startStation;
		this.endStation = endStation;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTrainid() {
		return trainid;
	}


	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}


	public String getNumofseats() {
		return numofseats;
	}


	public void setNumofseats(String numofseats) {
		this.numofseats = numofseats;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getStartStation() {
		return startStation;
	}


	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}


	public String getEndStation() {
		return endStation;
	}


	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

}
