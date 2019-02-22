package com.advantage.pages.OptumOne;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantage.fileutils.PropertyFile;
import com.advantage.framework.Framework;

public class EditAssessmentPage extends Framework{
	
	PropertyFile propF1;	
	public WebDriver driver;
	
	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 * @throws InterruptedException 
	 */
	public EditAssessmentPage(WebDriver driver) 
	{
		super(driver);	
		propF1 = new PropertyFile("objectrepository\\OR_EditAssesmentPage.properties");	
		

	}	
	
	public boolean verifyEditAssessmentPage(WebDriver driver)
	{
		WebElement addquestion;
		bWaitForEnabledElement(addquestion = findElement(driver, propF1.getPropertyValue("sLoc_AddQuestion")), "Add question button");
		if(addquestion.isEnabled()){
			System.out.println("Add assessment button found");
			return true;
		}
		return false;
		
	}	
	
	public void AddQuestionRadioButton(WebDriver driver, String questntext) throws InterruptedException{
		
		propF1 = new PropertyFile("objectrepository\\OR_EditAssessmentPage.properties");
		WebElement addquestion = findElement(driver, propF1.getPropertyValue("sLoc_AddQuestion"));
		addquestion.click();
		WebElement radiobutton;
		bWaitForEnabledElement(radiobutton = findElement(driver, propF1.getPropertyValue("sLoc_radiobutton")), "Radio button option");
		radiobutton.click();
		//clickAndWaitForURL(radiobutton, "Radio button", "OPDes_MasterAssessment");
		sleep(2000);
		WebElement questiontext = findElement(driver, propF1.getPropertyValue("sLoc_QuestionText"));
		//bWaitForEnabledElement(questiontext = findElement(driver, propF1.getPropertyValue("sLoc_QuestionText")), "Add question text box");
		questiontext.click();
		enterField(questiontext, "Add question text box", questntext);
		WebElement addresponse = findElement(driver, propF1.getPropertyValue("sLoc_AddResponse"));
		addresponse.click();
		List<WebElement> choicetext = findElements(driver, propF1.getPropertyValue("sLoc_ChoiceText"));
		WebElement choicetext1 = choicetext.get(0);
		choicetext1.sendKeys("yes");
		WebElement choicetext2 = choicetext.get(1);
		choicetext2.sendKeys("no");
		WebElement savebutton = findElement(driver, propF1.getPropertyValue("sLoc_SaveButton"));
		clickAndWaitForURL(savebutton, "Save button", "OPDes_MasterAssessment");
		
		
		
	}
	
	public void AddQuestionCheckBox(WebDriver driver, String questntext) throws InterruptedException{
		propF1 = new PropertyFile("objectrepository\\OR_EditAssessmentPage.properties");
		WebElement addquestion = findElement(driver, propF1.getPropertyValue("sLoc_AddQuestion"));
		addquestion.click();
		WebElement checkbox;
		bWaitForEnabledElement(checkbox = findElement(driver, propF1.getPropertyValue("sLoc_checkbox")), "Checkbox option");
		checkbox.click();
		//clickAndWaitForURL(checkbox, "Check box", "OPDes_MasterAssessment");
		sleep(2000);
		WebElement questiontext = findElement(driver, propF1.getPropertyValue("sLoc_QuestionText"));
		//bWaitForEnabledElement(questiontext = findElement(driver, propF1.getPropertyValue("sLoc_QuestionText")), "Add question text box");
		questiontext.click();
		enterField(questiontext, "Add question text box", questntext);
		//WebElement addresponse = findElement(driver, propF1.getPropertyValue("sLoc_AddResponse"));
		//addresponse.click();
		//addresponse.click();
		List<WebElement> addresponse = findElements(driver, propF1.getPropertyValue("sLoc_AddResponse"));
		WebElement addresponsebutton = addresponse.get(0);
		System.out.println(addresponse.get(0));
		//System.out.println(addresponse.get(1));
		sleep(2000);
		addresponsebutton.click();
		addresponsebutton.click();
		List<WebElement> choicetext = findElements(driver, propF1.getPropertyValue("sLoc_ChoiceText"));
		WebElement choicetext1 = choicetext.get(0);
		choicetext1.sendKeys("Option 1");
		WebElement choicetext2 = choicetext.get(1);
		choicetext2.sendKeys("Option 2");
		WebElement choicetext3 = choicetext.get(2);
		choicetext3.sendKeys("Option 3");
		WebElement savebutton = findElement(driver, propF1.getPropertyValue("sLoc_SaveButton"));
		clickAndWaitForURL(savebutton, "Save button", "OPDes_MasterAssessment");
		
	}
	
	public void finishAndPublish(WebDriver driver){
		WebElement finishpublish;
		finishpublish = findElement(driver, propF1.getPropertyValue("sLoc_finishpublish"));
		clickAndWaitForURL(finishpublish, "Finish and Publish button", "OPDes_MasterAssessment");
		
	}
	
	public void saveAndPublish(WebDriver driver){
		WebElement savepublish;
		bWaitForEnabledElement(savepublish = findElement(driver, propF1.getPropertyValue("sLoc_savepublish")), "Save and publish button");
		savepublish.click();
		WebElement yesbutton = findElement(driver, propF1.getPropertyValue("sLoc_yesbutton"));
		clickAndWaitForURL(yesbutton, "Yes button", "OPDes_MasterAssessment");
		
	}
	
	
	
	

}
