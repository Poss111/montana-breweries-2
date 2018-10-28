/**
 * 
 */
package com.montanabrews.daos.hibernate.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.constants.MontanaBrewsQueryConstants;
import com.montanabrews.daos.BreweryDao;
import com.montanabrews.daos.MontanaBrewsBaseDao;
import com.montanabrews.entities.Beer;
import com.montanabrews.entities.Brewery;

/**
 * @author Dan Poss
 *
 */
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

	@Override
	public void createOrUpdateBreweryRecord(Brewery brewery) {
		setClassy(Brewery.class);
		LOG.info("Brewery record to insert ('{}')", brewery);
		
		Brewery existingBreweryRecord = (Brewery) getCurrentSession()
				.getNamedQuery(MontanaBrewsQueryConstants.BREWERY_FIND_BREWERY_BY_NAME)
				.setString("breweryName", brewery.getBreweryName()).uniqueResult();
	
		if (existingBreweryRecord != null) {
			existingBreweryRecord.setBreweryAddress(brewery.getBreweryAddress());
			existingBreweryRecord.setZipcode(brewery.getZipcode());
			existingBreweryRecord.setRating(brewery.getRating());
			existingBreweryRecord.setTown(brewery.getTown());
			existingBreweryRecord.setState(brewery.getState());
			brewery = existingBreweryRecord;
		}
		
		update(brewery);
	}

}
