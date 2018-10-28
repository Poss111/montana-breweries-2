/**
 * 
 */
package com.montanabrews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.montanabrews.entities.BeerType;

/**
 * @author Daniel Poss
 *
 */
@Repository
public interface BeerTypeRepository extends JpaRepository<BeerType, Long> {

	BeerType findByBeerTypeNme(String beerTypeNme);
	
}
