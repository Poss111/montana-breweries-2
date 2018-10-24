/**
 * 
 */
package com.montanabrews.constants;

/**
 * @author Daniel Poss
 * This class is to be used to hold all of the named Queries developed.
 */
public class MontanaBrewsQueryConstants {

	public static final String FIND_BEER_RECORD_BY_NAME = "SELECT Beer FROM Beer WHERE BEER_NAME = ?";
	public static final String FIND_BREW_BY_NAME = "Beer.findBrewByName";
	public static final String BEER_TYPE_FIND_BEER_TYPE_BY_NAME = "BeerType.findBeerTypeByName";
	public static final String BREWERY_FIND_BREWERY_BY_NAME_QUERY = "Select b from Brewery b WHERE b.breweryName = :breweryName";
	public static final String BREWERY_FIND_BREWERY_BY_NAME = "Brewery.findBreweryByName";

}
