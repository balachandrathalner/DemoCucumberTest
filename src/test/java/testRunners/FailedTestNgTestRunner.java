package testRunners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features={"@target\\failed_scenarios.txt"},glue = {"stepParallel"},
		//tags = 
		monochrome = true,dryRun = false,
		
				plugin = { "pretty",
		                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		              
		        }
		
		 
		)

public class FailedTestNgTestRunner extends AbstractTestNGCucumberTests {
	
//	@Override
//	@DataProvider(parallel=true)
//	
//	public Object[][] scenarios(){
//		return super.scenarios();
//		
//	}
	
	
	
}
