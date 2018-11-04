package com.montanabrews.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

import com.montanabrews.daos.BeerDao;
import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.services.impls.BeerServiceImpl;
import com.montanabrews.util.BeerDtoMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@Transactional(propagation = Propagation.REQUIRED)
public class BeerServiceTest {
	
	@InjectMocks
	BeerService beerService = new BeerServiceImpl();
	
	@Mock
	private BeerDao beerDao;
	
	@Mock
	private BeerDtoMapper mockBeerMapper;
	
	@Autowired
	private BeerDtoMapper beerMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);	
	}

	@Test
	public void test_returnAllMicrobrews_validateThatMethodReturnsANonNullListOfBeer() {
		List<Beer> testListOfBeer = new ArrayList<>();
		when(beerDao.retrieveListOfBeers(null)).thenReturn(testListOfBeer);
		List<Beer> actualListOfBeer = beerService.returnAllMicrobrews(null);
		assertEquals(testListOfBeer,actualListOfBeer);
	}
	
	@Test
	public void test_insertBrew_validateThatcreateMicrobrewRecordIsCalledOnceWithGivenBeerDtoRecord() throws Exception {
		BeerDto beerDtoToInsert = new BeerDto();
		Beer convertedBeerToInsert = beerMapper.beerDtoToBeer(beerDtoToInsert);
		when(mockBeerMapper.beerDtoToBeer(beerDtoToInsert)).thenReturn(convertedBeerToInsert);
		beerService.insertBrew(beerDtoToInsert);
		verify(beerDao,times(1)).createOrUpdateMicrobrewRecord(convertedBeerToInsert);
	}

}
