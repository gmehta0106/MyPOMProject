package com.qa.opencart.pages;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {
	private WebDriver driver;
	private ElementUtil eleutl;
	// 1. Constructor of the page class
	public ResultsPage(WebDriver driver) {
		this.driver=driver;
		eleutl=new ElementUtil(this.driver);
		}
	
	By resultsProduct = By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']");
	
	
	//page actions:
	public String getResultsPageTitle(String searchKay) {
		return eleutl.waitForTitleIsAndCapture(searchKay, 10);
	}
	//search is successful or not 
	public int getProductResultsCount() {
	int resultCount= eleutl.waitForElementsVisible(resultsProduct, 10).size();
	System.out.println("product search result count=====>" + resultCount);
	return resultCount;
	}
	
	public ProductInfoPage selectProduct(String productName) {
		By productNameLocator = By.linkText(productName);
		eleutl.doClick(productNameLocator);
		return new ProductInfoPage(driver);
		
	}

	

	
	
}
