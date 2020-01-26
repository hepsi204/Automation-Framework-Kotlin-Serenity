@run-now
Feature: Test the-internet

  Scenario: User wants to retrieve the-internet website for testing checkboxes
  Given I am a user who has retrieved the-internet website
  When I click on the Checkboxes link on the landing page
  Then I see the checkboxes page
  And checkbox 1 is shown as not selected
  And checkbox 2 is shown as selected

  Scenario: On checkboxes page, user wants to select checkbox 1
  Given I am on the checkboxes page
  When I click on checkbox 1
  Then checkbox 1 is shown as selected

  Scenario: On checkboxes page, user wants to un-select checkbox 2
  Given I am on the checkboxes page
  When I click on checkbox 2
  Then checkbox 2 is shown as not selected