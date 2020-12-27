package com.cgtravelagency.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.entity.VehicleEntity;
import com.cgtravelagency.exception.InvalidVehicleDataException;
import com.cgtravelagency.json.Vehicle;
import com.cgtravelagency.repo.VehicleRepo;
import com.cgtravelagency.util.VehicleTypeUtil;
import com.cgtravelagency.util.VehicleUtil;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepo vehicleRepo;
	
	@Override
	public Vehicle updateVehicle(String vehicleNo, Vehicle vehicle) throws InvalidVehicleDataException {
		Optional<VehicleEntity> opVehicleEntity = vehicleRepo.findById(vehicleNo);
		if(opVehicleEntity.isPresent()) {
			VehicleEntity vehicleEntity = opVehicleEntity.get();
			vehicleEntity.setVehicleName(vehicle.getVehicleName());
			vehicleEntity.setFare(vehicle.getFare());
			vehicleEntity.setVehicleType(VehicleTypeUtil.convertVehicleTypeIntoVehicleTypeEntity(vehicle.getVehicleType()));
			vehicleEntity = vehicleRepo.save(vehicleEntity);
			return VehicleUtil.convertVehicleEntityIntoVehicle(vehicleEntity);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteVehicle(String vehicleNo) throws InvalidVehicleDataException {
		vehicleRepo.deleteById(vehicleNo);
		return true;
	}
	
}
