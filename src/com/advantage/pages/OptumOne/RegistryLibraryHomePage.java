package com.advantage.pages.OptumOne;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantage.fileutils.PropertyFile;
import com.advantage.framework.Framework;

/**
 * This class is for the SARs Home page
 */

public class RegistryLibraryHomePage extends Framework {
	
	PropertyFile propF;
		
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public RegistryLibraryHomePage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_RegistryLibraryHomePage.properties");
		
	}	
	
	/**
	 * Select Registry Library
	 */
	public boolean verifyRegistryLibraryPage(){
		WebElement icon = findElement(driver, propF.getPropertyValue("sLoc_RegistryLibraryIcon"));
		if(icon.isDisplayed()==true){
			return true;
		}
		return false;
		
		
	}
	
	public boolean checkTestRegistryExist(String sRegLibName){
		Boolean iselementpresent = driver.findElements(By.linkText(sRegLibName)).size()!= 0;
		
		return iselementpresent;
	}
	
	public void searchRegistry(String sRegLibName){
		int i=0;
		while(checkTestRegistryExist(sRegLibName)==false){
			System.out.println(i);
			driver.findElement(By.linkText("Next")).click();
			sleep(5000);
			i++;
		}
		
	}

	/**
	 * Select Registry Library
	 */
	public boolean selectRegistryLibrary(String sRegLibName){
		
		if(checkTestRegistryExist(sRegLibName)==false){
			WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDRegistrySelection"));
			dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDRegistrySelection"), "Recently Viewed");
			
			if(checkTestRegistryExist(sRegLibName)==false){
				WebElement button = findElement(driver, propF.getPropertyValue("sLoc_RegistryGoButton"));
				click(button, propF.getPropertyValue("sLog_RegistryGoButton"));
				searchRegistry(sRegLibName);
				driver.findElement(By.linkText(sRegLibName)).click();
			}				
		}
		else{
			driver.findElement(By.linkText(sRegLibName)).click();
		}
		
		WebDriverWait wait = new WebDriverWait(driver,40);				
		boolean flag = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(propF.getPropertyValue("sLoc_RegLibPageheader")), sRegLibName));
		return flag;
	}
	
	
	
	public void clickViewLink(String sViewName)
	{
		driver.findElement(By.linkText("View")).click();			
		sleep(50000);
	}
}
