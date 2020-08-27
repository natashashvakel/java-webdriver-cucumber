@calculator
Feature: Converter functions

  @converter1
  Scenario: Validate converter Fahrenheit to Celsius
    Given I go to new "converter" page
    When I click on "Temperature"
    And I set "Fahrenheit" to "Celsius"
    Then I enter into From field "54" and verify "12.2" result

  @converter2
  Scenario: Validate converter Pound to Kilogram
    Given I go to new "converter" page
    When I click on "Weight"
    And I set "Pound" to "Kilogram"
    Then I enter into From field "170" and verify "77" result

  @converter3
  Scenario: Validate converter Mile to Kilometer
    Given I go to new "converter" page
    When I click on "Length"
    And I set "Mile" to "Kilometer"
    Then I enter into From field "50" and verify "80.4" result
