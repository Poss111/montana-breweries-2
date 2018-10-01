package com.montanabrews.services;

import java.util.List;

import com.montanabrews.entities.Brewery;

public interface BreweryService {

	public void insertBrewery(Brewery brewery);
	
	public List<Brewery> listAllBreweries();
	
}
