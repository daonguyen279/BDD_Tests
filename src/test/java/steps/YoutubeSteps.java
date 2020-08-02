package steps;

import cucumber.api.java.en.Then;
import pages.YoutubePage;
import utilities.State;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Definition of Cucumber test steps.
 */
public class YoutubeSteps {
    State state;

    public YoutubeSteps(State state) {
        this.state = state;
    }

    YoutubePage youtubePage = new YoutubePage();

    @Then("^user play the video$")
    public void user_play_the_video() {
        youtubePage.clickPlayButton();
    }

    @Then("^user pause the video$")
    public void user_pause_the_video() {
        youtubePage.clickPauseButton();
    }

    @Then("^the video is playing$")
    public void video_is_playing() {
        youtubePage.checkVideoPlaying();
    }

    @Then("^the video is paused$")
    public void video_is_paused() {
        youtubePage.checkVideoPaused();
    }

    @Then("^the video title is equal to search result$")
    public void video_title_equal_to_search_result() {
        assertEquals(youtubePage.getVideoTitle(), state.videoTitle);
    }
}