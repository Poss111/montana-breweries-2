/**
 * 
 */
package com.montanabrews.util;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.dtos.BreweryDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.entities.Brewery;

/**
 * @author Dan Poss
 *
 */
@Component
public class BreweryDtoMapper {
	
	private static final Logger LOG = LoggerFactory.getLogger(BreweryDtoMapper.class);

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	BeerDtoMapper beerDtoMapper;

	public BreweryDto breweryToBreweryDto(Brewery brewery) {
		return modelMapper.map(brewery, BreweryDto.class);
	}
	
	public Brewery breweryDtoToBrewery(BreweryDto breweryDto) {
		return modelMapper.map(breweryDto, Brewery.class);
	}
	
}
