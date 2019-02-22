package com.advantage.tests.OptumOne;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.advantage.pages.OptumOne.*;
import com.advantage.datastructures.OptumOne.*;
import com.advantage.fileutils.Excel_poi;
import com.advantage.framework.Framework;
import com.advantage.framework.TestTemplate;
import com.advantage.pages.OptumOne.AdministrationHomePage;
import com.advantage.reporting.Logs;
import com.advantage.reporting.Report;

public class CreateAssessment extends TestTemplate{
	
	static String assessmentstatus;
	String assessmentname = "AE_Automation_POC";
	String patientname;
	
	@Parameters("sUseConfigFile")
	@BeforeSuite(groups = "setup")
	// @Override
	public void initialization(@Optional(CONFIG_FILE) String sUseConfigFile)
	{
		
	}
	
	@DataProvider(name = "DataFromExcel")
	public static Object[][] dataForLogin1(Method m)
	{
		String sTestDataFilePath;		
		sTestDataFilePath = ConfigInfo.getTestDataPath() + "\\testdata_CreateAssessment.xlsx";		
		
		System.out.println(sTestDataFilePath);
		// Object array for testNG
		Object[][] testngDataObject = null;
		
		String sAssessment_Name=null, sQuestionText=null, sQuestionType=null, sPatient_Name=null;
		
		Excel_poi excel;
		try
		{
			excel = new Excel_poi(sTestDataFilePath, "CreateAssessment");
			
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
					
					List<CreateAssessmentDetails> assessmentDtl = new ArrayList<CreateAssessmentDetails>();
					String[][] dataexcel= excel.getExcelSheetData();	
					
					LoginDetails details = null;

					for(int j=1;j<iRowCount;j++){
						for( int k=0;k<iColCount;k++) {					
						
							if(dataexcel[0][k].equals("QuestionText")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sQuestionText = dataexcel[j][k];
								}
																	
							}
							else if(dataexcel[0][k].equals("QuestionType")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sQuestionType = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Patient_Name")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {									
									sPatient_Name = dataexcel[j][k];
								}
							}
							else {
								Logs.logWarning("Invalid excel column name");
							}						
						}		
						
						// Instantiate the objects										
						assessmentDtl.add(new CreateAssessmentDetails(sQuestionText, sQuestionType, sPatient_Name));							
					}	
					
					// Put in the object array for testNG
					testngDataObject[i][0] = assessmentDtl;		
								
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
	
	@Test(dataProvider = "DataFromExcel")
	public void createAssessment(List<CreateAssessmentDetails> assessmentDtl) throws InterruptedException, ParseException{
	
		Login loginPage = new Login(driver);
		AdministrationHomePage adminHomePage = new AdministrationHomePage(driver);
		CareCoordinationHomePage ccHomePage = new CareCoordinationHomePage(driver);	
		CareCoordinationMyPatientListPage ccPatientListPage = new CareCoordinationMyPatientListPage(driver);
		loginPage.loginAs(ConfigInfo.getsCarePathwayOwner(), ConfigInfo.getsCarePathwayOwnerPassword());
		adminHomePage.verifyHomePage();
		adminHomePage.verifyApp("Assessment Builder");
		AssessmentListPage assessmentPage = new AssessmentListPage(driver);
		assessmentPage.verifyAssessmentListPage(driver);
		EditAssessmentPage editassessmentpage = new EditAssessmentPage(driver);
		String asmntname = createRandomName(assessmentname);
		assessmentPage.gotoEditAssessment(driver, asmntname);
		try{
		for(CreateAssessmentDetails asmntDtl:assessmentDtl){
		patientname = asmntDtl.sPatient_Name;
		//editassessmentpage.verifyEditAssessmentPage(driver);
		if(asmntDtl.sQuestionType.equalsIgnoreCase("RadioButton")){
		editassessmentpage.AddQuestionRadioButton(driver, asmntDtl.sQuestionText);
		
		}else if(asmntDtl.sQuestionType.equalsIgnoreCase("Checkbox")){
			//editassessmentpage.AddQuestionCheckBox(driver, asmntDtl.sQuestionText);
		}
		}
		}	
		catch(RuntimeException ex){
			Report.logError("Create Assessment scenario failed.", ex);
		}
		editassessmentpage.finishAndPublish(driver);
		editassessmentpage.saveAndPublish(driver);
		assessmentstatus = assessmentPage.checkAssessmentStatus(driver, asmntname);
		Assert.assertEquals(assessmentstatus, "Published");
		ccHomePage.selectPatientView();
		if(ccPatientListPage.verifyPageTitle()==true){
			Report.logPass("My Patient Page opened successfully.");					
		}
		else {
			Report.logError("Failed to open My Patient Page.");
		}
		
		ccPatientListPage.selectPatientFromList("My Active Patients", patientname);
		if(ccHomePage.verifyPatientConsolePage(patientname)==true){
			Report.logPass("Patient Console Page opened successfully.");					
		}
		else {
			Report.logError("Failed to open Patient Console Page.");
		}			
		ccHomePage.selectPatientTab(patientname);	
		
}	
}
