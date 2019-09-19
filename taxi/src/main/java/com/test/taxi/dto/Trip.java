package com.test.taxi.dto;

public class Trip {
	Point src;
	Point dest;
	long timeTaken;
	long distance;
	String city;
	public Point getSrc() {
		return src;
	}
	public void setSrc(Point src) {
		this.src = src;
	}
	public Point getDest() {
		return dest;
	}
	public void setDest(Point dest) {
		this.dest = dest;
	}
	public long getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
//	public Taxi getTaxi() {
//		return taxi;
//	}
//	public void setTaxi(Taxi taxi) {
//		this.taxi = taxi;
//	}
	
	
	
	

}
