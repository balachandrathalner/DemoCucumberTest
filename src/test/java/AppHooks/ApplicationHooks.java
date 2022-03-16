package AppHooks;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	
	private WebDriver driver;
	
	private ConfigReader configReader;
	Properties prop;
	
	@Before(value="@skip_scenario",order=0)
	public void skip_scenario(Scenario scenario) {
		
		System.out.println("SKIPED SCENARIO is :"+scenario.getName());
		Assume.assumeTrue(false);
		//Assert.assertTrue(false);
	}
	
	
	
	@Before(order=1)
	public void getProperty() throws IOException {
		
		configReader=new ConfigReader();
		
		prop=configReader.init_prop();
		
		
	}
	
	@Before(order = 2)
	
	public void launchBrowser() {
		
		String browserName_prop=prop.getProperty("browser");
		
		String browserName_maven =System.getProperty("browser");
		
		String browserName= browserName_maven !=null ? browserName_maven : browserName_prop;
		
		driverFactory=new DriverFactory();
		driver=driverFactory.initilizeDriver(browserName);
		
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			//take screenshot
			
			
			String screenshotName=scenario.getName().replaceAll(" ", "-");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			
		}
	}
	

}
