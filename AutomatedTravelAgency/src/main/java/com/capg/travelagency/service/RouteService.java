package com.capg.travelagency.service;

import com.capg.travelagency.dto.Route;
import com.capg.travelagency.exceptions.InvalidRouteDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public interface RouteService {
	public Route viewRouteById(int routeID) throws InvalidRouteDataException;
	public Route addRoute(Route addedRoute) throws InvalidRouteDataException,InvalidVehicleDataException;
	public Route deleteRoute(int routeId) throws InvalidRouteDataException;
	public Route modifyRoute(Route modifiedRoute) 
			throws InvalidRouteDataException, InvalidVehicleDataException;
}
