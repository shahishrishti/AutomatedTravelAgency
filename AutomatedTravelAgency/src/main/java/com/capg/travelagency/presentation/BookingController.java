package com.capg.travelagency.presentation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dto.Booking;
import com.capg.travelagency.exceptions.BookingNotFoundException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;
import com.capg.travelagency.service.BookingServiceImplementation;


public class BookingController {
	private static Logger logger = LogManager.getLogger(BookingController.class.getName());
	BookingServiceImplementation bookingService = new BookingServiceImplementation();
	
	
	public Booking viewById(int bookingId) throws BookingNotFoundException {
		logger.info("Finding books for id: " + bookingId);
		Booking booking = null;
		try {
			booking = bookingService.viewById(bookingId); 
		}
		catch(Exception e) {
			logger.error("BookingNotFoundException: " + e);
			throw new BookingNotFoundException(e.getMessage());
		}
		return booking;
	}
	
	
	public Booking viewAll(int bookingId) throws BookingNotFoundException {
		logger.info("Finding books for id: " + bookingId);
		Booking booking= null;
		try {
			booking = bookingService.viewAll(bookingId); 
		}
		catch(Exception e) {
			logger.error("BookingNotFoundException: " + e);
			throw new BookingNotFoundException(e.getMessage());
		}
		return booking;
	}
	
	public Booking cancelBookingById(int bookingId) throws BookingNotFoundException {
		logger.info("Finding books for id: " + bookingId);
		Booking booking = null;
		try {
			booking = bookingService.cancelBookingById(bookingId); 
		}
		catch(Exception e) {
			logger.error("BookingNotFoundException: " + e);
			throw new BookingNotFoundException(e.getMessage());
		}
		return booking;
	}
	
	public Booking addBooking(Booking addedBooking) throws BookingNotFoundException, InvalidVehicleDataException {
		logger.info("Finding books for id: " + addedBooking);
		Booking booking= null;
		if(addedBooking.getNumOfPassenger() <= 0 ) {
			logger.error("Number of passengers cannot be 0");
			throw new BookingNotFoundException("No. of passengers is less tha 0");
		}else if(addedBooking.getBoardingPoint().equals(addedBooking.getDropPoint())) {
			logger.error("boarding Point and drop point cannot be same");
			throw new BookingNotFoundException("boarding Point and drop point cannot be same");
		}else {
			try {
				booking=bookingService.addBooking(addedBooking);
			}catch(BookingNotFoundException bookingNotFoundException){
				logger.error("BookingNotFoundException: "+bookingNotFoundException);
				throw new BookingNotFoundException(bookingNotFoundException.getMessage());
			}
		}
		return booking;
	}
	
	public Booking viewBookingStatusById(int bookingId) throws BookingNotFoundException {
		logger.info("Finding booking for id: " + bookingId);
		Booking booking = null;
		try {
			booking = bookingService.viewBookingStatusById(bookingId); 
		}
		catch(Exception e) {
			logger.error("BookingNotFoundException: " + e);
			throw new BookingNotFoundException(e.getMessage());
		}
		return booking;
	}
	
	
}
