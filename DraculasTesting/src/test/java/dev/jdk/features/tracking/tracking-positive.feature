Feature: tracking positive
  Background:
    Given user is on tracking page

  Scenario: track order
    When user types in "d2a6030ee7f7f5ad400a81b943b53512" into the tracking no
    Then user should see a modal with details
    Then user clicks on close modal