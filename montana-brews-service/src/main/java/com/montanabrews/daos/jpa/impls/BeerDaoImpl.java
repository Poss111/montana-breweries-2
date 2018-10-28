package com.montanabrews.daos.jpa.impls;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.constants.MontanaBrewsQueryConstants;
import com.montanabrews.daos.BeerDao;
import com.montanabrews.daos.MontanaBrewsBaseDao;
import com.montanabrews.entities.Beer;
import com.montanabrews.entities.BeerType;
import com.montanabrews.entities.Brewery;
import com.montanabrews.repositories.BeerRepository;
import com.montanabrews.repositories.BeerTypeRepository;
import com.montanabrews.repositories.BreweryRepository;

@Repository
@Transactional
public class BeerDaoImpl implements BeerDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(BeerDaoImpl.class);
	
	@Autowired
	private BeerRepository beerRepository;
	
	@Autowired
	private BreweryRepository breweryRepository;
	
	@Autowired
	private BeerTypeRepository beerTypeRepository;
	
	@Override
	public List<Beer> retrieveListOfBeers() {
//		setClassy(Beer.class);
//		return findAll();
		return beerRepository.findAll();
	}

	@Override
	public void createMicrobrewRecord(Beer beer) {
		beerRepository.save(beer);
	}

	@Override
	public void createOrUpdateMicrobrewRecord(Beer beer) throws Exception {
		Beer foundBeerRecord = beerRepository.findByBeerName(beer.getBeerName());
		
		if (beer.getBrewery() != null && StringUtils.isNotBlank(beer.getBrewery().getBreweryName())) {
			Brewery foundBrewery = breweryRepository.findByBreweryName(beer.getBrewery().getBreweryName());
			if (foundBrewery != null) {
				LOG.info("Found Brewery to associate to Beer record for insertion. ('{}')", foundBrewery);
				beer.setBrewery(foundBrewery);
			} else {
				LOG.error("Cannot find given Brewery Name to associate to requested Microbrew Record ('{}')",beer.getBrewery().getBreweryName());
				throw new Exception("Cannot insert Microbrew record with Non-Existant Brewery Name");
			}
		}

		if (beer.getBeerType() != null) {
			BeerType foundBeerType = beerTypeRepository.findByBeerTypeNme(beer.getBeerType().getBeerTypeNme());
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
		beerRepository.save(beer);
	}

}
