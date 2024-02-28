package com.mysauce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	//create object of web driver
	WebDriver ldriver;
	
	//create constructor
	public InventoryPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//identify the web elements
	@FindBy(id = "react-burger-menu-btn")WebElement burgermenubutton;
	@FindBy(id = "inventory_sidebar_link")WebElement allitems;
	@FindBy(id = "about_sidebar_link")WebElement about;
	@FindBy(id = "logout_sidebar_link")WebElement logout;
	@FindBy(className = "app_logo") private WebElement yourClassElement;
	
	//identify action on the web elements
	public void clickburgermenubutton() {
		burgermenubutton.click();
	}
	public void clickallitems() {
		allitems.click();
	}
	public void clickabout() {
		about.click();
	}
	public void clicklogout() {
		logout.click();
	}
	public boolean isClassElementDisplayed() {
        return yourClassElement.isDisplayed();
    }
}
