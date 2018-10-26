package com.montanabrews.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.daos.BreweryDao;
import com.montanabrews.dtos.BreweryDto;
import com.montanabrews.entities.Brewery;
import com.montanabrews.services.impls.BreweryServiceImpl;
import com.montanabrews.util.BreweryDtoMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@Transactional(propagation = Propagation.REQUIRED)
public class BreweryServiceTest {
	
	@InjectMocks
	BreweryService breweryService = new BreweryServiceImpl();
	
	@Mock
	private BreweryDao mockBreweryDao;
	
	@Mock
	private BreweryDtoMapper mockBreweryDtoMapper;
	
	@Autowired
	private BreweryDtoMapper breweryDtoMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);	
	}
	
	@Test
	public void  test_insertBrewery_validateThatTheServiceConvertsTheBerweryDtoIntoBreweryAndCallsInsert() {
		BreweryDto breweryDtoToInsert = new BreweryDto();
		breweryDtoToInsert.setBreweryName("Brewery One");
		breweryDtoToInsert.setBreweryAddress("Location Location");
		breweryDtoToInsert.setZipcode(12345);
		Brewery convertedBrewery = breweryDtoMapper.breweryDtoToBrewery(breweryDtoToInsert);
		when(mockBreweryDtoMapper.breweryDtoToBrewery(breweryDtoToInsert)).thenReturn(convertedBrewery);
		breweryService.insertBrewery(breweryDtoToInsert);
		verify(mockBreweryDao,times(1)).createOrUpdateBreweryRecord(convertedBrewery);
	}
	
	@Test
	public void test_listAllBreweries_validateThatAListOfBreweriesAreReturned() {
		List<Brewery> expectedBreweryList = new ArrayList<>();
		when(mockBreweryDao.retrieveListOfBreweries()).thenReturn(expectedBreweryList);
		List<Brewery> actualBreweryList = breweryService.listAllBreweries();
		assertTrue(CollectionUtils.isEqualCollection(expectedBreweryList, actualBreweryList));
	}

}
