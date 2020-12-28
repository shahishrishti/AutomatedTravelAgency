package com.cgtravelagency.util;

import java.util.ArrayList;
import java.util.List;

import com.cgtravelagency.entity.DriverEntity;
import com.cgtravelagency.json.Driver;

import com.cgtravelagency.entity.VehicleEntity;
import com.cgtravelagency.json.Vehicle;   


public class DriverUtil {
	
	


	public static Driver convertDriverEntityIntoDriver(DriverEntity driverEntity) {
		VehicleEntity vehicleEntity = driverEntity.getVehicle();
		Vehicle vehicle = new Vehicle(vehicleEntity.getVehicleName(), vehicleEntity.getFare(), VehicleTypeUtil.convertVehicleTypeEntityIntoVehicleType(vehicleEntity.getVehicleType()));
		return new Driver(driverEntity.getDriverId(), driverEntity.getDriverName(), driverEntity.getAddress(), driverEntity.getContact(), driverEntity.getLicenseNo(), vehicle);
	}

	public static DriverEntity convertDriverIntoDriverEntity(Driver driver) {
		Vehicle vehicle = driver.getVehicle();
		VehicleEntity vehicleEntity = new VehicleEntity(vehicle.getVehicleName(), vehicle.getFare(),  VehicleTypeUtil.convertVehicleTypeIntoVehicleTypeEntity(vehicle.getVehicleType()));
		return new DriverEntity(driver.getDriverId(), driver.getDriverName(), driver.getAddress(), driver.getLicenseNo(),driver.getContact(), vehicleEntity);
	}

	public static List<Driver> convertDriverEntityListIntoDriverList(List<DriverEntity> driverEntityList) {
		List<Driver> drivers = new ArrayList<Driver>();
		for(DriverEntity driverEntity: driverEntityList) {
			drivers.add(convertDriverEntityIntoDriver(driverEntity));
		}
		return drivers;
	}  
}
