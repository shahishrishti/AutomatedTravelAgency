package com.cgtravelagency.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.json.Booking;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.json.Vehicle;
import com.cgtravelagency.repo.BookingRepo;
import com.cgtravelagency.service.BookingService;
import com.cgtravelagency.entity.BookingEntity;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepo bookingRepo;

	@Override
	public List<Booking> viewBookingsByUsername(String username) {
//		List<BookingEntity> bookingEntityList = bookingRepo.findByUsername(username);
//		List<Booking> bookings = new ArrayList<Booking>();
//		for(BookingEntity bookingEntity: bookingEntityList) {
//			Route route = new Route(bookingEntity.getRoute().getVehicle().getVehicleNo());
//			bookings.add(new Booking(bookingEntity.getBookingId(), bookingEntity.getJourneyDate(), bookingEntity.getBookingDate(), 
//					bookingEntity.getCancelDate(), bookingEntity.getFare(), bookingEntity.getBookingStatus(), bookingEntity.getVehicleType(), route));
//		}
		return null;
	}
	@Override
	public List<Booking> viewBookingsByStatus(String bookingStatus) {
//		List<BookingEntity> bookingEntityList = bookingRepo.findByBookingStatus(bookingStatus);
//		List<Booking> bookings = new ArrayList<Booking>();
//		for(BookingEntity bookingEntity: bookingEntityList) {
//			Route route = new Route(bookingEntity.getRoute().getVehicle().getVehicleNo());
//			bookings.add(new Booking(bookingEntity.getBookingId(), bookingEntity.getJourneyDate(), bookingEntity.getBookingDate(), 
//					bookingEntity.getCancelDate(), bookingEntity.getFare(), bookingEntity.getBookingStatus(), bookingEntity.getVehicleType(), route));
//		}
		return null;
	}
}
