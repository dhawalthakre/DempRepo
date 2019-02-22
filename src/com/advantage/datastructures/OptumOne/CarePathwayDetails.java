package com.advantage.datastructures.OptumOne;


/**
 * Data Structure to hold variables for Care Pathway 
 */
public class CarePathwayDetails {
	public String sRegLibName, sViewName, sPatientName, 
	sCarePathwayName, sProgram, sOwnerName, sOwnerAlias;
	

	/**
	 * Constructor for Care Pathway
	 * 
	 * @param sRegLibName - Registry Library 
	 * @param sViewName - View Name
	 * @param sPatientName - Patient Name
	 * @param sCarePathwayName - Care Pathway Name
	 * @param sProgram - Program
	 * @param sOwnerName - Owner Name
	 * @param sOwnerAlias - Owner Alias
	 */
	public CarePathwayDetails(String sRegLibName, String sViewName, String sPatientName, 
			String sCarePathwayName, String sProgram, String sOwnerName, String sOwnerAlias)
	{
		
		set(sRegLibName, sViewName, sPatientName, sCarePathwayName, sProgram, sOwnerName, sOwnerAlias);
	}

	

	/**
	 * Sets all the variables.
	 * 
	 * @param sRegLibName - Registry Library 
	 * @param sViewName - View Name
	 * @param sPatientName - Patient Name
	 * @param sCarePathwayName - Care Pathway Name
	 * @param sProgram - Program
	 * @param sOwnerName - Owner Name
	 * @param sOwnerAlias - Owner Alias
	 */
	private void set(String sRegLibName, String sViewName, String sPatientName, 
			String sCarePathwayName, String sProgram, String sOwnerName, String sOwnerAlias)
	{
		this.sRegLibName = sRegLibName;
		this.sViewName = sViewName;	
		this.sPatientName = sPatientName;	
		this.sCarePathwayName = sCarePathwayName;	
		this.sProgram = sProgram;
		this.sOwnerName = sOwnerName;
		this.sOwnerAlias = sOwnerAlias;
	}



	@Override
	public String toString() {
		return "CarePathwayDetails [sRegLibName=" + sRegLibName
				+ ", sViewName=" + sViewName + ", sPatientName=" + sPatientName
				+ ", sCarePathwayName=" + sCarePathwayName + ", sProgram="
				+ sProgram + ", sOwnerName=" + sOwnerName + ", sOwnerAlias="
				+ sOwnerAlias + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((sCarePathwayName == null) ? 0 : sCarePathwayName.hashCode());
		result = prime * result
				+ ((sOwnerAlias == null) ? 0 : sOwnerAlias.hashCode());
		result = prime * result
				+ ((sOwnerName == null) ? 0 : sOwnerName.hashCode());
		result = prime * result
				+ ((sPatientName == null) ? 0 : sPatientName.hashCode());
		result = prime * result
				+ ((sProgram == null) ? 0 : sProgram.hashCode());
		result = prime * result
				+ ((sRegLibName == null) ? 0 : sRegLibName.hashCode());
		result = prime * result
				+ ((sViewName == null) ? 0 : sViewName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarePathwayDetails other = (CarePathwayDetails) obj;
		if (sCarePathwayName == null) {
			if (other.sCarePathwayName != null)
				return false;
		} else if (!sCarePathwayName.equals(other.sCarePathwayName))
			return false;
		if (sOwnerAlias == null) {
			if (other.sOwnerAlias != null)
				return false;
		} else if (!sOwnerAlias.equals(other.sOwnerAlias))
			return false;
		if (sOwnerName == null) {
			if (other.sOwnerName != null)
				return false;
		} else if (!sOwnerName.equals(other.sOwnerName))
			return false;
		if (sPatientName == null) {
			if (other.sPatientName != null)
				return false;
		} else if (!sPatientName.equals(other.sPatientName))
			return false;
		if (sProgram == null) {
			if (other.sProgram != null)
				return false;
		} else if (!sProgram.equals(other.sProgram))
			return false;
		if (sRegLibName == null) {
			if (other.sRegLibName != null)
				return false;
		} else if (!sRegLibName.equals(other.sRegLibName))
			return false;
		if (sViewName == null) {
			if (other.sViewName != null)
				return false;
		} else if (!sViewName.equals(other.sViewName))
			return false;
		return true;
	}

	

	
}