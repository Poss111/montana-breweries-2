/**
 * 
 */
package com.montanabrews.daos.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.daos.BreweryDao;
import com.montanabrews.daos.MontanaBrewsBaseDao;
import com.montanabrews.entities.Brewery;

/**
 * @author Dan Poss
 *
 */
@Repository
@Transactional
public class BreweryDaoImpl extends MontanaBrewsBaseDao<Brewery> implements BreweryDao {

	private static final Logger LOG = LoggerFactory.getLogger(BreweryDaoImpl.class);
	
	@Override
	public List<Brewery> retrieveListOfBreweries() {
		setClassy(Brewery.class);
		LOG.info("Retrieving all instances of Breweries.");
		return findAll();
	}

	@Override
	public void createBreweryRecord(Brewery brewery) {
		setClassy(Brewery.class);
		LOG.info("Creating a record of brewery :: ('{}')", brewery);
		create(brewery);
	}

}
