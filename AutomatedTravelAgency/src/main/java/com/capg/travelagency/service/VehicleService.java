package com.capg.travelagency.service;

import com.capg.travelagency.dto.Vehicle;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public interface VehicleService {
	public Vehicle deleteVehicle(int vehicleNo) throws InvalidVehicleDataException;
	public Vehicle modifyVehicle(int vehicleNo, String vehicleName, String vehicleType, double farePerKm, int seatingCapacity, int driverId) 
			throws InvalidVehicleDataException, InvalidDriverDataException;
	public Vehicle viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException;
	public Vehicle addVehicle(String vehicleName, String vehicleType, double farePerKm, int seatingCapacity, int driverId) throws InvalidVehicleDataException, InvalidDriverDataException;

}
