package com.advantage.datastructures.OptumOne;


/**
 * Data Structure to hold variables for Plan of Care
 */
public class PlanOfCareDetails {
	public String sPatientName, 
	sGoal, sGoalTargetDate, sProblem, sPatientAction, sActionTargetDate,sActionStatus, 
	sTaskActivity, sTaskSubject, sTaskDueDate, sTaskStatus, sBarrierCategory, sBarrier, sGoalProgress;
	

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
	public PlanOfCareDetails(String sPatientName, 
			String sGoal, String sGoalTargetDate, String sProblem, String sPatientAction, String sActionTargetDate, String sActionStatus, 
			String sTaskActivity, String sTaskSubject, String sTaskDueDate, 
			String sTaskStatus, String sBarrierCategory, String sBarrier, String sGoalProgress)
	{
		
		set(sPatientName, 
				sGoal, sGoalTargetDate, sProblem, sPatientAction, sActionTargetDate,sActionStatus, 
				sTaskActivity, sTaskSubject, sTaskDueDate, sTaskStatus, sBarrierCategory, sBarrier, sGoalProgress);
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
	private void set(String sPatientName, 
			String sGoal, String sGoalTargetDate, String sProblem, String sPatientAction, String sActionTargetDate, String sActionStatus, 
			String sTaskActivity, String sTaskSubject, String sTaskDueDate, 
			String sTaskStatus, String sBarrierCategory, String sBarrier, String sGoalProgress)
	{
		
		this.sPatientName = sPatientName;	
		this.sGoal = sGoal;	
		this.sGoalTargetDate = sGoalTargetDate;
		this.sProblem = sProblem;
		this.sPatientAction = sPatientAction;
		this.sActionTargetDate = sActionTargetDate;
		this.sActionStatus = sActionStatus;
		this.sTaskActivity = sTaskActivity;
		this.sTaskSubject = sTaskSubject;
		this.sTaskDueDate = sTaskDueDate;
		this.sTaskStatus = sTaskStatus;
		this.sBarrierCategory = sBarrierCategory;
		this.sBarrier = sBarrier;
		this.sGoalProgress = sGoalProgress;		
	}



	@Override
	public String toString() {
		return "PlanOfCareDetails [sPatientName=" + sPatientName + ", sGoal="
				+ sGoal + ", sGoalTargetDate=" + sGoalTargetDate
				+ ", sProblem=" + sProblem + ", sPatientAction="
				+ sPatientAction + ", sActionTargetDate=" + sActionTargetDate
				+ ", sActionStatus=" + sActionStatus + ", sTaskActivity="
				+ sTaskActivity + ", sTaskSubject=" + sTaskSubject
				+ ", sTaskDueDate=" + sTaskDueDate + ", sTaskStatus="
				+ sTaskStatus + ", sBarrierCategory=" + sBarrierCategory
				+ ", sBarrier=" + sBarrier + ", sGoalProgress=" + sGoalProgress
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sActionStatus == null) ? 0 : sActionStatus.hashCode());
		result = prime
				* result
				+ ((sActionTargetDate == null) ? 0 : sActionTargetDate
						.hashCode());
		result = prime * result
				+ ((sBarrier == null) ? 0 : sBarrier.hashCode());
		result = prime
				* result
				+ ((sBarrierCategory == null) ? 0 : sBarrierCategory.hashCode());
		result = prime * result + ((sGoal == null) ? 0 : sGoal.hashCode());
		result = prime * result
				+ ((sGoalProgress == null) ? 0 : sGoalProgress.hashCode());
		result = prime * result
				+ ((sGoalTargetDate == null) ? 0 : sGoalTargetDate.hashCode());
		result = prime * result
				+ ((sPatientAction == null) ? 0 : sPatientAction.hashCode());
		result = prime * result
				+ ((sPatientName == null) ? 0 : sPatientName.hashCode());
		result = prime * result
				+ ((sProblem == null) ? 0 : sProblem.hashCode());
		result = prime * result
				+ ((sTaskActivity == null) ? 0 : sTaskActivity.hashCode());
		result = prime * result
				+ ((sTaskDueDate == null) ? 0 : sTaskDueDate.hashCode());
		result = prime * result
				+ ((sTaskStatus == null) ? 0 : sTaskStatus.hashCode());
		result = prime * result
				+ ((sTaskSubject == null) ? 0 : sTaskSubject.hashCode());
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
		PlanOfCareDetails other = (PlanOfCareDetails) obj;
		if (sActionStatus == null) {
			if (other.sActionStatus != null)
				return false;
		} else if (!sActionStatus.equals(other.sActionStatus))
			return false;
		if (sActionTargetDate == null) {
			if (other.sActionTargetDate != null)
				return false;
		} else if (!sActionTargetDate.equals(other.sActionTargetDate))
			return false;
		if (sBarrier == null) {
			if (other.sBarrier != null)
				return false;
		} else if (!sBarrier.equals(other.sBarrier))
			return false;
		if (sBarrierCategory == null) {
			if (other.sBarrierCategory != null)
				return false;
		} else if (!sBarrierCategory.equals(other.sBarrierCategory))
			return false;
		if (sGoal == null) {
			if (other.sGoal != null)
				return false;
		} else if (!sGoal.equals(other.sGoal))
			return false;
		if (sGoalProgress == null) {
			if (other.sGoalProgress != null)
				return false;
		} else if (!sGoalProgress.equals(other.sGoalProgress))
			return false;
		if (sGoalTargetDate == null) {
			if (other.sGoalTargetDate != null)
				return false;
		} else if (!sGoalTargetDate.equals(other.sGoalTargetDate))
			return false;
		if (sPatientAction == null) {
			if (other.sPatientAction != null)
				return false;
		} else if (!sPatientAction.equals(other.sPatientAction))
			return false;
		if (sPatientName == null) {
			if (other.sPatientName != null)
				return false;
		} else if (!sPatientName.equals(other.sPatientName))
			return false;
		if (sProblem == null) {
			if (other.sProblem != null)
				return false;
		} else if (!sProblem.equals(other.sProblem))
			return false;
		if (sTaskActivity == null) {
			if (other.sTaskActivity != null)
				return false;
		} else if (!sTaskActivity.equals(other.sTaskActivity))
			return false;
		if (sTaskDueDate == null) {
			if (other.sTaskDueDate != null)
				return false;
		} else if (!sTaskDueDate.equals(other.sTaskDueDate))
			return false;
		if (sTaskStatus == null) {
			if (other.sTaskStatus != null)
				return false;
		} else if (!sTaskStatus.equals(other.sTaskStatus))
			return false;
		if (sTaskSubject == null) {
			if (other.sTaskSubject != null)
				return false;
		} else if (!sTaskSubject.equals(other.sTaskSubject))
			return false;
		return true;
	}



	
}