/**
 * 
 */
package com.montanabrews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.montanabrews.entities.Beer;

/**
 * @author Daniel Poss
 *
 */
@Repository
public interface BeerRepository extends JpaRepository<Beer, Long>, JpaSpecificationExecutor<Beer> {

	Beer findByBeerName(String beerName);
	
}
