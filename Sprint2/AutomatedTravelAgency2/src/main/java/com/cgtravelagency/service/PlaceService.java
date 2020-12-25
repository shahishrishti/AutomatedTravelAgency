package com.cgtravelagency.service;

import java.util.List;

import com.cgtravelagency.json.Place;

public interface PlaceService {
	
	public Place createPlace(Place place);
	public List<Place> getAllPlaces();
	public Place updatePlace(Place place, Long placeId);
	public boolean deleteById(Long placeId);
	
}
