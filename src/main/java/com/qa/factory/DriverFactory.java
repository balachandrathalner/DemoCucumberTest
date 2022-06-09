package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {

	//public static WebDriver driver;
	
	
	public static ThreadLocal<WebDriver> tlDriver =new ThreadLocal<>();
	
	@SuppressWarnings("deprecation")
	public WebDriver initilizeDriver(String browserName) {
		
	
		System.out.println("browser value is : "+browserName );
		
		if(browserName.contains("chrome")) {
			

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\balachandra.4\\OneDrive - Coforge Limited\\Desktop\\Softwares\\Chromedriver\\Chromedriver.exe");
			
			//driver=new ChromeDriver();
			
			
			//WebDriverManager.chromedriver().setup();
			
			ChromeOptions options=new ChromeOptions();
			
			if(browserName.contains("headless")) {
				
				options.addArguments("headless");
				
			}
			
			tlDriver.set(new ChromeDriver(options));
			
			
		}
		
		else if(browserName.equals("firefox")) {
		
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\balachandra.4\\eclipse-workspace\\CucumberAutomation\\src\\test\\resources\\geckodriver.exe");
	
			tlDriver.set(new FirefoxDriver());
		
		} 
		

		else if(browserName.equals("safari")) {
			
			tlDriver.set(new SafariDriver());
			
		} 
		
else if(browserName.equals("edge")) {
			

			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			
		} 

		else {
			System.out.println("Please pass correct browser value : "+browserName);
		}
			
	
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();
			
	}
	
	
	public static synchronized WebDriver getDriver() {
		
		
		return tlDriver.get();
	}
	
}
