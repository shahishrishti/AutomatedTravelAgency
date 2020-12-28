package com.cgtravelagency.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgtravelagency.exception.InvalidVehicleDataException;
import com.cgtravelagency.exception.VehicleNotFoundException;
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
	
	//-------------------------Add vehicle--------------------------------------------
	@ApiOperation(value="Add New Vehicle")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New vehicle added")
			
	})
	@PostMapping(value="/vehicle/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehicle> createNewEmployee(@Valid @RequestBody Vehicle vehicle) throws InvalidVehicleDataException {
		try {
			logger.info("Add Vehicle Called!!");
		return new ResponseEntity<Vehicle>(vehicleService.createNewVehicle(vehicle), HttpStatus.OK);
		} catch(InvalidVehicleDataException invalidVehicleDataException)
		{
			logger.error(invalidVehicleDataException.getLocalizedMessage());
			return null;
		}
	}
	
	
	//-------------------View all Vehicles-------------------------------------------
		@ApiOperation(value="Returns all vehicles")
		@ApiResponses(value= {
				@ApiResponse(code=201, message="All Vehicles found"),
				@ApiResponse(code=404, message="No such vehicle found")
		})
		@GetMapping(value="/vehicle", produces=MediaType.APPLICATION_JSON_VALUE) 
		public List<Vehicle> getAllVehicles() throws VehicleNotFoundException {
			return vehicleService.getAllVehicles();
		}
		
		//------------------View Vehicle by Name----------------------------------------
		@ApiOperation(value="Returns all vehicles by Name")
		@ApiResponses(value= {
				@ApiResponse(code=201, message="Vehicles found with vehicleName"),
				@ApiResponse(code=404, message="No such vehicle found")
		})
		@GetMapping(value="/vehicle/{vehicleName}/filter", produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Vehicle> getVehicleByName(@PathVariable String vehicleName) throws VehicleNotFoundException
		{
			return vehicleService.getVehicleByName(vehicleName);
		}
		
		//------------------View Vehicle By No------------------------------------------
		@ApiOperation(value="Returns vehicle By No")
		@ApiResponses(value= {
				@ApiResponse(code=200, message="Vehicles found with vehicleNo"),
				@ApiResponse(code=404, message="No such vehicle found")
		})
		@GetMapping(value="/vehicle/{vehicleNo}", produces=MediaType.APPLICATION_JSON_VALUE)
		public Vehicle getVehicleByNo(@PathVariable String vehicleNo) throws VehicleNotFoundException
		{
			return vehicleService.getVehicleByNo(vehicleNo);
		}
		
		//----------------View Vehicle By Fare-------------------------------------------
		@ApiOperation(value="Returns vehicle By No")
		@ApiResponses(value= {
				@ApiResponse(code=200, message="Vehicles found with fare"),
				@ApiResponse(code=404, message="No such vehicles found")
		})
		@GetMapping(value="/vehicle/{fare}/filters", produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Vehicle> getVehicleByFare(@PathVariable double fare) throws VehicleNotFoundException
		{
			return vehicleService.getVehicleByFare(fare);
		}
		
		/*-------------View Vehicle By Seating capacity------------------------------
		@ApiOperation(value="Returns vehicle By No")
		@ApiResponses(value= {
				@ApiResponse(code=200, message="Vehicles found with fare"),
				@ApiResponse(code=404, message="No such vehicles found")
		})
		@GetMapping(value="/vehicle/{seatingCapacity}/filtering", produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Vehicle> getVehicleBySeatingCapacity(@PathVariable int seatingCapacity) throws VehicleNotFoundException
		{
			return vehicleService.getVehicleBySeatingCapacity(seatingCapacity);
		}*/
		
}
