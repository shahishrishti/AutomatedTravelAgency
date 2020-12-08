package com.capg.travelagency.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dto.Driver;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.service.DriverService;
import com.capg.travelagency.service.DriverServiceImplementation;

public class DriverController {
	private static Logger logger = LogManager.getLogger(DriverController.class.getName());
	DriverService driverService = new DriverServiceImplementation();
	
	public Driver addDriver(int driverId,String name,String address,long contactNo,String licenseNo) throws InvalidDriverDataException {
		logger.info("Adding driver with id: " + driverId);
		Driver driver = null;
		try {
			driver = driverService.addDriver(driverId,name,address,contactNo,licenseNo);
		}
		catch(InvalidDriverDataException invalidDriverDataException) {
			logger.error("InvalidDriverDataException: " + invalidDriverDataException);
			throw new InvalidDriverDataException(invalidDriverDataException.getMessage());
		}
		return driver;
	}

	
	
	public Driver viewDriverById(int  driverId) throws InvalidDriverDataException {
		logger.info("Finding driver with id " + driverId);
		Driver driver = null;
		try {
			driver = driverService.viewDriverById(driverId);
		}
		catch(InvalidDriverDataException invalidDriverDataException ) {
			logger.error("InvalidDriverDataException: " + invalidDriverDataException);
			throw new InvalidDriverDataException(invalidDriverDataException.getMessage());
		}
		return driver;
	}
	
	public Driver deleteDriver(int driverId) throws InvalidDriverDataException {
		logger.info("driverId: " + driverId);
		Driver driver = null;
		try {
			driver = driverService.deleteDriver(driverId);
		}
		catch(InvalidDriverDataException invalidDriverDataException) {
			logger.error("InvalidDriverDataException: " + invalidDriverDataException);
			throw new InvalidDriverDataException(invalidDriverDataException.getMessage());
		}
		return driver;
	}
}
