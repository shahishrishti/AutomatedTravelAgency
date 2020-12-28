package com.cgtravelagency.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.entity.PlaceEntity;
import com.cgtravelagency.json.Place;
import com.cgtravelagency.repo.PlaceRepo;
import com.cgtravelagency.util.PlaceUtil;

@Service
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	private PlaceRepo placeRepo;
	
	@Override
	public Place createPlace(Place place) {
		PlaceEntity placeEntity = placeRepo.save(PlaceUtil.convertPlaceIntoPlaceEntity(place));
		return PlaceUtil.convertPlaceEntityIntoPlace(placeEntity);
	}

	@Override
	public List<Place> getAllPlaces() {
		return PlaceUtil.convertPlaceEntityListIntoPlaceList(placeRepo.findAll());
	}

	@Override
	public Place updatePlace(Long placeId, Place place) {
		Optional<PlaceEntity> placeEntityOp = placeRepo.findById(placeId);
		if(placeEntityOp.isPresent()) {
			PlaceEntity placeEntity = placeEntityOp.get();
			placeEntity.setPlaceName(place.getPlaceName());
			placeEntity = placeRepo.save(placeEntity);
			return PlaceUtil.convertPlaceEntityIntoPlace(placeEntity);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteById(Long placeId) {
		placeRepo.deleteById(placeId);
		return true;
	}

	@Override
	public List<String> getAllPlaceNames() {
		return placeRepo.getAllPlaceNames();
	}

}
