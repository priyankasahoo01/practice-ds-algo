package com.test.taxi.dto;

import java.util.List;

public class Agency {

	int id;
	String name;
	List<Taxi> taxis;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Taxi> getTaxis() {
		return taxis;
	}
	public void setTaxis(List<Taxi> taxis) {
		this.taxis = taxis;
	}
	
	
}
