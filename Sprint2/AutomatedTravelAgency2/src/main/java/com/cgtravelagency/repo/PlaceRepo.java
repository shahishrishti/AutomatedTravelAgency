package com.cgtravelagency.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgtravelagency.entity.PlaceEntity;

public interface PlaceRepo extends JpaRepository<PlaceEntity, Long> {

}
