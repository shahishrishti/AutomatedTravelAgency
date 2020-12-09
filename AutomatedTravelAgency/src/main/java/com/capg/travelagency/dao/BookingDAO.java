
package com.capg.travelagency.dao;
import com.capg.travelagency.dto.Booking;
import com.capg.travelagency.entity.BookingEntity;
import com.capg.travelagency.exceptions.BookingNotFoundException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;
public interface BookingDAO {
	
		BookingEntity viewById(int bookingId) throws BookingNotFoundException;
		
		BookingEntity viewAll(int bookingId) throws BookingNotFoundException;
		
		BookingEntity cancelBookingById(int bookingId) throws BookingNotFoundException;
		
		BookingEntity addBooking(Booking addedBooking) throws BookingNotFoundException, InvalidVehicleDataException;
		
		BookingEntity viewBookingStatusById(int bookingId) throws BookingNotFoundException;
		
		
	}


