package com.montanabrews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.services.BeerService;

@RestController
public class MicrobrewController {

	@Autowired
	BeerService beerService;
	
	@RequestMapping(value="/microbrewlist", method=RequestMethod.POST)
	public List<Beer> returnListOfBeer() {
		return beerService.returnAllMicrobrews();
	}
	
	@RequestMapping(value="/createbeerrecord", method=RequestMethod.POST)
	public void createABeerRecord() {
		Beer beer = new Beer();
		beer.setBeerName("Some Name");
		beerService.createMicroBrewRecord(beer);
	}
	
	@RequestMapping(value="/insertbrew", method=RequestMethod.POST)
	public void insertBrewRecord(BeerDto beerDto) {
		beerService.insertBrew(beerDto);
	}
	
}