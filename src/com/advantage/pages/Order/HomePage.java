package com.advantage.pages.Order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.advantage.fileutils.PropertyFile;
import com.advantage.framework.Framework;

public class HomePage extends Framework{
	PropertyFile propF;
	
	public HomePage(WebDriver driver)
	{
		super(driver);	
		PropertyFile propF = new PropertyFile("objectrepository\\OR_OrderHomePage.properties");	
	}
	
	public void goToCreateOrder(){
		WebElement createOrder = findElement(driver, propF.getPropertyValue("sLoc_create_Order_Link"));
		click(createOrder, "Create Order Link");
	}
}
