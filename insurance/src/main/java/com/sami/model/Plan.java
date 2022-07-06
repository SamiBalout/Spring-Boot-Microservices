package com.cgi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;

@Document(collection = "plan")
public class Plan {
	
	//Declare Plan Model
	
	@Id
	private int planId;
	private String planName;
	private String period;
	private double amount;
	
	//Declare Constructor
	public Plan(int planId, String planName, String period, double amount) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.period = period;
		this.amount = amount;
	}
	
	//Declare Getters and Setters
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
