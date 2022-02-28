Feature: Account page feature

Background:
Given user already logged into application
|username |password|
|balachandra.thalner@gmail.com|balachandra|

Scenario: Accounts page title
Given user is on Accounts page
When user is gets the title of the page
Then page title should be "My account - My Store"

@smoke
Scenario: Account section count
Given user is on Accounts page
Then user gets Account section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|

And Accounts section count should be 6