package com.montanabrews.daos;

import java.util.List;

import com.montanabrews.entities.Beer;

public interface BeerDao {
	
	public List<Beer> retrieveListOfBeers();
	
	public void createMicrobrewRecord(Beer beerRecord);

}
