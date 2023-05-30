package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {//Class for headless mode
	/*
	 * The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. 
	 * Each key and its corresponding value in   the property list is a string. 
	 */
	/*
	 * ChromeOptions options = new ChromeOptions()
 options.addExtensions(new File("/path/to/extension.crx"))
 options.setBinary(new File("/path/to/chrome"));

 // For use with ChromeDriver:
 ChromeDriver driver = new ChromeDriver(options);

 // For use with RemoteWebDriver:
 RemoteWebDriver driver = new RemoteWebDriver(
     new URL("http://localhost:4444/"),
     new ChromeOptions());
 
	 */
	/*
	 * Manage firefox specific settings in a way that geckodriver can understand.
	 */
	private Properties prop; // create private variable of Properties class 
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	public OptionsManager(Properties prop) {//constructor of class to use prop variable 
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co= new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
		co.addArguments("--incognito");
		}
//		co.addArguments("--window-size=1920,1080");
//		co.addArguments("--no-sandbox");
//		co.addArguments("--disable-gpu");
//		co.addArguments("--disable-crash-reporter");
//		co.addArguments("--disable-extensions");
//		co.addArguments("--disable-in-process-stack-traces");
//		co.addArguments("--disable-logging");
//		co.addArguments("--disable-dev-shm-usage");
//		co.addArguments("--log-level=3");
//		co.addArguments("--output=/dev/null");
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo= new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			fo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
		fo.addArguments("--incognito");
		}
		return fo;
	}
	public EdgeOptions getEdgeOptions() {
		eo= new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			eo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
		fo.addArguments("--incognito");
		}
		return eo;
	}
	}
