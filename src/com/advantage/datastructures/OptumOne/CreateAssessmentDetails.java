package com.advantage.datastructures.OptumOne;

public class CreateAssessmentDetails {
	public String  sQuestionText, sQuestionType, sPatient_Name;
	

	/**
	 * Constructor for Plan of Care
	 * 
	 * @param sPatientName - Patient Name
	 * @param sGoal - Patient Goal
	 * @param sGoalTargetDate = Goal Target Date
	 * @param sProblem - Problem
	 * @param sPatientAction - Patient Action
	 * @param sActionTargetDate - Action Target Date
	 * @param sActionStatus - Action Status
	 * @param sTaskActivity - 	Task Activity
	 * @param sTaskSubject - Task Subject
	 * @param sTaskDueDate - Task Due Date
	 * @param sTaskStatus - Task Status
	 * @param sBarrierCategory - Barrier Category
	 * @param sBarrier - Barrier
	 * @param sGoalProgress - Goal Progress	 
	 * 
	 */
	public CreateAssessmentDetails(
			String sQuestionText, String sQuestionType, String sPatient_Name)
	{
		
		set(sQuestionText, sQuestionType, sPatient_Name);
	}

	

	/**
	 * Sets all the variables.
	 * 
	 * @param sPatientName - Patient Name
	 * @param sGoal - Patient Goal
	 * @param sGoalTargetDate = Goal Target Date
	 * @param sProblem - Problem
	 * @param sPatientAction - Patient Action
	 * @param sActionTargetDate - Action Target Date
	 * @param sActionStatus - Action Status
	 * @param sTaskActivity - 	Task Activity
	 * @param sTaskSubject - Task Subject
	 * @param sTaskDueDate - Task Due Date
	 * @param sTaskStatus - Task Status
	 * @param sBarrierCategory - Barrier Category
	 * @param sBarrier - Barrier
	 * @param sGoalProgress - Goal Progress	 
	 */
	private void set(
			String sQuestionText, String sQuestionType, String sPatient_Name)
	{
		
	
		this.sQuestionText = sQuestionText;	
		this.sQuestionType = sQuestionType;
		this.sPatient_Name = sPatient_Name;
			
	}



	@Override
	public String toString() {
		return "CreateAssessmentDetails [sQuestionText=" + sQuestionText + ", sQuestionType="
				+ sQuestionType
				+ ", sPatient_Name=" + sPatient_Name + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result
				+ ((sQuestionType == null) ? 0 : sQuestionType.hashCode());
		result = prime * result
				+ ((sPatient_Name == null) ? 0 : sPatient_Name.hashCode());
		result = prime * result
				+ ((sQuestionText == null) ? 0 : sQuestionText.hashCode());
		
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
		CreateAssessmentDetails other = (CreateAssessmentDetails) obj;
		if (sQuestionType == null) {
			if (other.sQuestionType != null)
				return false;
		} else if (!sQuestionType.equals(other.sQuestionType))
			return false;
		if (sPatient_Name == null) {
			if (other.sPatient_Name != null)
				return false;
		} else if (!sPatient_Name.equals(other.sPatient_Name))
			return false;
		if (sQuestionText == null) {
			if (other.sQuestionText != null)
				return false;
		} else if (!sQuestionText.equals(other.sQuestionText))
			return false;
		return true;
	}



	


	


	
}


