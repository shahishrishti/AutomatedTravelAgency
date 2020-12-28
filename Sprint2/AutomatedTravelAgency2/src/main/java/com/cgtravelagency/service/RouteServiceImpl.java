package com.cgtravelagency.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.entity.RouteEntity;
import com.cgtravelagency.exception.InvalidRouteDataException;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.repo.RouteRepo;
import com.cgtravelagency.util.RouteUtil;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepo routeRepo;
	private Logger logger = LogManager.getLogger(VehicleServiceImpl.class.getName());
	

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
	
	//-------------------------------------------------Update Route----------------------------------------------//
		@Override
		public Route updateRoute(Long routeid, Route route) throws InvalidRouteDataException {
			logger.info("Update Route from service");
			Optional<RouteEntity> opRouteEntity = routeRepo.findById(routeid);
			if(opRouteEntity.isPresent()) {
				RouteEntity routeEntity = opRouteEntity.get();
				routeEntity.setSource(route.getSource());
				routeEntity.setDestination(route.getDestination());
				routeEntity.setDistance(route.getDistance());
				routeEntity = routeRepo.save(routeEntity);
				return RouteUtil.convertRouteEntityIntoRoute(routeEntity);
			} else {
				logger.error("RouteId not found");
				throw new InvalidRouteDataException("RouteId not found");
			}
		}

		//-----------------------------------------------Delete Route----------------------------//

		@Override
		public Route deleteRoute(Long routeid) throws InvalidRouteDataException {
			logger.info("Delete Route from service");
			Optional<RouteEntity> opRouteEntity = routeRepo.findById(routeid);
			if(opRouteEntity.isPresent()) {
				RouteEntity routeEntity = opRouteEntity.get();
				routeRepo.deleteById(routeid);
				return RouteUtil.convertRouteEntityIntoRoute(routeEntity);
			} else {
				logger.error("RouteId not found");
				throw new InvalidRouteDataException("RouteId not found");
			}
		}

}
