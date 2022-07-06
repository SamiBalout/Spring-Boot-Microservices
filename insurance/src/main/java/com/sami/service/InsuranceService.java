package com.cgi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.exception.InsuranceAlreadyExistException;
import com.cgi.exception.InsuranceDoesNotExistException;
import com.cgi.exception.PlanIdNotFoundException;
import com.cgi.model.Insurance;
import com.cgi.repository.InsuranceRepository;

@Service
public class InsuranceService {

	@Autowired
	InsuranceRepository repo;

	// Add Insurance Details
	public Insurance addInsuranceDetails(Insurance insurance) throws InsuranceAlreadyExistException {

		Optional<Insurance> findIns = repo.findById(insurance.getInsuranceId());

		if (findIns == null) {
			return repo.save(insurance);
		}

		throw new InsuranceAlreadyExistException("Insurance Already Exist with id: " + insurance.getInsuranceId());

	}

	// Get All Insurance Details by Id
	public Insurance getAllInsuranceDetailsById(int insuranceId) throws InsuranceDoesNotExistException {

		Optional<Insurance> findIns = repo.findById(insuranceId);

		if (findIns.isPresent()) {
			return findIns.get();
		}

		throw new InsuranceDoesNotExistException("Insurance Does Not Exist with id: " + insuranceId);

	}

	// Get All Insurance Details based on Insurance Id and Plan Id
	public Insurance getInsuranceDetailsByInsuranceIdAndPlanId(int insuranceId, int planId)
			throws PlanIdNotFoundException {

		Optional<Insurance> findIns = repo.findById(insuranceId);

		if (findIns.isPresent()) {
			if (findIns.get().getPlan().getPlanId() == planId) {
				return findIns.get();
			}
		}

		throw new PlanIdNotFoundException("Plan Does Not Exist with is id: " + planId);
	}

}
