package com.montanabrews.services;

import java.util.List;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.util.SearchCriteria;

public interface BeerService {

	public List<Beer> returnAllMicrobrews(SearchCriteria searchCriteria);

	public void insertBrew(BeerDto beerDto) throws Exception;
	
}
