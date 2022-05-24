Feature: To check and validate login functionality with negative scenario 
  
  @incorrectID
  Scenario: Get response code on providing wrong ID for user
    Given Open home page to search user
    When Provide some ID of the user
    Then Validate response for nagative scenario