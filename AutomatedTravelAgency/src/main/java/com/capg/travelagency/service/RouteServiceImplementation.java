package com.capg.travelagency.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dao.RouteDAO;
import com.capg.travelagency.dao.RouteDAOImpl;
import com.capg.travelagency.dto.Route;
import com.capg.travelagency.entity.RouteEntity;
import com.capg.travelagency.exceptions.InvalidRouteDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;
import com.capg.travelagency.utils.RouteUtils;

public class RouteServiceImplementation implements RouteService {
	private static Logger logger = LogManager.getLogger(RouteServiceImplementation.class.getName());
	RouteDAO routeDao = new RouteDAOImpl();

	public Route viewRouteById(int routeID) throws InvalidRouteDataException {
		RouteEntity routeEntity = routeDao.viewRouteByID(routeID);
		logger.info("RouteEntity: " + routeEntity);
		return RouteUtils.convertRouteEntityIntoRoute(routeEntity);
	}

	public Route addRoute(Route addedRoute) throws InvalidRouteDataException, InvalidVehicleDataException {
		RouteEntity routeEntity = routeDao.addRoute(addedRoute);
		logger.info("RouteEntity: " + routeEntity);
		return RouteUtils.convertRouteEntityIntoRoute(routeEntity);		
	}

	public Route deleteRoute(int routeId) throws InvalidRouteDataException {
		RouteEntity routeEntity = routeDao.deleteRoute(routeId);
		logger.info("routeEntity: " + routeEntity);
		return RouteUtils.convertRouteEntityIntoRoute(routeEntity);		
	}

	public Route modifyRoute(Route modifiedRoute) throws InvalidRouteDataException, InvalidVehicleDataException {
		RouteEntity routeEntity = routeDao.modifyRoute(modifiedRoute);
		logger.info("routeEntity: " + routeEntity);
		return RouteUtils.convertRouteEntityIntoRoute(routeEntity);
	}

}
