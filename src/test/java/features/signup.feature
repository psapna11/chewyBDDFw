Feature: Signup Feature

  @smoke
  Scenario: User should be able to create a brand new account with unique email address
    Given user on Target Homepage
    And user clicks on "Create new account" button
    And user enter their valid email address
    And user enters First and Last Name
    And user enter Password
    When user clicks on Create my account button
    And user clicks on "Join free"
    Then user should be able to successfully Create Target Account