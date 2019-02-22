package com.advantage.tests.DataProviderClass;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.advantage.tests.DataProviderClass.*;
import com.advantage.datastructures.OptumOne.LoginDetails;
import com.advantage.datastructures.OptumOne.PatientInfoPrimaryContactDetails;
import com.advantage.fileutils.CSV;
import com.advantage.fileutils.Excel_poi;
import com.advantage.framework.TestTemplate;
import com.advantage.reporting.Logs;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
public class DataProviderClass extends TestTemplate {
	
	/**
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
	
	@DataProvider(name = "PatientInfoPrimaryContactDetails")
	public static Object[][] dataForPatientInfo(Method m)
	{
		String sTestDataFilePath;		
		sTestDataFilePath = ConfigInfo.getTestDataPath() + "\\testdata_EditPatientInformation.xlsx";	
		
		System.out.println(sTestDataFilePath);
		// Object array for testNG
		Object[][] testngDataObject = null;
		
		String sPatientName= null, sAtAGlance= null, sAcuityScore= null, sAcuityNotes= null, sPrimaryStreet= null, 
		sPrimaryCity= null, sPrimaryState= null, sPrimaryZip= null, sPrimaryCountry= null, sPrimaryEmail= null, 
		sPrimaryPhone= null, sPreferredContactMethod= null,sPreferredContactDays= null, sPreferredContactTime= null;
		
		Excel_poi excel;
		try
		{
			excel = new Excel_poi(sTestDataFilePath, "EditPatientInformation");
			
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
				System.out.println("Read excel");
					List<PatientInfoPrimaryContactDetails> PatientDtl = new ArrayList<PatientInfoPrimaryContactDetails>();
					String[][] dataexcel= excel.getExcelSheetData();	
					
					LoginDetails details = null;

					for(int j=1;j<iRowCount;j++){
						for( int k=0;k<iColCount;k++) {					
							System.out.println("inside for loop");
							if(dataexcel[0][k].equals("PatientName")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPatientName=null;
								}
								else {									
									sPatientName = dataexcel[j][k];
								}
																	
							}
							else if(dataexcel[0][k].equals("AtAGlance")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sAtAGlance=null;
								}
								else {									
									sAtAGlance = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("AcuityScore")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sAcuityScore=null;
								}
								else {									
									sAcuityScore = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("AcuityNotes")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sAcuityNotes=null;
								}
								else {									
									sAcuityNotes = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("PrimaryStreet")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPrimaryStreet=null;
								}
								else {									
									sPrimaryStreet = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("PrimaryCity")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPrimaryCity=null;
								}
								else {									
									sPrimaryCity = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("PrimaryState")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPrimaryState=null;
								}
								else {									
									sPrimaryState = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("PrimaryZip")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPrimaryZip=null;
								}
								else {									
									sPrimaryZip = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("PrimaryCountry")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPrimaryCountry=null;
								}
								else {									
									sPrimaryCountry = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("PrimaryEmail")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPrimaryEmail=null;
								}
								else {									
									sPrimaryEmail = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("PrimaryPhone")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPrimaryPhone=null;
								}
								else {									
									sPrimaryPhone = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("PreferredContactMethod")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPreferredContactMethod=null;
								}
								else {									
									sPreferredContactMethod = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("PreferredContactDays")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPreferredContactDays=null;
								}
								else {									
									sPreferredContactDays = dataexcel[j][k];									
								}
							}
							else if(dataexcel[0][k].equals("PreferredContactTime")){
								if(dataexcel[j][k]=="" || dataexcel[j][k]==null){
									sPreferredContactTime=null;
								}
								else {									
									sPreferredContactTime = dataexcel[j][k];									
								}
							}
							
							else {
								Logs.logWarning("Invalid excel column name");
							}						
						}		
						
						// Instantiate the objects
						details = new LoginDetails(ConfigInfo.getsCarePathwayOwner(), ConfigInfo.getsCarePathwayOwnerPassword());		
										
						PatientDtl.add(new PatientInfoPrimaryContactDetails(sPatientName, sAtAGlance, sAcuityScore, sAcuityNotes, sPrimaryStreet, sPrimaryCity, sPrimaryState, 
								sPrimaryZip, sPrimaryCountry, sPrimaryEmail, sPrimaryPhone, sPreferredContactMethod,
								sPreferredContactDays, sPreferredContactTime));							
					}	
					
					// Put in the object array for testNG
					testngDataObject[i][0] = details;
					
					// Put in the object array for testNG				
					testngDataObject[i][1] = PatientDtl;					
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
	
	
}
