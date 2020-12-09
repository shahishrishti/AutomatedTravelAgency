package com.capg.travelagency.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.travelagency.dto.Booking;
import com.capg.travelagency.exceptions.BookingNotFoundException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public class BookingControllerTest {
	private static Logger logger;
	private static BookingController bookingController;

	@BeforeClass
	public static void setUp() {
		logger = LogManager.getLogger(BookingControllerTest.class.getName());
		bookingController  = new BookingController();
	}
	
	@Test(expected = BookingNotFoundException.class)
	public void testAddBookingNoOfPassengersFail() throws BookingNotFoundException {
		
		logger.info("[start] testAddBookingNoOfPassengers()");
		Booking booking= new Booking(java.sql.Date.valueOf("2020-06-18"), "kpatra",40.0,"confirm",1,9930826784L,0,java.sql.Date.valueOf("2020-12-18"),"kalyan","pune");
		bookingController.addBooking(booking);
		logger.error("Number of passengers cannot be 0");
		logger.info("[end] testAddBookingNoOfPassengersFail()");
	}

	@Test(expected = BookingNotFoundException.class)
	public void testAddBookingNoOfPassengersSuccess() throws BookingNotFoundException {
		
		logger.info("[start] testAddBookingNoOfPassengers()");
		Booking booking= new Booking(java.sql.Date.valueOf("2020-06-18"), "kpatra",40.0,"confirm",1,9930826784L,1,java.sql.Date.valueOf("2020-12-18"),"kalyan","pune");
		bookingController.addBooking(booking);
		logger.info("[end] testAddBookingNoOfPassengersSuccess()");
	}
	
	@Test(expected = BookingNotFoundException.class)
	public void testAddBookingBoardingDropPointSuccess() throws BookingNotFoundException {
		
		logger.info("[start] testAddBookingBoardingDropPointSuccess()");
		Booking booking= new Booking(java.sql.Date.valueOf("2020-06-18"), "kpatra",40.0,"confirm",1,9930826784L,2,java.sql.Date.valueOf("2020-12-18"),"thane","thane");
		bookingController.addBooking(booking);
		logger.error("boarding point and drop point cannot be same");
		logger.info("[end] testAddBookingBoardingDropPointSuccess()");
	}
}
