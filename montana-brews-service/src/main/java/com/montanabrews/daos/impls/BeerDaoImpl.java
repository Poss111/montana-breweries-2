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
		
		if (foundBeerRecord != null) {
			foundBeerRecord.setAbv(beer.getAbv());
			if (!ObjectUtils.equals(beer, foundBeerRecord)) {
				foundBeerRecord.setBeerType(beer.getBeerType());
			}
			beer = foundBeerRecord;
		}
		
		LOG.info("Found Beer record by name ('{}')", foundBeerRecord);
		update(beer);
	}

}
