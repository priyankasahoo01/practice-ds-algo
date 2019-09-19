package com.test.taxi.service;

import com.test.taxi.dto.Taxi;
import com.test.taxi.model.BookingRequest;

public class BookingHandler implements IBookingHandler{

	@Override
	public void book(BookingRequest req) {
		// TODO Auto-generated method stub
		String city = req.getTrip().getCity();
		Taxi taxi = req.getTaxi();
		VehiclePools.getInstance().getVehiclePoolMaps(city).getTaxi(taxi);
		
		
		
	}

}
