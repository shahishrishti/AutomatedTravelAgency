package com.capg.travelagency.service;

import com.capg.travelagency.dto.Driver;
import com.capg.travelagency.exceptions.InvalidDriverDataException;

public interface DriverService {
	public Driver addDriver(int driverId,String name,String address,long contactNo,String licenseNo) throws InvalidDriverDataException;
	public Driver viewDriverById(int driverId) throws InvalidDriverDataException;
	public Driver deleteDriver(int driverId) throws InvalidDriverDataException;
}
