package com.cgtravelagency.controller;

import java.util.List;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgtravelagency.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.cgtravelagency.json.Booking;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.json.User;
import com.cgtravelagency.exception.BookingNotFoundException;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgata")
@Api(value="Booking related REST APIs")
public class BookingController {

	private Logger logger = LogManager.getLogger(BookingController.class.getName());
	@Autowired
	private BookingService bookingService;
	
	//---------------------View bookings by user--------------------------------------------------- 
	
	@ApiOperation(value="Returns all bookings")
	@ApiResponses(value={
		@ApiResponse(code=201,message="Bookings found by name"),
		@ApiResponse(code=404,message="No such booking found")
		})
	@GetMapping(value = "/booking/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Booking> viewBookingsByUser(@PathVariable User user) throws BookingNotFoundException {
        return bookingService.findByUser(user);
    }
	
	
	//-----------------------View bookings by user and status--------------------------------------
	
	@ApiOperation(value="Returns all bookings")
	@ApiResponses(value={
		@ApiResponse(code=201,message="Bookings found by status"),
		@ApiResponse(code=404,message="No such booking found")
		})
	@GetMapping(value = "/booking/{username,status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Booking> viewBookingsByUserAndBookingStatus(@PathVariable User user, String bookingStatus) throws BookingNotFoundException {
        return bookingService.findByUserAndBookingStatus(user, bookingStatus);
    }
	
	@ApiOperation(value="Cancel Booking")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="New Booking created"),
			@ApiResponse(code=404, message="No Booking found")
	})
	@PutMapping(value = "/booking/{bookingID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Booking> cancelBooking(@PathVariable long bookingID) throws BookingNotFoundException {
	//	logger.info("Cancel Booking Called!!");
		return bookingService.findByBookingId(bookingID);
	}
	
	//-----------------------------add booking -----------------------------------------//
		@ApiOperation(value="Book your vehicle")
		@ApiResponses(value={
			@ApiResponse(code=201,message="Booking is done successfully"),
			@ApiResponse(code=404,message="Error!Booking not done.")
			})
		@PostMapping(value="/booking",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		public Booking addNewBooking(@Valid @RequestBody Booking booking) throws BookingNotFoundException{
			logger.info("Booking is done successfully");
			return bookingService.addBooking(booking);
			
	}
	
		@ApiOperation(value="Returns all bookings")
		@ApiResponses(value= {
				@ApiResponse(code=201, message="All Bookings found"),
				@ApiResponse(code=404, message="No such booking found")
		})
		@GetMapping(value = "/booking", produces = MediaType.APPLICATION_JSON_VALUE)  //view all bookings
	    public List<Booking> viewAllBookings() throws BookingNotFoundException {
			logger.info("View all booking service started..");
	        return bookingService.viewAllBookings();
	    }
		
		@ApiOperation(value="Returns all bookings")                                    //view all routes in bookings
		@ApiResponses(value={
			@ApiResponse(code=201,message="Bookings found by status"),
			@ApiResponse(code=404,message="No such booking found")
			})
		@GetMapping(value="/booking/route",produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Route> getAllRoute(){
			logger.info("View all booking service started..");
			return bookingService.getAllRoute() ;
		}
}
