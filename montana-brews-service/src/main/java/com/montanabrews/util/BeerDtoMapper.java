package com.montanabrews.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;

@Component
public class BeerDtoMapper {
	
	@Autowired
	ModelMapper modelMapper;

	public BeerDto beerToBeerDto(Beer beer) {
		BeerDto beerDto = modelMapper.map(beer, BeerDto.class); 
		return beerDto;
	}
	
	public Beer beerDtoToBeer(BeerDto beerDto) {
		return modelMapper.map(beerDto, Beer.class);
	}
	
}
