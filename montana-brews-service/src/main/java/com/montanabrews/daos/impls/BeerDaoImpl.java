package com.montanabrews.daos.impls;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.constants.MontanaBrewsQueryConstants;
import com.montanabrews.daos.BeerDao;
import com.montanabrews.daos.MontanaBrewsBaseDao;
import com.montanabrews.entities.Beer;
import com.montanabrews.entities.BeerType;

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
		Beer foundBeerRecord = (Beer) getCurrentSession().getNamedQuery(MontanaBrewsQueryConstants.FIND_BREW_BY_NAME)
				.setString("beerName", beer.getBeerName()).uniqueResult();
		BeerType foundBeerType = null;
		if (beer.getBeerType() != null) {
			foundBeerType = (BeerType) getCurrentSession()
					.getNamedQuery(MontanaBrewsQueryConstants.BEER_TYPE_FIND_BEER_TYPE_BY_NAME)
					.setString("beerTypeNme", beer.getBeerType().getBeerTypeNme()).uniqueResult();
			if (foundBeerType != null) {
				beer.setBeerType(foundBeerType);
				LOG.info("Beer Type already existing for ('{}')", foundBeerType);			
			} else {
				LOG.info("Unique Beer Type will be inserted for ('{}')", beer.getBeerType());
			}
		}
		
		if (foundBeerRecord != null) {
			LOG.info("Found Beer record by name ('{}')", foundBeerRecord);
			foundBeerRecord.setAbv(beer.getAbv());
			foundBeerRecord.setBeerType(beer.getBeerType());
			beer = foundBeerRecord;
		}
		
		LOG.info("Inserting Beer record ('{}')",beer);
		update(beer);
	}

}
