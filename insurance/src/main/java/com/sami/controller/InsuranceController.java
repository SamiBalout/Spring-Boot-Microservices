package com.cgi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.exception.InsuranceAlreadyExistException;
import com.cgi.exception.InsuranceDoesNotExistException;
import com.cgi.exception.PlanIdNotFoundException;
import com.cgi.model.Insurance;
import com.cgi.service.InsuranceService;

@RestController
@RequestMapping("insurance")
public class InsuranceController {

	@Autowired
	InsuranceService service;

	// Add Insurance
	@PostMapping("/addInsurance")
	public ResponseEntity<?> addInsurance(@RequestBody Insurance insurance) throws InsuranceDoesNotExistException, InsuranceAlreadyExistException {

		try {
		Insurance findIns = service.getAllInsuranceDetailsById(insurance.getInsuranceId());

		if (findIns == null) {
			Insurance newInsurance = service.addInsuranceDetails(insurance);
			return new ResponseEntity<>(newInsurance, HttpStatus.CREATED);
		}

		} catch (InsuranceAlreadyExistException e) {
			throw new InsuranceAlreadyExistException(e.toString());
		}
		return new ResponseEntity<>(InsuranceAlreadyExistException.class, HttpStatus.CONFLICT);

	}

	@GetMapping("/{insuranceId}")
	public ResponseEntity<?> getAllInsuranceDetailsById(@PathVariable("insuranceId") int insuranceId)
			throws InsuranceDoesNotExistException {

		Insurance findIns = service.getAllInsuranceDetailsById(insuranceId);

		if (findIns != null) {
			return new ResponseEntity<>(findIns, HttpStatus.FOUND);
		}

		return new ResponseEntity<>(InsuranceDoesNotExistException.class, HttpStatus.NOT_FOUND);

	}

	@GetMapping("/{insuranceId}/{planId}")
	public ResponseEntity<?> getInsuranceDetailsByInsuranceIdAndPlanId(@PathVariable("insuranceId") int insuranceId,
			@PathVariable("planId") int planId) throws PlanIdNotFoundException {

		Insurance getInsByPlanId = service.getInsuranceDetailsByInsuranceIdAndPlanId(insuranceId, planId);

		if (getInsByPlanId != null) {
			return new ResponseEntity<>(getInsByPlanId, HttpStatus.FOUND);
		}

		return new ResponseEntity<>(PlanIdNotFoundException.class, HttpStatus.NOT_FOUND);

	}

}
