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
	private static VehicleEntity vehicleEntity = null;
	private static DriverEntity newDriverEntity = null;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TravelAgencyPU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
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

	public VehicleEntity modifyVehicle(int vehicleNo, String vehicleName, String vehicleType, double farePerKm, int seatingCapacity,
			int driverId) throws InvalidVehicleDataException, InvalidDriverDataException {
		entityManager.getTransaction().begin();
		if(vehicleName == null || vehicleType == null || farePerKm <= 0 || seatingCapacity <=0 ) {
			entityManager.getTransaction().commit();
			throw new InvalidVehicleDataException("Either the field is null or less than 0");
		} else if(vehicleType.equalsIgnoreCase("Car") && seatingCapacity >= 5) {
			entityManager.getTransaction().commit();
			throw new InvalidVehicleDataException("SeatingCapacity of car should be in the range 1 to 4.");
		} else if(vehicleType.equalsIgnoreCase("Bus") && seatingCapacity >= 21) {
			entityManager.getTransaction().commit();
			throw new InvalidVehicleDataException("SeatingCapacity of bus should be in the range 1 to 20.");
		} else {
			vehicleEntity = entityManager.find(VehicleEntity.class, vehicleNo);
			newDriverEntity = entityManager.find(DriverEntity.class, driverId);
			if(vehicleEntity == null) {
				entityManager.getTransaction().commit();
				throw new InvalidVehicleDataException("Invalid Vehicle No.: " + vehicleNo);
			} else if(newDriverEntity == null) {
				entityManager.getTransaction().commit();
				throw new InvalidDriverDataException("Invalid Driver ID: " + driverId);
			} else {
				vehicleEntity.setVehicleName(vehicleName);
				vehicleEntity.setVehicleType(vehicleType);
				vehicleEntity.setFarePerKm(farePerKm);
				vehicleEntity.setSeatingCapacity(seatingCapacity);
				vehicleEntity.setDriverEntity(newDriverEntity);
			}
			entityManager.getTransaction().commit();
			logger.info("Updated vehicleEntity: " + vehicleEntity);
		}
		return vehicleEntity;
	}
	
	public VehicleEntity viewVehicleByNo(int vehicleNo) throws InvalidVehicleDataException {
		vehicleEntity = entityManager.find(VehicleEntity.class, vehicleNo);
		logger.info("Database returned VehicleEntity: " + vehicleEntity);
		if(vehicleEntity==null)
			throw new InvalidVehicleDataException("vehicleNo: " + vehicleNo);
		return vehicleEntity;
	}
	
	public VehicleEntity addVehicle(String vehicleName, String vehicleType, double farePerKm,int seatingCapacity,
			 int driverId) throws InvalidVehicleDataException, InvalidDriverDataException {
		entityManager.getTransaction().begin();
		DriverEntity newDriverEntity = entityManager.find(DriverEntity.class, driverId);
		if(newDriverEntity == null) {
			throw new InvalidVehicleDataException("Invalid Driver ID: " + driverId);
		} else {
			vehicleEntity = new VehicleEntity(vehicleName, vehicleType, farePerKm, seatingCapacity, newDriverEntity);
			entityManager.persist(vehicleEntity);
		}
		entityManager.getTransaction().commit();
		return vehicleEntity;
	}
	
}
