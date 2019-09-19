package com.test.taxi.dao;

import java.util.Date;

import com.test.taxi.dto.TaxiType;
import com.test.taxi.exception.TaxiTypeDoesnotExistException;

public class BookingDao implements IBookingDao {

	@Override
	public Double getBookingsCount(TaxiType type, Date startDate, Date endDate) throws TaxiTypeDoesnotExistException {
		// TODO Auto-generated method stub
		return null;
	}

}
