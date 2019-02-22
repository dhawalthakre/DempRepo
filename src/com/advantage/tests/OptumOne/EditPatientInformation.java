package com.advantage.tests.OptumOne;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.advantage.datastructures.OptumOne.*;
import com.advantage.tests.DataProviderClass.*;
import com.advantage.framework.Framework;
import com.advantage.framework.TestTemplate;
import com.advantage.pages.OptumOne.*;
import com.advantage.reporting.Report;


public class EditPatientInformation extends TestTemplate {
	
	private static final String UpdatePatientInformation = "runUpdatePatientInformation";
	
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
	 * Test the create new user functionality
	 * 
	 * 
	 * @param details - Login detail variables
	 * @param lstNewUser - List of new user test case
	 * @throws InterruptedException 
	 * @throws ParseException 
	 */

	@Test(dataProvider = "PatientInfoPrimaryContactDetails", dataProviderClass=DataProviderClass.class)
	public static void runUpdatePatientInformation(LoginDetails details, List<PatientInfoPrimaryContactDetails> PatientDtl) throws InterruptedException, ParseException
	{
		/* Test case initiation */
		
		Report.logTitle(Framework.getNewLine() + "Method " + UpdatePatientInformation + " executing ..."
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
		try{
			for(PatientInfoPrimaryContactDetails patientDtl:PatientDtl){							
				loginPage.loginAs(details.sUserName, details.sPassword);
				ccHomePage.selectPatientView();
				ccmypatlstPage.selectPatientFromList("My Active Patients", patientDtl.sPatientName);
				ccHomePage.selectPatientTab1(patientDtl.sPatientName);	
				
				ccPatientPage.clickEditPatientInfoLink();
				/*if(ccPatientPage.verifyEditPatientInfoModalHeader()==true){
					Report.logPass("Edit Patient Information Modal Dialog opened successfully.");
				}
				else{
					Report.logError("Edit Patient Information Modal Dialog doesnot opened.");
				}*/
				ccPatientPage.editPatientInfo(patientDtl.sAtAGlance, patientDtl.sAcuityNotes, patientDtl.sAcuityScore);
				ccHomePage.selectPatientTab1(patientDtl.sPatientName);	
				ArrayList arrPatientInfo = ccPatientPage.verifyPatientInformation();
				System.out.println(arrPatientInfo);

				
				if((ccPatientPage.getPatientNameInfo(arrPatientInfo).trim().contains(patientDtl.sPatientName)) &&
						(ccPatientPage.getAcuityScoreInfo(arrPatientInfo).trim().equalsIgnoreCase(patientDtl.sAcuityScore))&&
						(ccPatientPage.getAcuityNotesInfo(arrPatientInfo).trim().equalsIgnoreCase(patientDtl.sAcuityNotes))&&
						(ccPatientPage.getAtAGlanceInfo(arrPatientInfo).trim().equalsIgnoreCase(patientDtl.sAtAGlance))){
					Report.logPass("Patient Information edited successfully.");
				}
				else{
					Report.logError("Edit Patient Information failed.");
				}
				ccHomePage.selectPatientTab1(patientDtl.sPatientName);
				ccPatientPage.clickAcuityScoreLink();
				
				if(ccPatientPage.verifyAcuityScoreRecord(patientDtl.sAcuityScore, patientDtl.sAcuityNotes)==true){
					Report.logPass("Acuity score has record entry for edit patient information.");					
				}
				else{
					Report.logError("Acuity score doesnot show edit patient information record.");
				}
				homePage.clickLogout();
			}
			
		}	
		catch(RuntimeException ex){
			Report.logError("Care Pathway assignment and status change scenario failed.", ex);
		}
	}
}
