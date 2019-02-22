package com.advantage.pages.OptumOne;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantage.framework.Framework;
import com.advantage.fileutils.*;
import com.advantage.pages.*;

/**
 * This class is for the Login page
 */

public class OptOutPopup extends Framework {
	PropertyFile propF;	
	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public OptOutPopup(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_OptOutPopup.properties");	
		
	}		
	
	public boolean verifyCreateTaskCheckbox(){
		driver.switchTo().frame("ext-comp-1016");
		WebElement regStatus = findElement(driver, propF.getPropertyValue("sLoc_RegistryOptOutStatus"));
		
		if(regStatus.isSelected()==false){
			boolean flag = driver.findElement(By.xpath(propF.getPropertyValue("sLoc_CreateTask"))).isDisplayed();
			System.out.println(flag);
			if(flag==false){
				return true;
			}
		}		
		return false;
	}
	
	public void checkRegistryOptOutStatus(){
		
		WebElement regStatus = findElement(driver, propF.getPropertyValue("sLoc_RegistryOptOutStatus"));
		check(regStatus, propF.getPropertyValue("sLog_RegistryOptOutStatus"), true);		
	}
	
	public void selectReasonRegistry(String sText){
		WebElement reasonReg = findElement(driver, propF.getPropertyValue("sLoc_ReasonRegistry"));
		dropDownSelect(reasonReg, propF.getPropertyValue("sLog_ReasonRegistry"), sText);	
		sleep(20000);
	}
	
	/*public void enterEndDate(){
		WebElement date = findElement(driver, propF.getPropertyValue("sLoc_EndDateRegistry"));
		enterField(date, propF.getPropertyValue("sLog_EndDateRegistry"));	
	}*/
	
	public void clickSaveButton(){
		//WebElement button = findElement(driver, propF.getPropertyValue("sLoc_SaveButton"));
		//button.click();
		driver.findElement(By.id("page:j_id5:j_id6:j_id29:page:j_id73:j_id1456")).click();
		/*System.out.println(button.isDisplayed());
		System.out.println(button.isEnabled());
		click(button, propF.getPropertyValue("sLog_SaveButton"));*/	
		//setDefaultFrame(driver);
	}
	
}
