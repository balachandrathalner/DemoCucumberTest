package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\test\\resources\\features\\ContactUs.feature"},glue = {"stepDefinitions", "AppHooks"},
		
		stepNotifications = true,monochrome = true,dryRun = true,
		
		plugin = { "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                
                "rerun:target/failed_scenarios.txt"
              
        }
	
		 
		)

public class MyTestRunner  {
	
	
	
}
