@usps
Feature: USPS scenarios

  Background:
    Given I go to my "usps" page

  @usps1
  Scenario Outline: Validate ZIP code for Portnov Computer School
  xx Given I go to my "usps" page
  xx Note: Above line was moved to Background (Background is reusable portion of the same code which runs for all screnarios)
  xx And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
  xx Then I validate "94022" zip code exists in the result
  xx Note: Above 2 lines were converted as Outline using examples table below
    When I go to Lookup ZIP page by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<zip>" zip code exists in the result

    Examples:
      | street              | city      | state | zip   |
      | 4970 El Camino Real | Los Altos | CA    | 94022 |
      | 11 Wall st          | New York  | NY    | 10005 |
      | 111 S Michigan Ave  | Chicago   | IL    | 60603 |

  @usps2
  Scenario: Calculate price
  xx Given I go to my "usps" page
    When I go to Calculate Price Page
    And I select "Canada" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.40"

  @usps3
  Scenario: Verify location
  xx Given I go to my "usps" page
    When I perform "Free Boxes" search
    And I set "Mail & Ship" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required

  @usps4
  Scenario: Quadcopters delivery
  xx Given I go to my "usps" page
    When I go to "Help" tab
    And I perform "Quadcopters delivery" help search
    Then I verify that no results of "Quadcopters delivery" available in help search

  @usps5
  Scenario: Every door direct mail
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I click "Show Table" on the map
    When I click "Select All" on the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

  @usps6
  Scenario: Homework # 12: Wrong store id does not match
    When I go to "Postal Store" tab
    And I enter "12345" into store search
    Then I search and validate no products found

  @usps7
  Scenario: Homework # 12: One item found
    When I go to "Stamps" under "Postal Store"
    And choose mail service Priority Mail
    Then I verify 1 items found

  @usps8
  Scenario: Homework # 12: Verify color
    When I go to "Stamps" under "Postal Store"
    When I unselect "Stamps" checkbox
    And select "Vertical" stamp Shape
    And I click "Blue" color
    Then I verify "Blue" and "Vertical" filters
    Then I verify "12" filtered items found
    And I verify that items below 12 dollars exists

  @usps9
  Scenario: Homework # 12: Verify location new
    When I perform "Passports" search
    And I select "Passport Application" in results
    And I click my "Schedule an Appointment" button
    And verify "Passport Renewal" service exists

  @usps10
  Scenario: Homework # 12: PO Box
    When I go to "PO Boxes" under "Track & Manage"
    And I reserve new PO box for "94022"
    Then I verify that "Los Altos — Post Office™" present
    And I verify that "Size 5-XL" PO Box is available in "Los Altos"

