package com.montanabrews.daos.impls;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.constants.MontanaBrewsQueryConstants;
import com.montanabrews.daos.BeerDao;
import com.montanabrews.daos.MontanaBrewsBaseDao;
import com.montanabrews.entities.Beer;
import com.montanabrews.entities.BeerType;
import com.montanabrews.entities.Brewery;

@Repository
@Transactional
public class BeerDaoImpl extends MontanaBrewsBaseDao<Beer> implements BeerDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(BeerDaoImpl.class);
	
	@Override
	public List<Beer> retrieveListOfBeers() {
		setClassy(Beer.class);
		return findAll();
	}

	@Override
	public void createMicrobrewRecord(Beer beer) {
		setClassy(Beer.class);
		create(beer);
	}

	@Override
	public void createOrUpdateMicrobrewRecord(Beer beer) throws Exception {
		setClassy(Beer.class);
		Beer foundBeerRecord = (Beer) getCurrentSession().getNamedQuery(MontanaBrewsQueryConstants.FIND_BREW_BY_NAME)
				.setString("beerName", beer.getBeerName()).uniqueResult();
		
		if (beer.getBrewery() != null && StringUtils.isNotBlank(beer.getBrewery().getBreweryName())) {
			Brewery foundBrewery = (Brewery) getCurrentSession()
					.getNamedQuery(MontanaBrewsQueryConstants.BREWERY_FIND_BREWERY_BY_NAME)
					.setString("breweryName", beer.getBrewery().getBreweryName()).uniqueResult();
			if (foundBrewery != null) {
				LOG.info("Found Brewery to associate to Beer record for insertion. ('{}')", foundBrewery);
				beer.setBrewery(foundBrewery);
			} else {
				LOG.error("Cannot find given Brewery Name to associate to requested Microbrew Record ('{}')",beer.getBrewery().getBreweryName());
				throw new Exception("Cannot insert Microbrew record with Non-Existant Brewery Name");
			}
		}
		
		if (beer.getBeerType() != null) {
			BeerType foundBeerType = (BeerType) getCurrentSession()
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
			foundBeerRecord.setRating(beer.getRating());
			if (beer.getBeerType() != null)
				foundBeerRecord.setBeerType(beer.getBeerType());
			if (beer.getBrewery() != null)
				foundBeerRecord.setBrewery(beer.getBrewery());
			beer = foundBeerRecord;
		}
		
		LOG.info("Inserting Beer record ('{}')",beer);
		update(beer);
	}

}
