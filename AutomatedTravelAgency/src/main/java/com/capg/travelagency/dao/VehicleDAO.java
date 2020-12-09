package com.capg.travelagency.dao;

import com.capg.travelagency.dto.Vehicle;
import com.capg.travelagency.entity.VehicleEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public interface VehicleDAO {
	
	public VehicleEntity addVehicle(Vehicle addedVehicle) throws InvalidVehicleDataException, InvalidDriverDataException;
	public VehicleEntity viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException;
	public VehicleEntity deleteVehicle(int vehicleNo) throws InvalidVehicleDataException;
	public VehicleEntity modifyVehicle(Vehicle modifiedVehicle) throws InvalidVehicleDataException, InvalidDriverDataException;
	
}
