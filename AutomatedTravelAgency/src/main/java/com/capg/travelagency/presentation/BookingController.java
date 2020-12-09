package com.capg.travelagency.presentation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dto.Booking;
import com.capg.travelagency.exceptions.BookingNotFoundException;
import com.capg.travelagency.service.BookingServiceImplementation;


public class BookingController {
	private static Logger logger = LogManager.getLogger(BookingController.class.getName());
	BookingServiceImplementation itemService = new BookingServiceImplementation();
	
	
	public Booking viewById(int bookingId) throws BookingNotFoundException {
		logger.info("Finding books for id: " + bookingId);
		Booking item = null;
		try {
			item = itemService.viewById(bookingId); 
		}
		catch(Exception e) {
			logger.error("BookingNotFoundException: " + e);
			throw new BookingNotFoundException(e.getMessage());
		}
		return item;
	}
	
	
	public Booking viewAll(int bookingId) throws BookingNotFoundException {
		logger.info("Finding books for id: " + bookingId);
		Booking item = null;
		try {
			item = itemService.viewAll(bookingId); 
		}
		catch(Exception e) {
			logger.error("BookingNotFoundException: " + e);
			throw new BookingNotFoundException(e.getMessage());
		}
		return item;
	}
	
	public Booking cancelBookingById(int bookingId) throws BookingNotFoundException {
		logger.info("Finding books for id: " + bookingId);
		Booking item = null;
		try {
			item = itemService.cancelBookingById(bookingId); 
		}
		catch(Exception e) {
			logger.error("BookingNotFoundException: " + e);
			throw new BookingNotFoundException(e.getMessage());
		}
		return item;
	}
	
	public Booking addBooking(int bookingId) throws BookingNotFoundException {
		logger.info("Finding books for id: " + bookingId);
		Booking item = null;
		try {
			item = itemService.addBooking(bookingId); 
		}
		catch(Exception e) {
			logger.error("BookingNotFoundException: " + e);
			throw new BookingNotFoundException(e.getMessage());
		}
		return item;
	}
	
	
	public Booking viewBookingStatusById(int bookingId) throws BookingNotFoundException {
		logger.info("Finding books for id: " + bookingId);
		Booking item = null;
		try {
			item = itemService.viewBookingStatusById(bookingId); 
		}
		catch(Exception e) {
			logger.error("BookingNotFoundException: " + e);
			throw new BookingNotFoundException(e.getMessage());
		}
		return item;
	}
	
	
}
