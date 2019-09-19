package com.test.taxi.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.test.taxi.dto.Taxi;
import com.test.taxi.dto.TaxiType;

public class VehiclePoolMaps {
	
	private static VehiclePoolMaps poolMap = null;
	
	public VehiclePoolMaps getInstance() {
		if(poolMap == null) {
			synchronized (VehiclePoolMaps.class) {
				if(poolMap == null) {
					poolMap = new VehiclePoolMaps();
				}
			}
		}
		return poolMap;
	}
	
	private VehiclePoolMaps() {
		map = new HashMap<>();
	}
	
	private Map<TaxiType, BlockingQueue<Taxi>> map = null;
	
	
	public boolean addTaxi(Taxi taxi) {
		BlockingQueue<Taxi> q = map.get(taxi.getTaxiType());
		synchronized (this) {
			if(q == null) {
				q = new LinkedBlockingQueue<>();
			}
		}
		return q.offer(taxi);
	}
	
	
	public Taxi getTaxi(Taxi taxi) throws TaxiNotAvailableException {
		BlockingQueue<Taxi> q = map.get(taxi.getTaxiType());
		if(q == null || q.isEmpty()) {
			throw new TaxiNotAvailableException("Taxi of category "+taxi.getTaxiType()+" is not available");
		}
		return q.poll();
	}
	
	
	

}
