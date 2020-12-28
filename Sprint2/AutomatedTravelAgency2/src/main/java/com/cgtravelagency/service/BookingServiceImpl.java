package com.cgtravelagency.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgtravelagency.json.Booking;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.json.User;
import com.cgtravelagency.repo.BookingRepo;
import com.cgtravelagency.repo.RouteRepo;
import com.cgtravelagency.util.BookingUtil;
import com.cgtravelagency.entity.BookingEntity;
import com.cgtravelagency.entity.RouteEntity;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepo bookingRepo;
	@Autowired
	private RouteRepo routeRepo;

	@Override
	public List<Booking> findByUser(User user) {
		List<BookingEntity> bookingEntityList = bookingRepo.findByUser(user);
		List<Booking> bookings = new ArrayList<Booking>();
		for(BookingEntity bookingEntity: bookingEntityList) {
			bookings.add(new Booking(bookingEntity.getBookingId(), bookingEntity.getJourneyDate(), bookingEntity.getBookingDate(), 
					bookingEntity.getCancelDate(), bookingEntity.getFare(), bookingEntity.getBookingStatus(), bookingEntity.getVehicleType()));
		}
		return bookings;
		
	}
	@Override
	public List<Booking> findByUserAndBookingStatus(User user, String bookingStatus) {
		List<BookingEntity> bookingEntityList = bookingRepo.findByUserAndBookingStatus(user, bookingStatus);
		List<Booking> bookings = new ArrayList<Booking>();
		for(BookingEntity bookingEntity: bookingEntityList) {
			bookings.add(new Booking(bookingEntity.getBookingId(), bookingEntity.getJourneyDate(), bookingEntity.getBookingDate(), 
					bookingEntity.getCancelDate(), bookingEntity.getFare(), bookingEntity.getBookingStatus(), bookingEntity.getVehicleType()));
		}
		return bookings;
	}
	@Override
	public List<Booking>findByBookingId(long bookingID){
		List<BookingEntity> bookingEntityList = bookingRepo.findByBookingId(bookingID);
		List<Booking> bookings = new ArrayList<Booking>();
		for(BookingEntity bookingEntity: bookingEntityList) {
		bookings.add(new Booking(bookingEntity.getBookingId(), bookingEntity.getJourneyDate(), bookingEntity.getBookingDate(), 
				bookingEntity.getCancelDate(), bookingEntity.getFare(), bookingEntity.getBookingStatus(), bookingEntity.getVehicleType()));
		}
		return null;
	}
	//------------------------------------Add Booking-------------------------------------------------
	@Override
	public Booking addBooking(Booking booking) {
			BookingEntity bookingEntity= bookingRepo.save(BookingUtil.convertBookingIntoBookingEntity(booking));
			return BookingUtil.convertBookingEntityIntoBooking(bookingEntity);
	}
	
	@Override
	public List<Booking> viewAllBookings() { 
		List<BookingEntity> bookingEntityList = bookingRepo.findAll(); 
		List<Booking> bookings = new ArrayList<Booking>(); 
		for(BookingEntity bookingEntity: bookingEntityList) {
			  bookings.add(new Booking(bookingEntity.getBookingId(), bookingEntity.getJourneyDate(),
					  bookingEntity.getBookingDate(), bookingEntity.getCancelDate(),
					  	bookingEntity.getFare(), bookingEntity.getBookingStatus(),
					  		bookingEntity.getVehicleType())); 
		}
	
		return bookings; 
	}	
	@Override 
	public List<Route> getAllRoute() { 
		List<RouteEntity>routeEntityList =routeRepo.findAll();
		List<Route> routes = new  ArrayList<Route>(); 
		for(RouteEntity routeEntity: routeEntityList) {
			routes.add(new Route(routeEntity.getRouteId(),routeEntity.getSource(),
			  routeEntity.getDestination(),routeEntity.getDistance()));
		}
		return routes; 
	}
	 
}