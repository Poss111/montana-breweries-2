package com.montanabrews.services;

import java.util.List;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;

public interface BeerService {

	public List<Beer> returnAllMicrobrews();

	public void insertBrew(BeerDto beerDto);
	
}
