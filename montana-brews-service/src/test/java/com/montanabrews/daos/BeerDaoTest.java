package com.montanabrews.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@WebAppConfiguration
public class BeerDaoTest {
	
	@Autowired
	BeerDao beerDao;

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

}
