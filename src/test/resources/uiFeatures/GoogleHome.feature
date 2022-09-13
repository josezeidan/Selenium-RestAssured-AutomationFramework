@jose
Feature: This feature file validate some google functionalities

  Background:
    Given User navigate to google home page

  Scenario: User should be able to do search on google website and choose the specific link
            and validate that landed into the right page
    When User enters the required search into the search field and clicks the search button
    |Laptops|
    Then User chooses the specific link we want to navigate to
    And User verifies that landed into the specific page


Scenario: User Should be able to perform search on google website, choose the specific link, perform search, add filters,
  choose the specific item, add item to cart and validate the correct item added to cart.
  When User enters the required search into the search field and clicks the search button
    |Laptops|
  Then User chooses the specific link we want to navigate to
  Then User enters the item want to search for and add filters
  Then User chooses the item and add it to cart
  And User navigates to cart and verified item added correctly



  Scenario: User should be able to choose the laptop with lowest rate
    When User enters the required search into the search field and clicks the search button
      |Laptops|
    Then User chooses the specific link we want to navigate to
    Then User enters the item want to search for and add filters
    Then User chooses the item with lowest rate and add it to cart
    And User navigates to cart and verified item added correctly





#@newTest
#  Scenario: User navigates to best buy website and chose lower and higher laptop price
#    When User enters the required search into the search field and clicks the search button
#      |Laptops|
#    Then User chooses the specific link we want to navigate to
#    Then User enters the item want to search for and add filters
#    Then User chose the lower and lower and higher laptop price
#    And User verifies that laptops got added correctly to add to cart



