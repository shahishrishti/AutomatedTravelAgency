package com.cgtravelagency.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgtravelagency.entity.VehicleEntity;

public interface VehicleRepo extends JpaRepository<VehicleEntity, String> {

	public List<VehicleEntity> findByVehicleName(String vehicleName);

	public List<VehicleEntity> findByFare(double fare);

	@Query("Select v.vehicleName from VehicleEntity v")
	public List<String> getAllVehicleNames();
	
	@Query("Select v.vehicleNo from VehicleEntity v")
	public List<String> getAllVehicleNos();
	
}
