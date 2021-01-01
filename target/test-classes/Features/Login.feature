Feature: Login

Background:
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on My Account Menu

@first
Scenario: Login with valid username and password
And Enter registered username in username textbox
And Enter password in password textbox
When Click on login button
Then User must successfully login to the web page

@second
Scenario: Login with incorrect username and password
And Enter incorrect "siddhantvs188@gmail" in username textbox
And Enter incorrect "31pushpa" in password textbox.
And Click on login button
Then Proper error must be display "Invalid username" and prompt to enter login again