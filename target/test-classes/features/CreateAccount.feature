Feature: Create new user account

Background:

Given user is allready on landing page
When user enters email address lenth of 5 to create an account
And click on create an account button
Then it should be navigates to "YOUR PERSONAL INFORMATION" page


Scenario Outline: Fill the Invalid personal information form

Given user fills the invalid personal information from the given sheetname "<sheetName>" and rownumber <rowNumber>
When user clicked on Register button
Then getting error message

Examples:
|sheetName | rowNumber |
|InvalidPersonalInfo |0|
|InvalidPersonalInfo |1|



Scenario Outline: Fill the valid personal information form

Given user fills the valid personal information from the given  given sheetname "<Valid>" and rownumber <rowNumber>
When user clicked on Register button
Then getting Home page with contains "MY ACCOUNT"

Examples:
|Valid | rowNumber |
|ValidPersonalInfo |0|
