package com.aws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aws.utilities.Driver;

public class LoginPage {
	public LoginPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id=\"password_input\"]")
	public WebElement password;

	@FindBy(id = "login_submit")
	public WebElement loginButton;

}