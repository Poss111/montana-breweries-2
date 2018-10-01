package com.montanabrews.services;

import java.util.List;

import com.montanabrews.dtos.BreweryDto;
import com.montanabrews.entities.Brewery;

public interface BreweryService {

	public void insertBrewery(BreweryDto breweryDto);
	
	public List<Brewery> listAllBreweries();
	
}
