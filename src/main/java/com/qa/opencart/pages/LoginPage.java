package com.qa.opencart.pages;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

//every page class private By locators
//private webDriver
//never write assert here
//if the page class not returning something we cannot assert
public class LoginPage {

	// private webdriver here
	// default driver value is null

	private WebDriver driver;
	private ElementUtil eleutl;

	// 1. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(this.driver);
	}

	// 2. Private By locators:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");
	private By loginerrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	private By registerLink = By.linkText("Register");

	// 3.public page actions/methods - means behavior of the page
	public String getLoginPageTitle() {
		return eleutl.waitForTitleIsAndCapture("Account Login", 5);
		//String title = driver.getTitle();
		//System.out.println("Login page title: " + title);
		//return title;
	}

	public String getLoginPageURL() {
		//String url = driver.getCurrentUrl();
		return eleutl.waitForURLContainsAndCapture("route=account/login", 5);
		//System.out.println("Login page title: " + url);
		//return url;
	}

	public boolean isForgotPWDLinkExist() {
		return eleutl.checkElementIsDisplayed(forgotPwdLink);
	}

	public List<String> getFooterLinksList() {
		List<WebElement> footerLinksList = eleutl.waitForElementsVisible(footerLinks, 10);//driver.findElements(footerLinks);
		List<String> footerTextList = new ArrayList<String>();
		for (WebElement e : footerLinksList) {
			String text = e.getText();
			footerTextList.add(text);

		}
		return footerTextList;

	}

	public AccountsPage doLogin(String userName, String pwd) {
		eleutl.waitForElementVisible(emailId, 10).sendKeys(userName);
		//driver.findElement(emailId).sendKeys(userName);
		eleutl.doSendKeys(password, pwd);
		//driver.findElement(password).sendKeys(pwd);
		eleutl.doClick(loginBtn);
		//driver.findElement(loginBtn).click();

		return new AccountsPage(driver);
		// return the next landing page --Account Page --page chaining model

	}
	
	public boolean doLoginWithWrongCredentials(String username, String pwd) {
		System.out.println("wrong cred are: " + username +":" + pwd);
		eleutl.waitForElementVisible(emailId, 10);
		eleutl.doSendKeys(emailId, username);
		eleutl.doSendKeys(password, pwd);
		eleutl.doClick(loginBtn);
		String errorMessg=eleutl.doGetElementText(loginerrorMessg);
		System.out.println(errorMessg);
		if(errorMessg.contains(errorMessg)) {
			return true;
		}return false;
	}
	
	public RegisterPage navigateToRegisterPage() {
		eleutl.doClick(registerLink);
		return new RegisterPage(driver);
	}
	

}
