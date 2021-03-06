package com.capg.travelagency.service;

import com.capg.travelagency.dto.Vehicle;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public interface VehicleService {
	
	public Vehicle viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException;
	public Vehicle addVehicle(Vehicle addedVehicle) throws InvalidVehicleDataException, InvalidDriverDataException;
	public Vehicle deleteVehicle(int vehicleNo) throws InvalidVehicleDataException;
	public Vehicle modifyVehicle(Vehicle modifiedVehicle) throws InvalidVehicleDataException, InvalidDriverDataException;
	
}
