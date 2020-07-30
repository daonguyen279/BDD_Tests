package controls.base;

import org.openqa.selenium.support.ui.Select;

public class Clickable extends BaseControl {

    public void click() {
        scrollIntoView();
        this.getRuntimeElement().click();
    }

    public void selectByVisibleText(String value) {
        scrollIntoView();
        Select select = new Select(getRuntimeElement());
        select.selectByVisibleText(value);
    }

}
