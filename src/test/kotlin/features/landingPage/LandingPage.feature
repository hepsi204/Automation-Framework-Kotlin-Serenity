@landing-page
@run-now
Feature: Test Main page

  Scenario: User wants to retrieve selenium test website
    Given I am a user who has retrieved the selenium test website
    And I can see the welcome toggle tab on the interactive board
    When I click on the Start Practising button
    Then I can see the Basic toggle tab section displayed

  Scenario: User clicks on Basic Toggle tab and can see correct links displayed
    Given I am a user who has retrieved the selenium test website
    And I have opened the Basic tab section
    When I click on Simple Form Demo link within basic tab section
    Then I see the Simple Form Demo page


#  Scenario:
#    Given
#    When
#    Then

#  Scenario:
#    Given
#    When
#    Then