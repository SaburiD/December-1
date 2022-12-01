Feature: Login
@Sanity
Scenario: Successfull Login With valid creadentials

    Given User Launch the Browser
    When user opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters the Email as "admin@yourstore.com" and password as "admin"
    And Click on login button
    Then title page should be "Dashboard / nopCommerce administration"
    When user click on Logout link
    Then page title should be "Your store. Login"
    And close browser
    
 @Regression   
    Scenario Outline:Successfull Login With valid creadentials with DDT
    Given User Launch the Browser
    When user opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters the Email as "<email>" and password as "<password>"
    And Click on login button
    Then title page should be "Dashboard / nopCommerce administration"
    When user click on Logout link
    Then page title should be "Your store. Login"
    And close browser
    
    Examples:
    |email|password|
    |admin@yourstore.com|admin|
    |test@yourstore.com|test123|