package com.mysauce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	//create object of web driver
	WebDriver ldriver;
	
	//create constructor
	public loginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//identify the web elements
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginbutton;
	
	//identify action on the web elements
	public void enteruname(String uname) {
		username.sendKeys(uname);
	}
	public void enterpassword(String pword) {
		password.sendKeys(pword);
	}
	public void clickloginbutton() {
		loginbutton.click();
	}

}
