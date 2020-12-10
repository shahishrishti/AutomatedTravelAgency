package com.capg.travelagency.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dto.Vehicle;
import com.capg.travelagency.entity.DriverEntity;
import com.capg.travelagency.entity.VehicleEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;


public class VehicleDAOImpl implements VehicleDAO {

	private static Logger logger = LogManager.getLogger(VehicleDAOImpl.class.getName());	
	private static EntityManager entityManager;
	private static VehicleEntity vehicleEntity = null;
	private static DriverEntity newDriverEntity = null;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TravelAgencyPU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public VehicleEntity addVehicle(Vehicle addedVehicle) throws InvalidVehicleDataException, InvalidDriverDataException {
		   entityManager.getTransaction().begin();
		    DriverEntity newDriverEntity = entityManager.find(DriverEntity.class, addedVehicle.getDriverId());
		     VehicleEntity vehicleEntity = null;
		     if(newDriverEntity == null) {
		    	 entityManager.getTransaction().commit();
			     throw new InvalidDriverDataException("Invalid Driver ID: " + addedVehicle.getDriverId());
		      } 
		      else {
			   vehicleEntity = new VehicleEntity(addedVehicle.getVehicleName(), addedVehicle.getVehicleType(), addedVehicle.getFarePerKm(), addedVehicle.getSeatingCapacity(), newDriverEntity );
			entityManager.persist(vehicleEntity);
		       }
		    entityManager.getTransaction().commit();
		
		   return vehicleEntity;
	}
	
	public VehicleEntity viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException {
		entityManager.getTransaction().begin();
		VehicleEntity vehicleEntity = entityManager.find(VehicleEntity.class, vehicleNo);
		logger.info("Database returned VehicleEntity: " + vehicleEntity);
		if(vehicleEntity==null)
		{
			logger.error("Vehicle entity was found null");
			entityManager.getTransaction().commit();
			throw new InvalidVehicleDataException("vehicleNo: " + vehicleNo);
		}
		else
		{
			logger.info("View vehicle data from database");
			System.out.println("vehicle data :"+vehicleEntity);
		}
		entityManager.getTransaction().commit();
		return vehicleEntity;
	}

	//Delete Vehicle
	public VehicleEntity deleteVehicle(int vehicleNo) throws InvalidVehicleDataException {
		entityManager.getTransaction().begin();
		vehicleEntity = entityManager.find(VehicleEntity.class, vehicleNo);
		logger.info("Database returned vehicleEntity: " + vehicleEntity);
		if(vehicleEntity==null) {
			logger.error("Vehicle entity was found null");
			entityManager.getTransaction().commit();
			throw new InvalidVehicleDataException("VehicleNo: " + vehicleNo + " was not found.");
		}
		else {
			logger.info("Delete vehicle data from database");
			entityManager.remove(vehicleEntity);
		}
		entityManager.getTransaction().commit();
		return vehicleEntity;
	}

	//Modify Vehicle
	public VehicleEntity modifyVehicle(Vehicle modifiedVehicle) throws InvalidVehicleDataException, InvalidDriverDataException {
		entityManager.getTransaction().begin();
		vehicleEntity = entityManager.find(VehicleEntity.class, modifiedVehicle.getVehicleNo());
		newDriverEntity = entityManager.find(DriverEntity.class, modifiedVehicle.getDriverId());
		if(vehicleEntity == null) {
			entityManager.getTransaction().commit();
			throw new InvalidVehicleDataException("Invalid Vehicle No.: " + modifiedVehicle.getVehicleNo());
		} else if(newDriverEntity == null) {
			entityManager.getTransaction().commit();
			throw new InvalidDriverDataException("Invalid Driver ID: " + modifiedVehicle.getDriverId());
		} else {
			vehicleEntity.setVehicleName(modifiedVehicle.getVehicleName());
			vehicleEntity.setVehicleType(modifiedVehicle.getVehicleType());
			vehicleEntity.setFarePerKm(modifiedVehicle.getFarePerKm());
			vehicleEntity.setSeatingCapacity(modifiedVehicle.getSeatingCapacity());
			vehicleEntity.setDriverEntity(newDriverEntity);
			entityManager.getTransaction().commit();
			logger.info("Updated vehicleEntity: " + vehicleEntity);
		}
		return vehicleEntity;
	}	
}
