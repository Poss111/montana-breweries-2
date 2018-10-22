/**
 * 
 */
package com.montanabrews.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Dan Poss
 * This class is to be used to create a Look up Table for Beer Types posted to the Database.
 */
@Entity
@Table(name = "BEER_TYPE_LKUP")
public class BeerType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BEER_TYPE_OBJ_ID")
	private Integer beerTypeObjId;
	
	@Column(name = "BEER_TYPE_NME")
	private String beerTypeNme;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "beerType")
	private Beer beer;

	/**
	 * @return the beerTypeObjId
	 */
	public Integer getBeerTypeObjId() {
		return beerTypeObjId;
	}

	/**
	 * @param beerTypeObjId the beerTypeObjId to set
	 */
	public void setBeerTypeObjId(Integer beerTypeObjId) {
		this.beerTypeObjId = beerTypeObjId;
	}

	/**
	 * @return the beerTypeNme
	 */
	public String getBeerTypeNme() {
		return beerTypeNme;
	}

	/**
	 * @param beerTypeNme the beerTypeNme to set
	 */
	public void setBeerTypeNme(String beerTypeNme) {
		this.beerTypeNme = beerTypeNme;
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
