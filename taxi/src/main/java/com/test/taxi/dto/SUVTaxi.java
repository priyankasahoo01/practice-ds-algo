package com.test.taxi.dto;

public class SUVTaxi extends Taxi{

	@Override
	public TaxiType getTaxiType() {
		return TaxiType.SUV;
	}

	@Override
	public double getCommission() {
		return 29.0;
	}

}
