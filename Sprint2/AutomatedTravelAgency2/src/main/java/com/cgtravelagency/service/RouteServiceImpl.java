package com.cgtravelagency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.exception.InvalidRouteDataException;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.repo.RouteRepo;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepo routeRepo;
	
	@Override
	public List<String> getAllSourceAndDestination() {
		return routeRepo.getAllSourceAndDestination();
	}

	@Override
	public Route createRoute(Route route) throws InvalidRouteDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> getAllRoute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> getRouteBySource(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> getRouteByDestination(String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> getRouteByDistance(double distance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> getRouteBySourceAndDestination(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
