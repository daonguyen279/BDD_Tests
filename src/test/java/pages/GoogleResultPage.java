package pages;

import controls.common.TextBox;
import env.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleResultPage {
    TextBox tbxSearchBox = new TextBox("name=q");

    public List<WebElement> getWebResults() {
        return DriverManager.getDriver().findElements(By.xpath("//div[@class=\"g\" and h2/text()=\"Web results\"]/div[@class=\"rc\"]"));
    }

    public List<WebElement> getPeopleAskResults() {
        return DriverManager.getDriver().findElements(By.cssSelector(".related-question-pair"));
    }

    public List<WebElement> getStoryResults() {
        return DriverManager.getDriver().findElements(By.xpath("//g-section-with-header[div/h3[@role=\"heading\" and text()=\"Top stories\"]]//div[@role=\"listitem\"]"));
    }

    public List<WebElement> getVideoResults() {
        return DriverManager.getDriver().findElements(By.xpath("//g-section-with-header[div/h3[@role=\"heading\" and text()=\"Videos\"]]//g-scrolling-carousel//g-inner-card"));
    }

    public String getSearchBoxText() {
        return tbxSearchBox.getValue();
    }

    public boolean checkSearchWebResults(String searchTerm) {
        String searchTermLowercase = searchTerm.toLowerCase();
        List<WebElement> results = getWebResults();
        for (WebElement result : results) {
            if (!result.getText().toLowerCase().contains(searchTermLowercase)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSearchPeopleAskResults(String searchTerm) {
        String searchTermLowercase = searchTerm.toLowerCase();
        List<WebElement> results = getPeopleAskResults();
        for (WebElement result : results) {
            if (!result.getText().toLowerCase().contains(searchTermLowercase)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSearchStoryResults(String searchTerm) {
        String searchTermLowercase = searchTerm.toLowerCase();
        List<WebElement> results = getStoryResults();
        for (WebElement result : results) {
            if (!result.getText().toLowerCase().contains(searchTermLowercase)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSearchVideoResults(String searchTerm) {
        String searchTermLowercase = searchTerm.toLowerCase();
        List<WebElement> results = getVideoResults();
        for (WebElement result : results) {
            if (!result.getText().toLowerCase().contains(searchTermLowercase)) {
                return false;
            }
        }
        return true;
    }

    public void clickOnVideo(int index) {
        getVideoResults().get(index).click();
    }
}
