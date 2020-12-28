package com.cgtravelagency.util;


import java.util.ArrayList;
import java.util.List;

import com.cgtravelagency.entity.DriverEntity;
import com.cgtravelagency.json.Driver;


public class DriverUtil {
	
	public static Driver convertDriverEntityIntoDriver(DriverEntity driverEntity) {
		return new Driver(driverEntity.getDriverId(), driverEntity.getDriverName(), driverEntity.getAddress(), driverEntity.getContact(), 
				driverEntity.getLicenseNo(), VehicleUtil.convertVehicleEntityIntoVehicle(driverEntity.getVehicle()));
	}

	public static DriverEntity convertDriverIntoDriverEntity(Driver driver) {
		return new DriverEntity(driver.getDriverId(), driver.getDriverName(), driver.getAddress(),
				driver.getLicenseNo(),driver.getContact(), VehicleUtil.convertVehicleIntoVehicleEntity(driver.getVehicle()));
	}

	public static List<Driver> convertDriverEntityListIntoDriverList(List<DriverEntity> driverEntityList) {
		List<Driver> drivers = new ArrayList<Driver>();
		for(DriverEntity driverEntity: driverEntityList) {
			drivers.add(convertDriverEntityIntoDriver(driverEntity));
		}
		return drivers;
	}  
	
}
