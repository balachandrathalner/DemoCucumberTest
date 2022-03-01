Feature: Footer section 


Background:
Given user is alreday on landing page


Scenario: to check login page title
Given user is on landing page 
When user is gets the title of the page
Then page title should be "Login - My Store"


Scenario: to check footer information section

Given user is on landing page
When user gets information section

|Specials|
|New products|
|Best sellers|
|Our stores|
|Contact us|
|Terms and conditions of use|
|About us|
|Sitemap|
				
Then information section should be 8 


Scenario: to check footer information section

Given user is on landing page
When user gets information section
|About us|
|Sitemap|
				
Then information section should be 8 

