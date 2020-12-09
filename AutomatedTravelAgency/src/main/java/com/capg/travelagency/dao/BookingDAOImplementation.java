package com.capg.travelagency.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capg.travelagency.dto.Booking;
import com.capg.travelagency.entity.BookingEntity;
import com.capg.travelagency.entity.VehicleEntity;
import com.capg.travelagency.exceptions.BookingNotFoundException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public class BookingDAOImplementation implements BookingDAO {

		private static Logger logger = LogManager.getLogger(BookingDAOImplementation.class.getName());	
		private static EntityManager entityManager;
		
		static {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TravelAgencyPU");
			entityManager = entityManagerFactory.createEntityManager();
		}
		
		public BookingEntity viewById(int bookingId) throws BookingNotFoundException {
			BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
			Query query = entityManager.createQuery("SELECT b.vehicle_id, b.booking_id,b.booking_date,b.journey_date,b.boarding_point,b.drop_point,b.mobile_no from Booking b");//JPQL
			List <BookingEntity> booking = query.getResultList();//Fire JPQL query
			for(BookingEntity be: booking) {
				System.out.println("Booking = " + be);
			}
			logger.info("Database returned BookingEntity: " + bookingEntity);
			if(bookingEntity==null)
				throw new BookingNotFoundException("BookingId: " + bookingId);
			return bookingEntity;
		}
		
		
		public BookingEntity viewAll(int bookingId) throws BookingNotFoundException {
			BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
			Query query = entityManager.createQuery("SELECT b.booking_id,b.vehicle_name,b.source,b.destination from Booking b");//JPQL
			//Query query = entityManager.createNamedQuery("READ_ALL_BOOKINGS");
			List <BookingEntity> booking = query.getResultList();//Fire JPQL query
			for(BookingEntity be: booking) {
				System.out.println("Booking = " + be);
			}
			logger.info("Database returned BookingEntity: " + bookingEntity);
			if(bookingEntity==null)
				throw new BookingNotFoundException();
			return bookingEntity;
		}
		
		
		public BookingEntity addBooking(Booking addedBooking) 
						throws BookingNotFoundException{
			entityManager.getTransaction().begin();
			BookingEntity bookEntity = null;
			VehicleEntity vehicleEntity=entityManager.find(VehicleEntity.class, addedBooking.getVehicleNo());
			if(vehicleEntity == null) {
				throw new BookingNotFoundException("VehicleNo is null");
			} else {
			 	bookEntity=new BookingEntity(addedBooking.getBookingDate(),addedBooking.getUsername(),addedBooking.getFare(),addedBooking.getBookingStatus(),
			 			addedBooking.getMobileNo(),addedBooking.getNumOfPassenger(),
						addedBooking.getJourneyDate(),addedBooking.getDropPoint(),addedBooking.getBoardingPoint(),vehicleEntity);
				entityManager.persist(bookEntity);
			}
			entityManager.getTransaction().commit();
			logger.info("vehicle is booked successfully" +bookEntity);
			return bookEntity;
		}
		
		public BookingEntity viewBookingStatusById(int bookingId) throws BookingNotFoundException {
			BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
			Query query = entityManager.createQuery("SELECT b.vehicle_id, b.booking_id,b.booking_date,b.journey_date,b.boarding_point,b.drop_point,b.mobile_no from Booking b");//JPQL
			List <BookingEntity> booking = query.getResultList();//Fire JPQL query
			for(BookingEntity be: booking) {
				System.out.println("Booking = " + be);
			}
			logger.info("Database returned BookingEntity: " + bookingEntity);
			if(bookingEntity==null)
				throw new BookingNotFoundException("BookingId: " + bookingId);
			return bookingEntity;
		}
		
		
		
		public BookingEntity cancelBookingById(int bookingId) throws BookingNotFoundException {
			BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
			Query query = entityManager.createQuery("Delete from Booking b where b.booking_id=:booking_id");//JPQL
			         query.executeUpdate();
			List <BookingEntity> booking = query.getResultList();//Fire JPQL query
			for(BookingEntity be: booking) {
				System.out.println("booking = " + be);
			}
			logger.info("Database returned BookingEntity: " + bookingEntity);
			if(bookingEntity==null)
				throw new BookingNotFoundException("BookingId: " + bookingId);
			return bookingEntity;
		}




		
		
		
		
}



