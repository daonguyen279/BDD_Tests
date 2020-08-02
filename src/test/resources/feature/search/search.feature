Feature: Search

    Scenario: Search
        Given user is on google search page
        And searches for ABC
        When user clicks on search button
        Then all of the results should be contained the search team
