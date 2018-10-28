/**
 * 
 */
package com.montanabrews.daos.jpa.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montanabrews.constants.MontanaBrewsQueryConstants;
import com.montanabrews.daos.BreweryDao;
import com.montanabrews.daos.MontanaBrewsBaseDao;
import com.montanabrews.entities.Brewery;
import com.montanabrews.repositories.BreweryRepository;

/**
 * @author Dan Poss
 *
 */
@Repository
@Transactional
public class BreweryDaoImpl implements BreweryDao {

	private static final Logger LOG = LoggerFactory.getLogger(BreweryDaoImpl.class);
	
	@Autowired
	private BreweryRepository breweryRepository;
	
	@Override
	public List<Brewery> retrieveListOfBreweries() {
		LOG.info("Retrieving all instances of Breweries.");
		return breweryRepository.findAll();
	}

	@Override
	public void createBreweryRecord(Brewery brewery) {
		LOG.info("Creating a record of brewery :: ('{}')", brewery);
		breweryRepository.save(brewery);
	}

	@Override
	public void createOrUpdateBreweryRecord(Brewery brewery) {
		LOG.info("Brewery record to insert ('{}')", brewery);
	
		Brewery existingBreweryRecord = breweryRepository.findByBreweryName(brewery.getBreweryName());
//		Brewery existingBreweryRecord = (Brewery) getCurrentSession()
//				.getNamedQuery(MontanaBrewsQueryConstants.BREWERY_FIND_BREWERY_BY_NAME)
//				.setString("breweryName", brewery.getBreweryName()).uniqueResult();
//	
		if (existingBreweryRecord != null) {
			existingBreweryRecord.setBreweryAddress(brewery.getBreweryAddress());
			existingBreweryRecord.setZipcode(brewery.getZipcode());
			existingBreweryRecord.setRating(brewery.getRating());
			existingBreweryRecord.setTown(brewery.getTown());
			existingBreweryRecord.setState(brewery.getState());
			brewery = existingBreweryRecord;
		}
		
		breweryRepository.save(brewery);
	}

}
