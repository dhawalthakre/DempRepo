package com.advantage.pages.OptumOne;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.advantage.reporting.Report;

/**
 * This class is for the Login page
 */

public class PlanOfCarePage extends Framework {
	PropertyFile propF;	
	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public PlanOfCarePage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_PlanOfCarePage.properties");	
		
	}		
	
	/**
	 * Switch to Plan of Care Iframe
	 */
	public void switchToPlanOfCareIFrame(){		
		switchFrame(driver, propF.getPropertyValue("sLoc_PlanOfCareIFrame"));
	}
	
	/**
	 * Click on New Patient Goal Button
	 */
	public void clickNewPatientGoalButton(){				
		
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_NewPatientGoalButton"));
		click(button, propF.getPropertyValue("sLog_NewPatientGoalButton"));
		//setDefaultFrame(driver);		
	}
	
	/**
	 * Search Goal
	 */
	public void searchGoal(String sValue){
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_GoalSearchTextbox"));
		enterField(textbox, propF.getPropertyValue("sLog_GoalSearchTextbox"), sValue);
	}
	
	public boolean verifyGoalSearchResult(String sValue){
		ArrayList goalDtl = new ArrayList<String>();
		WebElement searchtbl = driver.findElement(By.xpath("//tbody[@id='searchTable']"));
		
		
		List<WebElement> RowInfo = searchtbl.findElements(By.tagName("tr"));
		label:
		for(WebElement ul : RowInfo){
			if(ul.getText().contains(sValue)){
				System.out.println("Match");
				return true;		
			}
		}	
		return false;
	}
	
	public void dragdropGoal(String sCategory, String sGoalName){
		
		if(sCategory.equalsIgnoreCase("In Focus")){
			WebElement searchtbl = driver.findElement(By.xpath("//tbody[@id='searchTable']"));
			
			WebElement srcElement = searchtbl.findElement(By.xpath("//span[contains(text(), '"+ sGoalName + "')]"));
			WebElement targetElement = driver.findElement(By.xpath("//div[@id='inFocusListGrid']"));
			(new Actions(driver)).dragAndDrop(srcElement, targetElement).perform();
		}
		else if(sCategory.equalsIgnoreCase("Not In Focus")){
			WebElement searchtbl = driver.findElement(By.xpath("//tbody[@id='searchTable']"));
			
			WebElement srcElement = searchtbl.findElement(By.xpath("//span[contains(text(), '"+ sGoalName + "')]"));
			WebElement targetElement = driver.findElement(By.xpath("//div[@id='notInFocusListGrid']"));
			(new Actions(driver)).dragAndDrop(srcElement, targetElement).perform();
		}
		else {
			Report.logInfo("Invalid Category");
		}
	}	
	
	public void dragdropGoalToInFocus(String sValue){
		WebElement searchtbl = driver.findElement(By.xpath("//tbody[@id='searchTable']"));
		
		WebElement srcElement = searchtbl.findElement(By.xpath("//span[contains(text(), '"+ sValue + "')]"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='inFocusListGrid']"));
		(new Actions(driver)).dragAndDrop(srcElement, targetElement).perform();
		
	}
	
	public void dragdropGoalToNotInFocus(String sValue){
		WebElement searchtbl = driver.findElement(By.xpath("//tbody[@id='searchTable']"));
		
		WebElement srcElement = searchtbl.findElement(By.xpath("//span[contains(text(), '"+ sValue + "')]"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='notInFocusListGrid']"));
		(new Actions(driver)).dragAndDrop(srcElement, targetElement).perform();
		
	}
	
	public void clickCloseButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_GoalPopupCloseButton"));
		click(button, propF.getPropertyValue("sLog_GoalPopupCloseButton"));
		sleep(10000);
	}
	
	public boolean verifyInFocusDraggedGoal(String sValue){
		
		WebElement divpanel = driver.findElement(By.xpath("//div[@id='inFocusListGrid']"));
		WebElement tbl = divpanel.findElement(By.xpath("//table[@class='inner-table']"));
		
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		
		for(WebElement ul : RowInfo){
			if(ul.getText().contains(sValue)){								
				return true;
			}
		}
		return false;		
		
	}
	
	public boolean verifyNotInFocusDraggedGoal(String sValue){
		
		WebElement divpanel = driver.findElement(By.xpath("//div[@id='notInFocusListGrid']"));
		WebElement tbl = divpanel.findElement(By.xpath("//table[@class='inner-table']"));
		
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		
		for(WebElement ul : RowInfo){
			if(ul.getText().contains(sValue)){								
				return true;
			}
		}
		return false;		
		
	}
	
	public boolean verifyDraggedGoal(String sCategory, String sValue){
		
		if(sCategory.equalsIgnoreCase("In Focus")){
			WebElement divpanel = driver.findElement(By.xpath("//div[@id='inFocusListGrid']"));
			WebElement tbl = divpanel.findElement(By.xpath("//table[@class='inner-table']"));
			
			List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
			
			for(WebElement ul : RowInfo){
				if(ul.getText().contains(sValue)){								
					return true;
				}
			}
		}
		else if(sCategory.equalsIgnoreCase("Not In Focus")){
			WebElement divpanel = driver.findElement(By.xpath("//div[@id='notInFocusListGrid']"));
			WebElement tbl = divpanel.findElement(By.xpath("//table[@class='inner-table']"));
			
			List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
			
			for(WebElement ul : RowInfo){
				if(ul.getText().contains(sValue)){								
					return true;
				}
			}
		}
		else {
			Report.logInfo("Invalid Category");
		}		
		return false;		
		
	}
	
	public void clickGoalEditLink(){
		WebElement link = findElement(driver, propF.getPropertyValue("sLoc_GoalEditLink"));
		click(link, propF.getPropertyValue("sLog_GoalEditLink"));
		sleep(10000);
	}
	
	public void enterGoalTargetDate(String sValue){
		
		
		WebElement editHeaderTbl = driver.findElement(By.xpath("//table[@class='edit-header']"));
		List<WebElement> RowInfo = editHeaderTbl.findElements(By.tagName("tr"));
		int index = 0;
		for(WebElement ul : RowInfo){			
			List<WebElement> ColInfo = ul.findElements(By.tagName("td"));	
			
			for(WebElement col : ColInfo){	
				if(col.getAttribute("class").contains("target-date")){
					index = ColInfo.indexOf(col);
					WebElement field = ColInfo.get(index).findElement(By.tagName("input"));
					String id = field.getAttribute("id");
					driver.findElement(By.id(id)).clear();
					driver.findElement(By.id(id)).sendKeys(sValue);
					driver.findElement(By.id(id)).sendKeys(Keys.RETURN);
				}
				
			}
			
		}
		
	}
	
	/*public void enterGoalTargetDate(String sCategory, String sValue){
		if(sCategory.equalsIgnoreCase("In Focus")){
			//WebElement divpanel = driver.findElement(By.xpath("//div[@id='inFocusListGrid']"));
			//WebElement tbl = divpanel.findElement(By.xpath("//table[@class='inner-table']"));
			//WebElement editHeaderTbl = tbl.findElement(By.xpath("//table[@class='edit-header']"));
			
			WebElement targetDateTxt = driver.findElement(By.xpath("//td[contains(@class, 'target-date')]"));
			
			WebElement field = targetDateTxt.findElement(By.tagName("input"));
			String id = field.getAttribute("id");
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(sValue);
			targetDateTxt.click();
			targetDateTxt.sendKeys(sValue);
			targetDateTxt.sendKeys(Keys.RETURN);
			sleep(5000);
			//driver.findElement(By.cssSelector("ul.select2-selection__rendered")).click();
			
		}
		else if(sCategory.equalsIgnoreCase("Not In Focus")){
			
		}
		else {
			Report.logInfo("Invalid Category");
		}		
		
	}*/
	
	public void enterProblem(String sCategory, String sValue){
		
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_Problem"));
		enterField(textbox, propF.getPropertyValue("sLog_Problem"), sValue);
		sleep(5000);
		textbox.sendKeys(Keys.RETURN);
	}
	
	public boolean verifyProblem(String sValue){
		//WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_Problem"));
		
		if(driver.findElement(By.cssSelector("ul.select2-selection__rendered")).getText().contains(sValue)){
			
			return true;
		}
		return false;
	}
	
	public void scrollDownPage(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}
	
	public void clickAddActionLink(){		
		performTAB();
		sleep(5000);
		WebElement link = findElement(driver, propF.getPropertyValue("sLoc_AddActionLink"));
		click(link, propF.getPropertyValue("sLog_AddActionLink"));
		sleep(1000);
		//driver.findElement(By.linkText("+ Add Action")).click();
		//Actions actions = new Actions(driver);

		//actions.moveToElement(link).click().perform();
	}
	
	public boolean verifyActionModalDialog(){
		WebElement dialog = findElement(driver, propF.getPropertyValue("sLoc_ModalDialog"));
		if(dialog.isDisplayed()){
			//WebElement dialogTitle = findElement(driver, propF.getPropertyValue("sLoc_ModalTitle"));
			if(driver.findElement(By.cssSelector("h4.modal-title")).getText().contains("New Patient Action")){
				return true;
			}
		}
		return false;
	}
	
	public void selectActionText(String sCategory, String sValue){
		
		WebElement select = findElement(driver, propF.getPropertyValue("sLoc_ActionText"));
		select.click();
		
		WebElement searchField = driver.findElement(By.xpath(propF.getPropertyValue("sLoc_ActionTextSearchField")));
		
		searchField.sendKeys(sValue);
		searchField.sendKeys(Keys.RETURN);
		sleep(5000);
		//dropDownSelect(select, propF.getPropertyValue("sLog_ActionText"), sValue);
		//enterField(select, propF.getPropertyValue("sLog_ActionText"), sValue);
		//select.sendKeys(sValue);
	}
	
	public void enterActionTargetDate(String sCategory, String sValue){
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_ActionTargetDate"));
		enterField(textbox, propF.getPropertyValue("sLog_ActionTargetDate"), sValue);
		textbox.sendKeys(Keys.RETURN);
	}
	
	public void selectActionStatus(String sCategory, String sValue){
		WebElement select = findElement(driver, propF.getPropertyValue("sLoc_ActionStatus"));
		dropDownSelect(select, propF.getPropertyValue("sLog_ActionStatus"), sValue);
		sleep(10000);
	}
	
	public void clickActionSaveButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_ModalDialogActionSaveButton"));
		click(button, propF.getPropertyValue("sLog_ModalDialogActionSaveButton"));
		sleep(5000);
	}
	
	public boolean verifyActionText(String sActionText){
		WebElement editHeaderTbl = driver.findElement(By.xpath("//table[contains(@class, 'patientAction')]"));
		List<WebElement> RowInfo = editHeaderTbl.findElements(By.tagName("tr"));
		
		for(WebElement ul : RowInfo){			
			List<WebElement> ColInfo = ul.findElements(By.tagName("td"));	
			
			for(WebElement col : ColInfo){				
				if(col.getAttribute("class").contains("actiontext")){
					if(col.getText().contains(sActionText)){
						return true;
					}
				}		
				
			}
			
		}
		return false;
	}
	
	public boolean verifyActionTargetDate(String sActionTargetDate){
		WebElement editHeaderTbl = driver.findElement(By.xpath("//table[contains(@class, 'patientAction')]"));
		List<WebElement> RowInfo = editHeaderTbl.findElements(By.tagName("tr"));
		
		for(WebElement ul : RowInfo){			
			List<WebElement> ColInfo = ul.findElements(By.tagName("td"));	
			
			for(WebElement col : ColInfo){					
				if(col.getAttribute("class").contains("targetdate")){
					if(col.getText().contains(sActionTargetDate)){
						return true;
					}
				}		
				
			}
			
		}
		return false;
	}
	
	public void highlightInFocus(){
		/*WebElement editHeaderTbl = driver.findElement(By.xpath("//table[contains(@class, 'patientAction')]"));
		List<WebElement> RowInfo = editHeaderTbl.findElements(By.tagName("tr"));
		
		for(WebElement ul : RowInfo){			
			List<WebElement> ColInfo = ul.findElements(By.tagName("td"));	
			
			for(WebElement col : ColInfo){	
				WebElement dd = col.findElement(By.xpath("//select[@id='']"));
				System.out.println(dd.getAttribute("class"));
				if(dd.getAttribute("class").contains("actionstatus")){
					driver.findElement(By.className(dd.getAttribute("class"))).click();
					 Actions oAction = new Actions(driver);
					 oAction.sendKeys(Keys.TAB).perform();
					 sleep(2000);
					
				}		
				
			}
			
		}*/
		driver.findElement((By.xpath("//select[@id='']"))).click();
		sleep(2000);
		 Actions oAction = new Actions(driver);
		 oAction.sendKeys(Keys.TAB).perform();
		 sleep(4000);
		
	}
	
	
	public void clickAddTaskLink(){		
		scrollDownPage();
		WebElement link = findElement(driver, propF.getPropertyValue("sLoc_AddTaskLink"));
		click(link, propF.getPropertyValue("sLog_AddTaskLink"));
		sleep(5000);
	}
	
	
	public boolean verifyTaskModalDialog(){
		
		WebElement dialog = findElement(driver, propF.getPropertyValue("sLoc_TaskModalDialog"));
		System.out.println(dialog.isDisplayed());
		if(dialog.isDisplayed()){
			WebElement dialogTitle = findElement(driver, propF.getPropertyValue("sLoc_TaskModalDialogTitle"));
			if(dialogTitle.getText().equalsIgnoreCase("New Care Team Task")){
				System.out.println(dialogTitle.getText());
				return true;
			}
		}
		return false;
	}
	
	public void selectTaskActivity(String sCategory, String sValue){
		driver.switchTo().activeElement();
		WebElement select = findElement(driver, propF.getPropertyValue("sLoc_TaskActivity"));
		//dropDownSelect(select, propF.getPropertyValue("sLog_TaskActivity"), sValue);
		WebElement searchField = driver.findElement(By.xpath(propF.getPropertyValue("sLoc_TaskActivitySearchField")));
		
		searchField.sendKeys(sValue);
		searchField.sendKeys(Keys.RETURN);
	}
	
	public void selectTaskSubject(String sCategory, String sValue){
		WebElement select = findElement(driver, propF.getPropertyValue("sLoc_TaskSubject"));
		//dropDownSelect(select, propF.getPropertyValue("sLog_TaskSubject"), sValue);
		WebElement searchField = driver.findElement(By.xpath(propF.getPropertyValue("sLoc_TaskSubjectSearchField")));
		
		searchField.sendKeys(sValue);
		searchField.sendKeys(Keys.RETURN);
	}
	
	public void enterTaskDueDate(String sCategory, String sValue){
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TaskDueDate"));
		enterField(textbox, propF.getPropertyValue("sLog_TaskDueDate"), sValue);
		textbox.sendKeys(Keys.RETURN);
	}
	
	public void selectTaskPriority(String sCategory, String sValue){
		WebElement select = findElement(driver, propF.getPropertyValue("sLoc_TaskPriority"));
		dropDownSelect(select, propF.getPropertyValue("sLog_TaskPriority"), sValue);
	}
	
	public void selectTaskStatus(String sCategory, String sValue){
		WebElement select = findElement(driver, propF.getPropertyValue("sLoc_TaskStatus"));
		dropDownSelect(select, propF.getPropertyValue("sLog_TaskStatus"), sValue);
	}
	
	public void clickTaskSaveButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_TaskSaveButton"));
		click(button, propF.getPropertyValue("sLog_TaskSaveButton"));		
	}
	
	public void clickManageBarrierstoCareLink(){		
		WebElement link = findElement(driver, propF.getPropertyValue("sLoc_ManageBarrierstoCareLink"));
		click(link, propF.getPropertyValue("sLog_ManageBarrierstoCareLink"));
	}
	
	public boolean verifyBarrierModalDialog(){
		WebElement dialog = findElement(driver, propF.getPropertyValue("sLoc_ModalDialog"));
		if(dialog.isDisplayed()){
			WebElement dialogTitle = findElement(driver, propF.getPropertyValue("sLoc_ModalTitle"));
			if(dialogTitle.getText().contains("Manage Barriers for Goal")){
				return true;
			}
		}
		return false;
	}
	
	public void clickNewBarrierButton(){
		scrollDownPage();
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_NewBarrierButton"));
		click(button, propF.getPropertyValue("sLog_NewBarrierButton"));		
	}
	
	
	public boolean verifyNewBarrierModalDialog(){
		WebElement dialog = findElement(driver, propF.getPropertyValue("sLoc_ModalDialog"));
		if(dialog.isDisplayed()){
			WebElement dialogTitle = findElement(driver, propF.getPropertyValue("sLoc_ModalTitle"));
			if(dialogTitle.getText().contains("New Barrier to Care")){
				return true;
			}
		}
		return false;
	}
	
	public void selectBarrierCategory(String sCategory, String sValue){
		WebElement select = findElement(driver, propF.getPropertyValue("sLoc_BarrierCategory"));
		dropDownSelect(select, propF.getPropertyValue("sLog_BarrierCategory"), sValue);
	}
	
	public void selectBarrier(String sCategory, String sValue){
		WebElement select = findElement(driver, propF.getPropertyValue("sLoc_Barrier"));
		dropDownSelect(select, propF.getPropertyValue("sLog_Barrier"), sValue);
	}
	
	public void clickNewBarrierSaveButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_BarrierSaveButton"));
		click(button, propF.getPropertyValue("sLog_BarrierSaveButton"));		
	}
	
	public void clickGoalSaveButton(){
		/*//verifyActionStatus();
		sleep(2000);
		clickDivScrollBar();
		 Actions oAction = new Actions(driver);
		 oAction.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform();
		sleep(5000);*/
		//scrollDownPage();
		Actions oAction = new Actions(driver);
		 oAction.sendKeys(Keys.PAGE_DOWN).perform();
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_GoalSaveButton"));
		click(button, propF.getPropertyValue("sLog_GoalSaveButton"));	
		sleep(1000);
	}
	
	public void scrollUpPage(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}
	
	public void clickGoalCommitDialogYesButton(){
		
		
		//WebElement dialog = findElement(driver, propF.getPropertyValue("sLoc_isSaveModelDialog"));
		//if(dialog.isDisplayed()){
			driver.findElement(By.cssSelector("#isSaveModel > div.modal-dialog > div.modal-content > div.modal-footer > button.btn.btn-default")).click();
		//}
		//WebElement button = findElement(driver, propF.getPropertyValue("sLoc_GoalCommitDialogYesButton"));
		//click(button, propF.getPropertyValue("sLog_GoalCommitDialogYesButton"));		
		//driver.findElement(By.xpath("//div[@id='isSaveModel']/div/div/div[3]/button[1]")).click();
		sleep(6000);
		scrollUpPage();
		scrollUpPage();
		scrollUpPage();
		sleep(6000);
	}
	
	
	public boolean verifyGoal(String sValue){
		WebElement editHeaderTbl = driver.findElement(By.xpath("//table[@class='edit-header']"));
		List<WebElement> RowInfo = editHeaderTbl.findElements(By.tagName("tr"));
		int index = 0;
		for(WebElement ul : RowInfo){			
			List<WebElement> ColInfo = ul.findElements(By.tagName("td"));	
			
			for(WebElement col : ColInfo){	
				if(col.getAttribute("class").contains("edit-change")){
					index = ColInfo.indexOf(col);
					WebElement field = ColInfo.get(index).findElement(By.tagName("input"));
					String cls = field.getAttribute("class");
					
					String val = driver.findElement(By.className(cls)).getAttribute("value");
					System.out.println(val);
					if(val.equalsIgnoreCase(sValue)){
						return true;
					}
				}
				
			}
			
		}
		return false;
	}
	
	public boolean verifyGoalTargetDate(String sValue){
		WebElement editHeaderTbl = driver.findElement(By.xpath("//table[@class='edit-header']"));
		List<WebElement> RowInfo = editHeaderTbl.findElements(By.tagName("tr"));
		int index = 0;
		for(WebElement ul : RowInfo){			
			List<WebElement> ColInfo = ul.findElements(By.tagName("td"));	
			
			for(WebElement col : ColInfo){	
				if(col.getAttribute("class").contains("target-date")){
					index = ColInfo.indexOf(col);
					WebElement field = ColInfo.get(index).findElement(By.tagName("input"));
					String id = field.getAttribute("id");
					
					String val = driver.findElement(By.id(id)).getAttribute("value");
					System.out.println(val);
					if(val.equalsIgnoreCase(sValue)){
						return true;
					}
				}
				
			}
			
		}
		return false;
	}
	
	public void clickCancelButton(){
		
		Actions oAction = new Actions(driver);
		 oAction.sendKeys(Keys.PAGE_DOWN).perform();
		 sleep(5000);
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_CancelButton"));
		click(button, propF.getPropertyValue("sLog_CancelButton"));	
		sleep(1000);
	}
	
	public void clickGoalRemoveLink(){
		Actions oAction = new Actions(driver);
		 oAction.sendKeys(Keys.PAGE_UP).perform();
		WebElement link = findElement(driver, propF.getPropertyValue("sLoc_GoalRemoveLink"));
		click(link, propF.getPropertyValue("sLog_GoalRemoveLink"));
		sleep(10000);
	}
	
	public void clickWarningDialogToRemoveGoalYesButton(){
		driver.findElement(By.cssSelector("#warningMsgModal > div.modal-dialog > div.modal-content > div.modal-footer > button.btn.btn-default")).click();
		sleep(1000);
	}
	
	public void clickDivScrollBar(){
		/*WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_Problem"));	
		click(textbox,propF.getPropertyValue("sLog_Problem"));
		sleep(5000);
		textbox.sendKeys(Keys.RETURN);
		 Actions oAction=new Actions(driver);
		 oAction
		 		.sendKeys(Keys.TAB)
		 		.sendKeys(Keys.TAB)
		 		.keyDown(Keys.CONTROL)
		 		.sendKeys(Keys.END)
		 		.keyUp(Keys.CONTROL);		 		
		 Action clickTNode = oAction.build();
		 clickTNode.perform();*/
		highlightInFocus();
			 Actions oAction=new Actions(driver);
			 oAction
			 		.sendKeys(Keys.TAB)
			 		.sendKeys(Keys.TAB)
			 		.keyDown(Keys.CONTROL)
			 		.sendKeys(Keys.END)
			 		.keyUp(Keys.CONTROL);		 		
			 Action clickTNode = oAction.build();
			 clickTNode.perform();
	}
	
	public void performTAB(){
		Actions oAction=new Actions(driver);
		 oAction.sendKeys(Keys.TAB).perform();
	}
	
	public void clickHideAllDetailsLink(){
		driver.findElement(By.xpath("//li[@onclick=\"hideAllGoals('#inFocusListGrid')\"]")).click();
	}
	
	public void TABOperationForChangeFocus(){
		Actions oAction=new Actions(driver);
		 oAction
		 		.sendKeys(Keys.TAB)
		 		.sendKeys(Keys.TAB);		 		
		 Action clickTNode = oAction.build();
		 clickTNode.perform();
		
	}
}
