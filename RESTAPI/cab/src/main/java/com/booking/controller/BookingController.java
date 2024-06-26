package com.booking.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.BookingInfo;
import com.booking.service.BookingService;


@RestController
@CrossOrigin("*")
@RequestMapping("booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping(value = "/request-cab",consumes = MediaType.ALL_VALUE)
	public String createAccount(@RequestBody BookingInfo bookingDetails) {;
		System.out.println("Inside booking controller"+bookingDetails.toString());
		BookingInfo bookedInfo=bookingService.bookCab(bookingDetails);
		JSONObject result = new JSONObject();
		result.put("origin", bookingDetails.getFrom());
		result.put("destination", bookingDetails.getTo());
		result.put("distance", bookingDetails.getDistance());
		result.put("bookingId", bookedInfo.getBookingId());
		result.put("fare", bookedInfo.getPrice());
		return result.toString();
		
	}
	
	@PostMapping(value = "/cancel-cab",consumes = MediaType.ALL_VALUE)
	public String cancelBooking(@RequestBody int id) {;
		System.out.println("booking id"+ id);
		String status =bookingService.cancelCab(id);
		if(status.equalsIgnoreCase("success"))
			return String.valueOf(id).concat("cancelled");
		else
			return "Cancellation is not done";
	}
	
	
	

}
