package com.test.taxi.service;

import java.util.HashMap;
import java.util.Map;

import com.test.taxi.exception.CityNotRegisteredException;

public class VehiclePools {
	
	private static VehiclePools service = null;
	
	public static VehiclePools getInstance() {
		if(service == null) {
			synchronized (VehiclePools.class) {
				if(service == null) {
					service = new VehiclePools();
				}
			}
		}
		return service;
	}
	
	private VehiclePools() {
		// TODO Auto-generated constructor stub
	}
	
	Map<String, VehiclePoolMaps> map = new HashMap<>();
	

	public VehiclePoolMaps getVehiclePoolMaps(String city) throws CityNotRegisteredException {
		VehiclePoolMaps vehPoolMap = map.get(city);
		if(vehPoolMap == null) {
			throw new CityNotRegisteredException("City is not registered in the cab booking system");
		}
		return vehPoolMap;
	}
	
	
	public void registerCity(String city, VehiclePoolMaps vehiclePoolMaps) throws CityAlreadyRegisteredException {
		if(map.get(city) != null) {
			throw new CityAlreadyRegisteredException("City is already registered in the cab booking system");
		}
		map.put(city, vehiclePoolMaps);
	}
}
