package com.capg.travelagency.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dao.BookingDAO;
import com.capg.travelagency.dao.BookingDAOImplementation;
import com.capg.travelagency.dto.Booking;
import com.capg.travelagency.entity.BookingEntity;
import com.capg.travelagency.exceptions.BookingNotFoundException;
import com.capg.travelagency.utils.BookingUtils;

public class BookingServiceImplementation implements BookingService {
	
	private static Logger logger = LogManager.getLogger(BookingServiceImplementation.class.getName());
	BookingDAO bookingDao = new BookingDAOImplementation();
	
	public Booking viewById(int bookingId) throws BookingNotFoundException {
		BookingEntity bookingEntity = bookingDao.viewById(bookingId);
		logger.info("BookingEntity: " + bookingEntity);
		return BookingUtils.convertBookingEntityIntoBooking(bookingEntity);
		
	}
	
	public Booking viewAll(int bookingId) throws BookingNotFoundException {
		BookingEntity bookingEntity = bookingDao.viewAll(bookingId);
		logger.info("BookingEntity: " + bookingEntity);
		return BookingUtils.convertBookingEntityIntoBooking(bookingEntity);
		
	}

	public Booking cancelBookingById(int bookingId) throws BookingNotFoundException {
		BookingEntity bookingEntity = bookingDao.viewById(bookingId);
		logger.info("BookingEntity: " + bookingEntity);
		return BookingUtils.convertBookingEntityIntoBooking(bookingEntity);
	}

	public Booking addBooking(int bookingId) throws BookingNotFoundException {
		BookingEntity bookingEntity = bookingDao.viewById(bookingId);
		logger.info("BookingEntity: " + bookingEntity);
		return BookingUtils.convertBookingEntityIntoBooking(bookingEntity);
	}

	public Booking viewBookingStatusById(int bookingId) throws BookingNotFoundException {
		BookingEntity bookingEntity = bookingDao.viewById(bookingId);
		logger.info("BookingEntity: " + bookingEntity);
		return BookingUtils.convertBookingEntityIntoBooking(bookingEntity);
	}


	
	
	
}
