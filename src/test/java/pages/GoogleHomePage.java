package pages;

import controls.common.Button;
import controls.common.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import env.DriverManager;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class GoogleHomePage {
    TextBox tbxSearchBox = new TextBox("name=q");

    Button btnSearch = new Button("//div[@class='tfB0Bf']//input[@name='btnK']");

    public void searchWith(String searchTerm) {
        tbxSearchBox.type(searchTerm);
    }

    public void clickOnSearchButton() {
        btnSearch.click();
    }
    public boolean checkSearchResult(String searchTerm) {
        List<WebElement> results = DriverManager.getDriver().findElements(By.cssSelector(".r"));
        for (int i = 0; i < results.size(); i++) {
            assert.assertTrue(results.get(i).getText().contains(searchTerm), "Search result validation failed at instance [ + i + ].");
        }
    }

}
