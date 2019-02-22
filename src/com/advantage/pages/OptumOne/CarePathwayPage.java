package com.advantage.pages.OptumOne;

import java.util.ArrayList;
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

public class CarePathwayPage extends Framework {
	PropertyFile propF;	
	CareCoordinationPatientPage ccPatientPage = new CareCoordinationPatientPage(driver);
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CarePathwayPage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_CarePathwayPage.properties");	
		
	}		
	
	/**
	 * Select Care Pathway Subtab
	 */
	public void selectSubTab(String sTabName){	
		Actions oAction=new Actions(driver);
		oAction.sendKeys(Keys.ESCAPE).perform();
		oAction.sendKeys(Keys.chord("s")).perform(); 
		oAction.sendKeys(Keys.chord("d")).perform(); 		
		//driver.switchTo().window("null");
		//WebElement tabmenuarrow = findElement(driver, propF.getPropertyValue("sLoc_subTabMenuArrow"));
		//sleep(30000);
		sleep(10000);
		driver.findElement(By.linkText(sTabName)).click();
		//sleep(30000);
		sleep(5000);
		
		
	}
	
	/**
	 * Select Care Pathway Subtab
	 */
	public void selectSubTabForCloseCC(String sTabName){	
		Actions oAction=new Actions(driver);
		oAction.sendKeys(Keys.TAB).perform();
		oAction.sendKeys(Keys.chord("s")).perform(); 
		oAction.sendKeys(Keys.chord("d")).perform(); 	
		oAction.sendKeys(Keys.ARROW_DOWN).perform();
		oAction.sendKeys(Keys.ENTER).perform();
		//driver.switchTo().window("null");
		//WebElement tabmenuarrow = findElement(driver, propF.getPropertyValue("sLoc_subTabMenuArrow"));
		sleep(30000);
		//driver.findElement(By.linkText(sTabName)).click();
		//sleep(30000);
		//driver.switchTo().frame("ext-comp-1016");
		
		
	}
	
	/**
	 * Switch Iframe 
	 */
	public void switchCPWframe(){
		ArrayList framelist = findAllIframes();
		String[] frameid = framelist.toString().split(",");
		String id = frameid[2].trim();
		//WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@name, 'ext-comp')]"));
		//String id = iframe.getAttribute("id");	
		
		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='" + id + "']"));
		driver.switchTo().frame(iframe1);
	}
	
	public void switchTaskframe(){
		ArrayList framelist = findAllIframes();
		String[] frameid = framelist.toString().split(",");
		String id = frameid[4].trim();
		//WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@name, 'ext-comp')]"));
		//String id = iframe.getAttribute("id");	
		System.out.println(id);
		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='" + id + "']"));
		driver.switchTo().frame(iframe1);
	}
	
	/**
	 * Verify Page Title 
	 */
	public boolean verifyCarePathwayPageTitle(String sCPWID){
		//ccPatientPage.switchIframe();
		ccPatientPage.switchCCIframe();
		
		WebElement pagetitle = findElement(driver, propF.getPropertyValue("sLoc_pageTitle"));
		if(pagetitle.getText().toString().contains(sCPWID)){
			return true;
		}		
		return false;
	}
	
	/**
	 * ClicK Open Activities Link 
	 */
	public void clickOpenActivitiesLink(){
		
		driver.findElement(By.xpath("//span[contains(text(),'Open Activities')]")).click();
		
		//driver.findElement(By.cssSelector("#50017000002Ei3H_RelatedActivityList_link > span.listTitle")).click();
		sleep(5000);
	}
	
	/**
	 * Verify No record display in Open Activities
	 */
	public boolean verifyNoRecordOpenActivities(){
		
		WebElement activitylist = findElement(driver, propF.getPropertyValue("sLoc_RelatedActivityList"));
		String text = activitylist.getText();
		if(text.contains("No records to display")){
			return true;
		}				
		return false;		
	}
	
	
	/**
	 * Find all Iframes
	 */
	public ArrayList findAllIframes(){
		ArrayList frames = new ArrayList<String>();
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		for(WebElement ul : iframes){
			frames.add(ul.getAttribute("id"));
		}
		System.out.println(frames);
		return frames;				
	}
	
	/**
	 * Assign Owner to Care Pathway
	 */
	public void assignCarePathwayOwner(String sOwnerName){
		driver.findElement(By.linkText("[Change]")).click();
		sleep(20000);
		WebElement dropdown =findElement(driver, propF.getPropertyValue("sLoc_DDCarePathwayOwner"));
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDCarePathwayOwner"), "User");
		
		 String sParentWindowHandle = driver.getWindowHandle();
		 	 
		 WebElement lookup = findElement(driver, propF.getPropertyValue("sLoc_NewOwnerLookup"));
		 click(lookup, propF.getPropertyValue("sLog_NewOwnerLookup"));
		 sleep(20000);
		 driver.switchTo().window("lookup");
		 switchFrame(driver, propF.getPropertyValue("sLoc_LookupSearchFrame"));	
		 WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_LookupSerchTxtBx"));
		 enterField(txtsearch, propF.getPropertyValue("sLog_LookupSerchTxtBx"), sOwnerName);
		 
		 WebElement goBtn = findElement(driver, propF.getPropertyValue("sLoc_LookupGoBtn"));
		 click(goBtn, propF.getPropertyValue("sLog_LookupGoBtn"));
		 setDefaultFrame(driver);
		 driver.switchTo().window("lookup");
		 switchFrame(driver, propF.getPropertyValue("sLoc_LookupResultFrame"));	
		 driver.findElement(By.linkText(sOwnerName)).click();
		// setDefaultFrame(driver);
		 
		 driver.switchTo().window(sParentWindowHandle);	
		 switchCPWframe();
		 clickSaveButton();		 
		 sleep(50000);
	}
	
	/**
	 * Close All Sub Tabs
	 */
	public void closeAllSubTabs(){
		setDefaultFrame(driver);
		Actions oAction=new Actions(driver);		
		oAction.sendKeys(Keys.chord("s")).perform(); 
		oAction.sendKeys(Keys.chord("d")).perform(); 
		driver.findElement(By.linkText("Close all subtabs")).click();
		
	}
	
	/**
	 * Close Care Pathway
	 */
	public void closeCarePathway(String sStatus, String sReason){
		switchCPWframe();
		clickCloseButton();
		selectStatusCloseCarePathway(sStatus);
		selectCarePathwayCloseReason(sReason);
		clickSaveButton();
		setDefaultFrame(driver);
		sleep(20000);
	}
	
	/**
	 * Click on Close Care Pathway button
	 */
	public void clickCloseButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_CloseButton"));
		click(button, propF.getPropertyValue("sLog_CloseButton"));	
		sleep(20000);
	}
	
	
	/**
	 * Select Status for Close Care Pathway
	 */
	public void selectStatusCloseCarePathway(String sStatus){
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_StatusForCloseOption"));
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_StatusForCloseOption"), sStatus);
	}
	
	/**
	 * Select Care Pathway Close Reason
	 */
	public void selectCarePathwayCloseReason(String sReason){
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_CarePathwayCloseReason"));
		dropDownSelect(dropdown, propF.getPropertyValue("sLoc_CarePathwayCloseReason"), sReason);
	}
	
	/**
	 * Click on Save Button
	 */
	public void clickSaveButton(){
		WebElement saveBtn = findElement(driver, propF.getPropertyValue("sLoc_SaveBtn"));
		 click(saveBtn, propF.getPropertyValue("sLog_SaveBtn"));		 
		 sleep(20000);
	}
	
	/**
	 * Get Details of Care Pathway Details
	 */
	public ArrayList getCarePathwayDetails(String sCPWID){
		switchCPWframe();
		ArrayList carepathway = new ArrayList<String>();
		WebElement divpanel = driver.findElement(By.xpath("//div[@id='ep']"));
		WebElement secbody = divpanel.findElement(By.className("pbBody"));
		WebElement tbl =secbody.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		for(WebElement ul : RowInfo){
			if(ul.getText().contains(sCPWID)){	
				List<WebElement> ColInfo = ul.findElements(By.tagName("td"));
				
				for(WebElement col : ColInfo){
					carepathway.add(col.getText());
				}
									
			}							
		}
		
		return carepathway;
		
	}
	
	/**
	 * Verify No record display in Open Activities
	 */
	public boolean verifyRecordOpenActivities(String sText){
		
		WebElement activitylist = findElement(driver, propF.getPropertyValue("sLoc_RelatedActivityList"));
		
		String text = activitylist.getText();
		setDefaultFrame(driver);
		if(text.contains(sText)){
			return true;
		}				
		
		return false;		
	}
	
	/**
	 * Verify status of care pathway
	 */
	public boolean verifyCarePathwayStatus(String sText){
		
		WebElement table = findElement(driver, propF.getPropertyValue("sLoc_CarePathwayDetailsTable"));
		String text = table.getText();
		
		if(text.contains(sText)){
			return true;
		}				
		
		return false;		
	}
	
	/**
	 * Verify No record display in Open Activities
	 */
	public void closeTask(){
		
		driver.switchTo().frame("ext-comp-1023");
		driver.findElement(By.linkText("Cls")).click();
		setDefaultFrame(driver);
		WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@id,'close')]"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//input[@value='Save']")).click();		
	}
		
	
	/**
	 * close Task from open activities
	 */
	public void OpenActivitycloseTask(){
		String sTaskSubject = null;
		
		WebElement activitylist = findElement(driver, propF.getPropertyValue("sLoc_RelatedActivityList"));
		WebElement tbl =activitylist.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		for(WebElement ul : RowInfo){
				List<WebElement> ColInfo = ul.findElements(By.tagName("th"));
				System.out.println("Open Activity Close task");
				System.out.println(ColInfo.size());
				for(WebElement col : ColInfo){
					sTaskSubject= col.getText();
				}
						
		}
		String text = activitylist.getText();
		
		if(text.contains("No records to display")==false){
			driver.findElement(By.linkText("Cls")).click();
			sleep(20000);
			setDefaultFrame(driver);
			Actions oAction=new Actions(driver);		
			oAction.sendKeys(Keys.chord("s")).perform(); 
			oAction.sendKeys(Keys.chord("d")).perform();
			sleep(1000);
			//oAction.sendKeys(Keys.ARROW_DOWN).perform();
			//driver.findElement(By.linkText("Task")).click();
			click(driver.findElement(By.linkText("Task")), "Task Link");
			sleep(1000);
			WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src,'close=')]"));
			//WebElement iframe = driver.findElement(By.tagName("iframe"));
			
			driver.switchTo().frame(iframe);
			WebElement priority = findElement(driver, propF.getPropertyValue("sLoc_TaskPriority"));
			dropDownSelect(priority, propF.getPropertyValue("sLog_TaskPriority"), "Medium");
			
			driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
			sleep(20000);
		}	
		setDefaultFrame(driver);
	}
	
		
}
