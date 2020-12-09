package com.capg.travelagency.service;

import com.capg.travelagency.dto.Driver;
import com.capg.travelagency.exceptions.InvalidDriverDataException;

public interface DriverService {

	public Driver addDriver(Driver addedDriver) throws InvalidDriverDataException;
	public Driver viewDriverById(int driverId) throws InvalidDriverDataException;
	public Driver deleteDriver(int driverId) throws InvalidDriverDataException;
	public Driver modifyDriver(Driver modifiedDriver) throws InvalidDriverDataException;
}
