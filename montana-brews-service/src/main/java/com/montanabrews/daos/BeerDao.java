package com.montanabrews.daos;

import java.util.List;

import com.montanabrews.entities.Beer;
import com.montanabrews.util.SearchCriteria;

/**
 * @author Dan Poss This Dao class will handle the persistence Layer for the
 *         Beer entity. - Daniel
 */
public interface BeerDao {

	/**
	 * This method will be used to retrieve all Beer records from the persistence
	 * Layer. - Daniel
	 * @param searchCriteria TODO
	 * 
	 * @return a List of Beer records
	 */
	public List<Beer> retrieveListOfBeers(SearchCriteria searchCriteria);

	/**
	 * This method is used to insert a Beer record into the persistence Layer
	 * <b>without</b> validating that the uniqueness constraint. Currently it is Obj
	 * Id and Name. - Daniel
	 * 
	 * @param beer - The Beer record that the user wants to insert.
	 */
	public void createMicrobrewRecord(Beer beer);

	/**
	 * This method is used to insert a Beer record into the persistence Layer
	 * <b>with</b> validating the uniqueness constraint. If the uniqueness
	 * constraint matches then it will update instead.The current constraint is on
	 * Obj Id and/or Beer Name. - Daniel
	 * 
	 * @param beer - The Beer record that the user wants to insert
	 * @throws Exception If the expected Brewery to insert name does not match any
	 *                   in the persistence Layer then throw an excpetion and do not
	 *                   insert.
	 */
	public void createOrUpdateMicrobrewRecord(Beer beer) throws Exception;

}
