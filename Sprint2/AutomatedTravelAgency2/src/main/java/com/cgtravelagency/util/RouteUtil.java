package com.cgtravelagency.util;

import java.util.ArrayList;
import java.util.List;

import com.cgtravelagency.entity.RouteEntity;
import com.cgtravelagency.json.Route;

public class RouteUtil {
	public static Route convertRouteEntityIntoRoute(RouteEntity routeEntity) {
		return  new Route(routeEntity.getRouteId(),routeEntity.getSource(),routeEntity.getDestination(),routeEntity.getDistance());
				}

	public static RouteEntity convertRouteIntoRouteEntity(Route route) {
		return new RouteEntity(route.getRouteid(),route.getSource(), route.getDestination(), route.getDistance());
	}
	
	public static List<Route> convertRouteEntityListIntoRouteList(List<RouteEntity> routeEntityList) {
		List<Route> route = new ArrayList<Route>();
		for(RouteEntity routeEntity: routeEntityList) {
			route.add(convertRouteEntityIntoRoute(routeEntity));
		}
		return route;
	}
}
