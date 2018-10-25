package com.montanabrews.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.dtos.BreweryDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.entities.Brewery;
import com.montanabrews.util.BreweryDtoMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
public class BreweryDtoMapperTest {
	
	@Autowired
	private BreweryDtoMapper breweryDtoMapper;

	@Test
	public void test_breweryToBreweryDto_validateThatABreweryObjectIsConvertedToABreweryDto() {
		Brewery brewery = new Brewery();
		brewery.setBreweryName("Berwery One");
		brewery.setBreweryAddress("Location Location");
		brewery.setZipcode(54321);
		
		BreweryDto breweryDto = breweryDtoMapper.breweryToBreweryDto(brewery);
		
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getBreweryAddress(), brewery.getBreweryAddress()));
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getBreweryName(), brewery.getBreweryName()));
		assertEquals(breweryDto.getZipcode(), brewery.getZipcode());
	}
	
	@Test
	public void test_breweryDtoToBrewery_validateThatABreweryDtoObjectIsConvertedToABrewery() {
		BreweryDto breweryDto = new BreweryDto();
		breweryDto.setBreweryName("Berwery One");
		breweryDto.setBreweryAddress("Location Location");
		breweryDto.setZipcode(54321);
		
		Brewery brewery = breweryDtoMapper.breweryDtoToBrewery(breweryDto);
		
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getBreweryAddress(), brewery.getBreweryAddress()));
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getBreweryName(), brewery.getBreweryName()));
		assertEquals(breweryDto.getZipcode(), brewery.getZipcode());
	}

}
