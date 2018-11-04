package com.montanabrews.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.daos.BeerDao;
import com.montanabrews.daos.BreweryDao;
import com.montanabrews.entities.Beer;
import com.montanabrews.entities.BeerType;
import com.montanabrews.entities.Brewery;
import com.montanabrews.repositories.BeerRepository;
import com.montanabrews.specifications.impl.BeerSpecification;
import com.montanabrews.util.SearchCriteria;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@WebAppConfiguration
public class SpecificationTest {
		
	@Autowired
	BeerDao beerDao;
	
	@Autowired
	BreweryDao breweryDao;
	
	@Autowired
	BeerRepository beerRepository;
	
	@Test
	@Transactional
	@Rollback(true)
	public void test() throws Exception {
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
		
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setKey("beerName");
		searchCriteria.setOperation(":");
		searchCriteria.setValue("BeerOne");
		BeerSpecification beerSpecification = new BeerSpecification(searchCriteria);
		
		List<Beer> foundBeer = beerRepository.findAll(beerSpecification);
		
		expectedInsertedBeer.remove(beerTwoToInsert);
		expectedInsertedBeer.remove(beerThreeToInsert);
		assertEquals(foundBeer, expectedInsertedBeer);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void test_two() throws Exception {
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
		
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setKey("brewery");
		searchCriteria.setOperation("^");
		SearchCriteria insideSearchCriteria = new SearchCriteria();
		insideSearchCriteria.setKey("breweryName");
		insideSearchCriteria.setOperation(":");
		insideSearchCriteria.setValue("BreweryOne");
		searchCriteria.setSearchCriteria(insideSearchCriteria);
		BeerSpecification beerSpecification = new BeerSpecification(searchCriteria);
		
		List<Beer> foundBeer = beerRepository.findAll(beerSpecification);
		
		assertTrue(foundBeer.contains(beerOneToInsert));
	}

}
