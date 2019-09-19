package com.test.taxi.dto;

public class Mini extends Taxi{

	@Override
	public TaxiType getTaxiType() {
		return TaxiType.MINI;
	}

	@Override
	public double getCommission() {
		return 1.0;
	}

}
