@java
  Feature: Java feature
    @java1
    Scenario: Hello world
      Given I say hello world
      And I say "hello again"
      And I say "say hello!"
      And I call 5 times
      And I call 6 times
      And I perform actions with "var1" and "VAR2"
      And I perform actions with "Natasha" and "Shvakel" and "blue"

    @java2
      Scenario: I perform homework
      And I perform homework with "my var" and "my VAR"

    @java3
    Scenario: I perform homework for data types: Number exercise
      And I perform integer exercise with 10 and 3

    @java4
    Scenario: I perform homework for data types:Boolean exercise
      And I perform boolean actions with "Blue" and "Red"

    @java5
    Scenario: I perform homework for data types: Condition exercise
      And I print url for "yahoo" page

      @java6
      Scenario: I perform homework for data types: Array exercise
        And I perform array exercises

     @java7
        Scenario: Homework Steps with condition
          And I print if number 35 is positive

       @java8
       Scenario: Homework new Steps with condition
         And I print if number "35" is positive

         @java9
         Scenario: Homework for Days of the week
           And I print 7 th day of the week


