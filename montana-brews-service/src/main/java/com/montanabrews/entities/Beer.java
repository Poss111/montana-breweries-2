package com.montanabrews.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.montanabrews.constants.MontanaBrewsQueryConstants;


/**
 * @author Dan Poss
 * This class is to be used to store the Microbrew record and information pertaining to the Microbrew.
 */
@Entity
@Table(name = "MICRO_BREWS")
@NamedQuery(name = "Beer.findBrewByName", query="SELECT b FROM Beer b WHERE b.beerName = :beerName")
public class Beer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BEER_OBJ_ID", nullable = false)
	private Integer beerObjId;
	
	@Column(name = "BEER_NAME", nullable = false)
	private String beerName;
	
	@Column(name = "ABV")
	private Float abv;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "BEER_TYPE_OBJ_ID")
	private BeerType beerType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BREWERY_OBJ_ID")
	private Brewery brewery;
	
	/**
	 * @return the beerObjId
	 */
	public Integer getBeerObjId() {
		return beerObjId;
	}
	
	/**
	 * @param beerObjId the beerObjId to set
	 */
	public void setBeerObjId(Integer beerObjId) {
		this.beerObjId = beerObjId;
	}
	
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
	public Float getAbv() {
		return abv;
	}
	
	/**
	 * @param abv the abv to set
	 */
	public void setAbv(Float abv) {
		this.abv = abv;
	}

	/**
	 * @return the beerType
	 */
	public BeerType getBeerType() {
		return beerType;
	}

	/**
	 * @param beerType the beerType to set
	 */
	public void setBeerType(BeerType beerType) {
		this.beerType = beerType;
	}

	/**
	 * @return the brewery
	 */
	public Brewery getBrewery() {
		return brewery;
	}

	/**
	 * @param brewery the brewery to set
	 */
	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "beerObjId");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}	
		
}
