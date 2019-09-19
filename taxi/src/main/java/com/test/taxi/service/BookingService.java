package com.test.taxi.service;

import java.util.Date;

import com.test.taxi.dao.IBookingDao;
import com.test.taxi.dto.TaxiType;
import com.test.taxi.exception.TaxiTypeDoesnotExistException;
import com.test.taxi.model.BookingRequest;

public class BookingService {
	IBookingDao bookingDao;
	IBookingHandler handler;

	public void bookTaxi(BookingRequest req) {
		handler.book(req);
	}

	public double getBookingCount(TaxiType type, Date startDate, Date endDate) throws TaxiTypeDoesnotExistException {
		// TODO Auto-generated method stub
		Double bookingsCount = bookingDao.getBookingsCount(type, startDate, endDate);
		return bookingsCount;
	}

}
