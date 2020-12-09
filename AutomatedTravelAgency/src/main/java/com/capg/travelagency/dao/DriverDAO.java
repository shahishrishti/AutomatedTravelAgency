package com.capg.travelagency.dao;

import com.capg.travelagency.dto.Driver;
import com.capg.travelagency.entity.DriverEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;

public interface DriverDAO {
	public DriverEntity addDriver(Driver addedDriver) throws InvalidDriverDataException;
	public DriverEntity viewDriverById(int driverId) throws InvalidDriverDataException;
	public DriverEntity deleteDriver(int driverId) throws InvalidDriverDataException;
	public DriverEntity modifyDriver(Driver modifiedDriver) throws InvalidDriverDataException;
}
