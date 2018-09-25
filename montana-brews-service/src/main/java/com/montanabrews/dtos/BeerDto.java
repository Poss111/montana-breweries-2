package com.montanabrews.dtos;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Dan Poss
 * This class is used to store the Microbrew 
 * values coming from the endpoint.
 */
public class BeerDto {
	
	/**
	 * The name of the Microbrew to be returned to the User
	 */
	private String beerName;
	
	/**
	 * The Alcohol By Volume of the Microbrew
	 */
	private String abv;

	/**
	 * @return the beerName
	 */
	public String getBeerName() {
		return beerName;
	}

	/**
	 * @param beerName the beerName to set
	 */
	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	/**
	 * @return the abv
	 */
	public String getAbv() {
		return abv;
	}

	/**
	 * @param abv the abv to set
	 */
	public void setAbv(String abv) {
		this.abv = abv;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
}
