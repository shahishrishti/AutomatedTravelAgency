package com.capg.travelagency.dao;

import java.util.Date;
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
import com.capg.travelagency.exceptions.InvalidDriverDataException;
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
			Query query = entityManager.createQuery("SELECT b.vehicleEntity, b.bookingId,b.bookingDate,b.journeyDate,b.boardingPoint,b.dropPoint,b.mobileNo from BookingEntity b");//JPQL
			//query = entityManager.createNamedQuery("booking.viewById");
			List <BookingEntity> booking = query.getResultList();//Fire JPQL query
			for(BookingEntity be: booking) {
				System.out.println("Booking = " + be);
			}
			logger.info("Database returned BookingEntity: " + bookingEntity);
			if(bookingEntity==null)
				throw new BookingNotFoundException("BookingId: " + bookingId);//admin
			return bookingEntity;
		}
		
		
		public BookingEntity viewAll(int bookingId) throws BookingNotFoundException {
			BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
			Query query = entityManager.createQuery("SELECT b.bookingId,b.vehicleName,b.Source,b.Destination from BookingEntity b, Vehicle v, Route r where"
					+ "b.vehicleEntity=v.vehicleEntity AND v.vehicleEntity = r.vehicleEntity");//JPQL
			// query = entityManager.createNamedQuery("booking.viewAll");
			List <BookingEntity> booking = query.getResultList();//Fire JPQL query  //cust
			for(BookingEntity be: booking) {
				System.out.println("Booking = " + be);
			}
			logger.info("Database returned BookingEntity: " + bookingEntity);
			if(bookingEntity==null)
				throw new BookingNotFoundException();
			return bookingEntity;
		}
		

		public BookingEntity addBooking(Booking addedBooking) throws BookingNotFoundException, InvalidVehicleDataException {
			entityManager.getTransaction().begin();
			BookingEntity bookEntity = null;
			VehicleEntity vehicleEntity = entityManager.find(VehicleEntity.class, addedBooking.getVehicleNo());
			if(vehicleEntity == null) {
				logger.error("Invalid vehicleEntity");
				entityManager.getTransaction().commit();
			    throw new InvalidVehicleDataException("Invalid Vehicle ID: " + addedBooking.getVehicleNo());
			} else {
				bookEntity=new BookingEntity(addedBooking.getBookingDate(),addedBooking.getUsername(),addedBooking.getFare(),
						addedBooking.getBookingStatus(), addedBooking.getMobileNo(),addedBooking.getNumOfPassenger(),
						addedBooking.getJourneyDate(),addedBooking.getDropPoint(),addedBooking.getBoardingPoint(), vehicleEntity);
	 			entityManager.persist(bookEntity);
			}
 			entityManager.getTransaction().commit();
 			logger.info("vehicle is booked successfully" +bookEntity);
 			return bookEntity;
		}
		
		public BookingEntity viewBookingStatusById(int bookingId) throws BookingNotFoundException {
			entityManager.getTransaction().begin();
			BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
			logger.info("Database returned BookingEntity: " + bookingEntity);
			if(bookingEntity==null) {
				logger.error("Booking Entity was found null");
				entityManager.getTransaction().commit();
				throw new BookingNotFoundException("BookingId: " + bookingId);
			}
			else {
				logger.info("View bookings from database");
				System.out.println("Booking data : "+bookingEntity);
			}
			entityManager.getTransaction().commit();
			return bookingEntity;
		}
		

		public BookingEntity cancelBookingById(int bookingId) throws BookingNotFoundException {
			entityManager.getTransaction().begin();
			BookingEntity bookingEntity = entityManager.find(BookingEntity.class, bookingId);
			logger.info("Database returned BookingEntity: " + bookingEntity);
			if(bookingEntity==null) {
				logger.error("Booking entity was found null");
				entityManager.getTransaction().commit();
				throw new BookingNotFoundException("BookingId: " + bookingId);
			} else {
				logger.info("Delete booking data from database");
				entityManager.remove(bookingEntity);
			}
			entityManager.getTransaction().commit();
			return bookingEntity;
		}	
		
}



