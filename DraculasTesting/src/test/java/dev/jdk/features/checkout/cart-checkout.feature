Feature: checkout
  Background:
    Given user is on browse page

  Scenario: view books
    When user clicks on buy now
    Then user should be redirected to payment page
    When The user clicks the browser back button
    Then The user should be on the browse page and the title of page is Browse Page

  Scenario: proceed to payment
    When The user clicks on buy now
    Then user should be redirected to payment page
    Then user types in "rocky" into the name
    Then user types in "pdarpan321@outlook.com" into the email
    Then user types in "Orlando" into the city
    Then user types in "Florida" into the state
    Then user types in "9049623760" into the contactno
    Then user types in "US" into the country
    Then user types in "Street 1" into the streetaddress
    Then user types in "35556" into the zipcode
    Then user types in "4567896552367458" into the cardno
    Then user types in "2023-11-10" into the expirydate
    Then user types in "011" into the cvv
    Then user clicks on proceed
    Then user should be redirected to confirmation page

  Scenario: Cancel Order
    When The user clicks on buy now
    Then user should be redirected to payment page
    Then user clicks on cancel
    Then user is redirected to browse page
