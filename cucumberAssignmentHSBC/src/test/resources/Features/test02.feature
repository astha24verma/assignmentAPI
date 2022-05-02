Feature: To retrieve the data for particular user using ID

  @user
  Scenario: Get user detail with the help of his/her ID
    Given Navigate to the home page 
    When Provide the ID of the user
    Then Validate positive response code and output
