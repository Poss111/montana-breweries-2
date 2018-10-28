/**
 * 
 */
package com.montanabrews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.montanabrews.entities.Brewery;

/**
 * @author Daniel Poss
 *
 */
@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Long> {

	Brewery findByBreweryName(String breweryName);
	
}
