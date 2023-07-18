package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlistners.CustomListeners;
import com.tutorialsninja.page.pages.AccountRegisterPage;
import com.tutorialsninja.page.pages.HomePage;
import com.tutorialsninja.page.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class AccountRegisterPageTest extends BaseTest {

        HomePage homePage;
        AccountRegisterPage accountRegisterPage;
        MyAccountPage accountPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression","regression1"})
        public void inIt(){
            homePage = new HomePage();
            accountRegisterPage = new AccountRegisterPage();
            accountPage = new MyAccountPage();
        }

        @Test(groups = {"sanity"})
        public void verifyUserShouldNavigateToLoginPageSuccessfully() {
            homePage.clickOnMyAccountTab();
            homePage.selectMyAccountOptions("Register");
            Assert.assertEquals(accountRegisterPage.getRegisterAccountText(),
                    "Register Account", "Register page not displayed");
        }

        @Test(groups = {"regression"})
        public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
            homePage.clickOnMyAccountTab();
            homePage.selectMyAccountOptions("Register");
            accountRegisterPage.enterFirstName("prime" + getRandomString(4));
            accountRegisterPage.enterLastName("test" + getRandomString(4));
            accountRegisterPage.enterEmail("prime" + getRandomString(4) + "@gmail.com");
            accountRegisterPage.enterTelephone("07988112233");
            accountRegisterPage.enterPassword("test123");
            accountRegisterPage.enterConfirmPassword("test123");
            accountRegisterPage.selectSubscription("Yes");
            accountRegisterPage.clickOnPrivacyPolicyCheckBox();
            accountRegisterPage.clickOnContinueButton();
            Assert.assertEquals(accountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                    "Account not created");
            accountPage.clickOnContinueButton();
            homePage.clickOnMyAccountTab();
            homePage.selectMyAccountOptions("Logout");
            Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
            accountPage.clickOnContinueButton();
        }

    }

