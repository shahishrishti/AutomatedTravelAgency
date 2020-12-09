package com.capg.travelagency.utils;

import com.capg.travelagency.dto.Route;
import com.capg.travelagency.entity.RouteEntity;

public class RouteUtils {
	public static Route convertRouteEntityIntoRoute(RouteEntity routeEntity) {
		return new Route(routeEntity.getRouteId(), routeEntity.getSource(), 
				routeEntity.getDestination(), routeEntity.getDistance(), routeEntity.getDuration(), routeEntity.getVehicleEntity().getVehicleNo());
	}
}
