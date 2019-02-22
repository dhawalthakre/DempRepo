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


public class Patient_PrimaryContactDetails extends TestTemplate {
	
	private static final String PatientPrimaryConactDetails = "runPatientPrimaryConactDetails";
	
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
	public static void runPatientPrimaryConactDetails(LoginDetails details, List<PatientInfoPrimaryContactDetails> PatientDtl) throws InterruptedException, ParseException
	{
		/* Test case initiation */
		
		Report.logTitle(Framework.getNewLine() + "Method " + PatientPrimaryConactDetails + " executing ..."
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
				
				
				homePage.clickLogout();
			}
			
		}	
		catch(RuntimeException ex){
			Report.logError("Care Pathway assignment and status change scenario failed.", ex);
		}
	}
}
