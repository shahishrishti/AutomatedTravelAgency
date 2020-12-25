package com.cgtravelagency.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgtravelagency.entity.VehicleEntity;

public interface VehicleRepo extends JpaRepository<VehicleEntity, String> {

}
