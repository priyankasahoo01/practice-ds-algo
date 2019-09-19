package com.test.taxi.dto;

import java.util.Date;

public class User {

	int id;
	UserProfile profile;
	Date lastTravelDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserProfile getProfile() {
		return profile;
	}
	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	public Date getLastTravelDate() {
		return lastTravelDate;
	}
	public void setLastTravelDate(Date lastTravelDate) {
		this.lastTravelDate = lastTravelDate;
	}
	
	
}
