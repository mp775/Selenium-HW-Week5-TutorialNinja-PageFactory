package com.tutorialsninja.page.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistners.CustomListeners;
import com.tutorialsninja.page.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {
    @Deprecated
            @FindBy(xpath ="//div[@id='content']//h1" )
    WebElement shoppingCartText;
    @Deprecated
            @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
            WebElement productName;
    @Deprecated
            @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
            WebElement deliveryDate;
    @Deprecated
            @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
            WebElement model;
    @Deprecated
            @FindBy(xpath ="//div[@class = 'table-responsive']/table/tbody/tr/td[6]" )
            WebElement total;
    @Deprecated
            @FindBy(xpath = "//input[contains(@name, 'quantity')]")
            WebElement qtyField;
    @Deprecated
            @FindBy(xpath ="//button[contains(@data-original-title, 'Update')]" )
            WebElement qtyUpdateBtn;
    @Deprecated
            @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
            WebElement successModifiedMessage;



    public String getShoppingCartText() {

        String shoppingCart = getTextFromElement(shoppingCartText);
        CustomListeners.test.log(Status.PASS,"Shopping cart text is displayed");
        return shoppingCart;
    }

    public String getProductName() {

        String prodName = getTextFromElement(productName);
        CustomListeners.test.log(Status.PASS,"Product name text is displayed");
        return prodName;
    }

    public String getDeliveryDate() {

        String deliDate = getTextFromElement(deliveryDate);
        CustomListeners.test.log(Status.PASS,"Delivery Date is displayed");
        return deliDate;
    }

    public String getModel() {
        String number = getTextFromElement(model);
        CustomListeners.test.log(Status.PASS,"Model is displayed");
        return number;
    }

    public String getTotal() {

        String totalAmount = getTextFromElement(total);
        CustomListeners.test.log(Status.PASS,"total is displayed");
        return totalAmount;
    }

    public void changeQuantity(String qty) {
        sendTextToElement(qtyField, qty);
    }

    public void clickOnQtyUpdateButton() {
        clickOnElement(qtyUpdateBtn);
        CustomListeners.test.log(Status.PASS,"Click on Qut update button");
    }

    public String getSuccessModifiedMessage() {
        String modifieProduct = getTextFromElement(successModifiedMessage);
        CustomListeners.test.log(Status.PASS,"verify Success modified message");
        return modifieProduct;
    }
}

