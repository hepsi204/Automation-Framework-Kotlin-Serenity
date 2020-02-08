@simple-form-demo-page
Feature: Test Simple Form Demo Page

  Scenario: User clicks on Simple Form Demo Link within Basic tab section and is directed to the page
    Given I am a user who has retrieved the selenium test website
    And I have opened the Basic tab section on the Landing page
    When I click on Simple Form Demo link within basic tab section
    Then I see the Simple Form Demo page loaded

  Scenario: User wants to validate that the message entered in single input field matches text displayed
    Given I am on the Simple Form Demo page
    And I see the Simple Form Demo page loaded
    When I type TEST into the Enter message text box on Simple Form Demo page
    And I click on the Show Message button on the Simple Form Demo page
    Then I can see the text entered displayed next to 'Your Message' label on Simple Form Demo page

  Scenario Outline: User wants to validate that the message entered in two input fields match the text displayed
    Given I am on the Simple Form Demo page
    And I see the Simple Form Demo page loaded
    When I type <TextForFieldA> into the Enter a text box on Simple Form Demo page
    And I type <TextForFieldB> into the Enter b text box on Simple Form Demo page
    And I click on the Get Total button on the Simple Form Demo page
    Then I can see <Result> displayed next to 'Total a + b =' label on Simple Form Demo page
    Examples:
    | TextForFieldA | TextForFieldB | Result  |
    | 4             | 5             | 9       |
    | a             | 5             | NaN     |
    | 1             | b             | NaN     |
    | a             | b             | NaN     |