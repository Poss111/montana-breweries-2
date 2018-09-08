package com.montanabrews.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;

@Mapper(componentModel="spring")
public interface BeerDtoMapper {
	
	@Mapping(target = "")
	BeerDto beerToBeerDto(Beer beer);
	
	@Mapping(target = "")
	List<BeerDto> beersToBeerDtos(List<Beer> beer);
	
}
