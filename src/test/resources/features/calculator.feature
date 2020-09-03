@calculator
Feature: Calculator test suite

  @calculator1
  Scenario Outline: Verify calculator result
    Given I go to new "calculator" page
    When I navigate to "Auto Loan Calculator"
    And I clear all calculator fields
    And I calculate
    Then I verify "Please provide a positive auto price." calculator error
    Then I verify "Please provide a positive interest value." calculator error
    And I enter "<Price>" price, "<Months>" months, "<Interest>" interest, "<Downpayment>" downpayment, "<Trade-in>" trade-in, "<State>" state, "<Tax>" percent tax, "<Fees>" fees
    And I calculate
    Then I verify monthly pay is "<Payment>"
    Examples:
      | Price  | Months | Interest | Downpayment | Trade-in | State      | Tax | Fees | Payment   |
      | 25000  | 60     | 4.5      | 5000        | 0        | California | 7   | 300  | $372.86   |
      | 100000 | 60     | 5        | 10000       | 20000    | California | 7   | 1000 | $1,320.99 |
      | 30000  | 72     | 4.5      | 6000        | 10000    | California | 10  | 2000 | $222.24   |