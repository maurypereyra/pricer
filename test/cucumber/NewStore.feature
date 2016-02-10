Feature: new store entry
  As a pricer user
  I want to add stores to the pricer application
  so that I do not have to remember them by myself

  Scenario: new book
    Given I open create store
    When I add "Disco" located in "742 de Evergreen Terrace"
    Then I see "Disco"s details