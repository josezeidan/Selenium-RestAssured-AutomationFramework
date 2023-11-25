$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/uiFeatures/GoogleHome.feature");
formatter.feature({
  "name": "This feature file validate some google functionalities",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigate to google home page",
  "keyword": "Given "
});
formatter.match({
  "location": "GoogleHSteps.user_navigate_to_google_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User should be able to choose the laptop with lowest rate",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@jose"
    }
  ]
});
formatter.step({
  "name": "User enters the required search into the search field and clicks the search button",
  "rows": [
    {
      "cells": [
        "Laptops"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "GoogleHSteps.user_enters_the_required_search_into_the_search_field_and_clicks_the_search_button(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User chooses the specific link we want to navigate to",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleHSteps.user_chooses_the_specific_link_we_want_to_navigate_to()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the item want to search for and add filters",
  "keyword": "Then "
});
formatter.match({
  "location": "BestBuySteps.user_enters_the_item_want_to_search_for_and_add_filters()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User chooses the item with lowest rate and add it to cart",
  "keyword": "Then "
});
formatter.match({
  "location": "BestBuySteps.userChoosesTheItemWithLowestRateAndAddItToCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to cart and verified item added correctly",
  "keyword": "And "
});
formatter.match({
  "location": "BestBuySteps.user_navigates_to_cart_and_verified_item_added_correctly()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});