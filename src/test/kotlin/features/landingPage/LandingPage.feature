@run-now
@landing-page
Feature: Test Main page

  Scenario: User wants to retrieve selenium test website
  Given I am a user who has retrieved the selenium test website
  And I can see the welcome toggle tab on the interactive board
  When I click on the Start Practising button
  Then I can see the Basic toggle tab section displayed
#  And checkbox 1 is shown as not selected
#  And checkbox 2 is shown as selected
#
#  Scenario: On checkboxes page, user wants to select checkbox 1
#  Given I am on the checkboxes page
#  When I click on checkbox 1
#  Then checkbox 1 is shown as selected
#
#  Scenario: On checkboxes page, user wants to un-select checkbox 2
#  Given I am on the checkboxes page
#  When I click on checkbox 2
#  Then checkbox 2 is shown as not selected