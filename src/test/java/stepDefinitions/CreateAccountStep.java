package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pageObjects.AccountsPage;
import com.pageObjects.CreateAccountPage;
import com.pageObjects.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.Constants;
import com.qa.util.CreateRandomString;
import com.qa.util.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateAccountStep {

	
	private ConfigReader configReader;
	Properties prop;
	
	LoginPage lp=new LoginPage(DriverFactory.getDriver());
	
	CreateAccountPage cp;
	
	ExcelReader reader=new ExcelReader();
	
	AccountsPage ap=new AccountsPage(DriverFactory.getDriver());
	
	@Given("user is allready on landing page")
	public void user_is_allready_on_landing_page() throws IOException {

    	configReader=new ConfigReader();
    	prop=configReader.init_prop();
    
    	DriverFactory.getDriver().get(prop.getProperty("url"));

		
		
	
	}
	@When("user enters email address lenth of {int} to create an account")
	public void user_enters_email_address_lenth_of_to_create_an_account(Integer emailLenth) {
		
		CreateRandomString stg=new CreateRandomString();
		
		String emailId=stg.getAlphaNumericString(emailLenth)+"@gmail.com";
		lp.sendCreateAccountEmailId(emailId);
		
		System.out.println("Email ID is :"+emailId);
		
		
	}
	@When("click on create an account button")
	public void click_on_create_an_account_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	
		cp=lp.clickSubmitCreateAccountButton();
		Thread.sleep(7000);
	}
	
	@Then("it should be navigates to {string} page")
	public void it_should_be_navigates_to_page(String pageSubHeading) {
	
		Assert.assertEquals(cp.getPageSubTitle(),pageSubHeading);
		
		
	
	}
	
	@Given("user fills the invalid personal information from the given sheetname {string} and rownumber {int}")
	public void user_fills_the_invalid_personal_information_from_the_given_sheetname_and_rownumber(String sheetName, Integer rowNum) throws InvalidFormatException, IOException, InterruptedException {
	   
		
		List<Map<String,String>>testData=reader.getData(Constants.TEST_DATA_FILE_PATH, sheetName);
		
		String firstName=testData.get(rowNum).get("FirstName");
		String lastName=testData.get(rowNum).get("LastName");
		String Password=testData.get(rowNum).get("Password");
		String Date=testData.get(rowNum).get("Date");
		String Month=testData.get(rowNum).get("Month");
		String Year=testData.get(rowNum).get("Year");
		String Company=testData.get(rowNum).get("Company");
		String Address=testData.get(rowNum).get("Address");
		String Address2=testData.get(rowNum).get("Address2");
		String City=testData.get(rowNum).get("City");
		String State=testData.get(rowNum).get("State");
		String Zip=testData.get(rowNum).get("Zip");
		String Country=testData.get(rowNum).get("Country");
		String Additionallinfo=testData.get(rowNum).get("Additionallinfo");
		String Homephone=testData.get(rowNum).get("Homephone");
		String Mobilephone=testData.get(rowNum).get("Mobilephone");
		String alias=testData.get(rowNum).get("alias");
		
		cp.sendPersonalInformations(firstName, lastName, Password, Date, Month, Year, Company, Address, Address2, City, State, Zip, Country, Additionallinfo, Homephone, Mobilephone, alias);
	
		Thread.sleep(10000);
		
	}

	
	/*
	
	@Given("user fills the invalid personal information from the given info")
	public void user_fills_the_invalid_personal_information_from_the_given_sheetname_and_row_number_row_number(DataTable dataTable) throws InvalidFormatException, IOException {

		List<Map<String, String>>credList=dataTable.asMaps();
		
		String sheetname=credList.get(0).get("sheetName");
		
		int rowNo= Integer.parseInt(credList.get(0).get("rowNumber"))  ;
		
		System.out.println("Sheet name is ***:"+sheetname);
		ExcelReader reader=new ExcelReader();
		
		List<Map<String,String>>testData=reader.getData("C:\\Users\\balachandra.4\\OneDrive - Coforge Limited\\Desktop\\automatonData.xlsx", sheetname);
		
		String firstname=testData.get(rowNo).get("FirstName");
		System.out.println("====================firstname :"+firstname);
	
		Note: It is not usefull.becoze need to create loop to retrive second row.
		
	}
	*/
	
	@When("user clicked on Register button")
	public void user_clicked_on_register_button() throws InterruptedException {
	 
		cp.clickRegisterButton();
		
		Thread.sleep(6000);
		
	}
	@Then("getting error message")
	public void getting_error_message() {
	  
		
		boolean msg=cp.isErrorMsgDisplay();
		
		Assert.assertTrue(msg);
		
		String error=cp.getErrorMsg();
		
		System.out.println("Error message is :"+error);
		
		
		
	}
	@Given("user fills the valid personal information from the given  given sheetname {string} and rownumber {int}")
	public void user_fills_the_valid_personal_information_from_the_given_given_sheetname_and_rownumber(String sheetName, Integer rowNum) throws InvalidFormatException, IOException, InterruptedException {
	   
		List<Map<String,String>>testData=reader.getData(Constants.TEST_DATA_FILE_PATH, sheetName);
	

		String firstName=testData.get(rowNum).get("FirstName");
		String lastName=testData.get(rowNum).get("LastName");
		String Password=testData.get(rowNum).get("Password");
		String Date=testData.get(rowNum).get("Date");
		String Month=testData.get(rowNum).get("Month");
		String Year=testData.get(rowNum).get("Year");
		String Company=testData.get(rowNum).get("Company");
		String Address=testData.get(rowNum).get("Address");
		String Address2=testData.get(rowNum).get("Address2");
		String City=testData.get(rowNum).get("City");
		String State=testData.get(rowNum).get("State");
		String Zip=testData.get(rowNum).get("Zip");
		String Country=testData.get(rowNum).get("Country");
		String Additionallinfo=testData.get(rowNum).get("Additionallinfo");
		String Homephone=testData.get(rowNum).get("Homephone");
		String Mobilephone=testData.get(rowNum).get("Mobilephone");
		String alias=testData.get(rowNum).get("alias");
		
		cp.sendPersonalInformations(firstName, lastName, Password, Date, Month, Year, Company, Address, Address2, City, State, Zip, Country, Additionallinfo, Homephone, Mobilephone, alias);
	
	
		Thread.sleep(5000);
		
		
	}

	@Then("getting Home page with contains {string}")
	public void getting_home_page_with_contains(String expected) {

		String AccountpageHeading=ap.getAccountpageHeading();
		System.out.println("Account page Heading is :"+AccountpageHeading);
		
		Assert.assertEquals(AccountpageHeading, expected);
		
}

	
}
