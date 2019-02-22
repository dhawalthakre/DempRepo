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


public class OptOut_SpecificRegistry extends TestTemplate {
	
	private static final String OptOutSpecificRegistry = "runOptOutSpecificRegistry";
	
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
		sTestDataFilePath = ConfigInfo.getTestDataPath() + "\\testdata_OptOut_SpecificRegistry.xlsx";		
		
		System.out.println(sTestDataFilePath);
		// Object array for testNG
		Object[][] testngDataObject = null;
		
		String sRegLibName=null, sViewName=null, sPatientName=null, 
				sCarePathwayName=null, sProgram=null, sOwnerName=null, sOwnerAlias=null;
		
		Excel_poi excel;
		try
		{
			excel = new Excel_poi(sTestDataFilePath, "OptOut_SpecificRegistry");
			
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
	public static void runOptOutSpecificRegistry(LoginDetails details, List<CarePathwayDetails> carePathwayDtl) throws InterruptedException, ParseException
	{
		/* Test case initiation */
		
		Report.logTitle(Framework.getNewLine() + "Method " + OptOutSpecificRegistry + " executing ..."
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
		TasksEventsPage taskeventPage = new TasksEventsPage(driver);
		OptOutPopup optoutPage = new OptOutPopup(driver);
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
				System.out.println(ccPatientPage.getCarePathwayStatus(carePathwayDetails));
				String sCarePathwayRefReason = ccPatientPage.getCarePathwayRefReason(carePathwayDetails).trim();
				System.out.println( ccPatientPage.getCarePathwayRefReason(carePathwayDetails));
				String sCarePathwayOwner = ccPatientPage.getCarePathwayOwner(carePathwayDetails).trim();
				System.out.println(ccPatientPage.getCarePathwayOwner(carePathwayDetails));
				System.out.println(sCarePathwayName.equalsIgnoreCase(ccpDtl.sCarePathwayName));
				System.out.println(sCarePathwayStatus);
				System.out.println(sCarePathwayRefReason.equalsIgnoreCase("Meets criteria"));
				System.out.println(sCarePathwayOwner.equalsIgnoreCase("Default"));

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
				//String sCarePathwayId = "CP-00002634";
						
				loginPage.loginAs(ConfigInfo.getsCarePathwayOwner(), ConfigInfo.getsCarePathwayOwnerPassword());
				ccHomePage.selectPatientView();
				ccmypatlstPage.selectPatientFromList("My Active Patients", ccpDtl.sPatientName);
				ccHomePage.selectPatientTab(ccpDtl.sPatientName);	
				
				ccPatientPage.clickCarePathwayLink();				
				ccPatientPage.clickCPLink(sCarePathwayId);
				carepathwayPage.selectSubTab(sCarePathwayId);
				
				carepathwayPage.switchCPWframe();
				carepathwayPage.clickOpenActivitiesLink();
				if(carepathwayPage.verifyRecordOpenActivities(ccpDtl.sOwnerName)==true){
					Report.logPass("Task has been created for Care Pathway - " 
				+ sCarePathwayId + " which is assigned to " + ccpDtl.sOwnerName);
				}
				else {
					Report.logError("No Record found in Open Activities section as Care Pathway is assigned to " + ccpDtl.sOwnerName);
				}
				carepathwayPage.selectSubTab("Tasks & Events");
				boolean flag = taskeventPage.verifyTaskForCarePathway(sCarePathwayId);
				if(flag){
					Report.logPass("Task is present");
				}
				else{
					Report.logError("Task is not present");
				}
				
				ArrayList arr = taskeventPage.getTaskDetails(sCarePathwayId);
				System.out.println(arr);
				carepathwayPage.switchTaskframe();
				taskeventPage.clickOptOutButton();
				//carepathwayPage.switchCPWframe();
				
				if(optoutPage.verifyCreateTaskCheckbox()==true){
					Report.logPass("Create a follow-up task on the selected end date checkbox is not present when Opt Out Registry is uncheck");
				}
				else{
					Report.logError("Create a follow-up task on the selected end date checkbox is present when Opt Out Registry is uncheck");
				}
				optoutPage.checkRegistryOptOutStatus();
				optoutPage.selectReasonRegistry("Do not contact");
				optoutPage.clickSaveButton();
				ccHomePage.selectPatientTab(ccpDtl.sPatientName);	
				
				ccPatientPage.clickCarePathwayLink();				
				
				ArrayList carePathwayDetails1 = ccPatientPage.getCarePathwayDetails();
				if(ccPatientPage.getCarePathwayStatus(carePathwayDetails1).trim().equalsIgnoreCase("Opted Out-Close")){
					Report.logPass("Care Pathway status has been updated to - " +ccPatientPage.getCarePathwayStatus(carePathwayDetails1).trim());
				}
				else{
					Report.logError("Care Pathway status has not been updated correctly to - " +ccPatientPage.getCarePathwayStatus(carePathwayDetails1).trim());
				}
				ccPatientPage.clickCPLink(sCarePathwayId);
				
				carepathwayPage.selectSubTab("Tasks & Events");
				ArrayList arr1 = taskeventPage.getTaskDetails(sCarePathwayId);
				System.out.println(arr1);
				
				ArrayList arr2 = taskeventPage.getTaskHistoryDetails(sCarePathwayId);
				System.out.println(arr2);
			
				homePage.clickLogout();
			}
			
		}	
		catch(RuntimeException ex){
			Report.logError("Care Pathway assignment and status change scenario failed.", ex);
		}
	}
}
