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

public class NotesWidgetPage extends Framework {
	PropertyFile propF;	
	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NotesWidgetPage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_NotesWidgets.properties");	
		
	}
	
	/**
	 * Create Create Note and Task
	 * 
	 */
	public void createNoteAndTask(String sText, String sName, String sActivity, String sOtherActivity, 
			String sSubject, String sOtherSubject, String sDueDate, String sPriority,
			String sStatus, String sDuration, String sDesc){
		
		WebDriverWait wait = new WebDriverWait(driver,40);				
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(propF.getPropertyValue("sLoc_PageLoadingOverlay"))));
		sleep(5000);
		//driver.switchTo().window(propF.getPropertyValue("sLoc_NotesWidgetName"));
		driver.switchTo().frame("scc_widget_Notes");
		//switchFrame(driver, propF.getPropertyValue("sLoc_NotesWidgetName"));
		
		EnterNoteData(sText);
		
		enterTaskData(sName, sActivity, sOtherActivity, sSubject, sOtherSubject, 
				sDueDate, sPriority, sStatus, sDuration, sDesc);
		
		clickSaveAsFinalBtn();
		sleep(5000);
		setDefaultFrame(driver);
	}
	/**
	 * Create Notes
	 */
	public void EnterNoteData(String sText){
		enterSearchText(sText);
		sleep(5000);
	}
	
	/**
	 * Create Task
	 */
	public void enterTaskData(String sName, String sActivity, String sOtherActivity, 
			String sSubject, String sOtherSubject, String sDueDate, String sPriority,
			String sStatus, String sDuration, String sDesc){
		
		checkTaskCheckbox();
		TaskAssignTo(sName);		
		TaskActivity(sActivity, sOtherActivity);
		TaskSubject(sSubject, sOtherSubject);
		TaskDueDate(sDueDate);
		TaskPriority(sPriority);
		TaskStatus(sStatus);
		TaskDuration(sDuration);
		TaskDescription(sDesc);		
	}
	
	/**
	 * Enter Text in search field
	 */
	public void enterSearchText(String sText){
		driver.findElement(By.cssSelector("span.select2-selection.select2-selection--single")).click();
		//WebElement quickText = findElement(driver, propF.getPropertyValue("sLoc_QuickTextDD"));
		//quickText.click();
		//WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_AddQuickTextField"));
		//enterField(textbox, propF.getPropertyValue("sLog_AddQuickTextField"), sText);
		driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys(sText);
		WebDriverWait wait = new WebDriverWait(driver,60);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='select2-taglibrary-results']/li/div")));
		Actions oAction=new Actions(driver);	
		oAction.sendKeys(Keys.DOWN).perform();
		oAction.sendKeys(Keys.ENTER).perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(propF.getPropertyValue("sLoc_PageLoadingOverlay"))));
		
	}
	
	
	/**
	 * Enter Note Description
	 */
	public String enterNoteDesc(String sText){
		String sDescText = null;
		switchFrame(driver, propF.getPropertyValue("sLoc_NoteDescIFrame"));
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_NotesDescTextField"));
		if(textbox.getText().isEmpty()==false){
			sDescText= textbox.getText();
			
		}
		
		setDefaultFrame(driver);
		return sDescText;
	}
	
	/**
	 * Verify Tags
	 */
	public boolean verifyTags(String sText){
		WebElement tag = findElement(driver, propF.getPropertyValue("sLoc_Tags"));
		if(tag.getText().contains(sText)){
			return true;
		}
		return false;
		
	}
	
	/**
	 * Check Task checkbox
	 */
	public void checkTaskCheckbox(){
		WebElement checkbox = findElement(driver, propF.getPropertyValue("sLoc_TaskCheckbox"));
		check(checkbox, propF.getPropertyValue("sLog_TaskCheckbox"), true);
		sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver,60);				
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(propF.getPropertyValue("sLoc_PageLoadingOverlay"))));
	}
	
	/**
	 * Task Assign To 
	 */
	public void TaskAssignTo(String sName){
		String sParentWindowHandle = driver.getWindowHandle();
		WebElement icon = findElement(driver, propF.getPropertyValue("sLoc_TaskAssignedToLookupIcon"));
		click(icon, propF.getPropertyValue("sLoc_TaskAssignedToLookupIcon"));
		//driver.switchTo().window("lookup");
		//sleep(6000);
		//driver.switchTo().frame("searchFrame");
		//WebDriverWait wait = new WebDriverWait(driver,60);				
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_LookupSearchField"))));
		
		 WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_LookupSearchField"));
		 enterField(txtsearch, propF.getPropertyValue("sLog_LookupSearchField"), sName);
		 
		 WebElement goBtn = findElement(driver, propF.getPropertyValue("sLoc_LookupGoButton"));
		 click(goBtn, propF.getPropertyValue("sLog_LookupGoButton"));
		 //setDefaultFrame(driver);
		 //driver.switchTo().window("lookup");
		// driver.switchTo().frame("resultsFrame");
		 sleep(5000);
		 //driver.findElement(By.xpath("//span[text()='"+ sName + "']")).click();
		 driver.findElement(By.linkText(sName)).click();
		 sleep(5000);
		 //driver.switchTo().window(sParentWindowHandle);
		 //driver.switchTo().frame("scc_widget_Notes");
		// sleep(20000);
		
	}
	
	/**
	 * Task Activity 
	 */
	public void TaskActivity(String sActivity, String sOtherActivity){
		System.out.println(sActivity);
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_NotesDescTextField"));
		click(textbox, propF.getPropertyValue("sLog_NotesDescTextField"));
		/*Actions clickTB = new Actions(driver);
		clickTB.sendKeys(Keys.TAB).perform();
		 WebElement taskact = findElement(driver, propF.getPropertyValue("sLoc_TaskActivity"));
		 enterField(taskact, propF.getPropertyValue("sLog_TaskActivity"), sActivity);
		//dropDownSelect(taskact, propF.getPropertyValue("sLog_TaskActivity"), sActivity);
		//enterField(txtsearch, propF.getPropertyValue("sLog_TaskActivity"), sActivity);
*/		 Actions oAction=new Actions(driver);
		 oAction
		 		.sendKeys(Keys.TAB)
		 		.sendKeys(Keys.TAB)
		 		.sendKeys(Keys.TAB)
		 		.sendKeys(Keys.ARROW_DOWN)
		 		.sendKeys(sActivity)
		 		.sendKeys(Keys.ENTER);
		 Action clickTNode = oAction.build();
		 clickTNode.perform();
		 sleep(20000);	
		 Actions clickTB = new Actions(driver);
		 clickTB.sendKeys(Keys.TAB).perform();
		 Boolean iselementpresent =driver.findElement(By.xpath(propF.getPropertyValue("sLoc_TaskOtherActivity"))).isDisplayed()==true;	 
		
		 if(iselementpresent){
			 TaskOtherActivity(sOtherActivity);
		 }
	}
	
	/**
	 * Task Other Activity 
	 */
	public void TaskOtherActivity(String sOtherActivity){		
		WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_TaskOtherActivity"));
		enterField(txtsearch, propF.getPropertyValue("sLog_TaskOtherActivity"), sOtherActivity);	
	}
	
	/**
	 * Task Subject 
	 */
	public void TaskSubject(String sSubject, String sOtherSubject){
		/* WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_TaskSubject"));
		 enterField(txtsearch, propF.getPropertyValue("sLog_TaskSubject"), sSubject);*/
		Actions oAction=new Actions(driver);
		 oAction		 		
		 		.sendKeys(Keys.TAB)
		 		.sendKeys(Keys.ARROW_DOWN)
		 		.sendKeys(sSubject)
		 		.sendKeys(Keys.ENTER);
		 Action clickTNode = oAction.build();
		 clickTNode.perform();
		 sleep(20000);	
		 Actions clickTB = new Actions(driver);
		 clickTB.sendKeys(Keys.TAB).perform();
		 Boolean iselementpresent = driver.findElements(By.xpath(propF.getPropertyValue("sLoc_TaskOtherSubject"))).size()!= 0;
		 if(iselementpresent){
			 TaskOtherSubject(sOtherSubject);
		 }
	}
	
	/**
	 * Task Other Activity 
	 */
	public void TaskOtherSubject(String sOtherSubject){		
		WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_TaskOtherSubject"));
		enterField(txtsearch, propF.getPropertyValue("sLog_TaskOtherSubject"), sOtherSubject);	
	}
	
	/**
	 * Task Due Date 
	 */
	public void TaskDueDate(String sDueDate){		
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TaskDueDate"));
		enterField(textbox, propF.getPropertyValue("sLog_TaskDueDate"), sDueDate);	
		sleep(5000);
	}
	
	/**
	 * Task Priority Drop Down 
	 */
	public void TaskPriority(String sPriority){	
		/* Actions clickTB = new Actions(driver);
		 clickTB.sendKeys(Keys.TAB).perform();
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_TaskPriority"));
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_TaskPriority"), sPriority);*/
		Actions oAction=new Actions(driver);
		 oAction		 		
		 		.sendKeys(Keys.TAB)
		 		.sendKeys(Keys.TAB)
		 		.sendKeys(Keys.ARROW_DOWN)
		 		.sendKeys(sPriority)
		 		.sendKeys(Keys.ENTER);
		 Action clickTNode = oAction.build();
		 clickTNode.perform();
	}
	
	/**
	 * Task Status Drop Down 
	 */
	public void TaskStatus(String sStatus){		
		 Actions clickTB = new Actions(driver);
		 clickTB.sendKeys(Keys.TAB).perform();
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLocTaskStatus"));
		dropDownSelect(dropdown, propF.getPropertyValue("sLogTaskStatus"), sStatus);
		/*Actions oAction=new Actions(driver);
		 oAction		 		
		 		.sendKeys(Keys.TAB)
		 		.click()		 		
		 		.sendKeys(sStatus);
		 Action clickTNode = oAction.build();
		 clickTNode.perform();*/
	}
	
	/**
	 * Task Duration 
	 */
	public void TaskDuration(String sDuration){		
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TaskDuration"));
		enterField(textbox, propF.getPropertyValue("sLog_TaskDuration"), sDuration);	
	}
	
	/**
	 * Task Description 
	 */
	public void TaskDescription(String sDesc){		
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TaskDesc"));
		enterField(textbox, propF.getPropertyValue("sLog_TaskDesc"), sDesc);	
	}
	
	/**
	 * Click on Save As Final Button 
	 */
	public void clickSaveAsFinalBtn(){		
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_TaskSaveAsFinalButton"));
		click(button, propF.getPropertyValue("sLog_TaskSaveAsFinalButton"));	
		sleep(30000);
	}
	
}
