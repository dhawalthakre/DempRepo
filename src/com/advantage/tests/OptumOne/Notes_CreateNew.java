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


public class Notes_CreateNew extends TestTemplate {
	
	private static final String Notes_CreateNew = "runNotes_CreateNew";
	
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
		sTestDataFilePath = ConfigInfo.getTestDataPath() + "\\testdata_CreateNewNote.xlsx";		
		
		System.out.println(sTestDataFilePath);
		// Object array for testNG
		Object[][] testngDataObject = null;
		
		String sRegLibName=null, sViewName=null, sPatientName=null, 
				sCarePathwayName=null, sProgram=null, sOwnerName=null, sOwnerAlias=null,
				sText=null, sName=null, sActivity=null, sOtherActivity=null, 
				sSubject=null, sOtherSubject=null, sDueDate=null, sPriority=null,
				sStatus=null, sDuration=null, sDesc=null;
		
		Excel_poi excel;
		try
		{
			excel = new Excel_poi(sTestDataFilePath, "Create_NewNote");
			
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
					
					List<CreateNoteAndTaskDetails> createNoteDtl = new ArrayList<CreateNoteAndTaskDetails>();
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
							else if(dataexcel[0][k].equals("QuickText")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sText = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskOwnerName")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sName = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskActivity")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sActivity = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskOtherActivity")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sOtherActivity = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskSubject")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sSubject = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskOtherSubject")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sOtherSubject = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskDueDate")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sDueDate = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskPriority")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sPriority = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskStatus")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sStatus = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskDuration")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sDuration = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("TaskDesc")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sDesc = dataexcel[j][k];									
								}
							}
							
							else {
								Logs.logWarning("Invalid excel column name");
							}						
						}		
						
						// Instantiate the objects
						details = new LoginDetails(ConfigInfo.getsUserName(),ConfigInfo.getsPassword());		
										
						createNoteDtl.add(new CreateNoteAndTaskDetails(sRegLibName, sViewName, 
								sPatientName,sCarePathwayName, sProgram, sOwnerName, sOwnerAlias,sText, 
								sName, sActivity, sOtherActivity, sSubject, sOtherSubject, sDueDate, sPriority,
								sStatus, sDuration, sDesc));							
					}	
					
					// Put in the object array for testNG
					testngDataObject[i][0] = details;
					
					// Put in the object array for testNG				
					testngDataObject[i][1] = createNoteDtl;					
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
	public static void runNotes_CreateNew(LoginDetails details, List<CreateNoteAndTaskDetails> createNoteDtl) throws InterruptedException, ParseException
	{
		/* Test case initiation */
		
		Report.logTitle(Framework.getNewLine() + "Method " + Notes_CreateNew + " executing ..."
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
		NotesPage notePage = new NotesPage(driver);
		TasksEventsPage taskPage = new TasksEventsPage(driver);
		NotesWidgetPage noteWidgetPage = new NotesWidgetPage(driver);
		try{
			for(CreateNoteAndTaskDetails ccpDtl:createNoteDtl){			
				
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
				selectedRegLibPage.errorDialog();
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
				//String sCarePathwayId = "CP-00029296";
						
				loginPage.loginAs(ConfigInfo.getsCarePathwayOwner(), ConfigInfo.getsCarePathwayOwnerPassword());
				//homePage.verifyApp("Care Coordination");
				ccHomePage.selectPatientView();
				ccmypatlstPage.selectPatientFromList("My Active Patients", ccpDtl.sPatientName);
				ccHomePage.selectPatientTab(ccpDtl.sPatientName);	
				ccPatientPage.clickCarePathwayLink();				
				ccPatientPage.clickCPLink(sCarePathwayId);
				carepathwayPage.selectSubTab("Notes");
				
				notePage.clickNewNoteButton();
				noteWidgetPage.createNoteAndTask(ccpDtl.sText, ccpDtl.sName, ccpDtl.sActivity,
						ccpDtl.sOtherActivity, ccpDtl.sSubject, ccpDtl.sOtherSubject, ccpDtl.sDueDate, 
						ccpDtl.sPriority, ccpDtl.sStatus, ccpDtl.sDuration, ccpDtl.sDesc);
				
				ArrayList noteDetails = notePage.getNotesDetails(ccpDtl.sText);
				String sNoteID = notePage.getNoteID(noteDetails);
				String sTagName = notePage.getTagName(noteDetails);
				
				if(((sNoteID.isEmpty()==false) && (sTagName.contains(ccpDtl.sText)))){
					Report.logPass("Note has been created with tag name - " + ccpDtl.sText + " and tag name is "  + sNoteID);
				}
				else {
					Report.logError("Task creation failed");
				}				

				
				carepathwayPage.selectSubTab(sCarePathwayId);
				carepathwayPage.switchCPWframe();
				carepathwayPage.clickOpenActivitiesLink();
				carepathwayPage.OpenActivitycloseTask();
				
				carepathwayPage.selectSubTab(sCarePathwayId);
				carepathwayPage.closeCarePathway("Closed", "Discontinued");
				ArrayList arrList = carepathwayPage.getCarePathwayDetails(sCarePathwayId);
				System.out.println(arrList);
				carepathwayPage.closeAllSubTabs();
				ccHomePage.closeAllTabs();
				homePage.clickLogout();
			}
			
		}	
		catch(RuntimeException ex){
			Report.logError("Create Note scenario failed.", ex);
		}
	}
}
