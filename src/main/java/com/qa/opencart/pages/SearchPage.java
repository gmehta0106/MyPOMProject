package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class SearchPage {
	private WebDriver driver;
	private ElementUtil eleutl;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(this.driver);

	}

	private By searchHeader = By.xpath("//h1[text()='Search - imac']");
	private By searchInput = By.xpath("//input[@type='text' and @placeholder='Search']");
	private By searchBtn = By.xpath("//span[@class='input-group-btn']/button");

	public String getSearchPageHeader(String searchHeader) {
		return eleutl.waitForTitleIsAndCapture("Search - imac", 10);
	}

	public void searchText() {
		eleutl.waitForElementPresence(searchInput, 5).sendKeys("imac");
	}

	public void searchIcon() {
		eleutl.doClick(searchBtn);
	}

}
