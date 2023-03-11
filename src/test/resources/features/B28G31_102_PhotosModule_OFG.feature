@B28G31-102
Feature: Default

  Background: User is already in the log in page

    Given the user is on the login page
    Given User is already logged into the Ceallo


  Scenario: US102AC1TC1 - Verify users to access to Photos module
    Given user on the dashboard page
    When the user clicks the Photos module
    Then verify the page title is "Photos - Ceallo - QA"