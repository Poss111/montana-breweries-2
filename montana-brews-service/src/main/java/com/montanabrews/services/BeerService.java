package com.montanabrews.services;

import java.util.List;

import com.montanabrews.dtos.Beer;

public interface BeerService {

	public List<Beer> returnAllMicrobrews();

	public void createMicroBrewRecord(Beer beer);
	
}
