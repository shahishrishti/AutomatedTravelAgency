package com.cgtravelagency.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgtravelagency.entity.VehicleEntity;
import com.cgtravelagency.entity.VehicleTypeEntity;

public interface VehicleRepo extends JpaRepository<VehicleEntity, String> {

	public List<VehicleEntity> findByVehicleName(String vehicleName);

	public List<VehicleEntity> findByFare(double fare);

	//public List<VehicleTypeEntity> findBySeatingCapacity(int seatingCapacity);
	
	
}
