package com.capg.travelagency.utils;
import com.capg.travelagency.dto.Booking;
import com.capg.travelagency.entity.BookingEntity;

public class BookingUtils {

	public static Booking convertBookingEntityIntoBooking(BookingEntity bookingEntity) {
		return new Booking(bookingEntity.getBookingId(),bookingEntity.getBookingDate(),bookingEntity.getUsername(),bookingEntity.getFare(),bookingEntity.getBookingStatus(),bookingEntity.getVehicleEntity().getVehicleNo(),bookingEntity.getMobileNo(),bookingEntity.getNumOfPassenger(),
				bookingEntity.getJourneyDate()
				,bookingEntity.getDropPoint(),bookingEntity.getBoardingPoint());
	}
}




