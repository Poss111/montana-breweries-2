package com.montanabrews.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;

@Mapper
public interface BeerDtoMapper {

	BeerDtoMapper INSTANCE = Mappers.getMapper(BeerDtoMapper.class);
	
	@Mapping(target = "")
	BeerDto beerToBeerDto(Beer beer);
	
}
