package com.montanabrews.dtos;

/**
 * @author Dan Poss
 * This class is used to store the Microbrew 
 * values coming from the endpoint.
 */
public class BeerDto {
	
	private String beerName;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BeerDto [beerName=" + beerName + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beerName == null) ? 0 : beerName.hashCode());
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
		BeerDto other = (BeerDto) obj;
		if (beerName == null) {
			if (other.beerName != null)
				return false;
		} else if (!beerName.equals(other.beerName))
			return false;
		return true;
	}
	
}
