@usps oop
Feature: USPS OOP scenarios



  @uspsoop1
  Scenario Outline: Validate ZIP code oop
    Given I open "usps" page
    When I go to Lookup ZIP page by address oop
    And I fill out "<street>" street, "<city>" city, "<state>" state oop
    Then I validate "<zip>" zip code exists in the result oop

    Examples:
      | street              | city      | state | zip   |
      | 4970 El Camino Real | Los Altos | CA    | 94022 |

  @usps2
  Scenario: Calculate price oop
    Given I open "usps" page
    When I go to Calculate Price Page oop
    And I select "Canada" with "Postcard" shape oop
    And I define "2" quantity oop
    Then I calculate the price and validate cost is "$2.40" oop