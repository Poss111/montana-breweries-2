package com.montanabrews.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	public static final Logger LOG = LoggerFactory.getLogger(MicrobrewController.class);	

	@Autowired
	private BeerService beerService;

	@Autowired
	private BeerDtoMapper beerDtoMapper;

	/**
	 * This method will return the full list of Microbrew records stored in the
	 * Database - Daniel
	 * 
	 * @return A List of BeerDtos
	 */
	@RequestMapping(value = "/microbrewlist", method = RequestMethod.POST)
	public List<BeerDto> returnListOfBeer() throws Exception {
		return beerService.returnAllMicrobrews().stream().map(record -> beerDtoMapper.beerToBeerDto(record))
				.collect(Collectors.toList());
	}

	/**
	 * This method is to be used to insert a Microbrew Record into the Database
	 * using the expected Json - Daniel
	 * 
	 * @param beerDto
	 * @throws Exception 
	 */
	@RequestMapping(value = "/private/insertbrew", method = RequestMethod.POST)
	public void insertBrewRecord(@RequestBody BeerDto beerDto) throws Exception {
		LOG.info("Record to insert into Database from Controller :: {}", beerDto);
		beerService.insertBrew(beerDto);
	}

}
