package com.cgtravelagency.util;

import java.util.ArrayList;
import java.util.List;

import com.cgtravelagency.entity.RouteEntity;
import com.cgtravelagency.entity.VehicleEntity;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.json.Vehicle;



public class RouteUtil {
	public static List<Route> convertRouteEntityListIntoRouteList(List<RouteEntity> routeEntityList) {
		List<Route> routes = new ArrayList<Route>();
		for(RouteEntity routeEntity: routeEntityList) {
			routes.add(convertRouteEntityIntoRoute(routeEntity));
		}
		return routes;
	}
	public static Route convertRouteEntityIntoRoute(RouteEntity routeEntity) {
		return new Route(routeEntity.getRouteId(),routeEntity.getSource(), routeEntity.getDestination(), routeEntity.getDistance());
	}
	
	public static RouteEntity convertRouteIntoRouteEntity(Route route) {
		return new RouteEntity(route.getRouteid(), route.getSource(), route.getDestination(), route.getDistance());
	}


}
