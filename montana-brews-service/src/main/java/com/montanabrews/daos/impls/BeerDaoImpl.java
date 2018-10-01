package com.montanabrews.daos.impls;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.daos.BeerDao;
import com.montanabrews.daos.MontanaBrewsBaseDao;
import com.montanabrews.entities.Beer;

@Repository
@Transactional
public class BeerDaoImpl extends MontanaBrewsBaseDao<Beer> implements BeerDao {
	
	@Override
	public List<Beer> retrieveListOfBeers() {
		this.setClassy(Beer.class);
		return this.findAll();
	}

	@Override
	public void createMicrobrewRecord(Beer beer) {
		this.setClassy(Beer.class);
		create(beer);
	}

}
