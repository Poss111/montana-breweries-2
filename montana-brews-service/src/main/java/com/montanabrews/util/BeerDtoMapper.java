package com.montanabrews.util;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
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
		Converter<String, Float> toFloatFromStringConverter = new AbstractConverter<String, Float>() {
			protected Float convert(String dtoAbv) {
				return dtoAbv == null ? 0F : Float.parseFloat(dtoAbv);
			}
		};
		modelMapper.addConverter(toFloatFromStringConverter);
 		return modelMapper.map(beerDto, Beer.class);
	}
	
}
