/**
 * 
 */
package com.montanabrews.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.montanabrews.dtos.BreweryDto;
import com.montanabrews.entities.Brewery;

/**
 * @author Dan Poss
 *
 */
@Component
public class BreweryDtoMapper {

	@Autowired
	ModelMapper modelMapper;

	public BreweryDto breweryToBreweryDto(Brewery brewery) {
		return modelMapper.map(brewery, BreweryDto.class);
	}
	
	public Brewery breweryDtoToBrewery(BreweryDto breweryDto) {
 		return modelMapper.map(breweryDto, Brewery.class);
	}
	
}
