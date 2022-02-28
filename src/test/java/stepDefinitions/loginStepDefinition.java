package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pageObjects.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinition {

	private static String title;
	
	private LoginPage lp=new LoginPage(DriverFactory.getDriver());
	

    @Given("^user is on login page$")
    public void user_is_on_login_page() throws Throwable {
    	
    	DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }

    @When("^user is gets the title of the page$")
    public void user_is_gets_the_title_of_the_page() throws Throwable {


    	title=lp.getLoginPageTitle();
    	System.out.println("page title is : "+title);
    	
    	
    }

    @Then("^page title should be \"([^\"]*)\"$")
    public void page_title_should_be_something(String expectedTitleName) throws Throwable {
    	
    	

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


    
}
