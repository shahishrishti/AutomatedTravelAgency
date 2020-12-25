package com.cgtravelagency.util;

import java.util.ArrayList;
import java.util.List;

import com.cgtravelagency.entity.VehicleTypeEntity;
import com.cgtravelagency.json.VehicleType;

public class VehicleTypeUtil {
	
	public static VehicleType convertVehicleTypeEntityIntoVehicleType(VehicleTypeEntity vehicleTypeEntity) {
		return new VehicleType(vehicleTypeEntity.getTypeId(), vehicleTypeEntity.getTypeName(), vehicleTypeEntity.getSeatingCapacity());
	}

	public static VehicleTypeEntity convertVehicleTypeIntoVehicleTypeEntity(VehicleType vehicleType) {
		return new VehicleTypeEntity(vehicleType.getTypeId(), vehicleType.getTypeName(), vehicleType.getSeatingCapacity());
	}

	public static List<VehicleType> convertVehicleTypeEntityListIntoVehicleTypeList(List<VehicleTypeEntity> vehicleTypeEntityList) {
		List<VehicleType> vehicleTypes = new ArrayList<VehicleType>();
		for(VehicleTypeEntity vehicleTypeEntity: vehicleTypeEntityList) {
			vehicleTypes.add(convertVehicleTypeEntityIntoVehicleType(vehicleTypeEntity));
		}
		return vehicleTypes;
	}
}
