package com.capg.travelagency.dao;

import com.capg.travelagency.entity.VehicleEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public interface VehicleDAO {
	public VehicleEntity deleteVehicle(int vehicleNo) throws InvalidVehicleDataException;
	public VehicleEntity modifyVehicle(int vehicleNo, String vehicleName, String vehicleType, double farePerKm, int seatingCapacity, int driverId) 
			throws InvalidVehicleDataException, InvalidDriverDataException;
	public VehicleEntity viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException;
	public VehicleEntity addVehicle(String vehicleName, String vehicleType, double farePerKm, int seatingCapacity, int driverId) 
			throws InvalidVehicleDataException, InvalidDriverDataException;
}
