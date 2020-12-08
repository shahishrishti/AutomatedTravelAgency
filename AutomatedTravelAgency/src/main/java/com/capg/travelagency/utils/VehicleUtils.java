package com.capg.travelagency.utils;

import com.capg.travelagency.dto.Vehicle;
import com.capg.travelagency.entity.VehicleEntity;


public class VehicleUtils {

	public static Vehicle convertVehicleEntityIntoVehicle(VehicleEntity vehicleEntity) {
		return new Vehicle(vehicleEntity.getVehicleNo(), vehicleEntity.getVehicleName(), 
				vehicleEntity.getVehicleType(), vehicleEntity.getFarePerKm(), vehicleEntity.getSeatingCapacity(), 
				vehicleEntity.getDriverEntity().getDriverId());
	}
}
