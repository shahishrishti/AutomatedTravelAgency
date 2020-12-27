package com.cgtravelagency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.repo.RouteRepo;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepo routeRepo;
	
	@Override
	public List<String> getAllSourceAndDestination() {
		return routeRepo.getAllSourceAndDestination();
	}

}
