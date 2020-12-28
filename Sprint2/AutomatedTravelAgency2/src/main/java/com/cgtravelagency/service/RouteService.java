package com.cgtravelagency.service;

import java.util.List;

import javax.validation.Valid;

import com.cgtravelagency.exception.InvalidRouteDataException;
import com.cgtravelagency.json.Route;


public interface RouteService {

	
	public List<Route> getRouteBySource(String source) throws InvalidRouteDataException;
	public List<Route> getRouteByDestination(String destination) ;
	public List<Route> getRouteByDistance(double distance) ;
	public List<Route> getRouteBySourceAndDestination(String source,String destination) ;
	
	public Route createNewRoute(@Valid Route route);
	public List<Route> getAllRoutes();
	
	public Route updateRoute(Long routeId, Route route) throws InvalidRouteDataException;
	public Route deleteRoute(Long routeid) throws InvalidRouteDataException;
}
