package com.qa.opencart.pages;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleutl;

	// 1. Constructor of the page class
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(this.driver); 
	}

	// 2.By locators
	private By logout = By.linkText("Logout");
	private By myAccount = By.linkText("My Account");
	private By accHeader = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");

	// 3. Page actions:

	public String getAccPageTitle() {
		String title = eleutl.waitForTitleIsAndCapture("My Account", 5);
		System.out.println("Acc page title:" + title);
		return title;
	}

	public boolean isLogoutLinkExist() {
		return eleutl.checkElementIsDisplayed(logout);
	}

	public boolean isAccountLinkExist() {
		return eleutl.checkElementIsDisplayed(myAccount);
	}

	public List<String> getAccountPageHeadersList() {
		List<WebElement> headersList = eleutl.waitForElementsVisible(accHeader, 10);
		List<String> headersValList = new ArrayList<String>();
		for (WebElement e : headersList) {
			String text = e.getText();
			headersValList.add(text);

		}
		return headersValList;
	}

	public ResultsPage doSearch(String searchTerm) {
		eleutl.waitForElementPresence(search, 10);
		eleutl.doSendKeys(search, searchTerm);
		eleutl.doClick(searchIcon);
		return new ResultsPage(driver);// test driven development approach - to land on another page(class)called page chaning
		//have to return the object of next landing page class
	}
}
