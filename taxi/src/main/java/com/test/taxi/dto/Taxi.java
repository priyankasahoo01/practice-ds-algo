package com.test.taxi.dto;

public abstract class Taxi {

	private String taxId;
	private Agency agency;
	private TaxiType taxiType;
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public abstract TaxiType getTaxiType();
	
	public abstract double getCommission();
	
	
}
