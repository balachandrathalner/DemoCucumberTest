package stepDefinitions;


import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pageObjects.AccountsPage;
import com.pageObjects.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPagstepDefinition {
	
	
	private LoginPage lp=new LoginPage(DriverFactory.getDriver());
	
	private AccountsPage ap;
	
	
	
	

	@Given("user already logged into application")
	public void user_already_logged_into_application(DataTable dataTable) throws InterruptedException {
	    
		
		List<Map<String, String>>credList=dataTable.asMaps();
		
		
		String userName=credList.get(0).get("username");
		String pw=credList.get(0).get("password");
		
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		ap=lp.doLogin(userName, pw);
		
		
	
		
		
		Thread.sleep(4000);
		
		
		
		
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	    
		String title=ap.getAccoutsPageTitle();
		System.out.println("Account page itle: "+title);
	}

	@Then("user gets Account section")
	public void user_gets_account_section(DataTable sectionsTable) {
	    
		List<String> expAccountsectionList=sectionsTable.asList();
		
		System.out.println("Expected account section List :"+expAccountsectionList);
		
		List<String>actualAccountsectionList=ap.getAccountsSectionsList();
		
		
		for(String s:actualAccountsectionList) {
			System.out.println("***** : "+s);
		}
		
		System.out.println("actual account section List :"+actualAccountsectionList);
		
		
		Assert.assertTrue(expAccountsectionList.containsAll(actualAccountsectionList));
				
		
	}

	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionnCount) {
	   	
	Assert.assertTrue(ap.getAccountSectionsCount()==expectedSectionnCount);
	}

	
}
