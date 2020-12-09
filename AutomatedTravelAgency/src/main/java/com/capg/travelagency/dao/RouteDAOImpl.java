package com.capg.travelagency.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dto.Route;
import com.capg.travelagency.entity.RouteEntity;
import com.capg.travelagency.entity.VehicleEntity;
import com.capg.travelagency.exceptions.InvalidRouteDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public class RouteDAOImpl implements RouteDAO{
	
	private static Logger logger = LogManager.getLogger(RouteDAOImpl.class.getName());	
	private static EntityManager entityManager;

	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TravelAgencyPU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public RouteEntity viewRouteByID(int routeID) throws InvalidRouteDataException {
		entityManager.getTransaction().begin();
		RouteEntity routeEntity = entityManager.find(RouteEntity.class, routeID);
		logger.info("Database returned RouteEntity: " + routeEntity);
		if(routeEntity==null)
		{
			entityManager.getTransaction().commit();
			logger.error("Route entity was found null.");
			throw new InvalidRouteDataException("routeID: " + routeID);
		}
		else
		{
			logger.info("View route data from database");
			System.out.println("route data :"+routeEntity);
			entityManager.getTransaction().commit();
		}
		return routeEntity;
	}

	public RouteEntity addRoute(Route addedRoute) throws InvalidRouteDataException, InvalidVehicleDataException
	{
		entityManager.getTransaction().begin();
		VehicleEntity newVehicleEntity = entityManager.find(VehicleEntity.class, addedRoute.getVehicleNo());
		RouteEntity routeEntity = null;
		if(newVehicleEntity == null)
		{
			entityManager.getTransaction().commit();
			throw new InvalidVehicleDataException("Invalid vehicle No: " +addedRoute.getVehicleNo());
		}
		else {
		routeEntity =new RouteEntity(addedRoute.getSource(), addedRoute.getDestination(), addedRoute.getDistance(),addedRoute.getDuration(), newVehicleEntity);;
		entityManager.persist(routeEntity );
		entityManager.getTransaction().commit();
		}
		return routeEntity;
	}
	public RouteEntity deleteRoute(int routeId) throws InvalidRouteDataException {
		entityManager.getTransaction().begin();
		RouteEntity routeEntity = entityManager.find(RouteEntity.class, routeId);
		logger.info("Database returned routeEntity: " + routeEntity);
		if(routeEntity==null) {
			entityManager.getTransaction().commit();
			logger.error("Route entity was found null");
			throw new InvalidRouteDataException("RouteId: " + routeId + " was not found.");
		}
		else {
			logger.info("Delete route data from database");
			entityManager.remove(routeEntity);
		}
		entityManager.getTransaction().commit();
		return routeEntity;
	}

	public RouteEntity modifyRoute(Route modifiedRoute) throws InvalidVehicleDataException, InvalidRouteDataException 
	{
		entityManager.getTransaction().begin();
		RouteEntity routeEntity = entityManager.find(RouteEntity.class, modifiedRoute.getRouteId());
		
		if(routeEntity == null) {
			entityManager.getTransaction().commit();
			throw new InvalidRouteDataException("Invalid RouteId: " + modifiedRoute.getRouteId());
		} else {
			routeEntity.setSource(modifiedRoute.getSource());
			routeEntity.setDestination(modifiedRoute.getDestination());
			routeEntity.setDistance(modifiedRoute.getDistance());
			routeEntity.setDuration(modifiedRoute.getDuration());

			entityManager.getTransaction().commit();
			
			logger.info("Updated RouteEntity: " + routeEntity);
		}
		return routeEntity;
	}

}
