package com.montanabrews.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.services.BeerService;
import com.montanabrews.util.BeerDtoMapper;

@RestController
public class MicrobrewController {

	@Autowired
	private BeerService beerService;

	@Autowired
	private BeerDtoMapper beerDtoMapper;

	/**
	 * @return
	 */
	@RequestMapping(value = "/microbrewlist", method = RequestMethod.POST)
	public List<BeerDto> returnListOfBeer() {
		return beerService.returnAllMicrobrews().stream().map(record -> beerDtoMapper.beerToBeerDto(record))
				.collect(Collectors.toList());
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/createbeerrecord", method = RequestMethod.POST)
	public void createABeerRecord() {
		Beer beer = new Beer();
		beer.setBeerName("Some Name");
		beerService.createMicroBrewRecord(beer);
	}

	/**
	 * @param beerDto
	 */
	@RequestMapping(value = "/insertbrew", method = RequestMethod.POST)
	public void insertBrewRecord(@RequestBody BeerDto beerDto) {
		beerService.insertBrew(beerDto);
	}

}
