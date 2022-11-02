Feature: Browse

  Scenario Outline: Navigation
    Given The user is on the index page.
    When The user clicks the "<link>" link.
    Then the user will be on the "<title>" page.

  Examples:
    |link|title|
    |Cart|Cart|
    |Browse|Browse|

  Scenario Outline: Browse Filters
    Given The user is on the index page.
    When The user selects "<filter>" option.
    When The user clicks the "<filterLink>" button.
    Then the user should see only "<option>" books.

  Examples:
    |filter      |filterLink                       |option      |
    |Bram |Get All Books By Author          |Bram|
    |Adults      |Get All Books By Audience        |Slasher     |
    |Lovecraftian|Get All Books By Genre           |Lovecraftian|
    |15          |	Get Book By Id	               |Final Girls |
    |frankenstein|Get All Books By Search Keywords |Frankenstein|



