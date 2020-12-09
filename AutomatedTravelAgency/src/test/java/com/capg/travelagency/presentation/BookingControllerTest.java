package com.capg.travelagency.presentation;

import static org.junit.Assert.assertNotNull;

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
	public void testAddBookingNoOfPassengersFail() throws BookingNotFoundException, InvalidVehicleDataException {
		
		logger.info("[start] testAddBookingNoOfPassengers()");
		Booking booking= new Booking(java.sql.Date.valueOf("2020-06-18"), "kpatra",40.0,"confirm",1,9930826784L,0,java.sql.Date.valueOf("2020-12-18"),"kalyan","pune");
		bookingController.addBooking(booking);
		logger.error("Number of passengers cannot be 0");
		logger.info("[end] testAddBookingNoOfPassengersFail()");
	}

	public void testAddBookingNoOfPassengersSuccess() throws BookingNotFoundException, InvalidVehicleDataException {
		
		logger.info("[start] testAddBookingNoOfPassengers()");
		Booking booking= new Booking(java.sql.Date.valueOf("2020-06-18"), "kpatra",40.0,"confirm",8,9930826784L,1,java.sql.Date.valueOf("2020-12-18"),"kalyan","pune");
		assertNotNull("Booking added",bookingController.addBooking(booking));
		logger.info("[end] testAddBookingNoOfPassengersSuccess()");
	}
	
	@Test(expected = BookingNotFoundException.class)
	public void testAddBookingBoardingDropPointSuccess() throws BookingNotFoundException, InvalidVehicleDataException {
		
		logger.info("[start] testAddBookingBoardingDropPointSuccess()");
		Booking booking= new Booking(java.sql.Date.valueOf("2020-06-18"), "kpatra",40.0,"confirm",8,9930826784L,2,java.sql.Date.valueOf("2020-12-18"),"thane","thane");
		assertNotNull("Booking added",bookingController.addBooking(booking));
		logger.error("boarding point and drop point cannot be same");
		logger.info("[end] testAddBookingBoardingDropPointSuccess()");
	}

	@Test
	public void BookingSearchSuccess() throws BookingNotFoundException {
		logger.info("[START] BookingSearchSuccess()");
		assertNotNull("Booking Found", bookingController.viewById(123));//Checks that object isn't null,PASS
		logger.info("[END] BookingSearchSuccess()"); 
	}
	
	@Test(expected = BookingNotFoundException.class)
	public void BookingSearchFailed() throws BookingNotFoundException {
		logger.info("[START] BookingSearchFailed()");
		bookingController.viewById(-9345);
		logger.info("[END] BookingSearchFailed()");  //Fail negative ID not allowed
	}
	
	@Test (expected = BookingNotFoundException.class)
	public void BookingSearchEmpty() throws BookingNotFoundException {
		logger.info("[START] BookingSearchEmpty()");
		assertNull("Booking Not Found", bookingController.viewById(123));//Checks that object is null,Fail
		logger.info("[END] BookingSearchEmpty()");
	}

	@Test(expected = BookingNotFoundException.class)
	public void testCancelBookingIdFailed() throws BookingNotFoundException {
		logger.info("[start] testBookingId()");
			bookingController.cancelBookingById(-1);
		logger.info("[end] testBookingId(()");
	}
	@Test
	public void testCancelBookingIdSuccess() throws BookingNotFoundException {
		logger.info("[start] testBookingId(()");
		assertNotNull("Booking Cancelled", bookingController.cancelBookingById(46));
		logger.info("[end] testBookingId(()");
	}
	
	@Test(expected = BookingNotFoundException.class)
	public void testBookingStatusFail() throws BookingNotFoundException{
		logger.info("[start] testBookingStatusFail()");
		bookingController.viewBookingStatusById(1);
		logger.info("[end] testBookingStatusFail()");
	}
	
	@Test
	public void testBookingStatusSuccess() throws BookingNotFoundException{
		logger.info("[start] testBookingStatusSuccess()");
		assertNotNull("Status updated", bookingController.viewBookingStatusById(123));
		logger.info("[end] testBookingStatusSuccess()");
	}

}
