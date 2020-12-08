package com.capg.travelagency.dao;

import com.capg.travelagency.entity.BookingEntity;
import com.capg.travelagency.exceptions.BookingNotFoundException;

public interface BookingDAO {
	BookingEntity viewBookingStatusById(int bookingId) throws BookingNotFoundException;
}
