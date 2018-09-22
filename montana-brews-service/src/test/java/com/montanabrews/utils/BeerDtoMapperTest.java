package com.montanabrews.utils;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.util.BeerDtoMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@WebAppConfiguration
public class BeerDtoMapperTest {

	@Autowired
	BeerDtoMapper beerDtoMapper;
	
	@Test
	public void test_mapper_BeerListToBeerListDtos() {
		Beer beerOne = new Beer();
		beerOne.setAbv(1);
		beerOne.setBeerName("BeerNameOne");
		beerOne.setBeerObjId(2);
		BeerDto beerOneDto = beerDtoMapper.beerToBeerDto(beerOne);
		assertTrue(!StringUtils.isBlank(beerOneDto.getBeerName()));
	}

}
