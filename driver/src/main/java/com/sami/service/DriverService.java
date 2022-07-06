package com.cgi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.exception.DriverNotFoundException;
import com.cgi.exception.DuplicateDriverIdException;
import com.cgi.model.Driver;
import com.cgi.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository repo;

	// Add Drivers
	public Driver addDriver(Driver driver) throws DuplicateDriverIdException {

		//try {
		Optional<Driver> findDriver = repo.findById(driver.getDriverId());

			if (findDriver.isEmpty()) {
				return repo.save(driver);
			}
		//} //catch (NoSuchElementException e) {
			//throw new DuplicateDriverIdException(e.toString());
		//}
		throw new DuplicateDriverIdException("Driver Already Exists with id: " + driver.getDriverId());

	}

	// Get all Driver details
	public Driver getAllDriverDetailsById(int driverId) throws DriverNotFoundException {

		Optional<Driver> findDriver = repo.findById(driverId);

		if (findDriver.isPresent()) {
			return findDriver.get();
		}

		throw new DriverNotFoundException("Driver Not Found with id: " + driverId);

	}
	
	//Delete Driver by driverId
	public String deleteDriverByDriverId(int driverId) throws DriverNotFoundException {
		
		Optional<Driver> findDriver = repo.findById(driverId);
		
		if(findDriver.isPresent()) {
			repo.deleteById(driverId);
			return "Driver Successfully Deleted";
		}
		
		throw new DriverNotFoundException("Driver Not Found with id: " + driverId);
		
	}

}












