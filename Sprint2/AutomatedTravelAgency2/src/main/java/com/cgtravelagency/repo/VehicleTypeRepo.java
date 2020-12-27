package com.cgtravelagency.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgtravelagency.entity.VehicleTypeEntity;

public interface VehicleTypeRepo extends JpaRepository<VehicleTypeEntity, Long> {
	
	@Query("Select vt.typeName from VehicleTypeEntity vt")
	public List<String> getAllVehicleTypeNames();
	
}
