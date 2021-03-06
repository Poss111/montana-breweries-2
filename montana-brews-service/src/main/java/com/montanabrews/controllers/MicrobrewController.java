package com.montanabrews.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
import com.montanabrews.util.SearchCriteria;

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

    private SimpMessagingTemplate template;
    
    @Autowired
    public MicrobrewController(SimpMessagingTemplate template) {
    	this.template = template;
    }

	/**
	 * This method will return the full list of Microbrew records stored in the
	 * Database - Daniel
	 * 
	 * @return A List of BeerDtos
	 */
	@RequestMapping(value = MontanaBrewsAPIConstants.MICROBREW_LIST_API, method = RequestMethod.POST)
	public List<BeerDto> returnListOfBeer(@RequestBody(required=false) SearchCriteria searchCriteria) throws Exception {
		return beerService.returnAllMicrobrews(searchCriteria).stream().map(record -> beerDtoMapper.beerToBeerDto(record))
				.collect(Collectors.toList());
	}

	/**
	 * This method is to be used to insert a Microbrew Record into the Database
	 * using the expected Json - Daniel
	 * 
	 * @param beerDto
	 * @throws Exception
	 */
	@RequestMapping(value = MontanaBrewsAPIConstants.INSERT_BREW_API, method = RequestMethod.POST)
	public void insertBrewRecord(@RequestBody BeerDto beerDto) throws Exception {
		LOG.info("Record to insert into Database from Controller :: {}", beerDto);
		beerService.insertBrew(beerDto);
		template.convertAndSend("/topic/hello", returnListOfBeer(null));
	}

	/**
	 * This method is to be used to insert a Brewery Record into the Database using
	 * the expected Json - Daniel
	 * 
	 * @param breweryDto
	 * @throws Exception
	 */
	@RequestMapping(value = MontanaBrewsAPIConstants.INSERT_BREWERY_API, method = RequestMethod.POST)
	public void insertBreweryRecord(@Valid @RequestBody BreweryDto breweryDto) throws Exception {
		LOG.info("Record to insert into Database from Controller :: {}", breweryDto);
		breweryService.insertBrewery(breweryDto);
	}

	/**
	 * This method is to be used to list all Breweries available in the Database -
	 * Daniel
	 * 
	 * @return List<BreweryDto>
	 * @throws Exception
	 */
	@RequestMapping(value = MontanaBrewsAPIConstants.BREWERY_LIST_API, method = RequestMethod.POST)
	public List<BreweryDto> listAllBreweries() throws Exception {
		LOG.info("Request to list all Breweries available in Database.");
		return breweryService.listAllBreweries().stream().map(record -> breweryDtoMapper.breweryToBreweryDto(record))
				.collect(Collectors.toList());
	}

}
