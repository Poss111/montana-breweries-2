package com.montanabrews.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.montanabrews.daos.BeerDao;
import com.montanabrews.dtos.Beer;
import com.montanabrews.services.BeerService;

@Component
public class BeerServiceImpl implements BeerService {
	
	@Autowired
	BeerDao beerDao;
	
	@Override
	public List<Beer> returnAllMicrobrews() {
		return beerDao.retrieveListOfBeers();
	}

	@Override
	public void createMicroBrewRecord(Beer beer) {
		beerDao.createMicrobrewRecord(beer);
	}

}
