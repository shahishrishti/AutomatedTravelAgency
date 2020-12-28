package com.cgtravelagency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgtravelagency.service.RouteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgata")
@Api(value="Route related REST APIs")
public class RouteController {
	
	@Autowired
	private RouteService routeService;
	
	@ApiOperation(value="View all Routes")
	@GetMapping(value="/route/filter", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllSourceAndDestination() {
		return routeService.getAllSourceAndDestination();
	}
}
