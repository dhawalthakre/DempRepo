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

public class Login extends Framework {
	/* 
	 * Object Repository File variable
	 */
	PropertyFile propF;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Login(WebDriver driver)
	{
		super(driver);
		
		initialize("salesforce.com", "Login");			
		propF = new PropertyFile("objectrepository\\OR_LoginPage.properties");
		
	}
	
	By userName = By.xpath("xpath");
	By unsername = By.xpath(propF.getPropertyValue("sLoc_UserName"));
	
	

	/**
	 * Enters the User Name field
	 * 
	 * @param sInputValue - Value to enter
	 */
	public void enterUserName(String sInputValue)
	{		
		driver.findElement(userName).clear();
		WebElement userName = findElement(driver, propF.getPropertyValue("sLoc_UserName"));		
		enterField(userName, propF.getPropertyValue("sLog_userName"), sInputValue);
		
	}

	/**
	 * Enters the Password field
	 * 
	 * @param sInputValue - Value to enter
	 */
	public void enterPassword(String sInputValue)
	{		
		WebElement password = findElement(driver, propF.getPropertyValue("sLoc_Password"));
		enterField(password, propF.getPropertyValue("sLog_password"), sInputValue);
	}
	
	public void clickLoginAndWait()
	{		
		WebElement login = findElement(driver, propF.getPropertyValue("sLoc_Login"));
		clickAndWait(login, propF.getPropertyValue("sLog_login"));
	}

	/**
	 * Clicks the Login button 
	 */
	public void clickLogin()
	{
		WebElement login = findElement(driver, propF.getPropertyValue("sLoc_Login"));
		click(login, propF.getPropertyValue("sLog_login"));
	}	
	
		
	/**
	 * Logins into BMC Admin Portal.<BR>
	 
	 * @param details - variables need to login to BMC Admin Portal
	 */
	public void loginAs(String sUserName,String sPassword)
	{
		// Enter UserName & Password			
		enterUserName(sUserName);
		enterPassword(sPassword);
		clickLoginAndWait();     
		sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver,60);				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_UserNameLabel"))));
	}	

}
