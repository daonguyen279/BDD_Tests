package controls.base;

import org.openqa.selenium.Keys;

public class Editable extends BaseControl {
    public void clear() {
        this.getRuntimeElement().clear();
    }

    public void type(String content) {
        this.getRuntimeElement().sendKeys(content);
    }

    public void type(Keys key) {
        this.getRuntimeElement().sendKeys(key);
    }

    public String getValue() {
        return this.getRuntimeElement().getAttribute("value");
    }
}
