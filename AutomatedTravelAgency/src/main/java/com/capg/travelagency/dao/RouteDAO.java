package com.capg.travelagency.dao;

import com.capg.travelagency.dto.Route;
import com.capg.travelagency.entity.RouteEntity;
import com.capg.travelagency.exceptions.InvalidRouteDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public interface RouteDAO {
	public RouteEntity viewRouteByID(int routeID) throws InvalidRouteDataException;
	public RouteEntity addRoute(Route addedRoute)  throws InvalidRouteDataException, InvalidVehicleDataException;
	public RouteEntity deleteRoute(int routeId) throws InvalidRouteDataException;
	public RouteEntity modifyRoute(Route modifiedRoute)	throws InvalidRouteDataException, InvalidVehicleDataException;
}
