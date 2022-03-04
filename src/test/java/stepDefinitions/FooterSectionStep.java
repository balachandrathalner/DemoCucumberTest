package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import com.pageObjects.FooterSectionPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FooterSectionStep {

	FooterSectionPage fp=new FooterSectionPage(DriverFactory.getDriver());
	
	@Given("user is alreday on landing page")
	public void user_is_alreday_on_landing_page() {
	
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		
		
	}
	@When("user gets information section")
	public void user_gets_information_section(DataTable dataTable) {

		List<String>expectedList=dataTable.asList();
		List<String>actualList=fp.getActualInformationSectionList();
		
		Assert.assertTrue(expectedList.containsAll(actualList));
		
	
	}
	@Then("information section should be {int}")
	public void information_section_should_be(Integer expectedCount) {
	
		Assert.assertTrue(fp.getInformationSectionCount()==expectedCount);
		
	}
	
	@When("user gets my accoun section")
	public void user_gets_my_accoun_section(DataTable dataTable) {

		
		List<String> expectedList=dataTable.asList();
		
		List<String> actualList=fp.getActualMyAccountSectionList();
		
		

		Assert.assertTrue(expectedList.containsAll(actualList));
		
	
	}


	@Then("myaccount section should be {int}")
	public void myaccount_section_should_be(Integer expectedCount) {
	
		Assert.assertTrue(fp.getMyAccountSectionCount()==expectedCount);
		
	}
	
	
}
