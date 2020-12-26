package com.cgtravelagency.service;

import java.util.List;

import com.cgtravelagency.json.Booking;

public interface BookingService {

	 public List<Booking> viewBookingsByUsername(String username);
	 public List<Booking> viewBookingsByStatus(String bookingStatus);
}
