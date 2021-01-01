Feature:

Scenario Outline:
Given Open the Browser
When User Enter the Website URL 
And Click on the My Account Menu
And Enter "<Username>" in username textbox
And Now enter "<Password>" in the password textbox
When Click on login button.
Then Proper message must be displayed "Invalid username" or "Hello" and prompt to enter login again

Examples:
|        Username                  |  Password         |
|    siddhantvs311992@gmail.com    |  31Pushpavinod@   |
|      siddhantvs188@gmail.com     |  pushpavinod      |
|     siddhantvs311992@gmail.com   |                   |
|                                  |  31Pushpavinod@   |
|                                  |                   |