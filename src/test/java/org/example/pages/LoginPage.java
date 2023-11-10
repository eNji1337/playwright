package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.base.BaseTest;

public class LoginPage extends BaseTest {

    private final Page page;

    private final String userNameField = "//input[@data-test='username']";
    private final String userPasswordField = "//input[@data-test='password']";
    private final String logInBtn = "//input[@data-test='login-button']";
    private final String logoHeader = "//div[@class='app_logo' and text()='Swag Labs']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public MainPage logIn() {
        page.locator(userNameField).fill("standard_user");
        page.locator(userPasswordField).fill("secret_sauce");
        page.locator(logInBtn).click();
        return new MainPage(page);
    }

    public LoginPage enterLogin(String login) {
        page.locator(userNameField).fill(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        page.locator(userPasswordField).fill(password);
        return this;
    }

    public LoginPage clickOnLogIn() {
        page.locator(logInBtn).click();
        return this;
    }

}
