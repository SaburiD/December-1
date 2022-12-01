Feature: Customer

Background: common steps for all scenario

 	Given User Launch the Browser
    When user opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters the Email as "admin@yourstore.com" and password as "admin"
    And Click on login button
    Then user can view Dashboard
    When user clicks on Customer menu
    And click on customer menu item
     
    @Regression @Sanity
Scenario: Add new customer

    And click on add new Button
    Then user can view Add new customer page 
    When user enter cutomer info
    And click on Save button
    Then user can view confirmation message "The new customer has been added successfully."
    Then close browser
    
  
   @Sanity
Scenario: Search customer by Email

    And customer enter email
    When click on search button
    Then close browser
    
    @Sanity
 Scenario: Search by customer Name
   And customer enter firstname
   And customer enter Lastname
   When click on search button 
  Then close browser
    
   