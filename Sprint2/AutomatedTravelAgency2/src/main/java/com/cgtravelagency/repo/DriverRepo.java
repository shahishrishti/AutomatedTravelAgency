package com.cgtravelagency.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgtravelagency.entity.DriverEntity;

public interface DriverRepo extends JpaRepository<DriverEntity, Long> {

}
