package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pageObjects.LoginPage;
import com.qa.data.UserDataManager;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lu.ugeholl;

public class loginStepDefinition {

	private static String title;
	
	private ConfigReader configReader;
	Properties prop;
	
	
	private LoginPage lp=new LoginPage(DriverFactory.getDriver());
	
	
	
	
    @Given("^user is on login page$")
    public void user_is_on_login_page() throws Throwable {
    	
    	configReader=new ConfigReader();
    	prop=configReader.init_prop();
    
    	DriverFactory.getDriver().get(prop.getProperty("url"));

    }

    @When("^user is gets the title of the page$")
    public void user_is_gets_the_title_of_the_page() throws Throwable {

    	Thread.sleep(3000);

    	title=lp.getLoginPageTitle();
    	System.out.println("page title is : "+title);
    	
    	
    }

    @Then("^page title should be \"([^\"]*)\"$")
    public void page_title_should_be_something(String expectedTitleName) throws Throwable {
    	
    	
System.out.println("Actual**************:"+title);

System.out.println("Exp**************:"+expectedTitleName);
Assert.assertTrue(title.contains(expectedTitleName));
    	
    	

    }



    @Then("^forgot your password link should be displayed$")
    public void forgot_your_password_link_should_be_displayed() throws Throwable {

    	
    	
    	Assert.assertTrue(lp.isForgotPWdLinkExist(), "Forgot password not displying");
    	
    	
    	
    }
	
    
    @When("^user enters username \"([^\"]*)\"$")
    public void user_enters_username_something(String username) throws Throwable {
    
    lp.enterUsername(username);
    
    }
    
    @And("^user enters password \"([^\"]*)\"$")
    public void user_enters_password_something(String password) throws Throwable {

    	
    	lp.enterPw(password);
    }
    

    @And("^user clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {

    	lp.clickOnSignIn();
    	
    	Thread.sleep(5000);
    }
    

@Given("user logged in as a manager")
public void user_logged_in_as_a_manager() throws IOException {
 
	configReader=new ConfigReader();
	prop=configReader.init_prop();

	DriverFactory.getDriver().get(prop.getProperty("url"));


	lp.loginAsPM();
	
}
	

@Then("get the title of the page")
public void get_the_title_of_the_page() {

	
}


    
}
