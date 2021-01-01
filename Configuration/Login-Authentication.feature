Feature:

Scenario:
Given Open_the browser
When Enter the website URL 
And  Click on My Account Menu
And Enter the case changed username in username textbox
And Enter the case chenged password in the password tetxbox
When click on login button
Then  your are logged in, sign out of the site
When press back button
Then User shouldn’t be signed in to his account rather a general webpage must be visible