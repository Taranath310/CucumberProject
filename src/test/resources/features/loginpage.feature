Feature: Login functionality for FireCrowd application
  As a customer i want to able to log in with my email and password
  so i can conduct crowd testing on my application


  Background:
    Given I am on the login page

  Scenario Outline: SuccessFull login with valid emails and passwords
    Given I have entered valid "<email>" and "<password">
    When I clicked on signin button
    Then I should logged in successfully
    Examples:
      | email       | password |
      | tara@ty.com | Pass@123 |
      | raju@ty.com | Pass@123 |
      | sam@ty.com  | Pass@123 |