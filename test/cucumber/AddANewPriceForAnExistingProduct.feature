
Feature: new price entry
  As a pricer user
  I want to add stores to the pricer application
  so that I do not have to remember them by myself

  Scenario: new price
    Given I open create price
    When I add a price with amount "20", with the note "Too cheep" for "Honey" on "Walmart"
    Then I see the new price for "Honey" on "Walmart"