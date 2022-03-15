package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
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
	@Given("user verifies the {string} section heading")
	public void user_verifies_the_section_heading(String info) {
	 
	
		System.out.println(fp.getStoreInformationText());
		
		
		Assert.assertTrue(info.contains(fp.getStoreInformationText()));
		
		
	}
	@Then("check the total information is displaying")
	public void check_the_total_information_is_displaying() {
	
	
		
		Assert.assertEquals(true, fp.isgetStoreInformationDisplay());
	
	}
	


@Given("user checks the {string} links in the footer")
public void user_checks_the_links_in_the_footer(String linksHeading) {

	System.out.println(fp.getfollowUpLinkText());
	
	Assert.assertEquals(linksHeading, fp.getfollowUpLinkText());
	

}
@When("checks the each of the links")
public void checks_the_each_of_the_links() {

	fp.waitForVisibilityOfElement();
	
	System.out.println("waited");
	
	
	

}
@When("checks the links are broken or not")
public void checks_the_links_are_broken_or_not() {

boolean actual=fp.isFolloUsLinkBrokenOrNot();

Assert.assertTrue(actual);

}
@Then("user gets total followup links is {int}")
public void user_gets_total_followup_links_is(Integer count) {

int actualCount=fp.getCountFollowusLinks();

Assert.assertTrue(count==actualCount);

}


@Given("user check the all footer links broken or not")
public void user_check_the_all_footer_links_broken_or_not() {
 
	boolean actual=fp.isAllfooterLinksBrocken();

	Assert.assertTrue(actual);

	
}	
}
