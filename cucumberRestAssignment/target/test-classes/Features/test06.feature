#Future data
Feature: To test future date scenario

  @tag1
  Scenario: Validate future date 
    Given API to test
    When posted with future date information
    Then validate positive response code received
