package com.cgtravelagency.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cgtravelagency.entity.BookingEntity;

public interface BookingRepo extends JpaRepository<BookingEntity, Long> {

//	public List<BookingEntity> findByUsername(String username);
//	public List<BookingEntity> findByBookingStatus(String bookingStatus);
}
