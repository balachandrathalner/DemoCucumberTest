package testRunners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
features={"src\\test\\resources\\features\\login.feature"},glue = {"stepDefinitions","AppHooks"},
		
		monochrome = true,dryRun = false,
		//tags = "not @skip",
				plugin = { "pretty",
		                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		                
		                "rerun:target/failed_scenarios.txt",
		        }
		
	
		
		 
		)

public class TestNgTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	
	public Object[][] scenarios(){
		return super.scenarios();
		
	 }
	
	
	
}
