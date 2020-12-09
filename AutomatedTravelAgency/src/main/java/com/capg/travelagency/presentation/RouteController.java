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
}
