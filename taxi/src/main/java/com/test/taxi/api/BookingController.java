package com.test.taxi.api;

import java.util.Date;

import com.test.taxi.dto.TaxiType;
import com.test.taxi.service.BookingService;


public class BookingController {
	
	public double getBookingsCount(TaxiType type, Date startDate, Date endDate) {
		validateRequest(startDate, endDate);
		BookingService service = new BookingService();
		return service.getBookingCount(type, startDate, endDate);
	}

}
