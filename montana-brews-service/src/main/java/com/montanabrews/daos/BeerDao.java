package com.montanabrews.daos;

import java.util.List;

import com.montanabrews.dtos.Beer;

public interface BeerDao {
	
	public List<Beer> retrieveListOfBeers();
	
	public void createMicrobrewRecord(Beer beerRecord);

}
