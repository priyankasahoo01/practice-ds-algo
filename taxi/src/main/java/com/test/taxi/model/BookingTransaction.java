package com.test.taxi.model;

import com.test.taxi.dto.Taxi;
import com.test.taxi.dto.Trip;
import com.test.taxi.dto.User;

public class BookingTransaction {

	double transactionId;
	Trip trip;
	User user;
	Taxi taxi;
	double fare;
	public double getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(double transactionId) {
		this.transactionId = transactionId;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Taxi getTaxi() {
		return taxi;
	}
	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	
}
