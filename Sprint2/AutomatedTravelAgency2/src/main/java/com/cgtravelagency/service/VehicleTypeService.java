package com.cgtravelagency.service;

import java.util.List;

import com.cgtravelagency.json.VehicleType;

public interface VehicleTypeService {

	public VehicleType createVehicleType(VehicleType vehicleType);
	public List<VehicleType> getAllVehicleTypes();
	public VehicleType updateVehicleType(VehicleType vehicleType, Long typeId);
	public boolean deleteById(Long typeid);
	public List<String> getAllVehicleTypeNames();
}
