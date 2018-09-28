package com.montanabrews.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.services.BeerService;
import com.montanabrews.util.BeerDtoMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@Transactional(propagation = Propagation.REQUIRED)
public class MicrobrewControllerTest {

	@InjectMocks
	MicrobrewController microbrewController;
	
	@Mock
	BeerService mockBeerService;
	
	@Mock
	BeerDtoMapper mockBeerDtoMapper;
	
	@Autowired
	BeerDtoMapper beerDtoMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_returnListOfBeer_validateThatMethodReturnsListOfBeerDtoWhenEmpty() throws Exception {
		List<Beer> beerListToBeMapped = new ArrayList<>();
		when(mockBeerService.returnAllMicrobrews()).thenReturn(beerListToBeMapped);
		List<BeerDto> beerListToReturn = microbrewController.returnListOfBeer();
		assertNotNull(beerListToReturn);
	}
	
	@Test
	public void test_returnListOfBeer_validateThatMethodReturnsListOfBeerDtoWhenAValueIsReturned() throws Exception {
		List<Beer> beerListToBeMapped = new ArrayList<>();
		Beer beerOne = new Beer();
		beerOne.setBeerName("BeerOne");
		beerOne.setAbv(1.2F);
		beerListToBeMapped.add(beerOne);
		List<BeerDto> expectedBeerDtoList = beerListToBeMapped.stream().map(record -> beerDtoMapper.beerToBeerDto(record)).collect(Collectors.toList());
		when(mockBeerService.returnAllMicrobrews()).thenReturn(beerListToBeMapped);		
		when(mockBeerDtoMapper.beerToBeerDto(beerOne)).thenReturn(beerDtoMapper.beerToBeerDto(beerOne));
		List<BeerDto> actualBeerDtoList = microbrewController.returnListOfBeer();
		assertNotNull(actualBeerDtoList);
		assertEquals(expectedBeerDtoList,actualBeerDtoList);
	}
	
	@Test
	public void test_insertBrewRecord_validateThatMethodTakesInAndCallsInsertMethodFromBeerService() throws Exception {
		BeerDto beerDtoToInsert = new BeerDto();
		beerDtoToInsert.setAbv("1.2");
		beerDtoToInsert.setBeerName("BeerOne");
		microbrewController.insertBrewRecord(beerDtoToInsert);
		verify(mockBeerService, times(1)).insertBrew(beerDtoToInsert);
	}

}
