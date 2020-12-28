package com.cgtravelagency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.entity.RouteEntity;
import com.cgtravelagency.entity.VehicleEntity;
import com.cgtravelagency.exception.InvalidRouteDataException;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.repo.RouteRepo;
import com.cgtravelagency.util.RouteUtil;
import com.cgtravelagency.util.VehicleUtil;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepo routeRepo;
	
	

	@Override
	public Route createNewRoute(Route route) {
		RouteEntity routeEntity = routeRepo.save(RouteUtil.convertRouteIntoRouteEntity(route));
		return RouteUtil.convertRouteEntityIntoRoute(routeEntity);
	}

	
	@Override
	public List<Route> getRouteBySource(String source) throws InvalidRouteDataException {
		
			return RouteUtil.convertRouteEntityListIntoRouteList(routeRepo.findBySource(source));	
	}

	@Override
	public List<Route> getRouteByDestination(String destination) {
		return RouteUtil.convertRouteEntityListIntoRouteList(routeRepo.findByDestination(destination));	
	}

	@Override
	public List<Route> getRouteByDistance(double distance) {
		return RouteUtil.convertRouteEntityListIntoRouteList(routeRepo.findByDistance(distance));	
	}

	@Override
	public List<Route> getRouteBySourceAndDestination(String source, String destination) {
		return RouteUtil.convertRouteEntityListIntoRouteList(routeRepo.findBySourceAndDestination(source, destination));	
	}


	@Override
	public List<Route> getAllRoutes() {
		// TODO Auto-generated method stub
		return RouteUtil.convertRouteEntityListIntoRouteList(routeRepo.findAll());
	}

}
