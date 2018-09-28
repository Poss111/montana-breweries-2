package com.montanabrews.configuration;

import static org.junit.Assert.*;

import org.junit.Test;

import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfigTest {
	
	SwaggerConfig swaggerConfig = new SwaggerConfig();

	@Test
	public void test_api_validateDocketApiIsNotNullOnReturn() {
		Docket api = swaggerConfig.api();
		assertNotNull(api);
	}

}
