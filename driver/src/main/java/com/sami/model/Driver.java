package com.cgi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Driver {
	
	//Declare Model Class for Driver
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	private String firstName;
	private long telephonenumber;
	private String address;
	private String city;
	private String engineSize;
	private String quoteAmount;
	
	//Declare Constructor
	public Driver(int driverId, String firstName, long telephonenumber, String address, String city, String engineSize,
			String quoteAmount) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.telephonenumber = telephonenumber;
		this.address = address;
		this.city = city;
		this.engineSize = engineSize;
		this.quoteAmount = quoteAmount;
	}
	
	//Declare Getters and Setters
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public long getTelephonenumber() {
		return telephonenumber;
	}
	public void setTelephonenumber(long telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEngineSize() {
		return engineSize;
	}
	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}
	public String getQuoteAmount() {
		return quoteAmount;
	}
	public void setQuoteAmount(String quoteAmount) {
		this.quoteAmount = quoteAmount;
	}
	
	
	
	
	

}
