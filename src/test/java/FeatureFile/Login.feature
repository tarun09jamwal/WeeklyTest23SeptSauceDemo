Feature: feature to test website functionality

  Scenario: Check user is able to buy product
    Given clicks on login button
    When user is navigated to the product page and verify the page
    And click on any add to cart button
    And navigate to the carts button and verify the page
    Then click on checkout fill the billing information and click continue
    And Verify the item in overview page and click finish button
    And click on back home button