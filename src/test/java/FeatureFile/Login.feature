Feature: feature to test website functionality

  Scenario: Check user is able to buy product
    Given user is on login page
    And user enters username and password
    And clicks on login button
    When user is navigated to the product page and verify the page
    And click on any add to cart button
    And navigate to the carts button and verify the page
    Then click on checkout fill the billing information and click continue
    And Verify the item in overview page and click finish button
    And user is logged out and browser closes