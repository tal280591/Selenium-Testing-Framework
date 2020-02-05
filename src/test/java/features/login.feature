Feature: Application Login

Scenario Outline: Home page default login
Given Initialized the browser
And Navigate to "http://tennis-warehouse.com"
And In home page click on the login button
When The user enters <username> and <password>
Then Verify that user is successfully logged in


Examples:
|username                   |password     |
|someuser@gmail.com       	|user123      |
|anotheruser@gmail.com    	|another123   |
