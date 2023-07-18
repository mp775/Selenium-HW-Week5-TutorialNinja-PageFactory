package com.tutorialsninja.page.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistners.CustomListeners;
import com.tutorialsninja.page.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;


    public String getReturningCustomerText() {
        String customerText = getTextFromElement(returningCustomerText);
        CustomListeners.test.log(Status.PASS,"Returning customer text");
        return customerText;

    }

    public String getNewCustomerText() {
        String newCustomer = getTextFromElement(newCustomerText);
        CustomListeners.test.log(Status.PASS,"Returning  new customer text");
        return newCustomer;
    }

    public void enterEmailAddress(String email) {

        sendTextToElement(emailAddressField, email);
    }

    public void enterPassword(String password) {

        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"Click on Login Button");
    }

}

