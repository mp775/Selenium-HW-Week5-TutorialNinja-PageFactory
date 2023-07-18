package com.tutorialsninja.page.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistners.CustomListeners;
import com.tutorialsninja.page.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {
    @Deprecated
            @FindBy(xpath = "//h1[contains(text(),'Account Logout')]" )
    WebElement accountLogoutText;
    @Deprecated
            @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
            WebElement accountCreatedText;
    @Deprecated
            @FindBy(xpath = "//a[contains(text(),'Continue')]")
            WebElement continueBtn;


    public String getAccountLogoutText() {
        String accountLogout  = getTextFromElement(accountLogoutText);
        CustomListeners.test.log(Status.PASS,"Account logout text is displayed");
        return accountLogout;
    }

    public String getYourAccountHasBeenCreatedText() {
        String message =  getTextFromElement(accountCreatedText);
        CustomListeners.test.log(Status.PASS,"Your account has been created message");
        return message;
    }
    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"Click on continue button");
    }
}

