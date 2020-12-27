package com.cgtravelagency.service;

import java.util.List;

import com.cgtravelagency.exception.InvalidRouteDataException;
import com.cgtravelagency.json.Route;

public interface RouteService {
	
	public List<String> getAllSourceAndDestination();
	public Route createRoute(Route route) throws InvalidRouteDataException;
	public List<Route> getAllRoute();
	public List<Route> getRouteBySource(String source);
	public List<Route> getRouteByDestination(String destination) ;
	public List<Route> getRouteByDistance(double distance) ;
	public List<Route> getRouteBySourceAndDestination(String source,String destination) ;
}
