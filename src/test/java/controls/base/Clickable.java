package controls.base;

import env.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clickable extends BaseControl {

    public void click() {
        scrollIntoView();
        this.getRuntimeElement().click();
    }

    public void waitAndClick() {
        scrollIntoView();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.getRuntimeElement()));
        this.getRuntimeElement().click();
    }

    public void clickWithJs() {
        scrollIntoView();
        JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", this.getRuntimeElement());
    }

    public void selectByVisibleText(String value) {
        scrollIntoView();
        Select select = new Select(getRuntimeElement());
        select.selectByVisibleText(value);
    }
}
