package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Test1 extends BaseTest {

    @Test
    public void invalidPassTest() {
        loginPage.enterLogin("standard_user")
                .enterPassword("standard_user")
                .clickOnLogIn();
        assertThat(page.getByText("Epic sadface: Username and password do not match any user in this service")).isVisible();
    }

    @Test
    public void noLoginTest() {
        loginPage.enterPassword("standard_user")
                .clickOnLogIn();
        assertThat(page.getByText("Epic sadface: Username is required")).isVisible();
    }

    @Test
    public void noPasswordTest() {
        loginPage.enterLogin("standard_user")
                .clickOnLogIn();
        assertThat(page.getByText("Epic sadface: Password is required")).isVisible();
    }

    @Test
    public void logOutTest() {
        loginPage.logIn().clickOnMenuBtb().clickOnLogOut();
        assertThat(page.locator("//div[@class='login_logo' and text()='Swag Labs']")).isVisible();
    }
}
