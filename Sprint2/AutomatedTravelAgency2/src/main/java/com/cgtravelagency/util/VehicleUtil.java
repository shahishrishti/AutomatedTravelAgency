package com.cgtravelagency.util;

import java.util.ArrayList;
import java.util.List;

import com.cgtravelagency.entity.RouteEntity;
import com.cgtravelagency.entity.VehicleEntity;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.json.Vehicle;

public class VehicleUtil {

	public static Vehicle convertVehicleEntityIntoVehicle(VehicleEntity vehicleEntity) {
		RouteEntity routeEntity = vehicleEntity.getRoute();
		Route route = new Route(routeEntity.getRouteId(),routeEntity.getSource(), routeEntity.getDestination(),routeEntity.getDistance());
		return new Vehicle(vehicleEntity.getVehicleNo(), vehicleEntity.getVehicleName(), vehicleEntity.getFare(), VehicleTypeUtil.convertVehicleTypeEntityIntoVehicleType(vehicleEntity.getVehicleType()), route);
	}

	public static VehicleEntity convertVehicleIntoVehicleEntity(Vehicle vehicle) {
		Route route = vehicle.getRoute();
		RouteEntity routeEntity = new RouteEntity(route.getRouteid(), route.getSource(), route.getDestination(), route.getDistance());
		return new VehicleEntity(vehicle.getVehicleNo(), vehicle.getVehicleName(), vehicle.getFare(), VehicleTypeUtil.convertVehicleTypeIntoVehicleTypeEntity(vehicle.getVehicleType()), routeEntity);
	}

	public static List<Vehicle> convertVehicleEntityListIntoVehicleList(List<VehicleEntity> vehicleEntityList) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		for(VehicleEntity vehicleEntity: vehicleEntityList) {
			vehicles.add(convertVehicleEntityIntoVehicle(vehicleEntity));
		}
		return vehicles;
	}
}
