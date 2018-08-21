package com.montanabrews.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	public static final Logger LOG = LoggerFactory.getLogger(HealthCheckController.class);
	
	@RequestMapping(value="/healthcheck", method=RequestMethod.GET)
	public String healthCheck() {
		LOG.info("Healthcheck Hit");
		return "Montana-Brews Service OK";
	}
	
}
