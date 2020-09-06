Feature: Test login functionality
  

Scenario Outline: Check login is successful with valid credentials
   
    
Given browser is open 
And user is on login page
When Dismiss the Cookie dialogs
When clicks on login button
When user enter <username> and <password>
Then user is navigated to the home page
   
   
   Examples:
    |username                 |password|
    |sandygarrepally@gmail.com|SANTHOSH2404!!s|
    |deepu.it1712@gmail.com   |698ALum(Orts(  |
