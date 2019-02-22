package com.advantage.tests.OptumOne;


import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.advantage.datastructures.OptumOne.*;
import com.advantage.fileutils.Excel_poi;
import com.advantage.framework.Framework;
import com.advantage.framework.TestTemplate;
import com.advantage.pages.OptumOne.*;
import com.advantage.reporting.Logs;
import com.advantage.reporting.Report;


public class PlanOfCare extends TestTemplate {
	
	private static final String PlanOfCare = "runPlanOfCare";
	
	/**i
	 * Initializes all variables from config file
	 * 
	 * @param sUseConfigFile - Configuration file to load variables from
	 */
	@Parameters("sUseConfigFile")
	@BeforeSuite(groups = "setup")
	// @Override
	public void initialization(@Optional(CONFIG_FILE) String sUseConfigFile)
	{
		
	}
	
	/**
	 * Gets data driven values for the test. (This is used for both positive & negative tests.)
	 * 
	 * @param m
	 * @return data for testNG
	 */
	@DataProvider(name = "DataFromExcel")
	public static Object[][] dataForLogin1(Method m)
	{
		String sTestDataFilePath;		
		sTestDataFilePath = ConfigInfo.getTestDataPath() + "\\testdata_PlanOfCare.xlsx";		
		
		System.out.println(sTestDataFilePath);
		// Object array for testNG
		Object[][] testngDataObject = null;
		
		String sPatientName=null, sGoal=null, sGoalTargetDate=null, sProblem=null, sPatientAction=null, sActionTargetDate=null,
				sActionStatus=null, sTaskActivity=null, sTaskSubject=null, sTaskDueDate=null, 
				sTaskStatus=null, sBarrierCategory=null, sBarrier=null, sGoalProgress=null;
		
		Excel_poi excel;
		try
		{
			excel = new Excel_poi(sTestDataFilePath, "Planofcare");
			
			int iRowCount = excel.getExcelRowCount();
			int iColCount = excel.getExcelColumnCount();
			
			System.out.println(iRowCount);
			System.out.println(iColCount);
			
			// Initialize array which will store the test data			
			testngDataObject = new Object[1][1];
			
			// Loop through all the test cases and load the data into the array
			for (int i = 0; i < 1; i++)
			{
			
				// Construct the xpath to the specific test case
					
					List<PlanOfCareDetails> planofcareDtl = new ArrayList<PlanOfCareDetails>();
					String[][] dataexcel= excel.getExcelSheetData();	
					
					LoginDetails details = null;

					for(int j=1;j<iRowCount;j++){
						for( int k=0;k<iColCount;k++) {					
						
							if(dataexcel[0][k].equals("PatientName")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sPatientName = dataexcel[j][k];
								}
																	
							}
							else if(dataexcel[0][k].equals("Goal")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sGoal = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Goal_Target_Date")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sGoalTargetDate = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Problem")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sProblem = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Patient_Action")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sPatientAction = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Action_Target_Date")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sActionTargetDate = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Action_Status")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sActionStatus = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("Task_Activity")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sTaskActivity = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("Task_Subject")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sTaskSubject = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("Task_Due_Date")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sTaskDueDate = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("Task_Status")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sTaskStatus = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("Barrier_Category")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sBarrierCategory = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("Barrier")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sBarrier = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("Goal_Progress")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sGoalProgress = dataexcel[j][k];									
								}
							}							
							else {
								Logs.logWarning("Invalid excel column name");
							}						
						}		
						
						// Instantiate the objects										
						planofcareDtl.add(new PlanOfCareDetails(sPatientName, 
								sGoal, sGoalTargetDate, sProblem, sPatientAction, sActionTargetDate,sActionStatus, 
								sTaskActivity, sTaskSubject, sTaskDueDate, sTaskStatus, 
								sBarrierCategory, sBarrier, sGoalProgress));							
					}	
					
					// Put in the object array for testNG
					testngDataObject[i][0] = planofcareDtl;		
								
				}
			
		}
		
		catch (Exception ex)
		{
			Logs.logError("Unable to read test data", ex);
			browser.quitBrowser();
			System.exit(0);
		}			
		
		return testngDataObject;
	}
	
	/**
	 * Test the create new user functionality
	 * 
	 * 
	 * @param details - Login detail variables
	 * @param lstNewUser - List of new user test case
	 * @throws InterruptedException 
	 * @throws ParseException 
	 */

	@Test(dataProvider = "DataFromExcel")
	public static void runPlanOfCare(List<PlanOfCareDetails> planofcareDtl) throws InterruptedException, ParseException
	{
		/* Test case initiation */
		
		Report.logTitle(Framework.getNewLine() + "Method " + PlanOfCare + " executing ..."
				+ Framework.getNewLine());		
		setScreenshotPreferences();
					
		/* Login to application */		
		Login loginPage = new Login(driver);
		CareCoordinationHomePage ccHomePage = new CareCoordinationHomePage(driver);	
		CareCoordinationMyPatientListPage ccPatientListPage = new CareCoordinationMyPatientListPage(driver);
		AdministrationHomePage adminHomePage = new AdministrationHomePage(driver);
		CarePathwayPage carepathwayPage =  new CarePathwayPage(driver);
		PlanOfCarePage plancarePage = new PlanOfCarePage(driver);
		try{
			for(PlanOfCareDetails plancareDtl:planofcareDtl){			
				
				loginPage.loginAs(ConfigInfo.getsCarePathwayOwner(), ConfigInfo.getsCarePathwayOwnerPassword());
				if(ccHomePage.verifyCCUserLoggedIn()==true){
					Report.logPass("Care Coordinator User logged in successfully to the application");
				}
				else {
					Report.logError("Login failed to the application");
				}					
				
				ccHomePage.selectPatientView();
				if(ccPatientListPage.verifyPageTitle()==true){
					Report.logPass("My Patient Page opened successfully.");					
				}
				else {
					Report.logError("Failed to open My Patient Page.");
				}
				ccPatientListPage.selectPatientFromList("My Active Patients", plancareDtl.sPatientName);
				if(ccHomePage.verifyPatientConsolePage(plancareDtl.sPatientName)==true){
					Report.logPass("Patient Console Page opened successfully.");					
				}
				else {
					Report.logError("Failed to open Patient Console Page.");
				}			
				ccHomePage.selectPatientTab(plancareDtl.sPatientName);					
				carepathwayPage.selectSubTab("Plan Of Care");
				plancarePage.switchToPlanOfCareIFrame();
				plancarePage.clickNewPatientGoalButton();
				plancarePage.searchGoal(plancareDtl.sGoal);
				if(plancarePage.verifyGoalSearchResult(plancareDtl.sGoal)==true){
					plancarePage.dragdropGoalToInFocus(plancareDtl.sGoal);
				}				
				plancarePage.clickCloseButton();
				
				if(plancarePage.verifyInFocusDraggedGoal(plancareDtl.sGoal)== true){
					Report.logPass("Goal dragged successfully in category area");
				}
				else{
					Report.logError("Drag-drop operation failed.");
				}
				
				plancarePage.clickGoalEditLink();
				plancarePage.enterGoalTargetDate(plancareDtl.sGoalTargetDate);
				
				plancarePage.enterProblem("In Focus", plancareDtl.sProblem);
				
				if(plancarePage.verifyProblem(plancareDtl.sProblem)==true){
					Report.logPass("Problem is correctly saved - " + plancareDtl.sProblem);
				}
				else {
					Report.logError("Problem is not correctly saved - " + plancareDtl.sProblem);
				}
				
				plancarePage.clickAddActionLink();
				plancarePage.verifyActionModalDialog();
				
				plancarePage.selectActionText("In Focus", plancareDtl.sPatientAction);
				plancarePage.enterActionTargetDate("In Focus", plancareDtl.sActionTargetDate);
				plancarePage.selectActionStatus("In Focus", plancareDtl.sActionStatus);
				plancarePage.clickActionSaveButton();
				
				if(plancarePage.verifyActionText(plancareDtl.sPatientAction)){
					Report.logPass("Action Text is correctly saved - " + plancareDtl.sPatientAction);
				}
				else {
					Report.logError("Action Text is not correctly saved - " + plancareDtl.sPatientAction);
				}
				
				if(plancarePage.verifyActionTargetDate(plancareDtl.sActionTargetDate)){
					Report.logPass("Action Target Date is correctly saved - " + plancareDtl.sActionTargetDate);
				}
				else {
					Report.logError("Action Target Date is not correctly saved - " + plancareDtl.sActionTargetDate);
				}
				
				/*plancarePage.clickAddTaskLink();
				plancarePage.verifyTaskModalDialog();
				plancarePage.selectTaskActivity("In Focus", plancareDtl.sTaskActivity);
				plancarePage.selectTaskSubject("In Focus", plancareDtl.sTaskSubject);
				plancarePage.enterTaskDueDate("In Focus", plancareDtl.sTaskDueDate);
				plancarePage.selectTaskPriority("In Focus", "Medium");
				plancarePage.selectTaskStatus("In Focus", plancareDtl.sTaskStatus);
				plancarePage.clickTaskSaveButton();*/
				
				/*plancarePage.clickManageBarrierstoCareLink();
				plancarePage.verifyBarrierModalDialog();
				plancarePage.clickNewBarrierButton();
				plancarePage.verifyNewBarrierModalDialog();
				plancarePage.selectBarrierCategory("In Focus", plancareDtl.sBarrierCategory);
				plancarePage.selectBarrier("In Focus", plancareDtl.sBarrier);
				plancarePage.clickNewBarrierSaveButton();*/
				
				plancarePage.clickGoalSaveButton();
				plancarePage.clickGoalCommitDialogYesButton();
				
				plancarePage.clickGoalEditLink();
				
				if(plancarePage.verifyGoal(plancareDtl.sGoal)==true){
					Report.logPass("Goal is correctly saved - " + plancareDtl.sGoal);
				}
				else {
					Report.logError("Goal is not correctly saved - " + plancareDtl.sGoal);
				}
				
				if(plancarePage.verifyGoalTargetDate(plancareDtl.sGoalTargetDate)==true){
					Report.logPass("Goal Target Date is correctly saved - " + plancareDtl.sGoalTargetDate);
				}
				else {
					Report.logError("Goal Target Date is not correctly saved - " + plancareDtl.sGoalTargetDate);
				}
				
				if(plancarePage.verifyProblem(plancareDtl.sProblem)==true){
					Report.logPass("Problem is correctly saved - " + plancareDtl.sProblem);
				}
				else {
					Report.logError("Problem is not correctly saved - " + plancareDtl.sProblem);
				}
				
				plancarePage.clickCancelButton();
				//CleanUp
				plancarePage.clickGoalRemoveLink();
				plancarePage.clickWarningDialogToRemoveGoalYesButton();
				carepathwayPage.closeAllSubTabs();
				ccHomePage.closeAllTabs();
				adminHomePage.clickLogout();
				
			}
			
		}	
		catch(RuntimeException ex){
			Report.logError("Plan of Care scenario failed.", ex);
		}
	}
}
