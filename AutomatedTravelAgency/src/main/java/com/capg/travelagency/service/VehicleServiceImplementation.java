package com.capg.travelagency.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dao.VehicleDAO;
import com.capg.travelagency.dao.VehicleDAOImpl;
import com.capg.travelagency.dto.Vehicle;
import com.capg.travelagency.entity.VehicleEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;
import com.capg.travelagency.utils.VehicleUtils;

public class VehicleServiceImplementation implements VehicleService {

	private static Logger logger = LogManager.getLogger(VehicleServiceImplementation.class.getName());
	VehicleDAO vehicleDao = new VehicleDAOImpl();
	
	public Vehicle deleteVehicle(int vehicleNo) throws InvalidVehicleDataException {
		VehicleEntity vehicleEntity = vehicleDao.deleteVehicle(vehicleNo);
		logger.info("vehicleEntity: " + vehicleEntity);
		return VehicleUtils.convertVehicleEntityIntoVehicle(vehicleEntity);		
	}

	public Vehicle modifyVehicle(int vehicleNo, String vehicleName, String vehicleType, double farePerKm,
			int seatingCapacity, int driverId) throws InvalidVehicleDataException, InvalidDriverDataException {
		VehicleEntity vehicleEntity = vehicleDao.modifyVehicle(vehicleNo, vehicleName, vehicleType, farePerKm, seatingCapacity, driverId);
		logger.info("vehicleEntity: " + vehicleEntity);
		return VehicleUtils.convertVehicleEntityIntoVehicle(vehicleEntity);
	}
	
	public Vehicle viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException {
		VehicleEntity vehicleEntity = vehicleDao.viewVehicleByNo(vehicleNo);
		logger.info("VehicleEntity: " + vehicleEntity);
		return VehicleUtils.convertVehicleEntityIntoVehicle(vehicleEntity);
	}

	public Vehicle addVehicle(String vehicleName, String vehicleType, double farePerKm, int seatingCapacity, int driverId) throws InvalidVehicleDataException, InvalidDriverDataException {
		VehicleEntity vehicleEntity = vehicleDao.addVehicle(vehicleName, vehicleType, farePerKm, seatingCapacity, driverId);
		logger.info("VehicleEntity: " + vehicleEntity);
		return VehicleUtils.convertVehicleEntityIntoVehicle(vehicleEntity);		
	}

}
