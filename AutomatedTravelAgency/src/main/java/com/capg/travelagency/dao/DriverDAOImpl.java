package com.capg.travelagency.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.capg.travelagency.entity.DriverEntity;
import com.capg.travelagency.exceptions.InvalidDriverDataException;

public class DriverDAOImpl implements DriverDAO{

	private static Logger logger = LogManager.getLogger(DriverDAOImpl.class.getName());	
	private static EntityManager entityManager;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AutomatedTravelAgency");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public DriverEntity viewDriverById(int driverId) throws InvalidDriverDataException {
		DriverEntity driverEntity=entityManager.find(DriverEntity.class,driverId);
		logger.info("Database returned DriverEntity: " + driverEntity);
		if(driverEntity==null)
			throw new InvalidDriverDataException("ItemId: " + driverId);
		return driverEntity;
	}
		
		public DriverEntity addDriver(int driverId,String name,String address,long contactNo,String licenseNo) throws InvalidDriverDataException{
			DriverEntity driverEntity=new DriverEntity( driverId,name, address,  contactNo, licenseNo);
			entityManager.persist(driverEntity);
			return driverEntity;
		}

		public DriverEntity deleteDriver(int driverId) throws InvalidDriverDataException {
			entityManager.getTransaction().begin();
			DriverEntity driverEntity = entityManager.find(DriverEntity.class, driverId);
			logger.info("Database returned driverEntity: " + driverEntity);
			if(driverEntity==null) {
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
