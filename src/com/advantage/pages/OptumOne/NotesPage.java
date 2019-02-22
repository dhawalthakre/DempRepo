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

public class NotesPage extends Framework {
	PropertyFile propF;	
	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NotesPage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_NotesPage.properties");	
		
	}		
	
	/**
	 * Switch to Notes Iframe
	 */
	public void switchToNotesIFrame(){		
		switchFrame(driver, propF.getPropertyValue("sLoc_NotesIFrame"));
	}
	
	/**
	 * Click on New Note Button
	 */
	public void clickNewNoteButton(){				
		switchToNotesIFrame();
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_NewNoteButton"));
		click(button, propF.getPropertyValue("sLog_NewNoteButton"));
		setDefaultFrame(driver);
		
	}
	
	/**
	 * Get Notes Details
	 */
	public ArrayList getNotesDetails(String sTagName){
		switchToNotesIFrame();
		ArrayList noteDtl = new ArrayList<String>();
		WebElement divpanel = driver.findElement(By.className("notepage"));
		WebElement secbody = divpanel.findElement(By.className("pbBody"));
		WebElement tbl =secbody.findElement(By.tagName("table"));
		List<WebElement> RowInfo = tbl.findElements(By.tagName("tr"));
		label:
		for(WebElement ul : RowInfo){
			if(ul.getText().contains(sTagName)){
				
				List<WebElement> ColInfo = ul.findElements(By.tagName("td"));
				System.out.println(ColInfo.size());
				int i=0;
				for(WebElement col : ColInfo){
					noteDtl.add(col.getText());		
					i++;
					if(i==ColInfo.size()){
						break label;
					}
				}
									
			}
			
		}
		setDefaultFrame(driver);
		System.out.println(noteDtl);
		//setDefaultFrame(driver);
		return noteDtl;	
	}
	
	/**
	 * Get Note ID
	 */
	public String getNoteID(ArrayList noteDtl){
		String sNoteID = null;
		
		String[] colData = noteDtl.toString().split(",");
		
		String arr = colData[1];
		sNoteID = arr;
		return sNoteID;		
	}
	
	/**
	 * Get Tag name
	 */
	public String getTagName(ArrayList noteDtl){
		String sTag = null;
		
		String[] colData = noteDtl.toString().split(",");
		
		String arr = colData[4];
		sTag = arr;
		return sTag;		
	}

}
