package com.cgtravelagency.util;

import java.util.ArrayList;
import java.util.List;

import com.cgtravelagency.entity.PlaceEntity;
import com.cgtravelagency.json.Place;

public class PlaceUtil {

	public static Place convertPlaceEntityIntoPlace(PlaceEntity placeEntity) {
		return new Place(placeEntity.getPlaceId(), placeEntity.getPlaceName());
	}

	public static PlaceEntity convertPlaceIntoPlaceEntity(Place place) {
		return new PlaceEntity(place.getPlaceId(), place.getPlaceName());
	}

	public static List<Place> convertPlaceEntityListIntoPlaceList(List<PlaceEntity> placeEntityList) {
		List<Place> places = new ArrayList<Place>();
		for(PlaceEntity placeEntity: placeEntityList) {
			places.add(convertPlaceEntityIntoPlace(placeEntity));
		}
		return places;
	}
}
