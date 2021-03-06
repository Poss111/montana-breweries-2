package com.montanabrews.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.validation.annotation.Validated;

/**
 * @author Dan Poss
 * This class will be used to handle the Brewery request coming in from the Users.
 */
@Validated
public class BreweryDto {

	/**
	 * The given Brewery's Name.
	 */
	@NotNull
	private String breweryName;
	
	/**
	 * The address of said Brewery.
	 */
	private String breweryAddress;
	
	/**
	 * The state that the Brewery is located in, this will be given in 2 Char format i.e. TX
	 */
	@Pattern(regexp="[A-Z]{2}", message = "Your state should be of the format 'AA'")
	private String state;
	
	/**
	 * The town that the Brewery is located in.
	 */
	private String town;
	
	/**
	 * This is the corresponding rating of the Brewery.
	 */
	@Min(value=0, message = "Rating should not be less than {value}")
	@Max(value=5, message = "Rating should not be more than {value}")
	private Integer rating;
	
	/**
	 * This is the zipcode for the said Brewery.
	 */
	private Integer zipcode;
	
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
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
