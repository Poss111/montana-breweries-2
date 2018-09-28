package com.montanabrews.exceptionhandlers;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.WebRequest;

import com.montanabrews.constants.MontanaBrewsAPIConstants;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
public class GlobalExceptionHandlerTest {

	@Autowired
	GlobalExceptionHandler globalExceptionHandler;
	
	@Mock
	WebRequest mockWebRequest;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_globalHandler_returnsInternalServerErrorWhenCalled() {
		doNothing().when(mockWebRequest).setAttribute(Matchers.anyString(),Matchers.any(),Matchers.anyInt());
		ResponseEntity<Object> actualResponseEntity = globalExceptionHandler.globalHandler(new Exception("Sample Exception"), mockWebRequest);
		assertTrue(actualResponseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		assertTrue(MontanaBrewsAPIConstants.SOMETING_WENT_WRONG.equals(actualResponseEntity.getBody().toString()));
	}

}
