/**
 * 
 */
package com.montanabrews.dtos;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.montanabrews.entities.Beer;

/**
 * @author Dan Poss
 *
 */
public class BreweryDto {

	@NotNull
	private String breweryName;
	
	private String breweryAddress;
	
	@Size(min=5,max=5, message="Zipcode should be 5 Digits")
	private Integer zipcode;
	
	private List<BeerDto> microbrews;

	/**
	 * @return the breweryName
	 */
	public String getBreweryName() {
		return breweryName;
	}

	/**
	 * @param breweryName the breweryName to set
	 */
	public void setBreweryName(String breweryName) {
		this.breweryName = breweryName;
	}

	/**
	 * @return the breweryAddress
	 */
	public String getBreweryAddress() {
		return breweryAddress;
	}

	/**
	 * @param breweryAddress the breweryAddress to set
	 */
	public void setBreweryAddress(String breweryAddress) {
		this.breweryAddress = breweryAddress;
	}

	/**
	 * @return the zipcode
	 */
	public Integer getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}		

	/**
	 * @return the microbrewList
	 */
	public List<BeerDto> getMicrobrews() {
		return microbrews;
	}

	/**
	 * @param microbrewList the microbrewList to set
	 */
	public void setMicrobrews(List<BeerDto> microbrews) {
		this.microbrews = microbrews;
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
