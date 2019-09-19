package com.test.taxi.model;

import java.util.Date;

import com.test.taxi.dto.Taxi;
import com.test.taxi.dto.Trip;
import com.test.taxi.dto.User;

public class BookingRequest {
	String bookingId;
	Date date;
	User user;
	Trip trip;
	Taxi taxi;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public Taxi getTaxi() {
		return taxi;
	}
	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	
	

}
