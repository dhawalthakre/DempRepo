package com.advantage.pages.OptumOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantage.framework.Framework;
import com.advantage.fileutils.*;

/**
 * This class is for the Login page
 */

public class AdministrationHomePage extends Framework {
	PropertyFile propF;	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AdministrationHomePage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_AdministrationHomePage.properties");	
	}	

	/**
	 * verify BMC logo on Homepage
	 * @return boolean true or false
	 */
	public boolean verifyHomePage()
	{
		WebElement usrNavBtn = findElement(driver, propF.getPropertyValue("sLoc_UserNavBtn"));
		
		if(usrNavBtn.isDisplayed()){
			return true;
		}
		return false;
		
	}	
	
	/**
	 * Logout from application
	 * 
	 */
	public void clickLogout()
	{
		WebElement logo = findElement(driver, propF.getPropertyValue("sLoc_MoreOption"));
		click(logo, propF.getPropertyValue("sLog_MoreOption"));
		WebElement logout = findElement(driver, propF.getPropertyValue("sLoc_Logout"));
		click(logout, propF.getPropertyValue("sLog_Logout"));		
	}	
	
	/**
	 * Verify app view 
	 * This method will check selected view is Administration or Care Coordination
	 * and select application as required. 
	 */
	public void verifyApp(String sAppName){
		//sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver,50);	
		//wait.until(ExpectedConditions.invisibilityOfElementWithText(By.tagName("div"),"Loading..."));
		WebElement label = findElement(driver, propF.getPropertyValue("sLoc_AppLabel"));
		System.out.println(label.getText());
		LABEL:
			
		if(label.getText().equalsIgnoreCase(sAppName)){	
			//sleep(15000);
			break LABEL;
		}
		else {
			WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDAppSelection"));
			dropdown.click();
			driver.findElement(By.linkText(sAppName)).click();
			//WebDriverWait wait = new WebDriverWait(driver,40);				
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_ArrTabMenu"))));
			sleep(4000);
		}
	}
	
	/**
	 * Select tab	 
	 */
	public void selectTab(String sTabName){
		//WebElement moreTabArr = findElement(driver, propF.getPropertyValue("sLoc_ArrTabMenu"));
		
		//moreTabArr.click();
		driver.findElement(By.linkText(sTabName)).click();
		WebDriverWait wait = new WebDriverWait(driver,40);				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_RegistryLibraryIcon"))));
		sleep(5000);
	}
	
}
