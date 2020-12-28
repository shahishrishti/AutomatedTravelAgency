package com.cgtravelagency.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgtravelagency.exception.InvalidDriverDataException;
import com.cgtravelagency.json.Driver;
import com.cgtravelagency.service.DriverService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgata")
@Api(value="Driver related REST APIs")
public class DriverController {

	@Autowired
	private DriverService driverService;
	private Logger logger = LogManager.getLogger(DriverController.class.getName());
	
	@ApiOperation(value="Updates driver")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Driver created"),
			@ApiResponse(code=404, message="No such driver found")
	})
	@PutMapping(value="/driver/{driverId}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Driver updateDriver(@PathVariable Long driverId, @Valid @RequestBody Driver driver) throws InvalidDriverDataException{
			logger.info("Update Vehicle Called!!");
			return driverService.updatedriver(driverId, driver);
	}

	@ApiOperation(value="Delete Driver")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Driver created"),
			@ApiResponse(code=404, message="No such driver found")
	})
	@DeleteMapping(value="/driver/{driverId}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public Driver deleteDriver(@PathVariable Long driverId) throws InvalidDriverDataException {
		logger.info("Delete Driver Called!!");
		return driverService.deleteDriver(driverId);
	}   
}
