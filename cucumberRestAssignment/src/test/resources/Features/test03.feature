Feature: To check and validate login functionality with positive scenario

  @login
  Scenario: Login with a positive set of credential
    Given user is on login page
    When user login using credentials username and password
    Then user is navigated to Home page
