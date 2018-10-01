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

import com.montanabrews.constants.MontanaBrewsAPIConstants;
import com.montanabrews.dtos.BeerDto;
import com.montanabrews.dtos.BreweryDto;
import com.montanabrews.services.BeerService;
import com.montanabrews.services.BreweryService;
import com.montanabrews.util.BeerDtoMapper;
import com.montanabrews.util.BreweryDtoMapper;

@RestController
public class MicrobrewController {

	public static final Logger LOG = LoggerFactory.getLogger(MicrobrewController.class);	

	@Autowired
	private BeerService beerService;
	
	@Autowired
	private BreweryService breweryService;

	@Autowired
	private BeerDtoMapper beerDtoMapper;
	
	@Autowired
	private BreweryDtoMapper breweryDtoMapper;

	/**
	 * This method will return the full list of Microbrew records stored in the
	 * Database - Daniel
	 * 
	 * @return A List of BeerDtos
	 */
	@RequestMapping(value = MontanaBrewsAPIConstants.MICROBREWLIST_API, method = RequestMethod.POST)
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
	@RequestMapping(value = MontanaBrewsAPIConstants.INSERTBREW_API, method = RequestMethod.POST)
	public void insertBrewRecord(@RequestBody BeerDto beerDto) throws Exception {
		LOG.info("Record to insert into Database from Controller :: {}", beerDto);
		beerService.insertBrew(beerDto);
	}
	
	@RequestMapping(value = MontanaBrewsAPIConstants.INSERT_BREWERY_API, method = RequestMethod.POST)
	public void insertBreweryRecord(@RequestBody BreweryDto breweryDto) throws Exception {
		LOG.info("Record to insert into Database from Controller :: {}", breweryDto);
		breweryService.insertBrewery(breweryDtoMapper.breweryDtoToBrewery(breweryDto));
	}

}
