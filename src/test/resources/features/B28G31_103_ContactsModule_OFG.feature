@B28G31-103
Feature: Default

  Background: User is already in the log in page

    Given the user is on the login page
    Given User is already logged into the Ceallo


  Scenario: US102AC1TC1 - Verify users to access to Contacts module
    Given user on the dashboard page
    When the user clicks the Contacts module
    Then verify the page title is "Contacts - Ceallo - QA"