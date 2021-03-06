package com.montanabrews.controllers;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montanabrews.constants.MontanaBrewsAPIConstants;
import com.montanabrews.constants.MontanaBrewsCommonConstants;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HealthCheckController {

	public static final Logger LOG = LoggerFactory.getLogger(HealthCheckController.class);

	/**
	 * This method is to be used to just display a simple health check if the
	 * microservices are up and running - Daniel
	 * 
	 * @return A simple String stating the service is running.
	 */
	@RequestMapping(value=MontanaBrewsAPIConstants.HEALTHCHECK_API, method=RequestMethod.GET)
	@ApiResponses(value = {
			@ApiResponse(code = HttpStatus.SC_OK, message = MontanaBrewsCommonConstants.MONTANA_BREWS_SERVICE_OK)
	})
	public String healthCheck() {
		LOG.info("Healthcheck Hit");
		return MontanaBrewsCommonConstants.MONTANA_BREWS_SERVICE_OK;
	}
	
}
