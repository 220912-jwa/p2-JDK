Feature: tracking negative
  Background:
    Given user is on tracking page

  Scenario: track order
    When user types in "12345" into the tracking no
    Then user should see an alert