package com.montanabrews.daos;

import java.util.List;

import com.montanabrews.entities.Brewery;

/**
 * @author Dan Poss
 *
 */
public interface BreweryDao {

	public List<Brewery> retrieveListOfBreweries();
	
	public void createBreweryRecord(Brewery brewery);
	
	public void createOrUpdateBreweryRecord(Brewery brewery);
	
}
