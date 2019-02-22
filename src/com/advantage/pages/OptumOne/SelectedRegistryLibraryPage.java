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

import com.advantage.fileutils.PropertyFile;
import com.advantage.framework.Framework;

/**
 * This class is for the SARs Home page
 */

public class SelectedRegistryLibraryPage extends Framework {
	
	PropertyFile propF;
		
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SelectedRegistryLibraryPage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_SelectedRegistryLibraryPage.properties");
		
	}	
	
	/**
	 * Search Patient
	 */
	public void searchPatient(String sInputValue){
		
		WebElement textbox = driver.findElement(By.cssSelector(propF.getPropertyValue("sLoc_SearchTextBox")));
		enterField(textbox, propF.getPropertyValue("sLog_SearchTextBox"), sInputValue);
		WebDriverWait wait = new WebDriverWait(driver,40);				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_PatientTableInfo"))));
		sleep(2000);
	}
	
	/**
	 * verify Searched Patient
	 */
	public boolean verifySearchedPatient(String sInputValue){
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_PatientTableInfo"));
		if(textbox.getText().equalsIgnoreCase("Showing 1 to 1 of 1 entries")){
			return true;
		}
		return false;
	}
	
	/**
	 * Select Patient
	 */
	public void checkPatientCheckbox(){
		WebElement checkbox = findElement(driver, propF.getPropertyValue("sLoc_HeaderRowCheckBox"));
		check(checkbox, propF.getPropertyValue("sLog_HeaderRowCheckBox"), true);
		sleep(5000);
	}
	
	/**
	 * Select Care Pathway
	 */
	public void selectCarePathWay(String sCarePathWay){
		ArrayList info = new ArrayList<String>();
		WebElement sec = findElement(driver, propF.getPropertyValue("sLoc_MemberData"));
		WebElement tbl = sec.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
				
		for(WebElement ul : RowInfo){
			WebElement thtag = ul.findElement(By.tagName("th"));
			WebElement tdtag = ul.findElement(By.tagName("td"));
			
			if(thtag.getText().equalsIgnoreCase("Care Pathway")==true){
				WebElement select = tdtag.findElement(By.tagName("select"));
				String name = select.getAttribute("name");				
				WebElement ddcarepathway = driver.findElement(By.name(name));
				dropDownSelect(ddcarepathway, "Care Pathway", sCarePathWay);				
			}
		}	
		sleep(5000);
	}
	
	/**
	 * Select Program
	 */
	public void selectProgram(String sProgram){
		ArrayList info = new ArrayList<String>();
		WebElement sec = findElement(driver, propF.getPropertyValue("sLoc_MemberData"));
		WebElement tbl = sec.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
				
		for(WebElement ul : RowInfo){
			WebElement thtag = ul.findElement(By.tagName("th"));
			WebElement tdtag = ul.findElement(By.tagName("td"));
			
			if(thtag.getText().equalsIgnoreCase("Program")==true){
				WebElement select = tdtag.findElement(By.tagName("select"));
				String name = select.getAttribute("name");				
				WebElement ddcarepathway = driver.findElement(By.name(name));
				dropDownSelect(ddcarepathway, "Program", sProgram);				
			}
		}	
		sleep(5000);
	}
	
	/**
	 * check Auto assignment to care coordinator checkbox
	 */
	public void checkAutoAssignmentToCC(){
		ArrayList info = new ArrayList<String>();
		WebElement sec = findElement(driver, propF.getPropertyValue("sLoc_MemberData"));
		WebElement tbl = sec.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		LABEL:		
		for(WebElement ul : RowInfo){
			
			List<WebElement> thInfo = ul.findElements(By.tagName("th"));
			List<WebElement> tdInfo = ul.findElements(By.tagName("td"));
			
			if(thInfo.get(1).getText().equalsIgnoreCase("Auto assignment to care coordinator")==true){
				WebElement checkbox = tdInfo.get(1).findElement(By.tagName("input"));						
				if(checkbox.getAttribute("type").equalsIgnoreCase("checkbox")){
					String name = checkbox.getAttribute("name");
					System.out.println(name);
					WebElement ccauto = driver.findElement(By.name(name));
					//ccauto.click();
					check(ccauto, propF.getPropertyValue("sLog_AutoAssignmentCheckbox"), true);
					break LABEL; 
				}
			}		
		}	
		sleep(10000);
		
	}
	
	/**
	 * check Auto assignment to care coordinator checkbox
	 */
	public void clickAssociateCarePathwayButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_BtnAssociateCarePathway"));
		click(button, propF.getPropertyValue("sLog_BtnAssociateCarePathway"));		
		
		sleep(20000);
	}
	
	/**
	 * verify message
	 */
	public String verifyMsg(){
		String msg = null;
		WebElement msgtbl = driver.findElement(By.cssSelector("div.message.confirmM3"));
		msg=msgtbl.getText();		
		return msg;
	}
	
	/**
	 * Change Patient as LASTNAME,FIRSTNAME
	 */
	public String changePatientName(String sPatientName){
		System.out.println(sPatientName);
		String[] name = sPatientName.toString().split(" ");
		String sChangedName = name[1] + "," + name[0];
		System.out.println(sChangedName);
		return sChangedName;
	}
	
	/**
	 * Change Patient as LASTNAME,FIRSTNAME
	 */
	public String changePatientName1(String sPatientName){
		System.out.println(sPatientName);
		String[] name = sPatientName.toString().split(" ");
		String sChangedName = name[1] + ", " + name[0];
		System.out.println(sChangedName);
		return sChangedName;
	}
	/**
	 * click Patient link
	 */
	public void clickPatientLink(String sPatientName){
		String Pname = changePatientName(sPatientName);		
		driver.findElement(By.linkText(Pname)).click();
	}
	
	/**
	 * Handle Error Dialog 
	 */
	public void errorDialog(){
		if(driver.findElement(By.cssSelector("td.x-btn-mc")).isDisplayed()){
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER);
			action.perform();
		}
		
	}
	
}
