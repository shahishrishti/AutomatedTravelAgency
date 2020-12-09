package com.capg.travelagency.service;

import com.capg.travelagency.dto.Booking;
import com.capg.travelagency.exceptions.BookingNotFoundException;

public interface BookingService {
	Booking viewById(int bookingId) throws BookingNotFoundException;
	Booking viewAll(int bookingId) throws BookingNotFoundException;
	Booking cancelBookingById(int bookingId) throws BookingNotFoundException;
	Booking addBooking(int bookingId) throws BookingNotFoundException;
	Booking viewBookingStatusById(int bookingId) throws BookingNotFoundException;	
}
