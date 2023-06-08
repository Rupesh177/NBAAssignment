Feature: To Test NBA portal

  Scenario: Verify user is able to access NBA Home Page
    Given I have launched browser
    Given I am on NBA page
    Then I should be able to see NBA home page

  Scenario: Load More option loads 8 items
    When user clicks on Load More option to check only 8 Elements are added

  Scenario: "Feedback" button will load multiple options and the user will be able to "Buy Ticket"
    When user clicks on Feedback button
    Then Buy Ticket option should be available

  Scenario: Verify teams dropdown loads Team's page
    Then I click on "Boston" team

  Scenario: The video related content will load video overlay on the same page
    When I click on a random video
    Then video should be played in the same window
    Then user closes the browser







