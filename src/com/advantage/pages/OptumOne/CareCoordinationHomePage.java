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
import com.advantage.reporting.Report;

/**
 * This class is for the Login page
 */

public class CareCoordinationHomePage extends Framework {
	PropertyFile propF;	
	PropertyFile propF1;	
	PropertyFile propF2;
	PropertyFile propF3;
	CareCoordinationPatientPage ccPatPage = new CareCoordinationPatientPage(driver);
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CareCoordinationHomePage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_AdministrationHomePage.properties");	
		propF1 = new PropertyFile("objectrepository\\OR_CareCoordinationHomePage.properties");
		propF2 = new PropertyFile("objectrepository\\OR_LoginPage.properties");
		propF3 = new PropertyFile("objectrepository\\OR_CareCoordinationMyPatientListPage.properties");
	}	

		
	/**
	 * Verify app view 
	 * This method will check selected view is Administration or Care Coordination
	 * and select application as required. 
	 */
	public boolean verifyCareCoordinationApp(){
		
		/*WebDriverWait wait = new WebDriverWait(driver,40);				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_AppLabel"))));
		
		WebElement label = findElement(driver, propF.getPropertyValue("sLoc_AppLabel"));
		
		if(label.getText().equalsIgnoreCase("Care Coordination")){	
			return true;
		}
		return false;*/
		
		WebDriverWait wait = new WebDriverWait(driver,40);				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_AppIcon"))));
		
		WebElement label = findElement(driver, propF.getPropertyValue("sLoc_AppIcon"));
		
		if(label.getAttribute("title").equalsIgnoreCase("Care Coordination")){	
			return true;
		}
		return false;
	}
	
	/**
	 * Select tab	 
	 */
	public void selectPatientTab(String sPatientName){
		//sleep(10000);		
		sleep(5000);
		driver.findElement(By.id("ext-gen36")).click();
		//WebElement moreOptArr  = findElement(driver, propF.getPropertyValue("sLoc_MoreOptionArrow"));
		//click(moreOptArr, propF.getPropertyValue("sLog_MoreOptionArrow"));				
		driver.findElement(By.linkText(sPatientName)).click();		
		//sleep(20000);
		sleep(2000);
	}
	
	public void selectPatientTab1(String sPatientName){
		//sleep(10000);		
		Actions oAction=new Actions(driver);	
		oAction.sendKeys(Keys.ESCAPE).perform();
		oAction.sendKeys(Keys.chord("p")).perform(); 
		oAction.sendKeys(Keys.chord("d")).perform(); 
		oAction.sendKeys(Keys.ARROW_DOWN).perform();
		oAction.sendKeys(Keys.ENTER).perform();
		sleep(20000);
		ccPatPage.switchCCIframe();
		//WebElement moreOptArr  = findElement(driver, propF.getPropertyValue("sLoc_MoreOptionArrow"));
		//click(moreOptArr, propF.getPropertyValue("sLog_MoreOptionArrow"));				
		//driver.findElement(By.linkText(sPatientName)).click();		
		sleep(20000);
	}
	
	
	
	/**
	 * Close All Tabs
	 */
	public void closeAllTabs(){
		driver.findElement(By.id("ext-gen36")).click();
		driver.findElement(By.linkText("Close all primary tabs")).click();
		
	}
	
	/**
	 * Select Patient View
	 * 
	 */
	public void selectPatientView(){
		sleep(5000);
		clickViewMenuDD();
		clickMyPatients();		
		sleep(5000);
	}
	
	/**
	 * Select Care Pathways View
	 * 
	 */
	public void selectCarePathwayView(String sViewName){
		clickViewMenuDD();
		clickCarePathways();	
		changeView(sViewName);
	}
	
	/**
	 * Click View Menu Drop Down
	 * 
	 */
	public void clickViewMenuDD(){
		//WebElement menudd = findElement(driver, propF1.getPropertyValue("sLoc_ViewMenuDropDown"));
		//click(menudd, propF1.getPropertyValue("sLog_ViewMenuDropDown"));
		//driver.findElement(By.xpath("//table[@id='ext-comp-1007']/tbody/tr[2]/td[2]/em"));
		WebDriverWait wait = new WebDriverWait(driver,50);	
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.tagName("div"),"Loading..."));
		Actions oAction=new Actions(driver);	
		oAction.sendKeys(Keys.ESCAPE).perform();
		oAction.sendKeys(Keys.chord("v")).perform();
		//sleep(10000);
		sleep(2000);
	}
	
	/**
	 * Select My Patients Option
	 * 
	 */
	public void clickMyPatients(){
		//WebElement menudd = findElement(driver, propF1.getPropertyValue("sLoc_MyPatientOption"));
		//click(menudd, propF1.getPropertyValue("sLog_MyPatientOption"));
		driver.findElement(By.linkText("My Patients")).click();
		sleep(10000);
	}
	
	/**
	 * Select Care Pathways Option
	 * 
	 */
	public void clickCarePathways(){
		//WebElement menudd = findElement(driver, propF1.getPropertyValue("sLoc_CarePathwaysOption"));
		//click(menudd, propF1.getPropertyValue("sLoc_CarePathwaysOption"));
		driver.findElement(By.linkText("Care Pathways")).click();
		sleep(20000);
	}
	
	/**
	 * Sort Care Pathway number column
	 */
	public void sortCPWColumn(){
		switchFrame(driver, propF3.getPropertyValue("sLoc_MainFrame"));
		WebElement gridHeader = driver.findElement(By.className("x-grid3-hd-row"));
		List<WebElement> ColInfo = gridHeader.findElements(By.tagName("td")); 
		label:
		for(WebElement ul : ColInfo){
			
			if(ul.getText().contains("CARE PATHWAY NUMBER")){
				ul.getAttribute("class");
				if(ul.getAttribute("class").contains("ASC")){
					ul.click();
					break label;
				}
				
				sleep(2000);
			}					
		}
		setDefaultFrame(driver);
	}
	
	/**
	 * Get Care Pathway details from list
	 */
	public ArrayList getCarePathwayRecord(String sCPWId){
		switchFrame(driver, propF3.getPropertyValue("sLoc_MainFrame"));
		ArrayList cpw = new ArrayList<String>();	
    	WebElement gridBody = driver.findElement(By.className("x-grid3-body"));
    	WebElement gridrow = gridBody.findElement(By.className("x-grid3-row")); 
    	List<WebElement> allRows = gridrow.findElements(By.xpath("//table[@class='x-grid3-row-table']")); 
    	
    	for (WebElement row : allRows) {
    		//WebElement statusCol = row.findElement(By.id(id)
    		if((row.getText().toString().contains(sCPWId))){
    			cpw.add(row.getText());
    		}     	    
    	}    	
    	setDefaultFrame(driver);
		return cpw;
	}
	
	/**
	 * Verify Login Page
	 * 
	 */
	public void verifyLoginPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propF2.getPropertyValue("sLoc_UserName"))));
	}
	
	/**
	 * Change view
	 * 
	 * @param sView - View name (All Cases, My Cases)	
	 */
	public void changeView(String sView){
		switchFrame(driver, propF3.getPropertyValue("sLoc_MainFrame"));
		WebElement wbView = findElement(driver, propF1.getPropertyValue("sLoc_ViewDD"));
		dropDownSelect(wbView, propF1.getPropertyValue("sLog_ViewDD"), sView);
		sleep(20000);
		setDefaultFrame(driver);
	}
	
	public boolean verifyCarePathwayDetailsFromGrid(String sCPWId, String sStatus, 
			String sReasonForClose, String sOwnerAlias){
		ArrayList cpw = getCarePathwayRecord(sCPWId);
		if((cpw.toString().contains(sStatus)==true) &&
				(cpw.toString().contains(sReasonForClose) ==true) &&
				(cpw.toString().contains(sOwnerAlias)==true)){
				
				return true;					
			}
				return false;
		
	}
	
	/**
	 * Verify Care pathway status from grid
	 */
	public boolean verifyCarePathwayStatusFromGrid(String sCPWId, String sStatus){
		ArrayList cpw = getCarePathwayRecord(sCPWId);
		if(cpw.toString().contains(sStatus)){
			return true;
		}
		return false;
	}
	
	/**
	 * Verify Care pathway closed reason from grid
	 */
	public boolean verifyCarePathwayCloseReasonFromGrid(String sCPWId, String sReasonForClose){
		ArrayList cpw = getCarePathwayRecord(sCPWId);
		if(cpw.toString().contains(sReasonForClose)){
			return true;
		}
		return false;
	}
	
	/**
	 * Verify Care pathway owner alias from grid
	 */
	public boolean verifyCarePathwayOwnerFromGrid(String sCPWId, String sOwnerAlias){
		ArrayList cpw = getCarePathwayRecord(sCPWId);
		if(cpw.toString().contains(sOwnerAlias)){
			return true;
		}
		return false;
	}
	
	/**
	 * Verify Care Coordinator logged in 
	 */
	public boolean verifyCCUserLoggedIn(){
		WebElement usernavlbl = findElement(driver, propF1.getPropertyValue("sLoc_CCUserNavLabel"));
		if(usernavlbl.isDisplayed()){
			return true;
		}
		return false;
		
	}
	
	/**
	 * Verify Patient Console Page opened
	 */
	public boolean verifyPatientConsolePage(String sValue){
		if(getBrowserTitle(driver).contains(sValue)){
			return true;
		}
		return false;
		
	}
}
