package com.qa.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {

	private static boolean root=false;
	
	public static Logger getLogger(Class cls) {
		
		if(root) {
			
			return Logger.getLogger(cls);
			
		}
		
		
		PropertyConfigurator.configure(Constants.LOG4J_CONFIG_FILE_PATH);
		root=true;
		return Logger.getLogger(cls);
		
		
	}
	
	
}
