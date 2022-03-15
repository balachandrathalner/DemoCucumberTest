package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pageObjects.ContactUsPage;
import com.pageObjects.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Constants;
import com.qa.util.ExcelReader;
import com.qa.util.LoggerHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContactUsStep {

	
	
	Logger log=LoggerHelper.getLogger(ContactUsStep.class);
	
	 LoginPage lp=new LoginPage(DriverFactory.getDriver());

	ContactUsPage cp=new ContactUsPage(DriverFactory.getDriver());
	
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
	
	log.info("*********Browser Launched******************");	
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		log.error("click on contact us");
		lp.getContactUs();
		
		
	}

	@When("user fills the form from given sheetname {string} and rowNumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_row_number(String sheetName, Integer rowNo) throws InvalidFormatException, IOException, InterruptedException {

		ExcelReader reader=new ExcelReader();
		
		List<Map<String,String>>testData=reader.getData(Constants.TEST_DATA_FILE_PATH, sheetName);
	
		
		String subHeading=testData.get(rowNo).get("subjectheading");
		String email=testData.get(rowNo).get("email");
		String orderref=testData.get(rowNo).get("orderref");
		String message=testData.get(rowNo).get("message");
		
	
		log.info("sending values to contactus fields");
		
		cp.getValues(subHeading, email, orderref, message);
		
		
	}


	@When("clicks on send button")
	public void clicks_on_send_button() {
	    
		cp.clickSendmessage();

	}
	@Then("it shows successful message {string}")
	public void it_shows_successful_message(String expected) {
	    // Write code here that turns the phrase above into concrete actions
		
		String actualsuccessmsg=cp.getSuccessMsg();
		System.out.println("actualsuccessmsg :"+actualsuccessmsg);
		
		Assert.assertEquals(expected, actualsuccessmsg);
		
	}


}
