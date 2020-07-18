Feature: Simple Login application test

  Scenario: Validate Simple Login Home Page Test
    Given user opens browser
    Then user is on login page
    Then user enters username and password
    Then validate home page title
    Then validate logout button is displayed
    Then validate logo is displayed