package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlistners.CustomListeners;
import com.tutorialsninja.page.pages.ComponentsPage;
import com.tutorialsninja.page.pages.DesktopPage;
import com.tutorialsninja.page.pages.HomePage;
import com.tutorialsninja.page.pages.LaptopAndNoteBookPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopManuTest extends BaseTest {
        HomePage homePage;
        DesktopPage desktopPage;
        LaptopAndNoteBookPage laptopsAndNotebooksPage;
        ComponentsPage componentsPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression","regression1"})
        public void inIt(){
            homePage = new HomePage();
            desktopPage = new DesktopPage();
            laptopsAndNotebooksPage = new LaptopAndNoteBookPage();
            componentsPage = new ComponentsPage();
        }


        @Test(groups = {"sanity"})
        public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
            homePage.mouseHoverOnDesktopsLinkAndClick();
            homePage.selectMenu("Show All Desktops");
            String expectedText = "Desktops";
            String actualText = desktopPage.getDesktopsText();
            Assert.assertEquals(actualText, expectedText, "Not navigate to Desktop page");
        }

        @Test(groups = {"smoke"})
        public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
            homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
            homePage.selectMenu("Show All Laptops & Notebooks");
            Assert.assertEquals(laptopsAndNotebooksPage.getLaptopsAndNotebooksText(),
                    "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
        }

        @Test(groups = {"regression"})
        public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
            homePage.mouseHoverOnComponentLinkAndClick();
            homePage.selectMenu("Show All Components");
            Assert.assertEquals(componentsPage.getComponentsText(),
                    "Components", "Not navigate to Laptops and Notebooks page");
        }

    }

