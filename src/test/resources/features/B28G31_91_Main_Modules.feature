@alp
Feature: As a user, I should be accessing all the main modules of the app.

  As a user, I should be accessing all the main modules of the app.
  Background: User is already in the log in page


  Scenario:  Verify users accessing all the main modules of the app.
    Given the users  log in with valid credentials
    Then Verify the user see the following modules:

      |Files|
      |Photos|
      |Activity|
      |Talk|
      |Mail|
      |Contacts|
      |Calendar|
      |Notes|
      |Deck|
      |Tasks|