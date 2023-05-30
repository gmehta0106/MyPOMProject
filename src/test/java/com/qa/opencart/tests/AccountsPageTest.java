package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass//pre condition - login method for this class only
	public void accPageSetup() {
		accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accPageTitleTest() {
		String actTitle=accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, "My Account");
	}
	@Test
	public void isLogoutLinkExist() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
//	@Test
//	public void isMyAccLinkExistTest() {
//		Assert.assertTrue(accPage.isMyAccounLinkExist);
//	}
	
	@Test
	public void accPageHeaderCountTest() {
		List<String> actAccHearderList= accPage.getAccountPageHeadersList();
		Assert.assertEquals(actAccHearderList.size(), 4);
	}
	public void accPageHeaderTest() {
		List<String> actAccHearderList= accPage.getAccountPageHeadersList();
		//how to create the list
		List<String> expAccHeadersList = Arrays.asList("My Account", "My Orders", "My Affiliated Account", "Newsletter");
		Assert.assertEquals(actAccHearderList, expAccHeadersList);
		
		//Assignment - both list sort then compare  - sort first //collections.sort()
	}
	
	
	

}
