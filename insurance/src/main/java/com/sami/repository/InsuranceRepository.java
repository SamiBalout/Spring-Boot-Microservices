package com.cgi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgi.model.Insurance;

@Repository
public interface InsuranceRepository extends MongoRepository<Insurance, Integer>{
	
	//public void findInsuranceDetailsByInsurnaceIdAndPlanId(Insurance insurance, int insuranceId, int planId);

}
