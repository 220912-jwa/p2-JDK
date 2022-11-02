Feature: Cart

  Scenario: Cart Management
    Given The user is on the index page.
    When The user clicks on any add to cart button.
    Then The button turns green and says success and the amount of items in the cart appears next to the cart link.
    When The user navigates to the cart page.
    Then The user sees the book they added to the cart and a remove from cart button.
    When The user navigates to the index page.
    Then The book in the cart is marked as a success.
    When The user navigates to the cart page.
    When The user clicks the remove from cart button.
    Then The book is removed from the cart and the number of items in the cart is reduced.
    When The user navigates to the index page.
    Then The cart is empty and no books are marked for success.

