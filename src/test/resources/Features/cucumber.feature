Feature: Grolls cart
  Put 2 black T-shirt in the cart.

  Background:
    Given I have navigated to the website

  Scenario: Put 2 black T-shirt in the cart.
    Given I select size small
    And I want 2 t-shirts
    When I press "Lägg i varukorgen"
    Then the result should be 2 t-shirts size small in the cart

