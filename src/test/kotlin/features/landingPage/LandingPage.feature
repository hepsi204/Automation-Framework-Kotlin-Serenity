@landing-page
Feature: Test Main page

  Scenario: User wants to retrieve selenium test website
    Given I am a user who has retrieved the selenium test website
    And I can see the welcome toggle tab on the interactive board
    When I click on the Start Practising button on the landing page
    Then I can see the Basic toggle tab section displayed

  Scenario: User clicks on Basic Toggle tab and can see correct links displayed
    Given I am a user who has retrieved the selenium test website
    And I have opened the Basic tab section
    When I click on Simple Form Demo link within basic tab section
    Then I see the Simple Form Demo page loaded

  @run-now
  Scenario: User wants to validate that the message entered in single input field matches text displayed
    Given I have retrieved Simple Form Demo page
    And I see the Simple Form Demo page loaded
    When I type into the Enter message text box
    And I click on the Show Message button on the Simple Form Demo page
    Then I can see the text entered displayed next to 'Your Message' label

#  Scenario:
#    Given
#    When
#    Then