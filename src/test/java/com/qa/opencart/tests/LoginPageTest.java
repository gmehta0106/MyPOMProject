package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		// never use driver. here'
		String actTitle = loginPage.getLoginPageTitle();
		/**
		 * Asserts that two Strings are equal. If they are not, an AssertionError is thrown.
			Parameters:actual the actual value expected the expected value
		 */
		Assert.assertEquals(actTitle, "Account Login111");
	}
	
	@Test 
	public void loginPageURLTest() {
		String actlURL=loginPage.getLoginPageURL();
		//Asserts that a condition is true. If it isn't, an AssertionError is thrown.
		Assert.assertTrue(actlURL.contains("route=account/login"));
	}

	@Test
	public void forgotPWDLinkExistTest() {
		// never use driver. here'
		Assert.assertTrue(loginPage.isForgotPWDLinkExist());
	}

	@Test
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//reading username and password from config.properties file with the help of ref variable created in baseTest class
		Assert.assertTrue(accPage.isLogoutLinkExist());
		//Assert.assertTrue(accPage.getAccPageTitle().equals("My Account"));
	}

//logo 
	// label is there or not
	//
}
