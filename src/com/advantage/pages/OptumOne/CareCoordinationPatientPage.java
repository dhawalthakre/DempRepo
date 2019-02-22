package com.advantage.pages.OptumOne;

import java.util.ArrayList;
import java.util.Calendar;
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

/**
 * This class is for the Login page
 */

public class CareCoordinationPatientPage extends Framework {
	PropertyFile propF;	
	String CCFrameid;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CareCoordinationPatientPage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_CareCoordinationPatientPage.properties");	
		
	}	
	
	/**
	 * Verify Care Coordination Paitent page
	 */
	public boolean verifyCCPatientPage(String sPatientName){
		switchCCIframe();
		WebElement header = findElement(driver, propF.getPropertyValue("sLoc_PatientPageHeader"));
		if(header.getText().equalsIgnoreCase(sPatientName)){
			setDefaultFrame(driver);
			return true;
		}
		setDefaultFrame(driver);
		return false;
		 
		
	}
	
	/**
	 * Switch Iframe 
	 */
	public void switchIframe(){
		
//		WebElement iframecase = driver.findElement(By.tagName("iframe"));
//		String id = iframecase.getAttribute("id");
//		System.out.println(id);
//		driver.switchTo().frame(iframecase);
		WebElement iframe = driver.findElement(By.xpath("//iframe[not(contains(@src, '/home/home.jsp'))]"));
		String id = iframe.getAttribute("id");
		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='" + id + "']"));
		System.out.println(id);
		driver.switchTo().frame(iframe1);	
	}
	
	/**
	 * Switch Iframe 
	 */
	public void switchCCIframe(){
		
//		WebElement iframecase = driver.findElement(By.tagName("iframe"));
//		String id = iframecase.getAttribute("id");
//		System.out.println(id);
//		driver.switchTo().frame(iframecase);
		//WebElement iframe = driver.findElement(By.xpath("//iframe[not(contains(@id, 'ext-comp-1006'))]"));
		WebElement iframe = driver.findElement(By.xpath("//iframe[not(contains(@id, 'ext-comp-1005'))]"));
		CCFrameid = iframe.getAttribute("id");
		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='" + CCFrameid + "']"));		
		driver.switchTo().frame(iframe1);
			
	}
	
	/**
	 * Click Care Pathway link
	 */
	public void clickCarePathwayLink(){
		//switchIframe();
		switchCCIframe();
		WebElement link = findElement(driver, propF.getPropertyValue("sLoc_CarePathwayLink"));
		click(link, propF.getPropertyValue("sLog_CarePathwayLink"));
		//driver.findElement(By.id("page:j_id5:j_id6:j_id29:page:j_id73:careManagement1:CareManagement2:CPNav")).click();
		
		sleep(20000);
		
	}
	
	/**
	 * Get Care Pathway details
	 */
	public ArrayList getCarePathwayDetails(){
		ArrayList carepathway = new ArrayList<String>();
		WebElement rightPanel = driver.findElement(By.xpath("//div[@id='Patient']/div[2]"));
		WebElement panel = rightPanel.findElement(By.xpath("//span[contains(@id,':carepathwayPanel')]"));
		WebElement secbody = panel.findElement(By.className("pbBody"));
		WebElement tbl =secbody.findElement(By.tagName("table"));
		
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		for(WebElement ul : RowInfo){
			if(ul.getText().contains("Enrollment pending")){	
				List<WebElement> ColInfo = ul.findElements(By.tagName("td"));
				
				for(WebElement col : ColInfo){
					carepathway.add(col.getText());
				}
									
			}							
		}
		
		return carepathway;
		
	}
	
	/**
	 * Get Care Pathway ID
	 */
	public String getCarePathwayID(ArrayList ccPathway){
		String sCPW = null;
		
		String[] colData = ccPathway.toString().split(",");
		
		String arr = colData[0].substring(1);
		sCPW = arr;
		return sCPW;		
	}
	
	/**
	 * Get Care Pathway Name
	 */
	public String getCarePathwayName(ArrayList ccPathway){
		String sCPW = null;
		
		String[] colData = ccPathway.toString().split(",");
		sCPW = colData[1];
		return sCPW;		
	}
	
	/**
	 * Get Care Pathway Status
	 */
	public String getCarePathwayStatus(ArrayList ccPathway){
		String sCPW = null;
		
		String[] colData = ccPathway.toString().split(",");
		sCPW = colData[3];
		return sCPW;		
	}
	
	/**
	 * Get Care Pathway Referral Reason
	 */
	public String getCarePathwayRefReason(ArrayList ccPathway){
		String sCPW = null;
		
		String[] colData = ccPathway.toString().split(",");
		sCPW = colData[4];
		return sCPW;		
	}
	
	/**
	 * Get Care Pathway Owner
	 */
	public String getCarePathwayOwner(ArrayList ccPathway){
		String sCPW = null;
		
		String[] colData = ccPathway.toString().split(",");
		sCPW = colData[7];
		return sCPW;		
	}
	
	/**
	 * Click care pathway Link
	 */
	public void clickCPLink(String sCPIdLink){
		
		System.out.println(sCPIdLink);
		
		driver.findElement(By.linkText(sCPIdLink)).click();		
		setDefaultFrame(driver);
		sleep(20000);
	}
	
	/**
	 * Click on Edit Patient Information link
	 */
	public void clickEditPatientInfoLink(){
		driver.findElement(By.linkText("Edit Patient Information")).click();
	/*	WebElement link =  findElement(driver, propF.getPropertyValue("sLoc_EditPatientInfoLink"));
		click(link, propF.getPropertyValue("sLog_EditPatientInfoLink"));*/
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(propF.getPropertyValue("sLoc_PageLoading"))));
		
	}
	
	/**
	 * Edit Patient Information
	 */
	public void editPatientInfo(String sAtAGlance, String sAcuityNotes, String sAcuityScore){
		if(sAtAGlance.isEmpty()==false){
			enterAtaglance(sAtAGlance);
		}
		if(sAcuityNotes.isEmpty()==false){
			enterAcuityNotes(sAcuityNotes);
		}
		
		if(sAcuityScore.isEmpty()==false){
			selectAcuityScores(sAcuityScore);
		}
		clickSaveButton();
		setDefaultFrame(driver);
	}
	
	/**
	 * Enter At a Glance Field
	 */
	public void enterAtaglance(String sInputValue){
		WebElement textbox =  findElement(driver, propF.getPropertyValue("sLoc_AtAGlanceField"));
		enterField(textbox, propF.getPropertyValue("sLog_AtAGlanceField"), sInputValue);
	}
	
	
	/**
	 * Enter Acuity Notes Field
	 */
	public void enterAcuityNotes(String sInputValue){
		WebElement textbox =  findElement(driver, propF.getPropertyValue("sLoc_AcuityNotesField"));
		enterField(textbox, propF.getPropertyValue("sLog_AcuityNotesField"), sInputValue);
	}
	
	/**
	 * Select Acuity Scores Field
	 */
	public void selectAcuityScores(String sValue){
		WebElement dropdown =  findElement(driver, propF.getPropertyValue("sLoc_AcuityModalBodyDD"));
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_AcuityModalBodyDD"), sValue);
	}
	
	/**
	 * Verify Edit Patient Information Header
	 */
	public boolean verifyEditPatientInfoModalHeader(){
		WebElement header =  findElement(driver, propF.getPropertyValue("sLoc_HeaderEditPatientInfo"));
		if(header.isDisplayed()){
			return true;
		}
		return false;
	}
	
	/**
	 * Click on Save button
	 */
	public void clickSaveButton(){
		WebElement button =  findElement(driver, propF.getPropertyValue("sLoc_SaveButton"));
		String id = button.getAttribute("id");
		WebElement saveBtn = findElement(driver, id);
		click(saveBtn, propF.getPropertyValue("sLog_SaveButton"));
		
		//driver.findElement(By.xpath("//input[@id='page:j_id5:j_id6:j_id29:page:j_id73:j_id1352']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(propF.getPropertyValue("sLoc_PageLoading"))));
		sleep(50000);
	}
	
	/**
	 * Click Acuity Scores link
	 */
	public void clickAcuityScoreLink(){
		//switchIframe();
		//switchCCIframe();
		/*WebElement link = findElement(driver, propF.getPropertyValue("sLoc_AcuityScoreLink"));
		click(link, propF.getPropertyValue("sLog_AcuityScoreLink"));*/
		driver.findElement(By.partialLinkText("Acuity Scores")).click();
		//driver.findElement(By.id("page:j_id5:j_id6:j_id29:page:j_id73:careManagement1:CareManagement2:CPNav")).click();
		
		sleep(50000);
		
	}
	
		
	/**
	 * verify Acuity Score Record
	 * @return 
	 */
	public boolean verifyAcuityScoreRecord(String sAcuityScore, String sAcuityNotes){
		ArrayList carepathway = new ArrayList<String>();
		WebElement acuity = driver.findElement(By.xpath("//div[@id='page:j_id5:j_id6:j_id29:page:j_id73:j_id470']/div[2]/table/tbody"));
		WebElement acuityscore = driver.findElement(By.xpath("//div[@class='contactBlock']"));
		
		WebElement secbody = acuity.findElement(By.className("pbBody"));
		WebElement tbl =acuity.findElement(By.tagName("table"));
		WebElement body =tbl.findElement(By.tagName("tbody"));
		
		List<WebElement> RowInfo = acuity.findElements(By.tagName("tr"));
		for(WebElement ul : RowInfo){
			System.out.println(ul.getText());
			//System.out.println(Calendar.getInstance().toString());
			//if(ul.getText().contains(Calendar.getInstance().toString())){
				if((ul.getText().contains(sAcuityScore)) && (ul.getText().contains(sAcuityNotes))){	
					setDefaultFrame(driver);
					return true;
				}
			//}
								
		}
		setDefaultFrame(driver);
		return false;	
	}
	
	/**
	 * verify Patient Information
	 * @return 
	 */
	public ArrayList verifyPatientInformation(){
		ArrayList patientInfo = new ArrayList<String>();
		WebElement acuityscore = driver.findElement(By.xpath("//div[@class='patientInformationDiv']"));
		
		WebElement secbody = acuityscore.findElement(By.className("pbSubsection"));
		WebElement tbl =secbody.findElement(By.tagName("table"));
	
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		for(WebElement ul : RowInfo){
			
			List<WebElement> ColInfo = ul.findElements(By.tagName("td"));
			
			for(WebElement col : ColInfo){
				patientInfo.add(col.getText());
			}								
		}
		
		setDefaultFrame(driver);
		return patientInfo;
	}
	
	/**
	 * Get Patient Name from Patient Information table
	 */
	public String getPatientNameInfo(ArrayList patientInfo){
		String name = null;
		
		String[] colData = patientInfo.toString().split(",");
		
		String arr = colData[0];
		name = arr;
		return name;		
	}
	/**
	 * Get Acuity Score from Patient Information table
	 */
	public String getAcuityScoreInfo(ArrayList patientInfo){
		String score = null;
		
		String[] colData = patientInfo.toString().split(",");
		
		String arr = colData[1];
		score = arr;
		return score;		
	}
	
	/**
	 * Get At a glance from Patient Information table
	 */
	public String getAtAGlanceInfo(ArrayList patientInfo){
		String text = null;
		
		String[] colData = patientInfo.toString().split(",");
		
		String arr = colData[2];
		text = arr;
		return text;		
	}
	
	/**
	 * Get Acuity Notes from Patient Information table
	 */
	public String getAcuityNotesInfo(ArrayList patientInfo){
		String note = null;
		
		String[] colData = patientInfo.toString().split(",");
		
		String arr = colData[3];
		note = arr;
		return note;		
	}
	
	/**
	 * Click Contact Patient link
	 */
	public void clickContactPatientLink(){
		//switchIframe();
		switchCCIframe();
		WebElement link = findElement(driver, propF.getPropertyValue("sLoc_ContactPatientLink"));
		click(link, propF.getPropertyValue("sLog_ContactPatientLink"));
		//driver.findElement(By.id("page:j_id5:j_id6:j_id29:page:j_id73:careManagement1:CareManagement2:CPNav")).click();
		
		sleep(50000);
		
	}
	
	/**
	 * Click New Contact Details Button
	 */
	public void clickNewContactDetailsButton(){
		
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_NewContactDetailsButton"));
		click(button, propF.getPropertyValue("sLog_NewContactDetailsButton"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(propF.getPropertyValue("sLoc_PageLoading"))));
		sleep(50000);
		
	}
}
