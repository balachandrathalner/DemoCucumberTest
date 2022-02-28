package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;

	//This method is used to load the properties from config.properties file
	
	public Properties init_prop() throws IOException {
		
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\balachandra.4\\eclipse-workspace\\CucumberAutomation\\src\\test\\resources\\config\\config.properties");
		
		prop.load(fis);
		
		return prop;
		
		
	}

}
