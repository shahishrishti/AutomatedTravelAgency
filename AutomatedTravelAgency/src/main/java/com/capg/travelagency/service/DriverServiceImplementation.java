package com.capg.travelagency.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dao.DriverDAO;
import com.capg.travelagency.dao.DriverDAOImpl;
import com.capg.travelagency.dto.Driver;
import com.capg.travelagency.entity.DriverEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.utils.DriverUtils;

public class DriverServiceImplementation implements DriverService{
	private static Logger logger = LogManager.getLogger(DriverServiceImplementation.class.getName());
	DriverDAO driverDao = new DriverDAOImpl();
	
	public Driver addDriver(Driver addedDriver) throws InvalidDriverDataException {
		DriverEntity driverEntity = driverDao.addDriver(addedDriver);
		logger.info("DriverEntity: " + driverEntity);
		return DriverUtils.convertDriverEntityIntoDriver(driverEntity);
	}
	
	public Driver viewDriverById(int driverId) throws InvalidDriverDataException {
		DriverEntity driverEntity = driverDao.viewDriverById(driverId);
		logger.info("DriverEntity: " + driverEntity);
		return DriverUtils.convertDriverEntityIntoDriver(driverEntity);
	}

	public Driver deleteDriver(int driverId) throws InvalidDriverDataException {
		DriverEntity driverEntity = driverDao.deleteDriver(driverId);
		logger.info("deleteEntity: " + driverEntity);
		return DriverUtils.convertDriverEntityIntoDriver(driverEntity);		
	}
	
	public Driver modifyDriver(Driver modifiedDriver) 
	 throws  InvalidDriverDataException {
		DriverEntity driverEntity = driverDao.modifyDriver(modifiedDriver);
		logger.info("driverEntity: " + driverEntity);
		return DriverUtils.convertDriverEntityIntoDriver(driverEntity);
	}
}
