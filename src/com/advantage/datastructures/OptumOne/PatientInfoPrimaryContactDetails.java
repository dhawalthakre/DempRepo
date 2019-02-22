package com.advantage.datastructures.OptumOne;


/**
 * Data Structure to hold variables for Care Pathway 
 */
public class PatientInfoPrimaryContactDetails {
	public String sPatientName, sAtAGlance, sAcuityScore, sAcuityNotes, sPrimaryStreet, sPrimaryCity, sPrimaryState, 
	sPrimaryZip, sPrimaryCountry, sPrimaryEmail, sPrimaryPhone, sPreferredContactMethod,
	sPreferredContactDays, sPreferredContactTime;
	

	/**
	 * Constructor for Patient Info and Primary Contact Details
	 * 	 
	 * @param sPatientName - Patient Name
	 * @param sAtAGlance -  At A Glance
	 * @param sAcuityScore - Acuity Score
	 * @param sAcuityNotes - Acuity Notes
	 * @param sPrimaryStreet - Primary Street
	 * @param sPrimaryCity - Primary City
	 * @param sPrimaryState - Primary State
	 * @param sPrimaryZip - Primary Zip
	 * @param sPrimaryCountry - Primary Country
	 * @param sPrimaryEmail - Primary Email
	 * @param sPrimaryPhone - Primary Phone
	 * @param sPreferredContactMethod - Preferred Contact Method
	 * @param sPreferredContactDays -Preferred Contact Days
	 * @param sPreferredContactTime - Preferred Contact Time	 
	 */
	public PatientInfoPrimaryContactDetails(String sPatientName, String sAtAGlance, String sAcuityScore, String sAcuityNotes, String sPrimaryStreet, String sPrimaryCity, String sPrimaryState, 
			String sPrimaryZip, String sPrimaryCountry, String sPrimaryEmail, String sPrimaryPhone, String sPreferredContactMethod,
			String sPreferredContactDays, String sPreferredContactTime)
	{
		
		set(sPatientName, sAtAGlance, sAcuityScore, sAcuityNotes, sPrimaryStreet, sPrimaryCity, sPrimaryState, 
				sPrimaryZip, sPrimaryCountry, sPrimaryEmail, sPrimaryPhone, sPreferredContactMethod,
				sPreferredContactDays, sPreferredContactTime);
	}

	

	/**
	 * Sets all the variables.
	 * 
	* 	 
	 * @param sPatientName - Patient Name
	 * @param sAtAGlance -  At A Glance
	 * @param sAcuityScore - Acuity Score
	 * @param sAcuityNotes - Acuity Notes
	 * @param sPrimaryStreet - Primary Street
	 * @param sPrimaryCity - Primary City
	 * @param sPrimaryState - Primary State
	 * @param sPrimaryZip - Primary Zip
	 * @param sPrimaryCountry - Primary Country
	 * @param sPrimaryEmail - Primary Email
	 * @param sPrimaryPhone - Primary Phone
	 * @param sPreferredContactMethod - Preferred Contact Method
	 * @param sPreferredContactDays -Preferred Contact Days
	 * @param sPreferredContactTime - Preferred Contact Time
	 */
	private void set(String sPatientName, String sAtAGlance, String sAcuityScore, String sAcuityNotes, String sPrimaryStreet, String sPrimaryCity, String sPrimaryState, 
			String sPrimaryZip, String sPrimaryCountry, String sPrimaryEmail, String sPrimaryPhone, String sPreferredContactMethod,
			String sPreferredContactDays, String sPreferredContactTime)
	{
		this.sPatientName = sPatientName;
		this.sAtAGlance = sAtAGlance;	
		this.sAcuityScore = sAcuityScore;	
		this.sAcuityNotes = sAcuityNotes;	
		this.sPrimaryStreet = sPrimaryStreet;
		this.sPrimaryCity = sPrimaryCity;
		this.sPrimaryState = sPrimaryState;
		this.sPrimaryZip = sPrimaryZip;
		this.sPrimaryCountry = sPrimaryCountry;
		this.sPrimaryEmail = sPrimaryEmail;
		this.sPrimaryPhone = sPrimaryPhone;
		this.sPreferredContactMethod = sPreferredContactMethod;
		this.sPreferredContactDays = sPreferredContactDays;
		this.sPreferredContactTime = sPreferredContactTime;
	}



	@Override
	public String toString() {
		return "PatientInfoPrimaryContactDetails [sPatientName=" + sPatientName
				+ ", sAtAGlance=" + sAtAGlance + ", sAcuityScore="
				+ sAcuityScore + ", sAcuityNotes=" + sAcuityNotes
				+ ", sPrimaryStreet=" + sPrimaryStreet + ", sPrimaryCity="
				+ sPrimaryCity + ", sPrimaryState=" + sPrimaryState
				+ ", sPrimaryZip=" + sPrimaryZip + ", sPrimaryCountry="
				+ sPrimaryCountry + ", sPrimaryEmail=" + sPrimaryEmail
				+ ", sPrimaryPhone=" + sPrimaryPhone
				+ ", sPreferredContactMethod=" + sPreferredContactMethod
				+ ", sPreferredContactDays=" + sPreferredContactDays
				+ ", sPreferredContactTime=" + sPreferredContactTime + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sAcuityNotes == null) ? 0 : sAcuityNotes.hashCode());
		result = prime * result
				+ ((sAcuityScore == null) ? 0 : sAcuityScore.hashCode());
		result = prime * result
				+ ((sAtAGlance == null) ? 0 : sAtAGlance.hashCode());
		result = prime * result
				+ ((sPatientName == null) ? 0 : sPatientName.hashCode());
		result = prime
				* result
				+ ((sPreferredContactDays == null) ? 0 : sPreferredContactDays
						.hashCode());
		result = prime
				* result
				+ ((sPreferredContactMethod == null) ? 0
						: sPreferredContactMethod.hashCode());
		result = prime
				* result
				+ ((sPreferredContactTime == null) ? 0 : sPreferredContactTime
						.hashCode());
		result = prime * result
				+ ((sPrimaryCity == null) ? 0 : sPrimaryCity.hashCode());
		result = prime * result
				+ ((sPrimaryCountry == null) ? 0 : sPrimaryCountry.hashCode());
		result = prime * result
				+ ((sPrimaryEmail == null) ? 0 : sPrimaryEmail.hashCode());
		result = prime * result
				+ ((sPrimaryPhone == null) ? 0 : sPrimaryPhone.hashCode());
		result = prime * result
				+ ((sPrimaryState == null) ? 0 : sPrimaryState.hashCode());
		result = prime * result
				+ ((sPrimaryStreet == null) ? 0 : sPrimaryStreet.hashCode());
		result = prime * result
				+ ((sPrimaryZip == null) ? 0 : sPrimaryZip.hashCode());
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
		PatientInfoPrimaryContactDetails other = (PatientInfoPrimaryContactDetails) obj;
		if (sAcuityNotes == null) {
			if (other.sAcuityNotes != null)
				return false;
		} else if (!sAcuityNotes.equals(other.sAcuityNotes))
			return false;
		if (sAcuityScore == null) {
			if (other.sAcuityScore != null)
				return false;
		} else if (!sAcuityScore.equals(other.sAcuityScore))
			return false;
		if (sAtAGlance == null) {
			if (other.sAtAGlance != null)
				return false;
		} else if (!sAtAGlance.equals(other.sAtAGlance))
			return false;
		if (sPatientName == null) {
			if (other.sPatientName != null)
				return false;
		} else if (!sPatientName.equals(other.sPatientName))
			return false;
		if (sPreferredContactDays == null) {
			if (other.sPreferredContactDays != null)
				return false;
		} else if (!sPreferredContactDays.equals(other.sPreferredContactDays))
			return false;
		if (sPreferredContactMethod == null) {
			if (other.sPreferredContactMethod != null)
				return false;
		} else if (!sPreferredContactMethod
				.equals(other.sPreferredContactMethod))
			return false;
		if (sPreferredContactTime == null) {
			if (other.sPreferredContactTime != null)
				return false;
		} else if (!sPreferredContactTime.equals(other.sPreferredContactTime))
			return false;
		if (sPrimaryCity == null) {
			if (other.sPrimaryCity != null)
				return false;
		} else if (!sPrimaryCity.equals(other.sPrimaryCity))
			return false;
		if (sPrimaryCountry == null) {
			if (other.sPrimaryCountry != null)
				return false;
		} else if (!sPrimaryCountry.equals(other.sPrimaryCountry))
			return false;
		if (sPrimaryEmail == null) {
			if (other.sPrimaryEmail != null)
				return false;
		} else if (!sPrimaryEmail.equals(other.sPrimaryEmail))
			return false;
		if (sPrimaryPhone == null) {
			if (other.sPrimaryPhone != null)
				return false;
		} else if (!sPrimaryPhone.equals(other.sPrimaryPhone))
			return false;
		if (sPrimaryState == null) {
			if (other.sPrimaryState != null)
				return false;
		} else if (!sPrimaryState.equals(other.sPrimaryState))
			return false;
		if (sPrimaryStreet == null) {
			if (other.sPrimaryStreet != null)
				return false;
		} else if (!sPrimaryStreet.equals(other.sPrimaryStreet))
			return false;
		if (sPrimaryZip == null) {
			if (other.sPrimaryZip != null)
				return false;
		} else if (!sPrimaryZip.equals(other.sPrimaryZip))
			return false;
		return true;
	}



	

	
}