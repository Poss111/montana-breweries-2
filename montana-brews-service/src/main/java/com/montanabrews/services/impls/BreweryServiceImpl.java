/**
 * 
 */
package com.montanabrews.services.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.montanabrews.daos.BreweryDao;
import com.montanabrews.dtos.BreweryDto;
import com.montanabrews.entities.Brewery;
import com.montanabrews.services.BreweryService;
import com.montanabrews.util.BreweryDtoMapper;

/**
 * @author Dan Poss
 *
 */
@Component
public class BreweryServiceImpl implements BreweryService {
	
	private static final Logger LOG = LoggerFactory.getLogger(BreweryServiceImpl.class);
	
	@Autowired
	BreweryDao breweryDao;
	
	@Autowired
	BreweryDtoMapper breweryDtoMapper;

	/* (non-Javadoc)
	 * @see com.montanabrews.services.BreweryService#insertBrewery(com.montanabrews.entities.Brewery)
	 */
	@Override
	public void insertBrewery(BreweryDto breweryDto) {
		Brewery breweryRecordToInsert = breweryDtoMapper.breweryDtoToBrewery(breweryDto);
		LOG.info("Inserting following brewery record into Database :: ('{}')", breweryRecordToInsert);
		breweryDao.createBreweryRecord(breweryRecordToInsert);
	}

	/* (non-Javadoc)
	 * @see com.montanabrews.services.BreweryService#listAllBreweries()
	 */
	@Override
	public List<Brewery> listAllBreweries() {
		LOG.info("Retrieving list of Brewery records from Databse...");
		return breweryDao.retrieveListOfBreweries();
	}

}
