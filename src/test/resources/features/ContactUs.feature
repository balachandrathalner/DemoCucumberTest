Feature: contact Us feature

Scenario Outline: contact scenario with different sets of data

Given user navigates to contact us page
When user fills the form from given sheetname "<Sheetname>" and rowNumber <RowNumber>
And clicks on send button
Then it shows successful message "Your message has been successfully sent to our team."

Examples:

|Sheetname |RowNumber|
|contactUs |0|
|contactUs |1|

