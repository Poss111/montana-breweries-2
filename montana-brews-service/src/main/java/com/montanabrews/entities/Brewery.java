package com.montanabrews.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Dan Poss This class is to be used to store the Brewery records in the
 *         Database for the Montana-Brews Service.
 */
@Entity
@Table(name = "BREWERIES")
public class Brewery implements Serializable {

	private static final long serialVersionUID = -9213858388930151162L;

	@Id
	@GeneratedValue
	@Column(name = "BREWERY_OBJ_ID", nullable = false)
	private long breweryObjId;

	@Column(name = "BREWERY_NAME", nullable = false)
	private String breweryName;

	@Column(name = "BREWERY_ADDRESS")
	private String breweryAddress;

	@Column(name = "BREWERY_ZIPCODE")
	private Integer zipcode;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="BREWERY_OBJ_ID")
	@OrderBy("beerName asc")
	private List<Beer> microbrews;

	/**
	 * @return the breweryName
	 */
	public String getBreweryName() {
		return breweryName;
	}

	/**
	 * @param breweryName
	 *            the breweryName to set
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
	 * @param breweryAddress
	 *            the breweryAddress to set
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
	 * @param zipcode
	 *            the zipcode to set
	 */
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the breweryObjId
	 */
	public long getBreweryObjId() {
		return breweryObjId;
	}

	/**
	 * @param breweryObjId
	 *            the breweryObjId to set
	 */
	public void setBreweryObjId(long breweryObjId) {
		this.breweryObjId = breweryObjId;
	}

	/**
	 * @return the microbrews
	 */
	public List<Beer> getMicrobrews() {
		return microbrews;
	}

	/**
	 * @param microbrews
	 *            the microbrews to set
	 */
	public void setMicrobrews(List<Beer> microbrews) {
		this.microbrews = microbrews;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "breweryObjId");
	}

}
