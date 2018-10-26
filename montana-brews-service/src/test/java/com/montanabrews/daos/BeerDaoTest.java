package com.montanabrews.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.entities.Beer;
import com.montanabrews.entities.BeerType;
import com.montanabrews.entities.Brewery;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@WebAppConfiguration
public class BeerDaoTest {
	
	@Autowired
	BeerDao beerDao;
	
	@Autowired
	BreweryDao breweryDao;

	@Test
	@Transactional
	@Rollback(true)
	public void test_retrieveListOfBeers_validateThatMethodReturnsANonNullListOfBeerEntities() {
		List<Beer> listOfBeerFromDB = beerDao.retrieveListOfBeers();
		assertNotNull(listOfBeerFromDB);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void test_retrieveListOfBeers_validateThatMethodReturnsAListOfBeerEntities() {
		List<Beer> expectedInsertedBeer = new ArrayList<>();
		Beer beerOneToInsert = new Beer();
		beerOneToInsert.setAbv(0F);
		beerOneToInsert.setBeerName("BeerOne");
		expectedInsertedBeer.add(beerOneToInsert);		
		Beer beerTwoToInsert = new Beer();
		beerTwoToInsert.setAbv(0F);
		beerTwoToInsert.setBeerName("BeerTwo");	
		expectedInsertedBeer.add(beerTwoToInsert);		
		Beer beerThreeToInsert = new Beer();
		beerThreeToInsert.setAbv(0F);
		beerThreeToInsert.setBeerName("BeerThree");
		expectedInsertedBeer.add(beerThreeToInsert);	
		beerDao.createMicrobrewRecord(beerOneToInsert);
		beerDao.createMicrobrewRecord(beerTwoToInsert);
		beerDao.createMicrobrewRecord(beerThreeToInsert);
		List<Beer> listOfBeerFromDB = beerDao.retrieveListOfBeers();
		assertEquals(expectedInsertedBeer, listOfBeerFromDB);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void test_createOrUpdateMicrobrewRecord_validateThatMethodReturnsAListOfBeerEntities() throws Exception {
		List<Beer> expectedInsertedBeer = new ArrayList<>();
		Beer beerOneToInsert = new Beer();
		beerOneToInsert.setAbv(0F);
		beerOneToInsert.setBeerName("BeerOne");	
		Beer beerTwoToInsert = new Beer();
		beerTwoToInsert.setAbv(0F);
		beerTwoToInsert.setBeerName("BeerTwo");		
		Beer beerThreeToInsert = new Beer();
		beerThreeToInsert.setAbv(0F);
		beerThreeToInsert.setBeerName("BeerThree");
		expectedInsertedBeer.add(beerOneToInsert);	
		expectedInsertedBeer.add(beerTwoToInsert);	
		expectedInsertedBeer.add(beerThreeToInsert);	

		for (Beer beerToInsert : expectedInsertedBeer) {
			beerDao.createOrUpdateMicrobrewRecord(beerToInsert);
		}
		List<Beer> listOfBeerFromDB = beerDao.retrieveListOfBeers();
		assertEquals(expectedInsertedBeer, listOfBeerFromDB);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void test_createOrUpdateMicrobrewRecord_validateThatItUpdatesTheRecordIfTheNameMatches() throws Exception {
		List<Beer> expectedInsertedBeer = new ArrayList<>();
		Brewery brewery = new Brewery();
		brewery.setBreweryName("BreweryOne");
		
		breweryDao.createBreweryRecord(brewery);
		
		BeerType beerType = new BeerType();
		beerType.setBeerTypeNme("Test Beer Type");
		BeerType updatedBeerType = new BeerType();
		beerType.setBeerTypeNme("Test Updated Type");
		
		Beer beerOneToInsert = new Beer();
		beerOneToInsert.setAbv(0F);
		beerOneToInsert.setBeerName("BeerOne");
		beerOneToInsert.setBeerType(beerType);
		beerOneToInsert.setRating(0);
		Beer beerTwoToInsert = new Beer();
		beerTwoToInsert.setAbv(0F);
		beerTwoToInsert.setBeerName("BeerOne");	
		beerTwoToInsert.setBeerType(updatedBeerType);
		beerTwoToInsert.setRating(2);
		beerTwoToInsert.setBrewery(brewery);
		expectedInsertedBeer.add(beerOneToInsert);		
		expectedInsertedBeer.add(beerTwoToInsert);		
		
		for (Beer beerToInsert : expectedInsertedBeer) {
			beerDao.createOrUpdateMicrobrewRecord(beerToInsert);
		}
		
		expectedInsertedBeer.remove(0);
		
		List<Beer> actualInsertedBeerList = beerDao.retrieveListOfBeers();
		assertEquals(expectedInsertedBeer,actualInsertedBeerList);			
	}
	
	/**
	 * TODO: Refactor to use annotation expected for Exception - Daniel
	 */
	@Test
	@Transactional
	@Rollback(true)
	public void test_createOrUpdateMicrobrewRecord_validateThatTheMethodThrowsAnExceptionIfTheRequestedBreweryToAssociateDoesNotMatch() {
		Brewery brewery = new Brewery();
		brewery.setBreweryName("BreweryOne");
		
		Beer beerOneToInsert = new Beer();
		beerOneToInsert.setAbv(0F);
		beerOneToInsert.setBeerName("BeerOne");
		beerOneToInsert.setRating(0);
		beerOneToInsert.setBrewery(brewery);
		
		boolean exceptionThrown = false;
		try {
			beerDao.createOrUpdateMicrobrewRecord(beerOneToInsert);
		} catch(Exception error) {
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}
	
}