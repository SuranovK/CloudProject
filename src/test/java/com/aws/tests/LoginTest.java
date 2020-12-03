package com.aws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aws.utilities.BrowserUtility;
import com.aws.utilities.ConfigurationReader;

public class LoginTest extends TestBase {
	@Test
	public void positiveLoginTest() {

		driver.get(ConfigurationReader.getProperty("url"));
		driver.findElement(By.id("password_input")).sendKeys(ConfigurationReader.getProperty("password"));
		driver.findElement(By.id("login_submit")).click();
		BrowserUtility.waitFor(10);
		WebElement enableButton = driver.findElement(By.id("enableTls10Button"));
		if (enableButton.isEnabled())
			enableButton.click();

	}

}
