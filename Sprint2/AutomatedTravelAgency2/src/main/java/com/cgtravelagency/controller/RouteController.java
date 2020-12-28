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

import com.cgtravelagency.exception.InvalidRouteDataException;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.service.RouteService;
import com.cgtravelagency.service.VehicleServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgata")
@Api(value="Route related REST APIs")
public class RouteController {
	
	@Autowired
	private RouteService routeService;
	private Logger logger = LogManager.getLogger(VehicleServiceImpl.class.getName());
	
	@ApiOperation(value="Add New Route")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New route added")
			
	})
	@PostMapping(value="/route/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Route> createNewEmployee(@Valid @RequestBody Route route) throws InvalidRouteDataException {
		
		return new ResponseEntity<Route>(routeService.createNewRoute(route), HttpStatus.OK);
		
	}
	
	@ApiOperation(value="Returns all routes")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="All routes found"),
			@ApiResponse(code=404, message="No such route found")
	})
	@GetMapping(value="/route", produces=MediaType.APPLICATION_JSON_VALUE) 
	public List<Route> getAllRoutes() throws InvalidRouteDataException {
		
		return routeService.getAllRoutes();
	}
	
	@ApiOperation(value ="Returns all route By Source")

	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such route found")
			
	})
	@GetMapping(value="/route/{source}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Route> getRouteBySource(@PathVariable String source) throws InvalidRouteDataException {
	    return routeService.getRouteBySource(source);
	}
	
	@ApiOperation(value ="Returns all route By Destination")

	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such route found")
			
	})
	@GetMapping(value="/route/{destination}/filter",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Route> getRouteByDestination(@PathVariable String destination) throws InvalidRouteDataException {
	    return routeService.getRouteBySource(destination);
	}
	
	@ApiOperation(value ="Returns all route By Distance")

	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such route found")
			
	})
	@GetMapping(value="/route/{distance}/filters",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Route> getRouteByDistance(@PathVariable double distance) throws InvalidRouteDataException {
	    return routeService.getRouteByDistance(distance);
	}
	
	@ApiOperation(value ="Returns all route By Source and Distance")

	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such route found")
			
	})
	@GetMapping(value="/route/{source}/{destination}/filters",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Route> getRouteBySourceAndDestination(@PathVariable String source, @PathVariable String destination) throws InvalidRouteDataException {
	    return routeService.getRouteBySourceAndDestination(source, destination);
	}
	
	//--------------------Update Route-------------------------------------------- 
	
	@ApiOperation(value="Update Route")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Route created"),
			@ApiResponse(code=404, message="No such Route found")
	})
	@PutMapping(value = "/Route/{routeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Route updateRoute(@PathVariable Long routeId, @Valid @RequestBody Route route) throws InvalidRouteDataException {
		logger.info("Update Route Called!!");
		return routeService.updateRoute(routeId, route);
	}

//--------------------Delete Route--------------------------------------------

	@ApiOperation(value="Delete Route")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New route created"),
			@ApiResponse(code=404, message="No such route found")
	})
	@DeleteMapping(value = "/route/{routeid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Route deleteRoute(@PathVariable Long routeid ) throws InvalidRouteDataException {
		logger.info("Delete Route Called!!");
		return routeService.deleteRoute(routeid);
	}
}
