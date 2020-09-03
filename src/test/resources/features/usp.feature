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

  @usps12
  Scenario: Quadcopters delivery
  xx Given I go to my "usps" page
    When I go to "Help" tab
    And I perform "Quadcopters delivery" help search
    Then I verify that no results of "Quadcopters delivery" available in help search

