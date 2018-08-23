package com.montanabrews.dtos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Dan Poss
 * This class is to be used to store the Microbrew record and information pertaining to the Microbrew.
 */
@Entity
@Table(name = "MICRO_BREWS")
public class Beer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long beerObjId;
	
	private String beerName;
	
	private long abv;
	
	/**
	 * @return the beerObjId
	 */
	public long getBeerObjId() {
		return beerObjId;
	}
	
	/**
	 * @param beerObjId the beerObjId to set
	 */
	public void setBeerObjId(long beerObjId) {
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
	public long getAbv() {
		return abv;
	}
	
	/**
	 * @param abv the abv to set
	 */
	public void setAbv(long abv) {
		this.abv = abv;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (abv ^ (abv >>> 32));
		result = prime * result + ((beerName == null) ? 0 : beerName.hashCode());
		result = prime * result + (int) (beerObjId ^ (beerObjId >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		if (abv != other.abv)
			return false;
		if (beerName == null) {
			if (other.beerName != null)
				return false;
		} else if (!beerName.equals(other.beerName))
			return false;
		if (beerObjId != other.beerObjId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Beer [beerObjId=" + beerObjId + ", beerName=" + beerName + ", abv=" + abv + "]";
	}	
		
}
