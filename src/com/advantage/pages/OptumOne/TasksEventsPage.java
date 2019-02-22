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

public class TasksEventsPage extends Framework {
	PropertyFile propF;	
	CareCoordinationPatientPage ccPatientPage = new CareCoordinationPatientPage(driver);
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public TasksEventsPage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_TasksEventsPage.properties");	
		
	}		
	
	public void swtichTaskEventFrame(){
		WebElement frame = findElement(driver, propF.getPropertyValue("sLoc_TasksEventsFrame"));
		driver.switchTo().frame(frame);
	}
	
	public boolean verifyTaskForCarePathway(String sCarePathId){
		swtichTaskEventFrame();
		WebElement tbl = findElement(driver, propF.getPropertyValue("sLoc_TaskTable"));
		String tblText = tbl.getText();
		setDefaultFrame(driver);
		if(tblText.contains(sCarePathId)){
			return true;
		}
		return false;
		
	}
	
	public void swtichHighlightFrame(){
		WebElement frame = findElement(driver, propF.getPropertyValue("sLoc_HighlightPanel"));
		driver.switchTo().frame(frame);
	}
	
	public void clickOptOutButton(){
		//swtichHighlightFrame();
		
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_OptOutButton"));
		click(button, propF.getPropertyValue("sLog_OptOutButton"));
	//	WebDriverWait wait = new WebDriverWait(driver,40);				
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_OptOutWindow"))));
		setDefaultFrame(driver);
	}
	
	/**
	 * Get Details of Task Details
	 */
	public ArrayList getTaskDetails(String sCPWID){
		swtichTaskEventFrame();
		ArrayList task = new ArrayList<String>();
		WebElement divpanel = driver.findElement(By.xpath("//div[@id='opentask']"));
		WebElement secbody = divpanel.findElement(By.className("pbBody"));
		WebElement tbl =secbody.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		for(WebElement ul : RowInfo){
			if(ul.getText().contains(sCPWID)){	
				List<WebElement> ColInfo = ul.findElements(By.tagName("td"));
				System.out.println(ColInfo.size());
				for(WebElement col : ColInfo){
					task.add(col.getText());
				}
									
			}							
		}
		System.out.println(task);
		setDefaultFrame(driver);
		return task;
		
	}
	
	/**
	 * Get Details of Task History Details
	 */
	public ArrayList getTaskHistoryDetails(String sCPWID){
		swtichTaskEventFrame();
		ArrayList task = new ArrayList<String>();
		WebElement divpanel = driver.findElement(By.xpath("//div[contains(@id, 'taskform:CustomList']"));
		WebElement secbody = divpanel.findElement(By.className("pbBody"));
		WebElement tbl =secbody.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		for(WebElement ul : RowInfo){
			if(ul.getText().contains(sCPWID)){	
				List<WebElement> ColInfo = ul.findElements(By.tagName("td"));
				System.out.println(ColInfo.size());
				for(WebElement col : ColInfo){
					task.add(col.getText());
				}
									
			}							
		}
		System.out.println(task);
		return task;
		
	}
	
	/**
	 * Click on Cls Link
	 * 
	 */
	public void clickOnClSLink(String sCPWID){
		swtichTaskEventFrame();
		
		WebElement divpanel = driver.findElement(By.xpath("//div[@id='opentask']"));
		WebElement secbody = divpanel.findElement(By.className("pbBody"));
		WebElement tbl =secbody.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		for(WebElement ul : RowInfo){
			if(ul.getText().contains(sCPWID)){	
				List<WebElement> ColInfo = ul.findElements(By.tagName("td"));
				System.out.println(ColInfo.size());
				for(WebElement col : ColInfo){
					if(col.getText().contains("Cls")){
						driver.findElement(By.linkText("Cls")).click();
					}
				}
									
			}							
		}		
		setDefaultFrame(driver);
		
	}
	
	public void switchNewTaskFrame(){
		WebElement frame = findElement(driver, propF.getPropertyValue("sLoc_NewTaskFrame"));
		driver.switchTo().frame(frame);
	}
	
	/**
	 * Close Task
	 * 
	 */
	/*public void closeTask(){
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("html/body"));
		switchNewTaskFrame();
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_TaskClsSaveBtn"));
		click(button, propF.getPropertyValue("sLog_TaskClsSaveBtn"));
		setDefaultFrame(driver);
	}*/
	
	/**
	 * Close task
	 */
	public void closeTask(String sCPWID){
		swtichTaskEventFrame();
		String sParentWindowHandle = driver.getWindowHandle();
		System.out.println(sParentWindowHandle);
		WebElement divpanel = driver.findElement(By.xpath("//div[@id='opentask']"));
		WebElement secbody = divpanel.findElement(By.className("pbBody"));
		WebElement tbl =secbody.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		for(WebElement ul : RowInfo){
			if(ul.getText().contains(sCPWID)){	
				List<WebElement> ColInfo = ul.findElements(By.tagName("td"));
				System.out.println(ColInfo.size());
				for(WebElement col : ColInfo){
					if(col.getText().contains("Cls")){
						driver.findElement(By.linkText("Cls")).click();
						sleep(20000);
					}
				}
									
			}							
		}		
		
		Actions oAction=new Actions(driver);	
		oAction.sendKeys(Keys.TAB).perform();
		oAction.sendKeys(Keys.TAB).perform();
		String taskWinow = driver.getWindowHandle();
		System.out.println(taskWinow);
		//driver.switchTo().window(taskWinow);
		
		switchNewTaskFrame();
		//WebElement taskclsWin =driver.findElement(By.xpath("html/body"));		
		WebElement priority = findElement(driver, propF.getPropertyValue("sLoc_TaskPriority"));
		dropDownSelect(priority, propF.getPropertyValue("sLog_TaskPriority"), "Medium");
		WebElement button = driver.findElement(By.xpath("//input[contains(@value,'Save')]"));
		//WebElement button = findElement(driver, propF.getPropertyValue("sLoc_TaskClsSaveBtn"));
		click(button, propF.getPropertyValue("sLog_TaskClsSaveBtn"));
		sleep(20000);
		setDefaultFrame(driver);
		
	}
	

}
