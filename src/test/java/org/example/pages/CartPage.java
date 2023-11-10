package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.base.BaseTest;

public class CartPage extends BaseTest {

    private final Page page;
    private final String checkoutBtn = "//button[@data-test='checkout']";
    private final String firstNameField = "//input[@name='firstName']";
    private final String lastNameField = "//input[@name='lastName']";
    private final String zipCodeField = "//input[@name='postalCode']";
    private final String finishBtn = "//button[@data-test='finish']";
    private final String continueBtn = "//input[@name='continue']";

    public CartPage(Page page) {
        this.page = page;
    }

    public CartPage clickCheckout() {
        page.locator(checkoutBtn).click();
        return this;
    }

    public CartPage fillFirstName(String firstName) {
        page.locator(firstNameField).fill(firstName);
        return this;
    }

    public CartPage fillLastName(String lastName) {
        page.locator(lastNameField).fill(lastName);
        return this;
    }

    public CartPage fillZipCode(String zipCode) {
        page.locator(zipCodeField).fill(zipCode);
        return this;
    }

    public CartPage clickFinishBtn() {
        page.locator(finishBtn).click();
        return this;
    }

    public CartPage clickContinueBtn() {
        page.locator(continueBtn).click();
        return this;
    }
}
