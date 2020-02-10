@checkboxes-demo-page
Feature: Test Checkboxes Demo Page

  Scenario: User clicks on Checkbox Demo Link within Basic tab section and is directed to the page
    Given I am a user who has retrieved the selenium test website
    And I have opened the Basic tab section on the Landing page
    When I click on Check Box Demo link within basic tab section
    Then I see the Check Box Demo page loaded

  Scenario: User is able to click on the checkbox in Single Checkbox Demo section and a success message is displayed
    Given I am on the Check Box Demo page
    And I see the Check Box Demo page loaded
    When I select the Checkbox in Single Checkbox Demo section
    Then I see the success message displayed in Single Checkbox Demo section

  Scenario: User is able to click on the 'Check All' checkbox in Multiple Checkbox Demo section
            and button text is updated to 'Uncheck All'
    Given I am on the Check Box Demo page
    And I see the Check Box Demo page loaded
    When I click on the Check All button in Multiple Checkbox Demo section
    Then I can see all checkboxes selected in Multiple Checkbox Demo section

  Scenario: User is able to click on the 'Uncheck All' checkbox in Multiple Checkbox Demo section
            and button text is updated to 'Check All'
    Given I am on the Check Box Demo page and all the checkboxes in Multiple Checkbox Demo section are selected
    When I click on the Uncheck All button in Multiple Checkbox Demo section
    Then I can see all checkboxes unselected in Multiple Checkbox Demo section