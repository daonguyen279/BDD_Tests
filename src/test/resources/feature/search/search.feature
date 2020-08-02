Feature: Search

    Scenario: Validate Google search result
        Given user is on google search page
        And searches for the Beatles
        When user clicks on search button
        Then the search term remained on the search box
        And all of the web results should be contained the search term
        And all of the top story results should be contained the search term
        And all of the video results should be contained the search term
        And all of the people also ask results should be contained the search term

    Scenario: Validate YouTube result from Google search
        Given user is on google search page
        And searches for the Beatles
        When user clicks on search button
        And user clicks on the first video
        And user play the video
        Then the video is playing
        When user wait for 10 seconds
        And user pause the video
        Then the video is paused
        And the video title is equal to search result

