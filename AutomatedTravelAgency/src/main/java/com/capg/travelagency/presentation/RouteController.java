package com.capg.travelagency.presentation;

import com.capg.travelagency.dto.Route;
import com.capg.travelagency.exceptions.InvalidRouteDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;
import com.capg.travelagency.service.RouteService;
import com.capg.travelagency.service.RouteServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RouteController {
	
	private static Logger logger = LogManager.getLogger(RouteController.class.getName());
	RouteService routeService = new RouteServiceImplementation();
	
	public Route addRoute(Route addedRoute) throws InvalidRouteDataException, InvalidVehicleDataException
    {
		logger.info("Adding route "+addedRoute);
		Route route = null;
	if(addedRoute.getSource() == null || addedRoute.getDestination() == null || addedRoute.getDistance() <=0  || addedRoute.getDuration()<=0)
	{
		throw new InvalidRouteDataException("Either source or destination feild is empty or feild is less than 0.");
	}
	else if(addedRoute.getSource() == addedRoute.getDestination())
	{
		throw new InvalidRouteDataException("Source and destination are same");
	}
	else {
	try {
		route = routeService.addRoute(addedRoute);
	}
	catch(InvalidRouteDataException invalidRouteDataException) {
		logger.error("InvalidRouteDataException: " + invalidRouteDataException);
		throw new InvalidRouteDataException(invalidRouteDataException.getMessage());
	}
	}
	return route;
}

public Route viewRouteById(int  routeID) throws InvalidRouteDataException {
	logger.info("Finding route with id " + routeID);
	Route route = null;
	try {
		route = routeService.viewRouteById(routeID);
	}
	catch(InvalidRouteDataException invalidRouteDataException ) {
		logger.error("InvalidRouteDataException: " + invalidRouteDataException);
		throw new InvalidRouteDataException(invalidRouteDataException.getMessage());
	}
	return route;
}
public Route deleteRoute(int routeId) throws InvalidRouteDataException {
	logger.info("routeId: " + routeId);
	Route route = null;
	try {
		route = routeService.deleteRoute(routeId);
	}
	catch(InvalidRouteDataException invalidRouteDataException) {
		logger.error("InvalidRouteDataException: " + invalidRouteDataException);
		throw new InvalidRouteDataException(invalidRouteDataException.getMessage());
	}
	return route;
}

public Route modifyRoute(Route modifiedRoute) throws InvalidRouteDataException, InvalidVehicleDataException {
	logger.info(""+modifiedRoute);
	Route route = null;
	if(modifiedRoute.getRouteId() <=0 || modifiedRoute.getSource() == null || modifiedRoute.getDestination() == null
			|| modifiedRoute.getDistance() <=0 || modifiedRoute.getDuration() <=0 || modifiedRoute.getVehicleNo() <= 0) {
		throw new InvalidRouteDataException("Either the field is null or less than 0");
	} else if(modifiedRoute.getSource().equalsIgnoreCase("Bhopal") && modifiedRoute.getDestination().equalsIgnoreCase("Bhopal")) {
		throw new InvalidVehicleDataException("Source and Destination cannot be same.");
	} else if(modifiedRoute.getDestination().equalsIgnoreCase("Indore") && modifiedRoute.getSource().equalsIgnoreCase("Indore")) {
		throw new InvalidVehicleDataException("Destination and Source cannot be same.");
	} else {
		try {
			route = routeService.modifyRoute(modifiedRoute);
		} catch(InvalidRouteDataException invalidRouteDataException) {
			logger.error("InvalidRouteDataException: " + invalidRouteDataException);
			throw new InvalidRouteDataException(invalidRouteDataException.getMessage());
		}
	}
	return route;
}
}
