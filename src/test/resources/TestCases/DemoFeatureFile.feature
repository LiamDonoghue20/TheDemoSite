Feature: Using the demo site
  As a user
  I want to create a new account
  So that I can log into the website

  Scenario: Create a new user and log in
    Given the Add User Tab
    When I fill out new login details
    And I click save
    And I go to the Login Tab
    Then I can login with the new account