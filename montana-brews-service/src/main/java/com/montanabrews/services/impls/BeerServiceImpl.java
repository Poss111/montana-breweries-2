package com.montanabrews.services.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.montanabrews.daos.BeerDao;
import com.montanabrews.dtos.BeerDto;
import com.montanabrews.entities.Beer;
import com.montanabrews.services.BeerService;
import com.montanabrews.util.BeerDtoMapper;

@Component
public class BeerServiceImpl implements BeerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(BeerServiceImpl.class);
	
	@Autowired
	private BeerDao beerDao;
	
	@Autowired
	private BeerDtoMapper beerMapper;
	
	@Override
	public List<Beer> returnAllMicrobrews() {
		return beerDao.retrieveListOfBeers();
	}

	@Override
	public void insertBrew(BeerDto beerDto) {
		LOG.debug("Montana Brews :: inserting given record ('{}')", beerDto);
		beerDao.createMicrobrewRecord(beerMapper.beerDtoToBeer(beerDto));
	}

}
