# Generate TestNg report
@tag
Feature: To successfuly register

  @register
  Scenario: Register with a positive set of credential
    Given user is on register page
    When user registers using email and password
    Then validate the outcome after request
