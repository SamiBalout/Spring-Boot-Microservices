package com.cgi.model;


import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;

@Document(collection = "insurance")
public class Insurance {
	
	//Declare Insurance Class
	
	@Id
	private int insuranceId;
	private String insuranceType;
	Plan plan;
	
	//Declare Constructor
	public Insurance(int insuranceId, String insuranceType, Plan plan) {
		super();
		this.insuranceId = insuranceId;
		this.insuranceType = insuranceType;
		this.plan = plan;
	}

	//Declare Getters and Setters
	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	
	
	
}
