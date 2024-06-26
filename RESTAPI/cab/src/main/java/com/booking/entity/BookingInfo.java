package com.booking.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="bookinginfo")
public class BookingInfo {

	@Id
	@Column(name="bid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	@Column(name="origin")
	private String from;
	@Column(name="destination")
	private String to;
	@Column(name="timeofbooking")
	private Timestamp bookingtime;
	private float distance;
	@Column(name="price")
	private float price;
	@Column(name="userid")
	private int userId;
	
	@Transient
	private String userMobile;

	
	
	

	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Timestamp getBookingtime() {
		return bookingtime;
	}
	public void setBookingtime(Timestamp bookingtime) {
		this.bookingtime = bookingtime;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BookingInfo [bookingId=" + bookingId + ", from=" + from + ", to=" + to + ", bookingtime=" + bookingtime
				+ ", distance=" + distance + ", price=" + price + ", userId=" + userId + ", mobile=" + userMobile + "]";
	}
	
}
