package com.advantage.datastructures.OptumOne;


/**
 * Data Structure to hold variables for Create and Task 
 */
public class CreateNoteAndTaskDetails {
	public String sRegLibName, sViewName, sPatientName, 
	sCarePathwayName, sProgram, sOwnerName, sOwnerAlias,sText, 
	sName, sActivity, sOtherActivity, sSubject, sOtherSubject, sDueDate, sPriority,
	sStatus, sDuration, sDesc;
	

	/**
	 * Constructor for Create and Task
	 * 
	 * @param sRegLibName - Registry Library 
	 * @param sViewName - View Name
	 * @param sPatientName - Patient Name
	 * @param sCarePathwayName - Care Pathway Name
	 * @param sProgram - Program
	 * @param sOwnerName - Owner Name
	 * @param sOwnerAlias - Owner Alias
	 * @param sText - Quick Text
	 * @param sOwnerName - 	Owner Name
	 * @param sActivity - Activity
	 * @param sOtherActivity - sOtherActivity
	 * @param sSubject - sSubject
	 * @param sOtherSubject - Other Subject
	 * @param sDueDate - sDueDate
	 * @param sPriority - sPriority
	 * @param sStatus - sStatus
	 * @param sDuration - sDuration
	 * @param sDesc - Task Description
	 * 
	 */
	public CreateNoteAndTaskDetails(String sRegLibName, String sViewName, String sPatientName, 
			String sCarePathwayName, String sProgram, String sOwnerName, String sOwnerAlias, String sText, 
			String sName, String sActivity, String sOtherActivity, 
			String sSubject, String sOtherSubject, String sDueDate, String sPriority,
			String sStatus, String sDuration, String sDesc)
	{
		
		set(sRegLibName, sViewName, sPatientName, sCarePathwayName, sProgram, sOwnerName, sOwnerAlias, sText, 
				sName, sActivity, sOtherActivity, sSubject, sOtherSubject, sDueDate, sPriority,
				sStatus, sDuration, sDesc);
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
	 * @param sText - Quick Text
	 * @param sOwnerName - 	Owner Name
	 * @param sActivity - Activity
	 * @param sOtherActivity - sOtherActivity
	 * @param sSubject - sSubject
	 * @param sOtherSubject - Other Subject
	 * @param sDueDate - sDueDate
	 * @param sPriority - sPriority
	 * @param sStatus - sStatus
	 * @param sDuration - sDuration
	 * @param sDesc - Task Description
	 */
	private void set(String sRegLibName, String sViewName, String sPatientName, 
			String sCarePathwayName, String sProgram, String sOwnerName, String sOwnerAlias, String sText, 
			String sName, String sActivity, String sOtherActivity, 
			String sSubject, String sOtherSubject, String sDueDate, String sPriority,
			String sStatus, String sDuration, String sDesc)
	{
		this.sRegLibName = sRegLibName;
		this.sViewName = sViewName;	
		this.sPatientName = sPatientName;	
		this.sCarePathwayName = sCarePathwayName;	
		this.sProgram = sProgram;
		this.sOwnerName = sOwnerName;
		this.sOwnerAlias = sOwnerAlias;
		this.sText = sText;
		this.sName = sName;
		this.sActivity = sActivity;
		this.sOtherActivity = sOtherActivity;
		this.sSubject = sSubject;
		this.sOtherSubject = sOtherSubject;
		this.sDueDate = sDueDate;
		this.sPriority = sPriority;
		this.sStatus = sStatus;
		this.sDuration = sDuration;
		this.sDesc=sDesc;
	}



	@Override
	public String toString() {
		return "CreateNoteAndTaskDetails [sRegLibName=" + sRegLibName
				+ ", sViewName=" + sViewName + ", sPatientName=" + sPatientName
				+ ", sCarePathwayName=" + sCarePathwayName + ", sProgram="
				+ sProgram + ", sOwnerName=" + sOwnerName + ", sOwnerAlias="
				+ sOwnerAlias + ", sText=" + sText + ", sName=" + sName
				+ ", sActivity=" + sActivity + ", sOtherActivity="
				+ sOtherActivity + ", sSubject=" + sSubject
				+ ", sOtherSubject=" + sOtherSubject + ", sDueDate=" + sDueDate
				+ ", sPriority=" + sPriority + ", sStatus=" + sStatus
				+ ", sDuration=" + sDuration + ", sDesc=" + sDesc + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sActivity == null) ? 0 : sActivity.hashCode());
		result = prime
				* result
				+ ((sCarePathwayName == null) ? 0 : sCarePathwayName.hashCode());
		result = prime * result + ((sDesc == null) ? 0 : sDesc.hashCode());
		result = prime * result
				+ ((sDueDate == null) ? 0 : sDueDate.hashCode());
		result = prime * result
				+ ((sDuration == null) ? 0 : sDuration.hashCode());
		result = prime * result + ((sName == null) ? 0 : sName.hashCode());
		result = prime * result
				+ ((sOtherActivity == null) ? 0 : sOtherActivity.hashCode());
		result = prime * result
				+ ((sOtherSubject == null) ? 0 : sOtherSubject.hashCode());
		result = prime * result
				+ ((sOwnerAlias == null) ? 0 : sOwnerAlias.hashCode());
		result = prime * result
				+ ((sOwnerName == null) ? 0 : sOwnerName.hashCode());
		result = prime * result
				+ ((sPatientName == null) ? 0 : sPatientName.hashCode());
		result = prime * result
				+ ((sPriority == null) ? 0 : sPriority.hashCode());
		result = prime * result
				+ ((sProgram == null) ? 0 : sProgram.hashCode());
		result = prime * result
				+ ((sRegLibName == null) ? 0 : sRegLibName.hashCode());
		result = prime * result + ((sStatus == null) ? 0 : sStatus.hashCode());
		result = prime * result
				+ ((sSubject == null) ? 0 : sSubject.hashCode());
		result = prime * result + ((sText == null) ? 0 : sText.hashCode());
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
		CreateNoteAndTaskDetails other = (CreateNoteAndTaskDetails) obj;
		if (sActivity == null) {
			if (other.sActivity != null)
				return false;
		} else if (!sActivity.equals(other.sActivity))
			return false;
		if (sCarePathwayName == null) {
			if (other.sCarePathwayName != null)
				return false;
		} else if (!sCarePathwayName.equals(other.sCarePathwayName))
			return false;
		if (sDesc == null) {
			if (other.sDesc != null)
				return false;
		} else if (!sDesc.equals(other.sDesc))
			return false;
		if (sDueDate == null) {
			if (other.sDueDate != null)
				return false;
		} else if (!sDueDate.equals(other.sDueDate))
			return false;
		if (sDuration == null) {
			if (other.sDuration != null)
				return false;
		} else if (!sDuration.equals(other.sDuration))
			return false;
		if (sName == null) {
			if (other.sName != null)
				return false;
		} else if (!sName.equals(other.sName))
			return false;
		if (sOtherActivity == null) {
			if (other.sOtherActivity != null)
				return false;
		} else if (!sOtherActivity.equals(other.sOtherActivity))
			return false;
		if (sOtherSubject == null) {
			if (other.sOtherSubject != null)
				return false;
		} else if (!sOtherSubject.equals(other.sOtherSubject))
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
		if (sPriority == null) {
			if (other.sPriority != null)
				return false;
		} else if (!sPriority.equals(other.sPriority))
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
		if (sStatus == null) {
			if (other.sStatus != null)
				return false;
		} else if (!sStatus.equals(other.sStatus))
			return false;
		if (sSubject == null) {
			if (other.sSubject != null)
				return false;
		} else if (!sSubject.equals(other.sSubject))
			return false;
		if (sText == null) {
			if (other.sText != null)
				return false;
		} else if (!sText.equals(other.sText))
			return false;
		if (sViewName == null) {
			if (other.sViewName != null)
				return false;
		} else if (!sViewName.equals(other.sViewName))
			return false;
		return true;
	}



	
}