package com.tutorialsninja.page.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistners.CustomListeners;
import com.tutorialsninja.page.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComponentsPage extends Utility {
    @Deprecated
            @FindBy(xpath = "//h2[contains(text(),'Components')]")

    WebElement componentsText ;

    public String getComponentsText() {
        String componentElement = getTextFromElement(componentsText);
        CustomListeners.test.log(Status.PASS,"visible component text");
        return componentElement;
    }
}

