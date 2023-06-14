Feature: Login Feature
  Background:
    Given user on Target Homepage

  @smoke
  Scenario: user should be able to login with valid credentials
    And user enter valid email address
    And user enter valid password
    When user clicks on Log In button
    Then user should be able to successfully login

    Scenario: Existing user should be able to login
      And login
  @smoke
  Scenario: User should not be able to login with valid email and invalid password
    And user enter valid email address
    And user enter invalid password
    When user clicks on Log In button
    Then user should be able see "hat password is incorrect" message
  @smoke
  Scenario: User should not be able to login with invalid email and valid password
    And user enter invalid email address
    And user enter valid password
    When user clicks on Log In button
    Then user should be able see "e can't find your account" message
  @smoke
  Scenario: User should not be able to login with invalid email and password
    And user enter invalid email address
    And user enter invalid password
    When user clicks on Log In button
    Then user should be able see "e can't find your account" message
