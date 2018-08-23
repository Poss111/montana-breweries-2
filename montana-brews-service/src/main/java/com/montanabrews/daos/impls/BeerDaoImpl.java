package com.montanabrews.daos.impls;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.daos.BeerDao;
import com.montanabrews.daos.MontanaBrewsBaseDao;
import com.montanabrews.dtos.Beer;

@Repository
@Transactional
public class BeerDaoImpl extends MontanaBrewsBaseDao<Beer> implements BeerDao {
	
	@Override
	public List<Beer> retrieveListOfBeers() {
		return findAll();
	}

	@Override
	public void createMicrobrewRecord(Beer beerRecord) {
		create(beerRecord);
	}

}
