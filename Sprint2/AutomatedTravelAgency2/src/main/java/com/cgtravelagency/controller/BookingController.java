package com.cgtravelagency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgtravelagency.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.cgtravelagency.json.Booking;
import com.cgtravelagency.exception.BookingNotFoundException;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgata")
@Api(value="Booking related REST APIs")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@ApiOperation(value="Returns all bookings")
	@ApiResponses(value={
		@ApiResponse(code=201,message="Bookings found by name"),
		@ApiResponse(code=404,message="No such booking found")
		})
	@GetMapping(value = "/booking/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Booking> viewBookingsByUsername(@PathVariable String username) throws BookingNotFoundException {
        return bookingService.viewBookingsByUsername(username);
    }
	
	@ApiOperation(value="Returns all bookings")
	@ApiResponses(value={
		@ApiResponse(code=201,message="Bookings found by status"),
		@ApiResponse(code=404,message="No such booking found")
		})
	@GetMapping(value = "/booking/{username}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Booking> viewBookingsByStatus(@PathVariable String bookingStatus) throws BookingNotFoundException {
        return bookingService.viewBookingsByStatus(bookingStatus);
    }
}
