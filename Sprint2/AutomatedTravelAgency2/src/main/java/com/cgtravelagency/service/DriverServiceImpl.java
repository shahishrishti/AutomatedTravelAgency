package com.cgtravelagency.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.entity.DriverEntity;
import com.cgtravelagency.exception.InvalidDriverDataException;
import com.cgtravelagency.json.Driver;
import com.cgtravelagency.repo.DriverRepo;
import com.cgtravelagency.util.DriverUtil;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepo driverRepo;
	
	@Override
	public List<Driver> getAllDrivers() throws InvalidDriverDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver createNewDriver(Driver driver) throws InvalidDriverDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> getDriverByName(String drivername) throws InvalidDriverDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> getDriverByVehicleNo(String vehicleNo) throws InvalidDriverDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> getDriverByLicenseNo(String licenseNo) throws InvalidDriverDataException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Driver updatedriver(Long driverId, Driver driver) throws InvalidDriverDataException{
		Optional<DriverEntity> opdriverEntity = driverRepo.findById(driverId);
		if(opdriverEntity.isPresent()) {
			DriverEntity driverEntity = opdriverEntity.get();
			driverEntity.setDriverName(driver.getDriverName());
			driverEntity.setAddress(driver.getAddress());
			driverEntity.setContact(driver.getContact());
			driverEntity.setLicenseNo(driver.getLicenseNo());
		    driverEntity = driverRepo.save(driverEntity);
			return DriverUtil.convertDriverEntityIntoDriver(driverEntity);
		} else {
			return null;
		}
	}

	@Override
	public Driver deleteDriver(Long driverId) throws InvalidDriverDataException {
		Optional<DriverEntity> opDriverEntity = driverRepo.findById(driverId);
		if(opDriverEntity.isPresent()) {
			DriverEntity driverEntity = opDriverEntity.get();
			driverRepo.deleteById(driverId);
			return DriverUtil.convertDriverEntityIntoDriver(driverEntity);
		} else {
			throw new InvalidDriverDataException("Driver not found");
		}
	}
}
