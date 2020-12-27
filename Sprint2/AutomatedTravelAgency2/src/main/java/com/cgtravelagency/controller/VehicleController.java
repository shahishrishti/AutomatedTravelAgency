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

import com.cgtravelagency.exception.InvalidVehicleDataException;
import com.cgtravelagency.json.Vehicle;
import com.cgtravelagency.service.VehicleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgata")
@Api(value="Vehicle related REST APIs")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	private Logger logger = LogManager.getLogger(VehicleController.class.getName());
	
	@ApiOperation(value="Updates Vehicle")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New vehicleType created"),
			@ApiResponse(code=404, message="No such vehicleType found")
	})
	@PutMapping(value = "/vehicle/{vehicleNo}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Vehicle updateVehicle(@PathVariable String vehicleNo, @Valid @RequestBody Vehicle vehicle) throws InvalidVehicleDataException {
		try {
			logger.info("Update Vehicle Called!!");
			return vehicleService.updateVehicle(vehicleNo, vehicle);
		} catch(InvalidVehicleDataException invalidVehicleDataException) {
			logger.error(invalidVehicleDataException.getLocalizedMessage());
			return null;
		}
	}
	
	@ApiOperation(value="Delete Vehicle")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New vehicleType created"),
			@ApiResponse(code=404, message="No such vehicleType found")
	})
	@DeleteMapping(value = "/vehicle/{vehicleNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteVehicle(@PathVariable String vehicleNo) throws InvalidVehicleDataException {
		logger.info("Delete Vehicle Called!!");
		return vehicleService.deleteVehicle(vehicleNo);
	}
}
