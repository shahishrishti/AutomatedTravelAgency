package com.cgtravelagency.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.entity.DriverEntity;
import com.cgtravelagency.exception.InvalidDriverDataException;
import com.cgtravelagency.json.Driver;

import com.cgtravelagency.repo.DriverRepo;

import com.cgtravelagency.util.DriverUtil;


@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverRepo driverRepo;

//---------------Add new driver------------------
	@Override
	public Driver createNewDriver(Driver driver) throws InvalidDriverDataException {
		DriverEntity driverEntity = driverRepo.save(DriverUtil.convertDriverIntoDriverEntity(driver));
		return DriverUtil.convertDriverEntityIntoDriver(driverEntity);
	}
	
	
//----------------view all drivers------------------	
	@Override
	public List<Driver> getAllDrivers()throws InvalidDriverDataException {
		return DriverUtil.convertDriverEntityListIntoDriverList(driverRepo.findAll());
	}

//----------------view driver by driver name--------------------	
	@Override
	public List<Driver> getDriverByName(String drivername) throws InvalidDriverDataException{
		return DriverUtil.convertDriverEntityListIntoDriverList(driverRepo.findByDriverName(drivername));
	}



//-----------------------view driver by license number------------------------
	@Override
	public List<Driver> getDriverByLicenseNo(String licenseNo)throws InvalidDriverDataException {
		return DriverUtil.convertDriverEntityListIntoDriverList(driverRepo.findByLicenseNo(licenseNo));
	}
	
	}


	
		
	
	
	
	

	