package com.cgtravelagency.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.entity.VehicleEntity;
import com.cgtravelagency.exception.VehicleNotFoundException;
import com.cgtravelagency.json.Vehicle;
import com.cgtravelagency.repo.VehicleRepo;
import com.cgtravelagency.util.VehicleTypeUtil;
import com.cgtravelagency.util.VehicleUtil;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepo vehicleRepo;
	private Logger logger = LogManager.getLogger(VehicleServiceImpl.class.getName());
	//------------------------------Update Vehicle---------------------------------------------------------
	
	@Override
	public Vehicle updateVehicle(String vehicleNo, Vehicle vehicle) throws VehicleNotFoundException {
		logger.info("Update Vehicle from service");
		Optional<VehicleEntity> opVehicleEntity = vehicleRepo.findById(vehicleNo);
		if(opVehicleEntity.isPresent()) {
			VehicleEntity vehicleEntity = opVehicleEntity.get();
			vehicleEntity.setVehicleName(vehicle.getVehicleName());
			vehicleEntity.setFare(vehicle.getFare());
			vehicleEntity.setVehicleType(VehicleTypeUtil.convertVehicleTypeIntoVehicleTypeEntity(vehicle.getVehicleType()));
			vehicleEntity = vehicleRepo.save(vehicleEntity);
			return VehicleUtil.convertVehicleEntityIntoVehicle(vehicleEntity);
		} else {
			logger.error("Vehicle No Not Found");
			throw new VehicleNotFoundException("Vehicle No not found");
		}
	}

	//-----------------------------Delete Vehicle------------------------------------------------------
	@Override
	public Vehicle deleteVehicle(String vehicleNo) throws VehicleNotFoundException {
		logger.info("Delete Vehicle from service");
		Optional<VehicleEntity> opVehicleEntity = vehicleRepo.findById(vehicleNo);
		if(opVehicleEntity.isPresent()) {
			VehicleEntity vehicleEntity = opVehicleEntity.get();
			vehicleRepo.deleteById(vehicleNo);
			return VehicleUtil.convertVehicleEntityIntoVehicle(vehicleEntity);
		} else {
			logger.error("Vehicle No not found");
			throw new VehicleNotFoundException("Vehicle No not found");
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

	//---------------------------------View All Vehicle Names--------------------------------------
	@Override
	public List<String> getAllVehicleNames() {
		return vehicleRepo.getAllVehicleNames();
	}

	//--------------------------------View All Vehicle No-----------------------------------------
	@Override
	public List<String> getAllVehicleNos() {
		return vehicleRepo.getAllVehicleNos();
	}
	
}
