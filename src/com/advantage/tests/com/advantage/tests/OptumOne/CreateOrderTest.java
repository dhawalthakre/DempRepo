package com.advantage.tests.com.advantage.tests.OptumOne;

import org.testng.annotations.Test;

import com.advantage.framework.TestTemplate;
import com.advantage.pages.OptumOne.Login;
import com.advantage.pages.Order.HomePage;

public class CreateOrderTest extends TestTemplate {
	
  @Test
  public void verifyCreateOrder() {
	  Login loginPage = new Login(driver);
	  HomePage homePage = new HomePage(driver);
	  loginPage.loginAs(ConfigInfo.getsUserName(), ConfigInfo.getsPassword());
	  homePage.goToCreateOrder();
  }
}
