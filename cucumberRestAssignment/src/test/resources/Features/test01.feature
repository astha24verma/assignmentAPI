Feature: To check the functionality for creation of new user 

  @newUser
  Scenario: Create new user 
    Given Navigate the home page and provide new data
    When Post data of new user
    Then Validate the creation of new user

    