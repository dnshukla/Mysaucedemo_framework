package com.mysauce.utilities;
import java.util.Properties;
import java.io.FileInputStream;

public class ReadConfig {
	
	Properties properties;
	String path = "C:\\Users\\DeLL\\MysaucedemoV1\\Configuration\\config.properties";
	
	public ReadConfig() {
		try {
		properties = new Properties();
		
		FileInputStream fir = new FileInputStream(path);
		properties.load(fir);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getBaseurl() {
		String value = properties.getProperty("baseUrl");
		
		if(value!=null) 
			return value;
		else 
			throw new RuntimeException("URL is not specified in config file.");	
	}
	public String getBrowser() {
		String value = properties.getProperty("browser");
		
		if(value!=null) 
			return value;
		else 
			throw new RuntimeException("Browser is not specified in config file.");	
	}
	
}
