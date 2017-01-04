Feature: Showcases display on homepage

Background:
  Given I am on homepage

  Scenario: Verify cookies banner display on the top of the page
    Then Cookies banner should be displayed on top of the page

  Scenario: Close cookies banner
    When I select the close button
    And Refresh the page
    Then Cookies banner should be closed

  Scenario: Homepage header is "Welcome to Sky Go"
    Then Header title should be displayed as "Welcome to Sky Go"

  Scenario: Top picks title is "Featured"
    Then Top picks title should be displayed as "Featured"

  Scenario: Featured images displayed
    Then four top picks images should be displayed

  Scenario: Carousal is display on the homepage
   Then A carousel should be displayed on the top of the page

  Scenario: Sky Box Sets Highlights display
    Then Large image highlight should be displayed
    And Small size highlight should be displayed

  Scenario: Verify that Catch Up Highlights showcase display
    Then Catch Up Highlights should be displayed

  Scenario: Verify that Sky CinemaA  Highlights showcase display
    Then Sky Cinema Highlights should be displayed

  Scenario: Verify that What's On Now showcase display
    Then What's On Now should be displayed

  Scenario: Verify that Kids Highlights showcase display
    Then Kids Highlights showcase should be displayed

  Scenario: Verify that Sky Sports Highlights showcase is display
    Then Sky Sports Highlights should be displayed
