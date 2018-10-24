package com.montanabrews.util;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.entities.BeerType;
import com.montanabrews.entities.Brewery;

@Component
public class BeerDtoMapper {	
	
	@Autowired
	ModelMapper modelMapper;

	public BeerDto beerToBeerDto(Beer beer) {
		Converter<Brewery, String> fromBreweryToString = new AbstractConverter<Brewery, String>() {
			protected String convert(Brewery breweryToReturn) {
				return breweryToReturn.getBreweryName();
			}
		};		
		modelMapper.addConverter(fromBreweryToString);
		return modelMapper.map(beer, BeerDto.class);
	}
	
	public Beer beerDtoToBeer(BeerDto beerDto) {
		Converter<String, Float> toFloatFromStringConverter = new AbstractConverter<String, Float>() {
			protected Float convert(String dtoAbv) {
				return dtoAbv == null ? 0F : Float.parseFloat(dtoAbv);
			}
		};
		Converter<String, BeerType> toBeerTypeFromString = new AbstractConverter<String, BeerType>() {
			protected BeerType convert(String dtoBeerType) {
				BeerType beerType = new BeerType();
				beerType.setBeerTypeNme(dtoBeerType);
				return beerType;
			}
		};
		Converter<String, Brewery> toBreweryFromString = new AbstractConverter<String, Brewery>() {
			protected Brewery convert(String dtoBreweryName) {
				Brewery brewery = new Brewery();
				brewery.setBreweryName(dtoBreweryName);
				return brewery;
			}
		};
		modelMapper.addConverter(toFloatFromStringConverter);
		modelMapper.addConverter(toBeerTypeFromString);
		modelMapper.addConverter(toBreweryFromString);
 		return modelMapper.map(beerDto, Beer.class);
	}
	
}
