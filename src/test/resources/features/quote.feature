@quote
  Feature: Quote OOP

    @quote1
    Scenario: Required fields for quote OOP
      Given I open "quote" page
      When I fill out required fields for "admin" oop
      And I submit the form oop
      Then I verify required fields for "admin" oop

    @quote2
    Scenario: Required fields for quote oop
      Given I open "quote" page
      When I fill out required fields for "user" oop
      When I fill out optional fields for "user" oop
      And I submit the form oop
      Then I verify required fields for "user" oop
      Then I verify optional fields for "user" oop

    @quote3
    Scenario: Required fields test oop
      Given I open "quote" page
      And I submit the form oop
      Then I see "username" error message "This field is required." oop
      And I see "email" error message "This field is required." oop
      And I see "password" error message "This field is required." oop
      And I see "name" error message "This field is required." oop
      And I see "agreedToPrivacyPolicy" error message "- Must check!" oop

    @quote4
    Scenario: Market username test oop
      Given I open "quote" page
      When I fill out "username" field with "a"
      And I submit the form oop
      Then I see "username" error message "Please enter at least 2 characters." oop
      When I fill out "username" field with "ab"
      Then I don't see "username" error message