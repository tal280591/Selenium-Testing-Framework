Feature: Home page Search box  

Scenario Outline: Search for items by insert txt in search box
Given Navigated to "http://tennis-warehouse.com"
And Insert <item> into the search box field
When The user clicks on the serach button
Then Verify that the user moved to the <item> page


Examples:
|item|
|Wilson pro Staff|
|Nike shoes|
|Pure drive|

