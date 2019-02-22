package com.advantage.pages.OptumOne;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantage.framework.Framework;
import com.advantage.fileutils.*;

/**
 * This class is for the Login page
 */

public class CareCoordinationMyPatientListPage extends Framework {
	PropertyFile propF;	
	SelectedRegistryLibraryPage selectedRegLibPage = new SelectedRegistryLibraryPage(driver);
		
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CareCoordinationMyPatientListPage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_CareCoordinationMyPatientListPage.properties");	
		
	}	
	
	/**
	 * Verify Page Title
	 */
	public boolean verifyPageTitle(){
		if(driver.getTitle().equalsIgnoreCase("My Patients - Console")){
			return true;
		}
		return false;		
	}
	
	/**
	 * Select Patient from Patient List
	 */
	public void selectPatientFromList(String sViewOption, String sPatientName){
		switchFrame(driver, propF.getPropertyValue("sLoc_MainFrame"));
		selectMyPatientsView(sViewOption);
		clickGoButton();
		sleep(5000);
		//sleep(2000);
		enterSearchText(sPatientName);
		sleep(5000);
		//sleep(2000);
		String sNewPatientName = selectedRegLibPage.changePatientName1(sPatientName);
		clickPatientLink(sNewPatientName);
		setDefaultFrame(driver);
		sleep(10000);
		//sleep(5000);
	}
	
	/**
	 * select My Patients View
	 */
	public void selectMyPatientsView(String sOption){
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_MyPatientViewDD"));
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_MyPatientOption"), sOption);
	}
	
	/**
	 * Click on Go Button
	 */
	public void clickGoButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_GoButton"));
		click(button, propF.getPropertyValue("sLog_GoButton"));		
	}
	
	
	/**
	 * Enter Text to serach
	 */
	public void enterSearchText(String sSearchString){
		//WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_SearchTextbox"));
		//enterField(textbox, propF.getPropertyValue("sLog_SearchTextbox"), sSearchString);	
		driver.findElement(By.cssSelector("input[type=\"search\"]")).clear();
		driver.findElement(By.cssSelector("input[type=\"search\"]")).sendKeys(sSearchString);
	}
	
	/**
	 * Verify no records in patient list
	 */
	public boolean verifyPatientList(String sViewOption, String sPatientName){
		switchFrame(driver, propF.getPropertyValue("sLoc_MainFrame"));
		selectMyPatientsView(sViewOption);
		clickGoButton();
		sleep(5000);
		enterSearchText(sPatientName);
		sleep(5000);
		//selectedRegLibPage.clickPatientLink(sPatientName);
		Boolean iselementpresent = driver.findElements(By.className("dataTables_empty")).size()!= 0;
		if(iselementpresent==true){
			setDefaultFrame(driver);
			return true;
		}				
		setDefaultFrame(driver);
		return false;		
	}
	
	/**
	 * ClicK Patient Link 
	 */
	public void clickPatientLink(String sPatientName){
		
		driver.findElement(By.linkText(sPatientName)).click();
		
		
	}
	
}
