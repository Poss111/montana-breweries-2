package com.montanabrews.daos;

import java.util.List;

import com.montanabrews.entities.Beer;

/**
 * @author Dan Poss
 *
 */
public interface BeerDao {
	
	public List<Beer> retrieveListOfBeers();
	
	public void createMicrobrewRecord(Beer beer);
	
	public void createOrUpdateMicrobrewRecord(Beer beer) throws Exception;

}
