@run-now
Feature: Test the-internet

  Scenario: User wants to retrieve the-internet website for testing checkboxes
  Given I am a user who has retrieved the-internet website
  When I click on the Checkboxes link on the landing page
  Then I see the checkboxes page
  And I see checkbox 1 not selected on the page
  And I see checkbox 2 is selected on the page


