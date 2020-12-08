package com.capg.travelagency.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.entity.DriverEntity;
import com.capg.travelagency.entity.VehicleEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;


public class VehicleDAOImpl implements VehicleDAO {

	private static Logger logger = LogManager.getLogger(VehicleDAOImpl.class.getName());	
	private static EntityManager entityManager;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TravelAgencyPU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public VehicleEntity deleteVehicle(int vehicleNo) throws InvalidVehicleDataException {
		entityManager.getTransaction().begin();
		VehicleEntity vehicleEntity = entityManager.find(VehicleEntity.class, vehicleNo);
		logger.info("Database returned vehicleEntity: " + vehicleEntity);
		if(vehicleEntity==null) {
			logger.error("Vehicle entity was found null");
			throw new InvalidVehicleDataException("VehicleNo: " + vehicleNo + " was not found.");
		}
		else {
			logger.info("Delete vehicle data from database");
			entityManager.remove(vehicleEntity);
		}
		entityManager.getTransaction().commit();
		return vehicleEntity;
	}

	public VehicleEntity modifyVehicle(int vehicleNo, String vehicleName, String vehicleType, double farePerKm, int seatingCapacity,
			int driverId) throws InvalidVehicleDataException, InvalidDriverDataException {
		entityManager.getTransaction().begin();
		VehicleEntity vehicleEntity = entityManager.find(VehicleEntity.class, vehicleNo);
		if(vehicleEntity == null) {
			throw new InvalidVehicleDataException("Invalid Vehicle No.: " + vehicleNo);
		} else {
			DriverEntity newDriverEntity = entityManager.find(DriverEntity.class, driverId);
			if(newDriverEntity == null) {
				throw new InvalidDriverDataException("Invalid Driver ID: " + driverId);
			} else {
				vehicleEntity.setVehicleName(vehicleName);
				vehicleEntity.setVehicleType(vehicleType);
				vehicleEntity.setFarePerKm(farePerKm);
				vehicleEntity.setSeatingCapacity(seatingCapacity);
				vehicleEntity.setDriverEntity(newDriverEntity);
			}
		}
		entityManager.getTransaction().commit();
		logger.info("Updated vehicleEntity: " + vehicleEntity);
		return vehicleEntity;
	}
	
	public VehicleEntity viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException {
		VehicleEntity vehicleEntity = entityManager.find(VehicleEntity.class, vehicleNo);
		logger.info("Database returned VehicleEntity: " + vehicleEntity);
		if(vehicleEntity==null)
			throw new InvalidVehicleDataException("vehicleNo: " + vehicleNo);
		return vehicleEntity;
	}
	
	public VehicleEntity addVehicle(String vehicleName, String vehicleType, double farePerKm,int seatingCapacity,
			 int driverId) throws InvalidVehicleDataException, InvalidDriverDataException {
		VehicleEntity vehicleEntity = null;
		entityManager.getTransaction().begin();
		DriverEntity newDriverEntity = entityManager.find(DriverEntity.class, driverId);
		if(newDriverEntity == null) {
			throw new InvalidDriverDataException("Invalid Driver ID: " + driverId);
		} else {
			vehicleEntity = new VehicleEntity(vehicleName, vehicleType, farePerKm, seatingCapacity, newDriverEntity);
			entityManager.persist(vehicleEntity);
		}
		entityManager.getTransaction().commit();
		return vehicleEntity;
	}
	
}
