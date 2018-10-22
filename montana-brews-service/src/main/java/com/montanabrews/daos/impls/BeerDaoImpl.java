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
		setClassy(Beer.class);
		return this.findAll();
	}

	@Override
	public void createMicrobrewRecord(Beer beer) {
		setClassy(Beer.class);
		create(beer);
	}

	@Override
	public void createOrUpdateMicrobrewRecord(Beer beer) {
		setClassy(Beer.class);
		List<Beer> existingBeerRecords = findAll();
		Beer foundBeer = existingBeerRecords
		.stream()
		.filter(record -> record.equals(beer))
		.findFirst()
		.orElse(beer);
		update(existingBeerRecords
				.stream()
				.filter(record -> record.equals(beer))
				.findFirst()
				.orElse(beer));
	}

}
