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
	
		
//-------------------------Add driver--------------------------------------------
		@ApiOperation(value="Add New Driver")
		@ApiResponses(value= {
				@ApiResponse(code=201, message="New driver created"),
				@ApiResponse(code=404, message="No such driver created")
		})
		@PostMapping(value="/driver/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Driver> createNewDriver(@Valid @RequestBody Driver driver) throws InvalidDriverDataException {
			try {
				logger.info("Add Driver Called!!");
			return new ResponseEntity<Driver>(driverService.createNewDriver(driver), HttpStatus.OK);
			} catch(InvalidDriverDataException invalidDriverDataException)
			{
				logger.error(invalidDriverDataException.getLocalizedMessage());
				return null;
			}
		}
		
//----------------view all drivers-----------------------------------
	
	@ApiOperation(value="Returns all drivers")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="All drivers found"),
			@ApiResponse(code=404, message="No such drivers found")
	})
	@GetMapping(value="/driver", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Driver> getAllDrivers() throws  InvalidDriverDataException{
		logger.info("All driver details are displayed");
		return driverService.getAllDrivers();
	}
	

	
//-------------- view driver by driver name	-------------------------------
	
	@ApiOperation(value="Returns all drivers by driver name")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Return all driver by driver name"),
			@ApiResponse(code=404, message="No such drivers found")
	})
	@GetMapping(value="/driver/{driverName}/filter", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Driver> getDriverByName(@PathVariable String driverName)throws InvalidDriverDataException  {
		logger.info("All driver names are displayed");
		return driverService.getDriverByName(driverName);
	}
				
	
//--------------view driver by license number---------------------------------
	
	@ApiOperation(value="Returns all drivers by license number")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Returns all drivers by license number"),
			@ApiResponse(code=404, message="No such drivers found")
	})
	@GetMapping(value="/driver/{licenseNo}/filters", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Driver> getDriverByLicenseNo(@PathVariable String licenseNo)throws InvalidDriverDataException {
		logger.info("All drivers license number is displayed");
		return driverService. getDriverByLicenseNo(licenseNo);
	}

	@ApiOperation(value="Updates driver")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Driver created"),
			@ApiResponse(code=404, message="No such driver found")
	})
	@PutMapping(value="/driver/{driverId}/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Driver updateDriver(@PathVariable Long driverId, @Valid @RequestBody Driver driver) throws InvalidDriverDataException{
			logger.info("Update Vehicle Called!!");
			return driverService.updatedriver(driverId, driver);
	}

	@ApiOperation(value="Delete Driver")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Driver created"),
			@ApiResponse(code=404, message="No such driver found")
	})
	@DeleteMapping(value="/driver/{driverId}/delete", produces=MediaType.APPLICATION_JSON_VALUE) 
	public Driver deleteDriver(@PathVariable Long driverId) throws InvalidDriverDataException {
		logger.info("Delete Driver Called!!");
		return driverService.deleteDriver(driverId);
	}   

}
