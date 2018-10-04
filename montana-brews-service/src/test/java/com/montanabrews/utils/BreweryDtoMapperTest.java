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
		List<Beer> beerList = new ArrayList<Beer>();
		Beer beerOne = new Beer();
		beerOne.setAbv(2.3F);
		beerOne.setBeerName("Beer One");
		beerList.add(beerOne);
		brewery.setMicrobrews(beerList);
		
		BreweryDto breweryDto = breweryDtoMapper.breweryToBreweryDto(brewery);
		
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getBreweryAddress(), brewery.getBreweryAddress()));
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getBreweryName(), brewery.getBreweryName()));
		assertEquals(breweryDto.getZipcode(), brewery.getZipcode());
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getMicrobrews().get(0).getBeerName(), brewery.getMicrobrews().get(0).getBeerName()));
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getMicrobrews().get(0).getAbv(), Float.toString(brewery.getMicrobrews().get(0).getAbv())));
	}
	
	@Test
	public void test_breweryDtoToBrewery_validateThatABreweryDtoObjectIsConvertedToABrewery() {
		BreweryDto breweryDto = new BreweryDto();
		breweryDto.setBreweryName("Berwery One");
		breweryDto.setBreweryAddress("Location Location");
		breweryDto.setZipcode(54321);
		List<BeerDto> beerDtoList = new ArrayList<BeerDto>();
		BeerDto beerDto = new BeerDto();
		beerDto.setAbv("2.3");
		beerDto.setBeerName("Beer One");
		beerDtoList.add(beerDto);
		breweryDto.setMicrobrews(beerDtoList);
		
		Brewery brewery = breweryDtoMapper.breweryDtoToBrewery(breweryDto);
		
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getBreweryAddress(), brewery.getBreweryAddress()));
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getBreweryName(), brewery.getBreweryName()));
		assertEquals(breweryDto.getZipcode(), brewery.getZipcode());
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getMicrobrews().get(0).getBeerName(), brewery.getMicrobrews().get(0).getBeerName()));
		assertTrue(StringUtils.equalsIgnoreCase(breweryDto.getMicrobrews().get(0).getAbv(), Float.toString(brewery.getMicrobrews().get(0).getAbv())));
	}

}
