package com.cgi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.exception.DriverNotFoundException;
import com.cgi.exception.DuplicateDriverIdException;
import com.cgi.model.Driver;
import com.cgi.service.DriverService;

@RestController
//@RequestMapping("driver")
public class DriverController {
	
	@Autowired
	DriverService service;
	
	//Add Driver
	@PostMapping("driver/add")
	public ResponseEntity<?> addDriver(@RequestBody Driver driver) throws DuplicateDriverIdException, DriverNotFoundException {
		
		try {
		Driver findDriver = service.getAllDriverDetailsById(driver.getDriverId());
		
		if(findDriver == null) {
			
			Driver newDriver = service.addDriver(driver);
			
			return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
		}
		} catch (DuplicateDriverIdException e) {
			throw new DuplicateDriverIdException(e.toString());
		}
		return new ResponseEntity<>(DuplicateDriverIdException.class, HttpStatus.CONFLICT);
		
	}
	
	//Get All Driver Details By Driver Id
	@GetMapping("driver/{driverId}")
	public ResponseEntity<?> getDriverDetailsById(@PathVariable("driverId") int driverId) throws DriverNotFoundException {
		
		Driver getDriver = service.getAllDriverDetailsById(driverId);
		
		if(getDriver != null) {
			return new ResponseEntity<>(getDriver, HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>(DriverNotFoundException.class, HttpStatus.NOT_FOUND);
		
	}
	
	
	//Delete Driver By Id
	@DeleteMapping("driver/{driverId}")
	public ResponseEntity<?> deletDriverById(@PathVariable("driverId") int driverId) throws DriverNotFoundException {
		
		Driver getDriver = service.getAllDriverDetailsById(driverId);
		
		if(getDriver != null) {
			service.deleteDriverByDriverId(driverId);
			return new ResponseEntity<>("Driver Deleted", HttpStatus.OK);
		}
		
		return new ResponseEntity<>(DriverNotFoundException.class, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
