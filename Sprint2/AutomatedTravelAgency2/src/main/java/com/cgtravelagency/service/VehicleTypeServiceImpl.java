package com.cgtravelagency.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.entity.VehicleTypeEntity;
import com.cgtravelagency.json.VehicleType;
import com.cgtravelagency.repo.VehicleTypeRepo;
import com.cgtravelagency.util.VehicleTypeUtil;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService{

	@Autowired
	private VehicleTypeRepo vehicleTypeRepo;
	
	@Override
	public VehicleType createVehicleType(VehicleType vehicleType) {
		VehicleTypeEntity vehicleTypeEntity = vehicleTypeRepo.save(VehicleTypeUtil.convertVehicleTypeIntoVehicleTypeEntity(vehicleType));
		return VehicleTypeUtil.convertVehicleTypeEntityIntoVehicleType(vehicleTypeEntity);
	}

	@Override
	public List<VehicleType> getAllVehicleTypes() {
		return VehicleTypeUtil.convertVehicleTypeEntityListIntoVehicleTypeList(vehicleTypeRepo.findAll());
	}

	@Override
	public VehicleType updateVehicleType(VehicleType vehicleType, Long typeId) {
		Optional<VehicleTypeEntity> vehicleTypeEntityOp = vehicleTypeRepo.findById(typeId);
		if(vehicleTypeEntityOp.isPresent()) {
			VehicleTypeEntity vehicleTypeEntity = vehicleTypeEntityOp.get();
			vehicleTypeEntity.setTypeName(vehicleType.getTypeName());
			vehicleTypeEntity.setSeatingCapacity(vehicleType.getSeatingCapacity());
			vehicleTypeEntity = vehicleTypeRepo.save(vehicleTypeEntity);
			return VehicleTypeUtil.convertVehicleTypeEntityIntoVehicleType(vehicleTypeEntity);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteById(Long typeid) {
		vehicleTypeRepo.deleteById(typeid);
		return true;
	}

	@Override
	public List<String> getAllVehicleTypeNames() {
		return vehicleTypeRepo.getAllVehicleTypeNames();
	}

}
