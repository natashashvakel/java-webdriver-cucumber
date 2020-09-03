@UPS
Feature: UPS test suite

  @UPS1
  Scenario: UPS end to end first
    Given I go to my "ups" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields for "ups"
    And I submit the shipment form
    Then I verify origin shipment fields submitted for "ups"
    And I cancel the shipment form
    Then I verify shipment form is reset
  
  @UPS2
  Scenario: UPS end to end full
    Given I go to my "ups" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields for "ups"
    And I submit the shipment form
    Then I verify origin shipment fields submitted for "ups"
    When I fill out destination shipment fields for "ups2"
    When I submit the shipment form
    And I set packaging type and weight
    When I submit the shipment form
    Then I verify total charges appear
    And I select cheapest delivery option
    And I submit the shipment form
    And I set description and check Saturday Delivery type
    Then I verify total charges changed
    When I submit the shipment form
    And I select Paypal payment type
    And I submit the shipment form review
    Then I review all recorded details on the review page
    And I cancel the shipment form
    Then I verify shipment form is reset