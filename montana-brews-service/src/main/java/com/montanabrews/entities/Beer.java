package com.montanabrews.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * @author Dan Poss
 * This class is to be used to store the Microbrew record and information pertaining to the Microbrew.
 */
@Entity
@Table(name = "MICRO_BREWS")
public class Beer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "BEER_OBJ_ID", nullable = false)
	private Integer beerObjId;
	
	@Column(name = "BEER_NAME", nullable = false)
	private String beerName;
	
	@Column(name = "ABV")
	private Float abv;
	
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
