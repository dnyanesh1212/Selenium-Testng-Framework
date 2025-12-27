package pages;

import utils.ElementActions;
import utils.MouseActions;

public class BasePage {

    protected ElementActions elementActions;
    protected MouseActions mouseActions;

    public BasePage() {

        this.elementActions = new ElementActions();
        this.mouseActions = new MouseActions();

    }
}
