Feature: To check and validate login functionality with negative scenario 
  
  @login @negative
  Scenario: Login with a nagative set of credential
  
    Given user visits login page
    When user trying to login using only username
    Then user gets error message