@usps
Feature: USPS scenarios

  @usps1
  Scenario: Validate ZIP code for Portnov Computer School
    Given I go to my "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94522" zip code exists in the result

  @usps2
  Scenario: Calculate price
    Given I go to my "usps" page
    When I go to Calculate Price Page
    And I select "Canada" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.40"

  @usps3
  Scenario: Verify location
    Given I go to my "usps" page
    When I perform "Free Boxes" search
    And I set "Mail & Ship" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required

  @usps12
  Scenario: Quadcopters delivery
    Given I go to my "usps" page
    When I go to "Help" tab
    And I perform "Quadcopters delivery" help search
    Then I verify that no results of "Quadcopters delivery" available in help search

