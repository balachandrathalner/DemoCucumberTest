package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties prop;

	//This method is used to load the properties from config.properties file
	
	public Properties init_prop() throws IOException {
		
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream(Constants.getConfigFilePath());
		
		prop.load(fis);
		
		return prop;
		
		
	}

}
