$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/uiFeatures/GoogleHome.feature");
formatter.feature({
  "name": "This feature file validate some google functionalities",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
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
  "name": "Use should be able to do search on google website and choose the specific link",
  "description": "            and validate that landed into the right page",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
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
  "keyword": "Given "
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
  "name": "User verifies that landed into the specific page",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleHSteps.user_verifies_that_landed_into_the_specific_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
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
  "name": "User Should be able to perform search on google website, choose the specific link, perform search, add filters,",
  "description": "  choose the specific item, add item to cart and validate the correct item added to cart.",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
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
  "keyword": "Given "
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
  "name": "User chooses the item and add it to cart",
  "keyword": "Then "
});
formatter.match({
  "location": "BestBuySteps.user_chooses_the_item_and_add_it_to_cart()"
});
formatter.result({
  "error_message": "java.lang.NumberFormatException: For input string: \"ot Yet Reviewe\"\r\n\tat java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)\r\n\tat java.base/java.lang.Integer.parseInt(Integer.java:668)\r\n\tat java.base/java.lang.Integer.parseInt(Integer.java:786)\r\n\tat ui_automation.step_definitions.BestBuySteps.user_chooses_the_item_and_add_it_to_cart(BestBuySteps.java:60)\r\n\tat ✽.User chooses the item and add it to cart(file:src/test/resources/uiFeatures/GoogleHome.feature:21)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User navigates to cart and verified item added correctly",
  "keyword": "And "
});
formatter.match({
  "location": "BestBuySteps.user_navigates_to_cart_and_verified_item_added_correctly()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});