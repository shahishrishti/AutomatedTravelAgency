package com.cgtravelagency.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cgtravelagency.entity.BookingEntity;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.json.User;

public interface BookingRepo extends JpaRepository<BookingEntity, Long> {

	public List<BookingEntity> findByUser(User user);
	public List<BookingEntity> findByUserAndBookingStatus(User user, String bookingStatus);
	public List<BookingEntity> findByBookingId(long bookingID);
	public List<BookingEntity> findAll();
	//public List<BookingEntity> findByRouteId(Long routeid);
	public List<BookingEntity> findByUserAndRoute(User user, Route route);
}
