package com.cgtravelagency.service;

import java.util.List;
import com.cgtravelagency.json.Booking;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.json.User;

public interface BookingService {

	public List<Booking> findByUser(User user);
	public List<Booking> findByUserAndBookingStatus(User user, String bookingStatus);
	public List<Booking> findByBookingId(long bookingID);
	public Booking addBooking(Booking booking);
	public List<Booking> viewAllBookings();
	public List<Route> getAllRoute();
}
