package com.cgtravelagency.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgtravelagency.entity.RouteEntity;

public interface RouteRepo extends JpaRepository<RouteEntity, Long>{

	@Query("Select concat(route.source, ' - ', route.destination) from RouteEntity route")
	public List<String> getAllSourceAndDestination();
}
