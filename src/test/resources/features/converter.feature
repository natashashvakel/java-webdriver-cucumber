@calculator
Feature: Converter functions

  Background:
    Given I go to new "converter" page

  @converter1
  Scenario Outline: Validate converter From one option to another
    When I click on "<Option>"
    And I set "<From>" to "<To>"
    Then I enter into From field "<Original Value>" and verify "<Converted Value>" result
    Examples:
      | Option      | From       | To        | Original Value | Converted Value |
      | Temperature | Fahrenheit | Celsius   | 54             | 12.2            |
      | Weight      | Pound      | Kilogram  | 170            | 77              |
      | Length      | Mile       | Kilometer | 50             | 80.4            |


  @converter2
  Scenario: Validate converter Fahrenheit to Celsius
  xx Scenario: Validate converter Pound to Kilogram
  xx When I click on "Weight"
  xx And I set "Pound" to "Kilogram"
  xx Then I enter into From field "170" and verify "77" result

  @converter3
  Scenario: Validate converter Mile to Kilometer
  xx When I click on "Length"
  xx And I set "Mile" to "Kilometer"
  xx Then I enter into From field "50" and verify "80.4" result
