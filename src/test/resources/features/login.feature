Feature: Login page feature

@skip_scenario
Scenario: Login page title

Given user is on login page
When user is gets the title of the page
Then page title should be "Login - My Store"


Scenario: Forgot password link

Given user is on login page
Then forgot your password link should be displayed

@sanity @skip 
Scenario Outline: Login with correct credentials
Given user is on login page
When user enters username "<UserName>"
And user enters password "<password>"
And user clicks on login button
Then user is gets the title of the page
And page title should be "My account - My Store"

Examples:

|UserName|password|
|balachandra.thalner@gmail.com|balachandra|

