package com.montanabrews.daos.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.constants.MontanaBrewsQueryConstants;
import com.montanabrews.daos.BeerDao;
import com.montanabrews.daos.MontanaBrewsBaseDao;
import com.montanabrews.entities.Beer;

@Repository
@Transactional
public class BeerDaoImpl extends MontanaBrewsBaseDao<Beer> implements BeerDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(BeerDaoImpl.class);
	
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
//		Beer foundBeerRecord = (Beer) getCurrentSession().getNamedQuery(MontanaBrewsQueryConstants.FIND_BREW_BY_NAME).uniqueResult();
//		
//		LOG.info("Found Beer record by name ('{}')", foundBeerRecord);
		List<Beer> existingBeerRecords = findAll();

		for (Beer beerToCheck : existingBeerRecords) {
			LOG.info("Checking beer Record from Database :: ('{}')", beerToCheck);
			LOG.info("Against requested beer Record to insert :: ('{}')", beer);
			if (beer.getBeerName().equals(beerToCheck.getBeerName())) {
				LOG.info("Match found!");
				beerToCheck.setAbv(beer.getAbv());
				if (!beer.getBeerType().equals(beerToCheck.getBeerType())) {
					beerToCheck.setBeerType(beer.getBeerType());
				}
				beer = beerToCheck;
				break;
			}
		}
		update(beer);
	}

}
