package com.capg.travelagency.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dto.Driver;
import com.capg.travelagency.entity.DriverEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;

public class DriverDAOImpl implements DriverDAO{

	private static Logger logger = LogManager.getLogger(DriverDAOImpl.class.getName());	
	private static EntityManager entityManager;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TravelAgencyPU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public DriverEntity viewDriverById(int driverId) throws InvalidDriverDataException {
		DriverEntity driverEntity=entityManager.find(DriverEntity.class,driverId);
		logger.info("Database returned DriverEntity: " + driverEntity);
		if(driverEntity==null)
			throw new InvalidDriverDataException("DriverId: " + driverId);
		return driverEntity;
	}
		
		public DriverEntity addDriver(Driver addedDriver) throws InvalidDriverDataException{
			entityManager.getTransaction().begin();
			DriverEntity driverEntity = new DriverEntity(addedDriver.getName(), addedDriver.getAddress(), addedDriver.getContactNo(), addedDriver.getLicenseNo());
			entityManager.persist(driverEntity);
			entityManager.getTransaction().commit();
			return driverEntity;			
		}

		public DriverEntity modifyDriver(Driver modifiedDriver) throws  InvalidDriverDataException {
			entityManager.getTransaction().begin();
			DriverEntity driverEntity = entityManager.find(DriverEntity.class, modifiedDriver.getDriverId());
			
			if(driverEntity == null) {
				entityManager.getTransaction().commit();
					throw new InvalidDriverDataException("Invalid Driver ID: " + modifiedDriver.getDriverId());
					
				} else {
					driverEntity.setName(modifiedDriver.getName());
					driverEntity.setAddress(modifiedDriver.getAddress());
					driverEntity.setContactNo(modifiedDriver.getContactNo());
					driverEntity.setLicenseNo(modifiedDriver.getLicenseNo());
					
				entityManager.getTransaction().commit();
			
		   
			logger.info("Updated driverEntity: " + driverEntity);
				}
			return driverEntity;
		}
		
		
		public DriverEntity deleteDriver(int driverId) throws InvalidDriverDataException {
			entityManager.getTransaction().begin();
			DriverEntity driverEntity = entityManager.find(DriverEntity.class, driverId);
			logger.info("Database returned driverEntity: " + driverEntity);
			if(driverEntity==null) {
				entityManager.getTransaction().commit();
				logger.error("driver entity was found null");
				throw new InvalidDriverDataException("DriverId: " + driverId + " was not found.");
			}
			else {
				logger.info("Delete driver data from database");
				entityManager.remove(driverEntity);
			}
			entityManager.getTransaction().commit();
			return driverEntity;
		}
}
