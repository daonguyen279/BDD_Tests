package pages;

import controls.common.Button;
import controls.common.Label;

public class YoutubePage {
    Label title = new Label("css=h1.title .style-scope.ytd-video-primary-info-renderer");
    Button btnPlay = new Button("css=.ytp-play-button.ytp-button");

    public boolean checkVideoPlaying() {
        return btnPlay.getRuntimeElement().getAttribute("title").equals("Pause (k)");
    }

    public boolean checkVideoPaused() {
        return btnPlay.getRuntimeElement().getAttribute("title").equals("Play (k)");
    }

    public void clickPlayButton() {
        if (checkVideoPaused()) {
            btnPlay.clickWithJs();
        }
    }

    public void clickPauseButton() {
        if (checkVideoPlaying()) {
            btnPlay.clickWithJs();
        }
    }

    public String getVideoTitle() {
        return title.getText();
    }
}
