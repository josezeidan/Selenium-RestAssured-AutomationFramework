@fidelity
Feature: This file check some functionality of fidelity web app

  Background:
    Given User navigate to fidelity web page

  Scenario: User should be able to chose an option from why fidelity menu
    Given User hover over the Why Fidelity drop down menu
    Then User selects carers from the menu
    And User verifies landed on the carer page