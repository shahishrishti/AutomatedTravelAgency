package com.cgtravelagency.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.cgtravelagency.json.Place;
import com.cgtravelagency.service.PlaceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgata")
@Api(value="Vehicle Type related REST APIs")
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;
	
	//------------------------
	@ApiOperation(value="Returns all the places")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Place created"),
			@ApiResponse(code=404, message="No such Place found")
	})
	@GetMapping(value="/place", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Place> getAllPlace() {
		return placeService.getAllPlaces();
	}
	
	@ApiOperation(value="Adds new place")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Place created"),
			@ApiResponse(code=404, message="No such Place found")
	})
	@PostMapping(value="/place", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Place createNewPlace(@Valid @RequestBody Place place) {
		return placeService.createPlace(place);
	}
	
	@ApiOperation(value="Updates place")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Place created"),
			@ApiResponse(code=404, message="No such Place found")
	})
	@PutMapping(value="/place/{placeId}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Place updatePlace(@PathVariable Long placeId,@Valid @RequestBody Place place) {
		return placeService.updatePlace(placeId, place);
	}
	
	@ApiOperation(value="Deletes Place")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Place created"),
			@ApiResponse(code=404, message="No such Place found")
	})
	@DeleteMapping(value="/place/{placeId}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public boolean deletePlaceById(@PathVariable Long placeId) {
		return placeService.deleteById(placeId);
	}
	
	@ApiOperation(value="Get All Place Names")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Place created"),
			@ApiResponse(code=404, message="No such Place found")
	})
	@DeleteMapping(value="/place/filter", produces=MediaType.APPLICATION_JSON_VALUE) 
	public List<String> getAllPlaceNames() {
		return placeService.getAllPlaceNames();
	}
}
