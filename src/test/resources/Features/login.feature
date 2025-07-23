Feature: Login page Automation of saucedemo app

  Scenario: Check login is successful with valid creds
    Given User is on login page
    When User enters valid username and password
    And Clicks on login Button
    Then User is naviagted to Home page
    And Close the browser
