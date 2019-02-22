package com.advantage.tests.OptumOne;


import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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


public class CP_AssingmentAndStatusChange extends TestTemplate {
	
	private static final String AssingmentAndStatusChange = "runAssingmentAndStatusChange";
	
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
		sTestDataFilePath = ConfigInfo.getTestDataPath() + "\\testdata_CP_AssingmentAndStatusChange.xlsx";		
		
		System.out.println(sTestDataFilePath);
		// Object array for testNG
		Object[][] testngDataObject = null;
		
		String sRegLibName=null, sViewName=null, sPatientName=null, 
				sCarePathwayName=null, sProgram=null, sOwnerName=null, sOwnerAlias=null;
		
		Excel_poi excel;
		try
		{
			excel = new Excel_poi(sTestDataFilePath, "CP_AssingmentAndStatusChange");
			
			int iRowCount = excel.getExcelRowCount();
			int iColCount = excel.getExcelColumnCount();
			
			System.out.println(iRowCount);
			System.out.println(iColCount);
			
			// Initialize array which will store the test data			
			testngDataObject = new Object[1][2];
			
			// Loop through all the test cases and load the data into the array
			for (int i = 0; i < 1; i++)
			{
			
				// Construct the xpath to the specific test case
					
					List<CarePathwayDetails> carePathwayDtl = new ArrayList<CarePathwayDetails>();
					String[][] dataexcel= excel.getExcelSheetData();	
					
					LoginDetails details = null;

					for(int j=1;j<iRowCount;j++){
						for( int k=0;k<iColCount;k++) {					
						
							if(dataexcel[0][k].equals("RegistryLibrary")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sRegLibName = dataexcel[j][k];
								}
																	
							}
							else if(dataexcel[0][k].equals("ViewName")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sViewName = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("PatientName")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sPatientName = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("CarePathway")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sCarePathwayName = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Program")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sProgram = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("OwnerName")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sOwnerName = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("OwnerAlias")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sOwnerAlias = dataexcel[j][k];									
								}
							}
							
							else {
								Logs.logWarning("Invalid excel column name");
							}						
						}		
						
						// Instantiate the objects
						details = new LoginDetails(ConfigInfo.getsUserName(),ConfigInfo.getsPassword());		
										
						carePathwayDtl.add(new CarePathwayDetails(sRegLibName, sViewName, 
								sPatientName,sCarePathwayName, sProgram, sOwnerName, sOwnerAlias));							
					}	
					
					// Put in the object array for testNG
					testngDataObject[i][0] = details;
					
					// Put in the object array for testNG				
					testngDataObject[i][1] = carePathwayDtl;					
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
	public static void runAssingmentAndStatusChange(LoginDetails details, List<CarePathwayDetails> carePathwayDtl) throws InterruptedException, ParseException
	{
		/* Test case initiation */
		
		Report.logTitle(Framework.getNewLine() + "Method " + AssingmentAndStatusChange + " executing ..."
				+ Framework.getNewLine());		
		setScreenshotPreferences();
					
		/* Login to application */		
		Login loginPage = new Login(driver);
		AdministrationHomePage homePage = new AdministrationHomePage(driver);		
		RegistryLibraryHomePage reglibPage = new RegistryLibraryHomePage(driver);
		SelectedRegistryLibraryPage selectedRegLibPage = new SelectedRegistryLibraryPage(driver);
		CareCoordinationHomePage ccHomePage = new CareCoordinationHomePage(driver);
		CareCoordinationPatientPage ccPatientPage = new CareCoordinationPatientPage(driver);
		CarePathwayPage carepathwayPage =  new CarePathwayPage(driver);
		CareCoordinationMyPatientListPage ccmypatlstPage = new CareCoordinationMyPatientListPage(driver);
		TasksEventsPage taskPage = new TasksEventsPage(driver);
		try{
			for(CarePathwayDetails ccpDtl:carePathwayDtl){			
				
				loginPage.loginAs(details.sUserName, details.sPassword);
				if(homePage.verifyHomePage()==true){
					Report.logPass("User logged in successfully to the application");
				}
				else {
					Report.logError("Login failed to the application");
				}	
				
				homePage.verifyApp("Administration");
				
				homePage.selectTab("Registry Library");		
				if(reglibPage.verifyRegistryLibraryPage()==true){
					Report.logPass("Registry Library Page opened");
				}
				else {
					Report.logError("Registry Library Page is not opened");
				}	
				
				if(reglibPage.selectRegistryLibrary(ccpDtl.sRegLibName)==true){
					Report.logPass("Selected Registry Library Page opened");
				}
				else {
					Report.logError("Selected Registry Library Page is not opened");
				}
				reglibPage.clickViewLink(ccpDtl.sViewName);
				
				selectedRegLibPage.searchPatient(ccpDtl.sPatientName);
				
				if(selectedRegLibPage.verifySearchedPatient(ccpDtl.sPatientName)==true){
					Report.logPass("Patient search successful");
				}
				else {
					Report.logError("Paitent Search failed.");
				}	
				selectedRegLibPage.checkPatientCheckbox();
				selectedRegLibPage.selectCarePathWay(ccpDtl.sCarePathwayName);
				selectedRegLibPage.selectProgram(ccpDtl.sProgram);
				//selectedRegLibPage.checkAutoAssignmentToCC();
				selectedRegLibPage.clickAssociateCarePathwayButton();
				String msg = selectedRegLibPage.verifyMsg();
				if(msg.contains("Success")){
					Report.logPass("Care Pathway created and its success message is - " + msg);
				}
				else {
					Report.logError("Care Pathway is not created and its failure message is - " + msg);
				}
				
				selectedRegLibPage.clickPatientLink(ccpDtl.sPatientName);
				
				if(ccHomePage.verifyCareCoordinationApp()==true){
					Report.logPass("Care Coordination Home page is displayed");
				}
				else {
					Report.logError("Care Coordination Home page is not displayed");
				}
				
				ccHomePage.selectPatientTab(ccpDtl.sPatientName);
				
				
				ccPatientPage.clickCarePathwayLink();
				ArrayList carePathwayDetails = ccPatientPage.getCarePathwayDetails();		
				String sCarePathwayId = ccPatientPage.getCarePathwayID(carePathwayDetails).trim();
				String sCarePathwayName = ccPatientPage.getCarePathwayName(carePathwayDetails).trim();
				
				String sCarePathwayStatus = ccPatientPage.getCarePathwayStatus(carePathwayDetails).trim();
			
				String sCarePathwayRefReason = ccPatientPage.getCarePathwayRefReason(carePathwayDetails).trim();
				
				String sCarePathwayOwner = ccPatientPage.getCarePathwayOwner(carePathwayDetails).trim();
								
				if((sCarePathwayName.equalsIgnoreCase(ccpDtl.sCarePathwayName)) &&
					(sCarePathwayStatus.equalsIgnoreCase("Enrollment pending")) &&
					(sCarePathwayRefReason.equalsIgnoreCase("Meets criteria")) &&
					(sCarePathwayOwner.equalsIgnoreCase("Default"))) {
					
					Report.logPass("Care Pathway created with ID -" + sCarePathwayId + " for patient - " 
					+ ccpDtl.sPatientName + " which is assigned to owner - " + sCarePathwayOwner +
					" and its status - " + sCarePathwayStatus + " and referral reason is " + sCarePathwayRefReason);
				}
				else {
					Report.logError("Care Pathway is not created for patient - " + ccpDtl.sPatientName);
				}
				ccPatientPage.clickCPLink(sCarePathwayId);
				carepathwayPage.selectSubTab(sCarePathwayId);
				/*if(carepathwayPage.verifyCarePathwayPageTitle(sCarePathwayId)==true){
					Report.logPass(sCarePathwayId + " Care Pathway page is displayed.");
				}
				else {
					Report.logError(sCarePathwayId + " Care Pathway page is not displayed");
				}*/
				carepathwayPage.switchCPWframe();
				carepathwayPage.clickOpenActivitiesLink();
				
				if(carepathwayPage.verifyNoRecordOpenActivities()==true){
					Report.logPass("No task has been created for Care Pathway - " 
				+ sCarePathwayId + " which is assigned to " + sCarePathwayOwner);
				}
				else {
					Report.logError("Record found in Open Activities section as Care Pathway is assigned to " + sCarePathwayOwner);
				}
				carepathwayPage.assignCarePathwayOwner(ccpDtl.sOwnerName);
				
				carepathwayPage.clickOpenActivitiesLink();
				if(carepathwayPage.verifyNoRecordOpenActivities()==false){
					Report.logPass("Task has been created for Care Pathway - " 
				+ sCarePathwayId + " which is assigned to " + ccpDtl.sOwnerName);
				}
				else {
					Report.logError("No Record found in Open Activities section as Care Pathway is assigned to " + ccpDtl.sOwnerName);
				}
				carepathwayPage.closeAllSubTabs();
				ccHomePage.closeAllTabs();
				homePage.clickLogout();
				ccHomePage.verifyLoginPage();
				//String sCarePathwayId = "CP-00029333";
						
				loginPage.loginAs(ConfigInfo.getsCarePathwayOwner(), ConfigInfo.getsCarePathwayOwnerPassword());
				ccHomePage.selectPatientView();
				ccmypatlstPage.selectPatientFromList("My Active Patients", ccpDtl.sPatientName);
				ccHomePage.selectPatientTab(ccpDtl.sPatientName);	
				
				ccPatientPage.clickCarePathwayLink();				
				ccPatientPage.clickCPLink(sCarePathwayId);
				
				//carepathwayPage.closeTask();
				carepathwayPage.selectSubTab("Tasks & Events");
				boolean flag = taskPage.verifyTaskForCarePathway(sCarePathwayId);
				if(flag){
					Report.logPass("Task is present");
				}
				else{
					Report.logError("Task is not present");
				}
				//taskPage.clickOnClSLink(sCarePathwayId);
				taskPage.closeTask(sCarePathwayId);
				carepathwayPage.selectSubTab(sCarePathwayId);
				carepathwayPage.closeCarePathway("Closed", "Discontinued");
				ArrayList arrList = carepathwayPage.getCarePathwayDetails(sCarePathwayId);
				carepathwayPage.closeAllSubTabs();
				ccHomePage.closeAllTabs();
				if(ccmypatlstPage.verifyPatientList("My Active Patients", ccpDtl.sPatientName)==true){
					Report.logPass(ccpDtl.sPatientName + " patient not found in My Active Patients as care pathway is closed");
				}
				else {
					Report.logError(ccpDtl.sPatientName + " patient found in My Active Patients as care pathway is closed");
				}
				
				if(ccmypatlstPage.verifyPatientList("All My Patients", ccpDtl.sPatientName)==false){
					Report.logPass(ccpDtl.sPatientName + " patient found in All My Patients");
				}
				else {
					Report.logError(ccpDtl.sPatientName + " patient not found in All My Patients");
				}
				
				ccHomePage.selectCarePathwayView("All Care Pathways from Registries");
				ccHomePage.sortCPWColumn();				
							
			/*	if((ccHomePage.verifyCarePathwayStatusFromGrid(sCarePathwayId, "Closed") ==true) &&
					(ccHomePage.verifyCarePathwayCloseReasonFromGrid(sCarePathwayId, "Discontinued") ==true) &&
					(ccHomePage.verifyCarePathwayOwnerFromGrid(sCarePathwayId, ccpDtl.sOwnerAlias)==true)){
					
					Report.logPass(sCarePathwayId + " Care Pathway has been closed with reason Discontinued which is assigned to owner " + ccpDtl.sOwnerName);					
				}
				else {
					Report.logError(sCarePathwayId + " Care Pathway status change step failed.");
				}*/
				
				if(ccHomePage.verifyCarePathwayDetailsFromGrid(sCarePathwayId,"Closed", "Discontinued", ccpDtl.sOwnerAlias)==true){
					Report.logPass(sCarePathwayId + " Care Pathway has been closed with reason Discontinued which is assigned to owner " + ccpDtl.sOwnerName);					
				}
				else {
					Report.logError(sCarePathwayId + " Care Pathway status change step failed.");
				}
				
				homePage.clickLogout();
			}
			
		}	
		catch(RuntimeException ex){
			Report.logError("Care Pathway assignment and status change scenario failed.", ex);
		}
	}
}
