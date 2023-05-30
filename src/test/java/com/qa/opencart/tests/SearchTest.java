package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.ProductDataProvider;
public class SearchTest extends BaseTest{

	@BeforeClass
	//precondition for search class
	public void searchSetup() {
		accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		//Page chaining model or zig zag pattern ==> we started from Login page>> 
																		//then Account page<< then landed on the result page 
																				//<<Product info page<< then go to cart page 
																						//<<if required then go to some other page.
	}
	
	

	

		@Test(dataProvider = "productDataWithSearchKey", dataProviderClass = ProductDataProvider.class)
		public void searchProductResultCountTest(String searchKey) {
			resultsPage = accPage.doSearch(searchKey);
			Assert.assertTrue(resultsPage.getProductResultsCount() > 0);
		}

		@Test(dataProvider = "productDataWithSearchKey", dataProviderClass = ProductDataProvider.class)
		public void searchPageTitleTest(String searchKey) {
			resultsPage = accPage.doSearch(searchKey);
			String actSearchTitle = resultsPage.getResultsPageTitle(searchKey);
			System.out.println("Search Page Title : " + actSearchTitle);
			Assert.assertEquals(actSearchTitle, "Search - " + searchKey);
		}

		@Test(dataProvider = "productDataWithName", dataProviderClass = ProductDataProvider.class)
		public void selectProductTest(String searchKey, String productName) {
			resultsPage = accPage.doSearch(searchKey);
			productInfoPage = resultsPage.selectProduct(productName);
			String actProductHeaderName = productInfoPage.getProductHeaderName();
			System.out.println("actual product name : " + actProductHeaderName);
			Assert.assertEquals(actProductHeaderName, productName);
		}

		@Test(dataProvider = "productDataWithImage", dataProviderClass = ProductDataProvider.class)
		public void productImagesTest(String searchKey, String productName, int expImagesCount) {
			resultsPage = accPage.doSearch(searchKey);
			productInfoPage = resultsPage.selectProduct(productName);
			int actProductImagesCount = productInfoPage.getProductImagesCount();
			System.out.println("actual product images count : " + actProductImagesCount);
			Assert.assertEquals(actProductImagesCount, expImagesCount);
		}}
