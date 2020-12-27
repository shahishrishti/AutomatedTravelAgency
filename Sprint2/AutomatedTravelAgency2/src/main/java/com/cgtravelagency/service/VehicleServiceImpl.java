package com.cgtravelagency.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.entity.VehicleEntity;
import com.cgtravelagency.exception.InvalidVehicleDataException;
import com.cgtravelagency.exception.VehicleNotFoundException;
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
	
	@Override
	public List<Vehicle> getAllVehicles() {
		return VehicleUtil.convertVehicleEntityListIntoVehicleList(vehicleRepo.findAll());
	}


	@Override
	public List<Vehicle> getVehicleByName(String vehicleName) throws VehicleNotFoundException {
		
			return VehicleUtil.convertVehicleEntityListIntoVehicleList(vehicleRepo.findByVehicleName(vehicleName));
	}
		
	
	

	@Override
	public Vehicle getVehicleByNo(String vehicleNo) throws VehicleNotFoundException {
		Optional<VehicleEntity> opVehicleEntity = vehicleRepo.findById(vehicleNo);
		if(opVehicleEntity.isPresent()) {
			VehicleEntity vehicleEntity = opVehicleEntity.get();
			
			return VehicleUtil.convertVehicleEntityIntoVehicle(vehicleEntity);
		}
		else {
			throw new VehicleNotFoundException("vehicleNo: " +vehicleNo);
		}
	}


	@Override
	public List<Vehicle> getVehicleByFare(double fare) throws VehicleNotFoundException {

		return VehicleUtil.convertVehicleEntityListIntoVehicleList(vehicleRepo.findByFare(fare));
	}

}
