package com.capg.travelagency.dao;

import com.capg.travelagency.entity.DriverEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;

public interface DriverDAO {
	public DriverEntity addDriver(int driverId,String name,String address,long contactNo,String licenseNo) throws InvalidDriverDataException;
	public DriverEntity viewDriverById(int driverId) throws InvalidDriverDataException;
	public DriverEntity deleteDriver(int driverId) throws InvalidDriverDataException;
}
