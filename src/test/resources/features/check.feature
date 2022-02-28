Feature: check data Tables

Scenario Outline:: To check login

Given user is on landing page
When user click on sign in button
When user given username <Username> and password <Password>
When click on submit button
Then navigates to home page

Examples:

|Username|Password|
|balu@gmail.com|balu|
|manu@gmail.com|Manu|



@sanity
Scenario: To check dataTables
Given user on form page
When need to send data to form from below table

|jayalaxmi|talaner|83793987|India|
|sadhashiva|hulegar|87276763|sagara|
|suvatte|kandika|56249200|hamsagaru|
|pannaga|puutur|828999|mangalore|


Then user able to submit the form

#@smoke
Scenario: To check dataTables
Given user on form page
When need to send data to form from below tables
|Name|city|number|country|
|jayalaxmi|talaner|83793987|India|
|sadhashiva|hulegar|87276763|sagara|
|suvatte|kandika|56249200|hamsagaru|
|pannaga|puutur|828999|mangalore|


Then user able to submit the form


