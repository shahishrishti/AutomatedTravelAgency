package com.capg.travelagency.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dto.Vehicle;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;
import com.capg.travelagency.service.VehicleService;
import com.capg.travelagency.service.VehicleServiceImplementation;

public class VehicleController {

	private static Logger logger = LogManager.getLogger(VehicleController.class.getName());
	VehicleService vehicleService = new VehicleServiceImplementation();
	
	public Vehicle deleteVehicle(int vehicleNo) throws InvalidVehicleDataException {
		logger.info("vehicleNo: " + vehicleNo);
		Vehicle vehicle = null;
		try {
			vehicle = vehicleService.deleteVehicle(vehicleNo);
		}
		catch(InvalidVehicleDataException invalidVehicleDataException) {
			logger.error("InvalidVehicleDataException: " + invalidVehicleDataException);
			throw new InvalidVehicleDataException(invalidVehicleDataException.getMessage());
		}
		return vehicle;
	}
	
	public Vehicle modifyVehicle(int vehicleNo, String vehicleName, String vehicleType, double farePerKm, int seatingCapacity, int driverId) throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("vehicleNo: " + vehicleNo);
		Vehicle vehicle = null;
		try {
			vehicle = vehicleService.modifyVehicle(vehicleNo, vehicleName, vehicleType, farePerKm, seatingCapacity, driverId);
		} catch(InvalidVehicleDataException invalidVehicleDataException) {
			logger.error("InvalidVehicleDataException: " + invalidVehicleDataException);
			throw new InvalidVehicleDataException(invalidVehicleDataException.getMessage());
		}
		return vehicle;
	}
	
	public Vehicle  addVehicle(String vehicleName, String vehicleType, double farePerKm, int seatingCapacity, int driverId) throws InvalidVehicleDataException, InvalidDriverDataException
	{
		logger.info("Adding vehicle");
		Vehicle vehicle = null;
		try {
			vehicle = vehicleService.addVehicle(vehicleName, vehicleType, farePerKm, seatingCapacity, driverId);
		}
		catch(InvalidVehicleDataException invalidVehicleDataException) {
			logger.error("InvalidVehicleDataException: " + invalidVehicleDataException);
			throw new InvalidVehicleDataException(invalidVehicleDataException.getMessage());
		}
		return vehicle;
	}
	
	public Vehicle  viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException
	{
		logger.info("Finding vehicle for no. : " + vehicleNo);
		Vehicle vehicle = null;
		try {
			vehicle = vehicleService.viewVehicleByNo(vehicleNo);
		}
		catch(InvalidVehicleDataException invalidVehicleDataException) {
			logger.error("InvalidVehicleDataException: " + invalidVehicleDataException);
			throw new InvalidVehicleDataException(invalidVehicleDataException.getMessage());
		}
		return vehicle;
	}
}
