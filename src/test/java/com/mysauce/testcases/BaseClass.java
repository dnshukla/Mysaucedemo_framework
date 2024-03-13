package com.mysauce.testcases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import com.mysauce.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	String url = readconfig.getBaseurl();
	String browser1 = readconfig.getBrowser1();
//	String browser2 = readconfig.getBrowser2();
//	String browser3 = readconfig.getBrowser3();

	public static WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
//	public void setup() 
//	    {
//		switch(browser1.toLowerCase())
//		{
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			break;
//		}
//			// Add more cases for other browsers
//        default:
//            throw new IllegalArgumentException("Unsupported browser: " + browser);
//		}
	@Parameters("browser")
	public void setup()
	{	
		if (browser1.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
//		} else if (browser2.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//		}else if (browser3.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//			driver.manage().window().maximize();
		} 
		else {
            throw new IllegalArgumentException("Invalid browser value provided");
		}
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.close();
		//driver.quit();
	}
}
