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
	
	public Driver addDriver(Driver addedDriver) throws InvalidDriverDataException {
		logger.info("Adding driver :");
		Driver responce = null;
		if(addedDriver.getName()==null || addedDriver.getAddress()==null || addedDriver.getContactNo()==0|| addedDriver.getLicenseNo()==null)
		{
			throw new InvalidDriverDataException( "The field is null  ");
		}
		try {
			responce = driverService.addDriver(addedDriver);
		}
		catch(InvalidDriverDataException invalidDriverDataException) {
			logger.error("InvalidDriverDataException: " + invalidDriverDataException);
			throw new InvalidDriverDataException(invalidDriverDataException.getMessage());
		}
		return responce;
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
	
	
	public Driver modifyDriver(Driver  modifiedDriver) throws InvalidDriverDataException  {
		logger.info(""  +modifiedDriver);
		Driver driver = null;
		if(modifiedDriver.getName() == null || modifiedDriver.getAddress() == null || modifiedDriver.getContactNo() == 0  || modifiedDriver.getLicenseNo() == null)
		{
			throw new InvalidDriverDataException("Field is null");
		}else{
		try {
			driver = driverService.modifyDriver(modifiedDriver);
		} catch(InvalidDriverDataException invalidDriverDataException) {
			logger.error("InvalidDriverDataException: " + invalidDriverDataException);
			throw new InvalidDriverDataException(invalidDriverDataException.getMessage());
		}
		}
		return driver;
	}
}
