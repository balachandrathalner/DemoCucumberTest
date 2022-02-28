package stepDefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkStep {

	@Given("user is on landing page")
	public void user_is_on_landing_page() {
	 
	}
	@When("user click on sign in button")
	public void user_click_on_sign_in_button() {
	
		
	}
	 @When("^user given username (.+) and password (.+)$")
	    public void user_given_username_and_password(String username, String password) throws Throwable {
	    
		 
		 System.out.println("Username :"+username);
			System.out.println("Password :"+password);
			
	    
		
	}
	@When("click on submit button")
	public void click_on_submit_button() {
	    
	}
	@Then("navigates to home page")
	public void navigates_to_home_page() {
	    
	}


	@Given("user on form page")
	public void user_on_form_page() {
	    // Write code here that turns the phrase above into concrete actions
	   
		
		
	}
	@When("need to send data to form from below table")
	public void need_to_send_data_to_form_from_below_table(DataTable dataTable) {
	    
		
		List<List<String>> userList=dataTable.asLists();
		
		System.out.println(userList);
		
		for(List<String> s:userList) {
			
			System.out.println(s);
			
			
		}
		
		
		System.out.println("**** :"+userList.get(2).get(1));
		
		
	}

	
	 @Then("^user able to submit the form$")
	    public void user_able_to_submit_the_form() throws Throwable {
	     
		 
		 
	    }
	

    @When("^need to send data to form from below tables$")
    public void need_to_send_data_to_form_from_below_tables(DataTable table) throws Throwable {
    
    
    	
    	List<Map<String,String>>userMap=table.asMaps();
    	
    	
    	System.out.println("Size  :"+userMap.size());
    	
    	
    	for(int i=0;i<=userMap.size()-1;i++) {
    	System.out.println(userMap.get(i).get("Name"));

    	System.out.println(userMap.get(i).get("city"));
    	

    	System.out.println(userMap.get(i).get("number"));

    	System.out.println(userMap.get(i).get("country"));
    	
    	System.out.println("=========================================");
    
    	}
    	
    }

   


}
