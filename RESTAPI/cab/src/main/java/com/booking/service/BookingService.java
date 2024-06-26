package com.booking.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entity.BookingInfo;
import com.booking.repository.BookingRepo;
import com.booking.repository.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Service
public class BookingService {

	 EntityManager entityManager;
	 
	    public BookingService(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }
	@Autowired
	BookingRepo bookingRepo;
	
	@Autowired
	UserRepo userRepo;
	@Transactional
	public BookingInfo bookCab (BookingInfo bookingInfo) {
		System.out.println("Inside booking service");
		float distance = bookingInfo.getDistance();
		int userid = userRepo.findByMobile(bookingInfo.getUserMobile());
		bookingInfo.setBookingtime(new Timestamp(System.currentTimeMillis()));
		if(distance <=50)
			bookingInfo.setPrice(bookingInfo.getDistance()*10);
		else if(distance >50 && distance <= 100)
			bookingInfo.setPrice(bookingInfo.getDistance()*12);
		else if(distance > 100 && distance <= 200 ) 
			bookingInfo.setPrice(bookingInfo.getDistance()*14);
		else if(distance > 200 && distance <= 300 ) 
			bookingInfo.setPrice(bookingInfo.getDistance()*16);
		else
			bookingInfo.setPrice(bookingInfo.getDistance()*18);
		bookingInfo.setUserId(userid);
		BookingInfo bookedInfo =bookingRepo.save(bookingInfo);
		return bookedInfo;
	}
	
	public String cancelCab (int bookingId) {
		
			bookingRepo.deleteById(bookingId);
			return "success";
		
			
	}
}
