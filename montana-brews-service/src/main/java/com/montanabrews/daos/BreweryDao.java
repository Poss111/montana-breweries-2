package com.montanabrews.daos;

import java.util.List;

import com.montanabrews.entities.Brewery;

/**
 * @author Dan Poss
 *
 */
public interface BreweryDao {

	/**
	 * This method is used to retrieve all records of Breweries currently inside the
	 * persistence Layer - Daniel
	 * 
	 * @return - A List of Brewery objects
	 */
	public List<Brewery> retrieveListOfBreweries();

	/**
	 * This method is used to insert a Brewery Record into the persistence Layer
	 * <b>without</b> the uniqueness constraint. The current uniqueness constraint
	 * is on Obj Id or Brewery Name. - Daniel
	 * 
	 * @param brewery - The Brewery object to insert into the persistence Layer.
	 */
	public void createBreweryRecord(Brewery brewery);

	/**
	 * This method is used to insert a Brewery Record into the persistence Layer
	 * <b>with</b> the uniqueness constraint. It will update the record if the
	 * uniqueness constraints match. The current uniqueness constraint is on Obj Id
	 * or Brewery Name. - Daniel
	 * 
	 * @param brewery - the Brewery object to insert into the persistence Layer.
	 */
	public void createOrUpdateBreweryRecord(Brewery brewery);

}
