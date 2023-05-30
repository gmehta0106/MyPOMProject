package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {
	WebDriver driver;
	// important to declare access modifier so we can read ref variable in our child
	// classes
	protected LoginPage loginPage;// within the package or outside the child class
	protected AccountsPage accPage;
	// every page class we need to maintain the protected references here in the
	// baseTest
	protected ResultsPage resultsPage;
	protected DriverFactory df;
	protected Properties prop;
	protected ProductInfoPage productInfoPage;
	protected RegisterPage registerPage;
	protected SoftAssert softAssert;

	@Parameters({ "browser" })

	@BeforeTest
	public void setup(String browserName) throws InterruptedException {
		// move this code to driver factory
		df = new DriverFactory();
		prop = df.initProp();
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}