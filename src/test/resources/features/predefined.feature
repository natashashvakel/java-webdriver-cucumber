@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"
    
    

  @predefined2
  Scenario: Predefined Steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title as "Yahoo"
    Then element with xpath "//input[@id='header-search-input']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='header-search-input']"
    And I click on element with xpath "//button[@id='header-desktop-search-button']"
    Then I wait for element with xpath "//div[@id='web']" to be present
    Then element with xpath "//div[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined Steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    And I click on element with xpath "//label[@class='search icon tooltip']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined Steps for Gibiru
    Given I open url "https://gibiru.com/"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    And I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@class='gsc-wrapper']" to be present
    Then element with xpath "//div[@class='gsc-wrapper']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined Steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    And I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[contains(@class,'results--main')]" to be present
    Then element with xpath "//div[contains(@class,'results--main')]" should contain text "Cucumber"

    @predefined6
    Scenario: Predefined Steps for Swisscows
      Given I open url "https://swisscows.com/"
      Then I should see page title contains "Swisscows"
      Then element with xpath "//input[@name='query']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
      And I click on element with xpath "//button[@class='search-submit']"
      Then I wait for element with xpath "//div[@class='web-results']" to be present
      Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"


@predefined7
Scenario: Predefined Steps for Searchencrypt
  Given I open url "https://searchencrypt.com/home"
  Then I should see page title contains "Search Encrypt"
  Then element with xpath "//input[@placeholder='Search...']" should be present
  Then I type "Behavior Driven Development" into element with xpath "//input[@placeholder='Search...']"
  And I click on element with xpath "//i[@class='fas fa-search']"
  Then I wait for element with xpath "//section[@class='serp__results container']" to be present
  Then I wait for 2 sec
  Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"
  
  @predefined8
  Scenario: Predefined Steps for Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title contains "Startpage.com"
    And element with xpath "//input[@id='q']" should be present
    Then I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    And I click on element with xpath "//div[@class='ico']"
    Then I wait for element with xpath "//div[@class='mainline-results mainline-results__web']" to be present
    Then I wait for 2 sec
    Then element with xpath "//div[@class='mainline-results mainline-results__web']" should contain text "Cucumber"

      
  @predefined9
  Scenario: 1. Validate Responsive UI
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 1280 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 800 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 400 and 1024
    Then element with xpath "//b[@id='location']" should not be displayed
    
    @predefined10
    Scenario: 2. Validate min Username field length
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "a" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='username-error']" should be displayed
      And I clear element with xpath "//input[@name='username']"
      When I type "ab" into element with xpath "//input[@name='username']"
      Then element with xpath "//label[@id='username-error']" should not be displayed

      @predefined11
        Scenario: 3.Validate Email field
        Given I open url "https://skryabin.com/market/quote.html"
        When I type "natasha.shvakel" into element with xpath "//input[@name='email']"
        And I click on element with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='email-error']" should be displayed
        And I clear element with xpath "//input[@name='email']"
        Then element with xpath "//label[@id='email-error']" should not be displayed

      @predefined12
      Scenario: 4. Validate Password field
        Given I open url "https://skryabin.com/market/quote.html"
        When I type "a" into element with xpath "//input[@id='password']"
        And I click on element with xpath "//input[@id='confirmPassword']"
        Then element with xpath "//label[@id='password-error']" should be displayed
        And I clear element with xpath "//input[@id='password']"
        When I type "ab" into element with xpath "//input[@id='password']"
        And I click on element with xpath "//input[@id='confirmPassword']"
        Then element with xpath "//label[@id='password-error']" should be displayed
        And I clear element with xpath "//input[@id='password']"
        When I type "abc" into element with xpath "//input[@id='password']"
        And I click on element with xpath "//input[@id='confirmPassword']"
        Then element with xpath "//label[@id='password-error']" should be displayed
        And I clear element with xpath "//input[@id='password']"
        When I type "abcd" into element with xpath "//input[@id='password']"
        And I click on element with xpath "//input[@id='confirmPassword']"
        Then element with xpath "//label[@id='password-error']" should be displayed
        And I clear element with xpath "//input[@id='password']"
        When I type "abcde" into element with xpath "//input[@id='password']"
        And I click on element with xpath "//input[@id='confirmPassword']"
        Then element with xpath "//label[@id='password-error']" should not be displayed
        When I clear element with xpath "//input[@id='password']"
        And I click on element with xpath "//input[@id='confirmPassword']"
        Then element with xpath "//input[@id='confirmPassword'][@disabled='disabled']" should be displayed
        When I type "abcde" into element with xpath "//input[@id='password']"
        And I type "abcd" into element with xpath "//input[@id='confirmPassword']"
        And I click on element with xpath "//input[@id='dateOfBirth']"
        Then element with xpath "//label[@id='confirmPassword-error']" should be displayed

        @predefined13
        Scenario: 5. Validate Name field
          Given I open url "https://skryabin.com/market/quote.html"
          Then I click on element with xpath "//input[@id='name']"
          Then element with xpath "//input[@id='firstName']" should be displayed
          And I type "Natasha" into element with xpath "//input[@id='firstName']"
          And I type "Shvakel" into element with xpath "//input[@id='lastName']"
          And I type "A" into element with xpath "//input[@id='middleName']"
          And I click on element with xpath "//span[contains(text(),'Save')]"
          Then element with xpath "//*[@id='name']" should have attribute "value" as "Natasha A Shvakel"

        @predefined14
        Scenario: 6. Accepting Privacy policy
            Given I open url "https://skryabin.com/market/quote.html"
            When I type "Username" into element with xpath "//input[@name='username']"
            And I type "natasha.shvakel@gmail.com" into element with xpath "//input[@name='email']"
            And I type "Password" into element with xpath "//input[@id='password']"
            And I type "Password" into element with xpath "//input[@id='confirmPassword']"
            And I click on element with xpath "//input[@id='name']"
            And I type "Natasha" into element with xpath "//input[@id='firstName']"
            And I type "Shvakel" into element with xpath "//input[@id='lastName']"
            And I type "A" into element with xpath "//input[@id='middleName']"
            And I click on element with xpath "//span[contains(text(),'Save')]"
            And I click on element with xpath "//button[@id='formSubmit']"
            Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
            When I click on element with xpath "//label[@class='required checkbox_radio']"
            And I click on element with xpath "//button[@id='formSubmit']"

          @predefined15
          Scenario: 8. Submit form and verify the data
            Given I open url "https://skryabin.com/market/quote.html"
            When I type "Username" into element with xpath "//input[@name='username']"
            And I type "natasha.shvakel@gmail.com" into element with xpath "//input[@name='email']"
            And I type "Password" into element with xpath "//input[@id='password']"
            And I type "Password" into element with xpath "//input[@id='confirmPassword']"
            And I click on element with xpath "//input[@id='name']"
            And I type "Natasha" into element with xpath "//input[@id='firstName']"
            And I type "Shvakel" into element with xpath "//input[@id='lastName']"
            And I type "A" into element with xpath "//input[@id='middleName']"
            And I click on element with xpath "//span[contains(text(),'Save')]"
            And I click on element with xpath "//button[@id='formSubmit']"
            Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
            When I click on element with xpath "//label[@class='required checkbox_radio']"
            And I click on element with xpath "//button[@id='formSubmit']"
            Then element with xpath "//b[@name='firstName']" should have text as "Natasha"
            And element with xpath "//b[@name='lastName']" should have text as "Shvakel"
            And element with xpath "//b[@name='middleName']" should have text as "A"
            And element with xpath "//b[@name='email']" should have text as "natasha.shvakel@gmail.com"
            And element with xpath "//b[@name='password']" should not contain text "Password"

           @predefined15
           Scenario: 9. Test for my Quiz answers
             Given I open url "https://skryabin.com/market/quote.html"
             When I type "a" into element with xpath "//*[@name='username']"
             And I click on element with xpath "//button[@id='formSubmit']"
             And I clear element with xpath "//input[@name='username']"

           @predefined16
           Scenario: 10. Test for my Quiz answers
             Given I open url "https://www.ecosia.org/"
             Then I should see page title as "Ecosia - the search engine that plants trees"
             When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
             When I click on element with xpath "//button[@type='submit']"

           @predefined16
           Scenario: 11. Test for my Quiz answers
             Given I open url "https://skryabin.com/market/quote.html"
             When I click on element with xpath "//input[@id='name']"
             And I wait for element with xpath "//div[contains(@aria-describedby,'Dialog')]" to be present







