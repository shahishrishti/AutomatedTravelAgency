package com.cgtravelagency.service;

import com.cgtravelagency.exception.InvalidVehicleDataException;
import com.cgtravelagency.json.Vehicle;

public interface VehicleService {

	public Vehicle updateVehicle(String vehicleNo, Vehicle vehicle) throws InvalidVehicleDataException;
	public boolean deleteVehicle(String vehicleNo) throws InvalidVehicleDataException;
} 
