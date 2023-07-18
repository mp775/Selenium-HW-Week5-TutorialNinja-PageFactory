package com.tutorialsninja.page.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistners.CustomListeners;
import com.tutorialsninja.page.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaptopAndNoteBookPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;


    public String getLaptopsAndNotebooksText() {
        String lapAndNot =  getTextFromElement(laptopsAndNotebooksText);
        CustomListeners.test.log(Status.PASS,"Visible laptop and notebook text");
        return lapAndNot;
    }

    public ArrayList<Double> getProductsPriceList() {
        List<WebElement> products = getListOfElements(productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
            CustomListeners.test.log(Status.PASS,"Displayed product Price list");
        }
        return originalProductsPrice;
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
        CustomListeners.test.log(Status.PASS,"Select sort by option");

    }

    public void selectProductByName(String product) {
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
            CustomListeners.test.log(Status.PASS,"Select product by name");

        }
    }
}


