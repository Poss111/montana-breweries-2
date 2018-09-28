package com.montanabrews;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;

@RunWith(MockitoJUnitRunner.class)
public class ServletInitializerTest {

	ServletInitializer servletInitializer;
	
	@Mock
	SpringApplicationBuilder mockSpringApplicationBuilder;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		servletInitializer = new ServletInitializer();
	}

	@Test
	public void test_configure_whenMethodIsCalledItReturnsASpringApplicationBuilderInstance() {
		when(mockSpringApplicationBuilder.sources(MontanaBrewsServiceApplication.class)).thenReturn(mockSpringApplicationBuilder);
		servletInitializer.configure(mockSpringApplicationBuilder);
		assertTrue(mockSpringApplicationBuilder instanceof SpringApplicationBuilder);
	}

}
