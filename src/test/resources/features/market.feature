@market
Feature: Marketing test suite

  @market1
  Scenario: Navigation for quote
    Given I go to "google" page
    And I print page details
    And I go to "quote" page
    And I print page details
    And I go back and forward, then refresh

  @market2
  Scenario: Required fields for quote
    Given I go to "quote" page
    And I print page details
    When I fill out required fields
    And I submit the form
    Then I verify required fields

   @market3
   Scenario: Homework GetDriver() exercises
     Given I go to "quote" page
     And I print page details

   @market4
   Scenario: Homework GetDriver().navigate exercises
     Given I go to "google" page
     And I go to "quote" page
     And I go back and forward, then refresh

  @market5
  Scenario: Homework GetDriver().manage().window() exercises
    Given I go to "quote" page
    And I change resolution to "phone"
    And I change resolution to "desktop"

  @market6
  Scenario: Homework GetDriver().findElement() exercises
    Given I go to "quote" page
    And I fill out required fields
    And I submit the form

  @market7
  Scenario: Homework Assertion exercises
    Given I go to "quote" page
    And I fill out required fields
    And I fill out optional fields
    And I "accept" agreement
    And I submit the form
    Then I verify that fields values recorded correctly


