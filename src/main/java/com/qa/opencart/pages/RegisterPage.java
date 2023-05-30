package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
private WebDriver driver;
private ElementUtil eleutl;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleutl = new ElementUtil(driver);  
	}
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[2]/input");
	private By userRegSuccMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public String registerUser(String firstName, String lastName, 
			String email, String telephone, String password, String subscribe) {
		
		eleutl.waitForElementVisible(this.firstName, 10);
		eleutl.doSendKeys(this.firstName, firstName);
		eleutl.doSendKeys(this.lastName, lastName);
		eleutl.doSendKeys(this.email, email);
		eleutl.doSendKeys(this.telephone, telephone);
		eleutl.doSendKeys(this.password, password);
		eleutl.doSendKeys(this.confirmpassword, password);

		doSubscribe(subscribe);
			
		eleutl.doClick(agreeCheckBox);
		eleutl.doClick(continueButton);
		
		String userRegSuccessMesg = 
				eleutl.waitForElementVisible(userRegSuccMessg, 10).getText();
		System.out.println(userRegSuccessMesg);
		
		
		eleutl.doClick(logoutLink);
		eleutl.doClick(registerLink);

		
		return userRegSuccessMesg;
	}
	
	private void doSubscribe(String subscribe) {
		if(subscribe.equalsIgnoreCase("yes")) {
			eleutl.doClick(subscribeYes);
		}
		else {
			eleutl.doClick(subscribeNo);
		}
	}

}
