package com.cgtravelagency.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
			throw new InvalidVehicleDataException("Vehicle No not found");
		}
	}

	@Override
	public Vehicle deleteVehicle(String vehicleNo) throws InvalidVehicleDataException {
		Optional<VehicleEntity> opVehicleEntity = vehicleRepo.findById(vehicleNo);
		if(opVehicleEntity.isPresent()) {
			VehicleEntity vehicleEntity = opVehicleEntity.get();
			vehicleRepo.deleteById(vehicleNo);
			return VehicleUtil.convertVehicleEntityIntoVehicle(vehicleEntity);
		} else {
			throw new InvalidVehicleDataException("Vehicle No not found");
		}
	}
	//---------------------------------Add New Vehicle----------------------------------------
	@Override
	public Vehicle createNewVehicle(Vehicle vehicle) {
		VehicleEntity vehicleEntity = vehicleRepo.save(VehicleUtil.convertVehicleIntoVehicleEntity(vehicle));
		return VehicleUtil.convertVehicleEntityIntoVehicle(vehicleEntity);
	}
	//--------------------------------View All Vehicles---------------------------------------
	@Override
	public List<Vehicle> getAllVehicles() {
		return VehicleUtil.convertVehicleEntityListIntoVehicleList(vehicleRepo.findAll());
	}
	
	//-------------------------------View Vehicle By Vehicle Name------------------------------
    @Override
	public List<Vehicle> getVehicleByName(String vehicleName) throws VehicleNotFoundException {
		
			return VehicleUtil.convertVehicleEntityListIntoVehicleList(vehicleRepo.findByVehicleName(vehicleName));
	}
		
	
	//-------------------------------View Vehicle By Vehicle No-------------------------------

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

    //------------------------------View Vehicle By Fare----------------------------------------
	@Override
	public List<Vehicle> getVehicleByFare(double fare) throws VehicleNotFoundException {

		return VehicleUtil.convertVehicleEntityListIntoVehicleList(vehicleRepo.findByFare(fare));
	}
	
}
