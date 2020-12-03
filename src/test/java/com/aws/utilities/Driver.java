package com.aws.utilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private Driver() {
		
	}
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null) {
			switch(ConfigurationReader.getProperty("browser")) {
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile ffProfile = profile.getProfile("myProfile");
				ffProfile.setAcceptUntrustedCertificates(true);
				ffProfile.setAssumeUntrustedCertificateIssuer(false);
				driver = new FirefoxDriver((Capabilities) ffProfile);
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			}	
		}
		return driver;
	}
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
