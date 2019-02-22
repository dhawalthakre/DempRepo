package com.advantage.pages.OptumOne;



import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.advantage.fileutils.PropertyFile;
import com.advantage.framework.Framework;

public class AssessmentListPage extends Framework {
		PropertyFile propF, propF1;	
		public WebDriver driver;
		
		
		
		/**
		 * Constructor
		 * 
		 * @param driver
		 * @throws InterruptedException 
		 */
		public AssessmentListPage(WebDriver driver) 
		{
			super(driver);	
			propF = new PropertyFile("objectrepository\\OR_AssessmentList.properties");	
			
	
		}	
		
		public boolean verifyAssessmentListPage(WebDriver driver)
		{
			WebElement AddAssmntBtn = findElement(driver, propF.getPropertyValue("sLoc_AddNewAssessment"));
			if(AddAssmntBtn.isDisplayed()){
				System.out.println("Add assessment button found");
				return true;
			}
			return false;
			
		}	
		
		public void gotoEditAssessment(WebDriver driver, String assessmentname){
			WebElement AddAssmntBtn = findElement(driver, propF.getPropertyValue("sLoc_AddNewAssessment"));
			AddAssmntBtn.click();
			WebElement AssessmentName = findElement(driver, propF.getPropertyValue("sLoc_AssessmentName"));
			enterField(AssessmentName, "Assessment Name text box", assessmentname);
			WebElement checkbox = findElement(driver, propF.getPropertyValue("sLoc_CheckBox"));
			checkbox(checkbox, "isStandard checkbox", true,
					false);
			WebElement SaveButton = findElement(driver, propF.getPropertyValue("sLoc_SaveButton"));
			clickAndWaitForURL(SaveButton, "Save button", "OPDes_MasterAssessment");
			
		}
		
		public boolean searchAssessment(WebDriver driver, String assessmentname){
			
			WebElement searchtextbox = findElement(driver, propF.getPropertyValue("sLoc_searchbox"));
			enterField(searchtextbox, "Search text box", assessmentname);
			WebElement searchbutton = findElement(driver, propF.getPropertyValue("sLoc_searchbutton"));
			searchbutton.click();
			WebElement assmntname = findElement(driver, propF.getPropertyValue("sLoc_assessmentname"));
			String assessmentName = getText(assmntname, "Asessment Name", true);
			if(assessmentName.equals(assessmentname)){
				return true;
			}else{
				
				return false;
			}
		}	
		public String checkAssessmentStatus(WebDriver driver, String assessmentname){
			
			searchAssessment(driver, assessmentname);
			WebElement assessmntstatus = findElement(driver, propF.getPropertyValue("sLoc_assessmentstatus"));
			String assessmentStatus = getText(assessmntstatus, "Asessment Status", true);
			return assessmentStatus;
			
		}
			
}
		
		
		
		
		

