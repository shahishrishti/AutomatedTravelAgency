package com.cgtravelagency.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgtravelagency.entity.VehicleTypeEntity;

public interface VehicleTypeRepo extends JpaRepository<VehicleTypeEntity, Long> {
	
}
