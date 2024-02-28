package com.mysauce.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import com.mysauce.pageobject.InventoryPage;
import com.mysauce.pageobject.loginPage;


public class TClogin extends BaseClass{
	
	@Test(priority = 1)
	public void verifyvalidlogintest() {
		
		//Open url
		driver.get(url);
		
		//Login with valid credentials
		loginPage lp = new loginPage(driver);
		lp.enteruname("standard_user");
		lp.enterpassword("secret_sauce");
		lp.clickloginbutton();
		
		//Add assertion to confirm the login and Logout from the account.
		InventoryPage Ip1 = new InventoryPage(driver);
		
		Assert.assertTrue(Ip1.isClassElementDisplayed(),"Login not successful as expected.");
		
		//Logout from the account
		Ip1.clickburgermenubutton();
		Ip1.clicklogout();
		
	}
	
	@Test(priority = 2)
    public void verifylockedoutusertest() {
		
		//Open url
		driver.get(url);
			
		//Login with locked out user credentials
		loginPage lp = new loginPage(driver);
		lp.enteruname("locked_out_user");
		lp.enterpassword("secret_sauce");
		lp.clickloginbutton();
		
		//Add assertion to confirm the locked out user validation message.
		// Capture the validation message
        WebElement errorMessage = driver.findElement(By.xpath("(//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')])[1]"));
        String actualErrorMessage = errorMessage.getText();

        // Assert the validation message
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Validation message doesn't match.");
	}
	
	@Test(priority = 3)
    public void verifyinvalidcredentailtest() {
		
		//Open url
		driver.get(url);
			
		//Login with invalid user credentials
		loginPage lp = new loginPage(driver);
		lp.enteruname("ABC");
		lp.enterpassword("Test_123");
		lp.clickloginbutton();
		
		//Add assertion to confirm the Error validation message.
		// Capture the validation message
        WebElement errorMessage = driver.findElement(By.xpath("(//h3[contains(text(),'Epic sadface: Username and password do not match a')])[1]"));
        String actualErrorMessage = errorMessage.getText();

        // Assert the validation message
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Validation message doesn't match.");
	}
	
	@Test(priority = 4)
    public void verifyusernamerequiredtest() {
		
		//Open url
		driver.get(url);
			
		//Verify the user name required field validation
		loginPage lp = new loginPage(driver);
		lp.clickloginbutton();
		
		//Add assertion to confirm the user name required validation message.
		// Capture the validation message
        WebElement errorMessage = driver.findElement(By.xpath("(//h3[normalize-space()='Epic sadface: Username is required'])[1]"));
        String actualErrorMessage = errorMessage.getText();

        // Assert the validation message
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Validation message doesn't match.");
	}
	
	@Test(priority = 5)
    public void verifypasswordrequiredtest() {
		
		//Open url
		driver.get(url);
			
		//Verify the password required field validation
		loginPage lp = new loginPage(driver);
		lp.enteruname("standard_user");
		lp.clickloginbutton();
		
		//Add assertion to confirm the password required validation message.
		// Capture the validation message
        WebElement errorMessage = driver.findElement(By.xpath("(//h3[normalize-space()='Epic sadface: Password is required'])[1]"));
        String actualErrorMessage = errorMessage.getText();

        // Assert the validation message
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Validation message doesn't match.");
	}
	 
}
