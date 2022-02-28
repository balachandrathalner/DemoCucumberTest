package com.qa.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {

	private static boolean root=false;
	
	public static Logger getLogger(Class cls) {
		
		if(root) {
			
			return Logger.getLogger(cls);
			
		}
		
		
		PropertyConfigurator.configure("C:\\Users\\balachandra.4\\eclipse-workspace\\CucumberAutomation\\src\\test\\resources\\log4j.properties");
		root=true;
		return Logger.getLogger(cls);

		
	}
	
	
}
