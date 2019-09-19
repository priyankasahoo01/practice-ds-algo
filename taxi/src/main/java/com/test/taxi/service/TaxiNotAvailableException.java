package com.test.taxi.service;

import com.test.taxi.exception.TaxiBookingException;

public class TaxiNotAvailableException extends TaxiBookingException {

	public TaxiNotAvailableException() {
		// TODO Auto-generated constructor stub
	}

	public TaxiNotAvailableException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TaxiNotAvailableException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public TaxiNotAvailableException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TaxiNotAvailableException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
