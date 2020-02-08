@landing-page
Feature: Test Main page

  Scenario: User wants to retrieve selenium test website
    Given I am a user who has retrieved the selenium test website
    And I can see the welcome toggle tab on the interactive board
    When I click on the Start Practising button on the Landing page
    Then I can see the Basic toggle tab section displayed on the Landing page