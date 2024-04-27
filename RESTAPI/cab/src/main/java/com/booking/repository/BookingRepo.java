package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entity.BookingInfo;


@Repository
public interface BookingRepo extends JpaRepository<BookingInfo, Integer> {
	

}
