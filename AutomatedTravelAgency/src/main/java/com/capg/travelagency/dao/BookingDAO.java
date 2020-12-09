
package com.capg.travelagency.dao;
import java.util.Date;

import com.capg.travelagency.entity.BookingEntity;
import com.capg.travelagency.entity.VehicleEntity;
import com.capg.travelagency.exceptions.BookingNotFoundException;
public interface BookingDAO {
	
		BookingEntity viewById(int bookingId) throws BookingNotFoundException;
		
		BookingEntity viewAll(int bookingId) throws BookingNotFoundException;
		
		BookingEntity cancelBookingById(int bookingId) throws BookingNotFoundException;
		
		BookingEntity addBooking(Date bookingDate ,String username,double fare,String bookingStatus,long mobileNo,int numOfPassenger,
				Date journeyDate,String dropPoint,String boardingPoint,VehicleEntity vehicleEntity) throws BookingNotFoundException;
		
		BookingEntity viewBookingStatusById(int bookingId) throws BookingNotFoundException;
		
	}


