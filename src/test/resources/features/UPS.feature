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