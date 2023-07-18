package com.tutorialsninja.page.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistners.CustomListeners;
import com.tutorialsninja.page.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountRegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement LastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;
    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subscribeRadios;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;


    public String getRegisterAccountText() {
        String regAccountText = getTextFromElement(registerAccountText);
        CustomListeners.test.log(Status.PASS,"Register Account Text is Displayed ");
        return regAccountText;
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstNameField, fName);
        CustomListeners.test.log(Status.PASS,"Enter first name");
    }

    public void enterLastName(String lName) {
        sendTextToElement(LastNameField, lName);
        CustomListeners.test.log(Status.PASS,"Enter Lastname");
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter Email");
    }

    public void enterTelephone(String telephone) {
        sendTextToElement(telephoneField, telephone);
        CustomListeners.test.log(Status.PASS,"Enter Telephone number");
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password");
    }

    public void enterConfirmPassword(String cPassword) {
        sendTextToElement(passwordConfirmField, cPassword);
        CustomListeners.test.log(Status.PASS,"conform password");
    }

    public void selectSubscription(String option) {
        webElementList(subscribeRadios, option);
        CustomListeners.test.log(Status.PASS,"select subscription option");
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS,"Click on Privacy policy checkbox");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"click on continue button");
    }

}


