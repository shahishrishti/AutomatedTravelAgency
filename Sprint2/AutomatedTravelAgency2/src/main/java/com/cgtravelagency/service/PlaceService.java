package com.cgtravelagency.service;

import java.util.List;

import com.cgtravelagency.json.Place;

public interface PlaceService {
	
	public Place createPlace(Place place);
	public List<Place> getAllPlaces();
	public Place updatePlace(Long placeId, Place place);
	public boolean deleteById(Long placeId);
	public List<String> getAllPlaceNames();
	
}
