package com.montanabrews.constants;

public class MontanaBrewsAPIConstants {

	/**
	 * The Healthcheck URL to be used to validate that the API is running.
	 */
	public static final String HEALTHCHECK_API = "/healthcheck";
	
	/**
	 * The insert Microbrew URL to be hit for inserting Brew data
	 */
	public static final String INSERTBREW_API = "/private/insertbrew";
	
	/**
	 * The API to list out all the Microbrew data stored in the database
	 */
	public static final String MICROBREWLIST_API = "/microbrewlist";
	
	/**
	 * The API Url convention under which the Basic Auth takes affect
	 */
	public static final String PRIVATE_API_FILTER = "/private/**";

}
