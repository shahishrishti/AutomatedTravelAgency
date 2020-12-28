package com.cgtravelagency.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgtravelagency.json.VehicleType;
import com.cgtravelagency.service.VehicleTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgata")
@Api(value="Vehicle Type related REST APIs")
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@ApiOperation(value="Returns all the vehicle types")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New vehicleType created"),
			@ApiResponse(code=404, message="No such vehicleType found")
	})
	@GetMapping(value="/vehicletype", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<VehicleType> getAllVehicleType() {
		return vehicleTypeService.getAllVehicleTypes();
	}
	
	@ApiOperation(value="Adds new vehicleType")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New vehicleType created"),
			@ApiResponse(code=404, message="No such vehicleType found")
	})
	@PostMapping(value="/vehicletype", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public VehicleType createNewVehicleType(@Valid @RequestBody VehicleType vehicleType) {
		return vehicleTypeService.createVehicleType(vehicleType);
	}
	
	@ApiOperation(value="Updates vehicleType")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New vehicleType created"),
			@ApiResponse(code=404, message="No such vehicleType found")
	})
	@PutMapping(value="/vehicletype/{typeId}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public VehicleType updateVehicleType(@Valid @RequestBody VehicleType vehicleType, @PathVariable Long typeId) {
		return vehicleTypeService.updateVehicleType(vehicleType, typeId);
	}
	
	@ApiOperation(value="Deletes vehicleType")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New vehicleType created"),
			@ApiResponse(code=404, message="No such vehicleType found")
	})
	@DeleteMapping(value="/vehicletype/{typeId}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public boolean deleteVehicleTypeById(@PathVariable Long typeId) {
		return vehicleTypeService.deleteById(typeId);
	}
	
	@ApiOperation(value="View all vehicleType Name")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New vehicleType created"),
			@ApiResponse(code=404, message="No such vehicleType found")
	})
	@GetMapping(value="/vehicleType/filter", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllVehicleTypeNames() {
		return vehicleTypeService.getAllVehicleTypeNames();
	}
}
