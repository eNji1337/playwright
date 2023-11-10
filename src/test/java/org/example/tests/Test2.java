package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.MainPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Test2 extends BaseTest {

    @Test
    public void validLogInTest() {
        loginPage.logIn();
        assertThat(page.locator("//div[@class='app_logo' and text()='Swag Labs']")).isVisible();
    }

    @Test
    public void addToCartAndRemove() {
        loginPage.logIn().addToCartFirstItem();
        assertThat(page.locator("//a[@class='shopping_cart_link']//child::span")).containsText("1");
        MainPage mainPage = new MainPage(page);
        mainPage.removeFromCartFirstItem();
    }

    @Test
    public void addAllVisibleItemsToCart() {
        loginPage.logIn().addAllVisibleItemsToCart();
        assertThat(page.locator("//a[@class='shopping_cart_link']//child::span")).containsText("6");
    }
}
