package pages;

import utils.ElementActions;
import utils.FrameUtils;
import utils.MouseActions;
import utils.WindowUtils;

public class BasePage {

    protected ElementActions elementActions;
    protected MouseActions mouseActions;
    protected WindowUtils windowUtils;
    protected FrameUtils frameUtils;

    public BasePage() {

        this.elementActions = new ElementActions();
        this.mouseActions = new MouseActions();
        this.windowUtils = new WindowUtils();
        this.frameUtils = new FrameUtils();

    }
}
