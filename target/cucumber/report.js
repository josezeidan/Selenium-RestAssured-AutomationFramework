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
  "name": "User Should be able to perform search on google website, choose the specific link, perform search, add filters,",
  "description": "  choose the specific item, add item to cart and validate the correct item added to cart.",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    },
    {
      "name": "@test"
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
  "error_message": "org.openqa.selenium.interactions.MoveTargetOutOfBoundsException: (935, 1089) is out of bounds of viewport width (1536) and height (739)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-LJFJGJO\u0027, ip: \u002710.1.10.92\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002717.0.2\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities {acceptInsecureCerts: true, browserName: firefox, browserVersion: 103.0.1, javascriptEnabled: true, moz:accessibilityChecks: false, moz:buildID: 20220729222726, moz:geckodriverVersion: 0.31.0, moz:headless: false, moz:platformVersion: 10.0, moz:processID: 16440, moz:profile: C:\\Users\\jzedan\\AppData\\Loc..., moz:shutdownTimeout: 60000, moz:useNonSpecCompliantPointerOrigin: false, moz:webdriverClick: true, moz:windowless: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 78b591b0-9813-4cdb-8066-a64a77eb932f\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.perform(RemoteWebDriver.java:618)\r\n\tat org.openqa.selenium.interactions.Actions$BuiltAction.perform(Actions.java:639)\r\n\tat org.openqa.selenium.interactions.Actions.perform(Actions.java:595)\r\n\tat ui_automation.step_definitions.BestBuySteps.user_chooses_the_item_and_add_it_to_cart(BestBuySteps.java:133)\r\n\tat ✽.User chooses the item and add it to cart(file:src/test/resources/uiFeatures/GoogleHome.feature:21)\r\n",
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