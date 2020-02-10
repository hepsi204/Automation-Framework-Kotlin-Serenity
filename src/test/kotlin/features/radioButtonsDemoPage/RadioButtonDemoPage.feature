@radio-buttons-demo-page
Feature: Test Radio Buttons Demo Page

  @run-now
  Scenario: User clicks on Radio Button Demo Link within Basic tab section and is directed to the page
    Given I am a user who has retrieved the selenium test website
    And I have opened the Basic tab section on the Landing page
    When I click on Radio Buttons Demo link within basic tab section
    Then I see the Radio Buttons Demo page loaded