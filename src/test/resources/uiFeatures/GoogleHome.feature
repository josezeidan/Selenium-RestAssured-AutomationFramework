
Feature: This feature file validate some google functionalities

  Background:
    Given User navigate to google home page

  Scenario: Use should be able to do search on google website and choose the specific link
            and validate that landed into the right page
    Given User enters the required search into the search field and clicks the search button
    |Laptops|
    Then User chooses the specific link we want to navigate to
    And User verifies that landed into the specific page

  @smoke
Scenario: User Should be able to perform search on google website, choose the specific link, perform search, add filters,
  choose the specific item, add item to cart and validate the correct item added to cart.
  Given User enters the required search into the search field and clicks the search button
    |Laptops|
  Then User chooses the specific link we want to navigate to
  Then User enters the item want to search for and add filters
  Then User chooses the item and add it to cart
  And User navigates to cart and verified item added correctly

