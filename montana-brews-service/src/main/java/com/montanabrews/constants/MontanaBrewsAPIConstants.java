package com.montanabrews.constants;

public class MontanaBrewsAPIConstants {

	/**
	 * The Healthcheck URL to be used to validate that the API is running.
	 */
	public static final String HEALTHCHECK_API = "/healthcheck";
	
	/**
	 * The insert Microbrew URL to be hit for inserting Brew data
	 */
	public static final String INSERT_BREW_API = "/private/insertbrew";
	
	/**
	 * The API to list out all the Microbrew data stored in the database
	 */
	public static final String MICROBREW_LIST_API = "/microbrewlist";
	
	/**
	 * The API Url convention under which the Basic Auth takes affect
	 */
	public static final String PRIVATE_API_FILTER = "/private/**";

	/**
	 * The Error statement to print out if there is an issue
	 */
	public static final String SOMETING_WENT_WRONG = "Someting went wrong...";

	/**
	 * The API Url for inserting a brewery record into the Database
	 */
	public static final String INSERT_BREWERY_API = "/private/insertbrewery";
	
	/**
	 * The API Url for listing all available Breweries in the Database
	 */
	public static final String BREWERY_LIST_API = "/brewerylist";

}
