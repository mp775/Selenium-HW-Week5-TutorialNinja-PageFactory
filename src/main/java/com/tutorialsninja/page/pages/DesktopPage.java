package com.tutorialsninja.page.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistners.CustomListeners;
import com.tutorialsninja.page.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
            @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
            WebElement desktopsText;
    @CacheLookup
            @FindBy(xpath = "//h4/a")
            List<WebElement> productsList;
    @CacheLookup
            @FindBy(id ="input-sort")
            WebElement sortBy;







    public String getDesktopsText() {
        String desktop = getTextFromElement(desktopsText);
        CustomListeners.test.log(Status.PASS,"Desktop text is visisble");
        return desktop;

    }

    public ArrayList<String> getProductsNameList() {
        List<WebElement> products = getListOfElements(productsList);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        CustomListeners.test.log(Status.PASS,"Select product name from list");
        return originalProductsName;
    }
    public void selectProductByName(String product) {
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
            CustomListeners.test.log(Status.PASS,"Select product By name");
        }
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
        CustomListeners.test.log(Status.PASS,"Select sort by option");
    }
}

