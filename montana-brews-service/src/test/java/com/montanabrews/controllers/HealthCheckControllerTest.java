package com.montanabrews.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.montanabrews.constants.MontanaBrewsCommonConstants;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@WebAppConfiguration
public class HealthCheckControllerTest {

	@Autowired
	private HealthCheckController healthCheckController;
	
	@Test
	public void test_validateHealthCheckMessage() {
		assertEquals(MontanaBrewsCommonConstants.MONTANA_BREWS_SERVICE_OK,healthCheckController.healthCheck());
	}

}
