  @checkout
  Feature: Checkout
    Background:
      When I input "standard_user" to username field
      And input "secret_sauce" to password field
      When I push the Login button
      Then I am on the page Inventory

    Scenario: Success backpack purchase
      When I push Add to cart button of backpack
      #...
      # check text "Thank you for your order!"
      # check that URL contains checkout-complete