package com.test.taxi.dao;

import java.util.Date;

import com.test.taxi.dto.TaxiType;
import com.test.taxi.exception.TaxiTypeDoesnotExistException;

public interface IBookingDao {

	Double getBookingsCount(TaxiType type, Date startDate, Date endDate) throws TaxiTypeDoesnotExistException;

}
