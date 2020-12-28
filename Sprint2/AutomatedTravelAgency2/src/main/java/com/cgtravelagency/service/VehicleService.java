package com.cgtravelagency.service;

import java.util.List;

import javax.validation.Valid;

import com.cgtravelagency.exception.InvalidVehicleDataException;
import com.cgtravelagency.exception.VehicleNotFoundException;
import com.cgtravelagency.json.Vehicle;

public interface VehicleService {

	public Vehicle updateVehicle(String vehicleNo, Vehicle vehicle) throws VehicleNotFoundException;
	
	public Vehicle deleteVehicle(String vehicleNo) throws VehicleNotFoundException;
	
	public List<Vehicle> getAllVehicles();

	public List<Vehicle> getVehicleByName(String vehicleName) throws VehicleNotFoundException;

	public Vehicle getVehicleByNo(String vehicleNo) throws VehicleNotFoundException;

	public List<Vehicle> getVehicleByFare(double fare) throws VehicleNotFoundException;
	
	public Vehicle createNewVehicle(@Valid Vehicle vehicle) throws InvalidVehicleDataException;
	
	public List<String> getAllVehicleNames();
	
	public List<String> getAllVehicleNos();
	
} 
