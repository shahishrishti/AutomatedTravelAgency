package com.capg.travelagency.utils;

import com.capg.travelagency.dto.Driver;
import com.capg.travelagency.entity.DriverEntity;

public class DriverUtils {
	public static DriverEntity convertDriverIntoDriverEntity(Driver driver) {
		return new DriverEntity(driver.getDriverId(), driver.getName(), driver.getAddress(),driver.getContactNo(),driver.getLicenseNo());
	}
	public static Driver convertDriverEntityIntoDriver(DriverEntity driverEntity) {
		return new Driver(driverEntity.getDriverId(), driverEntity.getName(), driverEntity.getAddress(),driverEntity.getContactNo(),driverEntity.getLicenseNo());
	}
}
