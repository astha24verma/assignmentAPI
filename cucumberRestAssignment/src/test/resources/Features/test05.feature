Feature: Negative Scenario : To get response after giving wrong URI

  @incorrectURI
  Scenario: Get error message on using wrong URI
    Given Go to the home page
    When Provide wrong URI
    Then Validate response after wrong URI
    #https://api.ratesapi.io/api/
