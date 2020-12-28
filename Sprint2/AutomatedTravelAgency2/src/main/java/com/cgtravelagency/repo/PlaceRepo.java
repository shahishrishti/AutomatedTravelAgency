package com.cgtravelagency.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgtravelagency.entity.PlaceEntity;

public interface PlaceRepo extends JpaRepository<PlaceEntity, Long> {

	@Query("Select p.placeName from PlaceEntity p")
	public List<String> getAllPlaceNames();
}
