Feature: Inventory page

  Background:
    When I input "standard_user" to username field
    And input "secret_sauce" to password field
    When I push the Login button
    Then I am on the page Inventory

    @inventory-1
  Scenario: 6 inventory items are displayed
    Then inventory item quantity is 6

     @inventory-2
     @sort_by_name_az
     @4356
  Scenario: Sorting by name A-Z
    When I choose sorting option by name A-Z
    Then all items name are sorted alphabetically

  @inventory-3
  Scenario: Sorting by name Z-A
    When I choose sorting option by name Z-A
    Then all items name are sorted in reverse alphabetical order

    @inventory-4
    Scenario: Sorting by price from low to high
      When I choose sorting option by price from low to high
      Then all prices are sorted from low to high


    @inventory-5
    Scenario:  Sorting by price from high to low
      When I choose sorting option by price from high to low
      Then all prices are sorted from high to low