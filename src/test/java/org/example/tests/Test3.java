package org.example.tests;

import org.example.base.BaseTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Test3 extends BaseTest {

    @Test
    public void validLogInTest() {
        loginPage.logIn();
        assertThat(page.locator("//div[@class='app_logo' and text()='Swag Labs']")).isVisible();
    }

    @Test
    public void createOrder() {
        loginPage.logIn().addToCartFirstItem()
                .navigateToCartPage()
                .clickCheckout()
                .fillFirstName("Kolya")
                .fillLastName("Nikolay")
                .fillZipCode("20800")
                .clickContinueBtn()
                .clickFinishBtn();
        assertThat(page.getByText("Thank you for your order!")).isVisible();
    }

    @Test
    public void createOrderWithInvalidCustomerInfo() {
        loginPage.logIn().addToCartFirstItem()
                .navigateToCartPage()
                .clickCheckout()
                .fillFirstName("")
                .clickContinueBtn();
        assertThat(page.getByText("Error: First Name is required")).isVisible();
    }
}
