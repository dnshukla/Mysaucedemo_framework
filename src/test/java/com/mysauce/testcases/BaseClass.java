package com.mysauce.testcases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import com.mysauce.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	String url = readconfig.getBaseurl();
	String browser = readconfig.getBrowser();

	public static WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setup() {
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
		}
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.close();
		//driver.quit();
	}
}
