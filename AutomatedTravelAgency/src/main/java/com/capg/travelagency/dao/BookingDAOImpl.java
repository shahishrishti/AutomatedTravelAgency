package com.capg.travelagency.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dao.BookingDAOImpl;
import com.capg.travelagency.entity.BookingEntity;
import com.capg.travelagency.exceptions.BookingNotFoundException;


public class BookingDAOImpl implements BookingDAO{
	private static Logger logger = LogManager.getLogger(BookingDAOImpl.class.getName());	
	private static EntityManager entityManager;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TravelAgencyPU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public BookingEntity viewBookingStatusById(int bookingId) throws BookingNotFoundException {
		BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
		Query query = entityManager.createQuery("SELECT b.vehicle_id, b.booking_id,b.booking_date,b.journey_date,b.boarding_point,b.drop_point,b.mobile_no from Booking b");//JPQL
		//Query query = entityManager.createNamedQuery("READ_ALL_BOOKINGS");
		List <BookingEntity> booking = query.getResultList();//Fire JPQL query
		for(BookingEntity be: booking) {
			System.out.println("student = " + be);
		}
		logger.info("Database returned BookingEntity: " + bookingEntity);
		if(bookingEntity==null)
			throw new BookingNotFoundException("BookingId: " + bookingId);
		return bookingEntity;
	}
}
