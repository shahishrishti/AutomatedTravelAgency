package com.capg.travelagency.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dto.Vehicle;
import com.capg.travelagency.entity.VehicleEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;
import com.capg.travelagency.service.VehicleService;
import com.capg.travelagency.service.VehicleServiceImplementation;

public class VehicleController {

	private static Logger logger = LogManager.getLogger(VehicleController.class.getName());
	VehicleService vehicleService = new VehicleServiceImplementation();
	
	public Vehicle  addVehicle(Vehicle addedVehicle) throws InvalidVehicleDataException, InvalidDriverDataException
	{
		logger.info("Adding vehicle"+addedVehicle);
		Vehicle vehicle = null;
		if(addedVehicle.getVehicleName() == null || addedVehicle.getVehicleType() == null || addedVehicle.getFarePerKm()<=0 ||
				addedVehicle.getSeatingCapacity()<=0) {
			throw new InvalidVehicleDataException("Either the field is null or less than or equal to zero.");
		}
		else if(addedVehicle.getVehicleType().equalsIgnoreCase("Car") && addedVehicle.getSeatingCapacity() >4)
		{
			throw new InvalidVehicleDataException("Seating capacity of car should be in the range of 1 to 4");
		}
		else if(addedVehicle.getVehicleType().equalsIgnoreCase("Bus") && addedVehicle.getSeatingCapacity()>=21)
		{
			throw new InvalidVehicleDataException("Seating capacity of bus should be in range of 1 to 20");
		}
		else {
		try {
			vehicle = vehicleService.addVehicle(addedVehicle);
		}
		catch(InvalidVehicleDataException invalidVehicleDataException) {
			logger.error("InvalidVehicleDataException: " + invalidVehicleDataException);
			throw new InvalidVehicleDataException(invalidVehicleDataException.getMessage());
		}
		}
		return vehicle;
	}
	
	public Vehicle  viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException
	{
		logger.info("Finding vehicle from no. : " + vehicleNo);
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
	
	public Vehicle modifyVehicle(Vehicle modifiedVehicle) throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info(""+modifiedVehicle);
		Vehicle vehicle = null;
		if(modifiedVehicle.getVehicleName() == null || modifiedVehicle.getVehicleType() == null || modifiedVehicle.getFarePerKm() <= 0 
				|| modifiedVehicle.getSeatingCapacity() <=0) {
			throw new InvalidVehicleDataException("Either the field is null or less than 0");
		} else if(modifiedVehicle.getVehicleType().equalsIgnoreCase("Car") && modifiedVehicle.getSeatingCapacity() >= 5) {
			throw new InvalidVehicleDataException("SeatingCapacity of car should be in the range 1 to 4.");
		} else if(modifiedVehicle.getVehicleType().equalsIgnoreCase("Bus") && modifiedVehicle.getSeatingCapacity() >= 21) {
			throw new InvalidVehicleDataException("SeatingCapacity of bus should be in the range 1 to 20.");
		} else {
			try {
				vehicle = vehicleService.modifyVehicle(modifiedVehicle);
			} catch(InvalidVehicleDataException invalidVehicleDataException) {
				logger.error("InvalidVehicleDataException: " + invalidVehicleDataException);
				throw new InvalidVehicleDataException(invalidVehicleDataException.getMessage());
			}
		}
		return vehicle;
	}
}
