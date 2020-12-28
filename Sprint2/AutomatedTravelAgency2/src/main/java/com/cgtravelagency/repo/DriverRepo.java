package com.cgtravelagency.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgtravelagency.entity.DriverEntity;


public interface DriverRepo extends JpaRepository<DriverEntity, Long> {

	public List<DriverEntity> findByDriverName(String drivername);

	
	public List<DriverEntity> findByLicenseNo(String licenseNo);

}