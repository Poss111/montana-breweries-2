/**
 * 
 */
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

import com.montanabrews.entities.Brewery;

/**
 * @author Dan Poss
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@WebAppConfiguration
public class BreweryDaoTest {
	
	@Autowired
	BreweryDao breweryDao;

	@Test
	@Transactional
	@Rollback(true)
	public void test_retrieveListOfBreweries_validateThatMethodReturnsANonNullList() {
		List<Brewery> breweriesAvailable = breweryDao.retrieveListOfBreweries();
		assertNotNull(breweriesAvailable);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void test_retrieveListOfBreweries_validateThatMethodReturnsExpectedListOfBreweriesWhenCalled() {
		List<Brewery> listOfBreweriesToInsert = new ArrayList<>();
		Brewery breweryOne = new Brewery();
		breweryOne.setBreweryName("Brewery One");
		breweryOne.setBreweryAddress("Location One");
		breweryOne.setZipcode(12345);
		Brewery breweryTwo = new Brewery();
		breweryTwo.setBreweryName("Brewery Two");
		breweryTwo.setBreweryAddress("Location Two");
		breweryTwo.setZipcode(23456);
		Brewery breweryThree = new Brewery();
		breweryThree.setBreweryName("Brewery Three");
		breweryThree.setBreweryAddress("Location Three");
		breweryThree.setZipcode(34567);
		listOfBreweriesToInsert.add(breweryOne);
		listOfBreweriesToInsert.add(breweryTwo);
		listOfBreweriesToInsert.add(breweryThree);
		
		for (Brewery breweryToInsert : listOfBreweriesToInsert) {
			breweryDao.createBreweryRecord(breweryToInsert);
		}
		
		List<Brewery> actualBreweriesInserted = breweryDao.retrieveListOfBreweries();
		
		assertEquals(listOfBreweriesToInsert, actualBreweriesInserted);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void test_createOrUpdateBreweryRecord_validateThatMethodReturnsExpectedListOfBreweriesWhenCalled() {
		List<Brewery> listOfBreweriesToInsert = new ArrayList<>();
		Brewery breweryOne = new Brewery();
		breweryOne.setBreweryName("Brewery One");
		breweryOne.setBreweryAddress("Location One");
		breweryOne.setZipcode(12345);
		Brewery breweryTwo = new Brewery();
		breweryTwo.setBreweryName("Brewery Two");
		breweryTwo.setBreweryAddress("Location Two");
		breweryTwo.setZipcode(23456);
		Brewery breweryThree = new Brewery();
		breweryThree.setBreweryName("Brewery Three");
		breweryThree.setBreweryAddress("Location Three");
		breweryThree.setZipcode(34567);
		listOfBreweriesToInsert.add(breweryOne);
		listOfBreweriesToInsert.add(breweryTwo);
		listOfBreweriesToInsert.add(breweryThree);
		
		for (Brewery breweryToInsert : listOfBreweriesToInsert) {
			breweryDao.createOrUpdateBreweryRecord(breweryToInsert);
		}
		
		List<Brewery> actualBreweriesInserted = breweryDao.retrieveListOfBreweries();
		
		assertEquals(listOfBreweriesToInsert, actualBreweriesInserted);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void test_createBreweryRecord_validateThatBreweryRecordIsUpdatedIfBreweryNameMatchesRequestedInserted() {
		List<Brewery> breweriesToInsert = new ArrayList<>();
		Brewery uniqueBreweryToInsert = new Brewery();
		uniqueBreweryToInsert.setBreweryName("BreweryOne");
		uniqueBreweryToInsert.setBreweryAddress("Location");
		uniqueBreweryToInsert.setRating(0);
		uniqueBreweryToInsert.setTown("Towny");
		uniqueBreweryToInsert.setState("TX");
		uniqueBreweryToInsert.setZipcode(12345);
		Brewery uniqueBreweryTwoToInsert = new Brewery();
		uniqueBreweryTwoToInsert.setBreweryName("BreweryOne");
		uniqueBreweryTwoToInsert.setBreweryAddress("Location Special");
		uniqueBreweryTwoToInsert.setRating(2);
		uniqueBreweryTwoToInsert.setTown("Dallas");
		uniqueBreweryTwoToInsert.setState("AL");
		uniqueBreweryTwoToInsert.setZipcode(54321);
		breweriesToInsert.add(uniqueBreweryToInsert);
		breweriesToInsert.add(uniqueBreweryTwoToInsert);
		
		for (Brewery breweryToInsert : breweriesToInsert) 
			breweryDao.createOrUpdateBreweryRecord(breweryToInsert);
		
		breweriesToInsert.remove(0);
		
		List<Brewery> actualBreweriesInsert = breweryDao.retrieveListOfBreweries();
	
		assertEquals(breweriesToInsert,actualBreweriesInsert);
	}

}
