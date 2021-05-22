Feature: OrangeHRM website login functionality

Scenario: logging in to orangeHRM website
Given I open a chrome brawser
When I navigate to orangeHMR website
Then I see OrangeHMR landing page
When I enter username 
And I enter password
And I click on login button
Then I see orangeHRM main page
