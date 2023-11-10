package org.example.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.base.BaseTest;

import java.util.List;

public class MainPage extends BaseTest {

    private final Page page;

    private final String header = "//div[@class='header_label']//child::div";
    private final String addToCartFirstItem = "//button[@name='add-to-cart-sauce-labs-backpack']";
    private final String removeFromCartFirstItem = "//button[@data-test=\"remove-sauce-labs-backpack\"]";
    private final String addToCartBtnList = "//button[text()='Add to cart']";
    private final String cartBtn = "//a[@class='shopping_cart_link']";
    private final String menuBtn = "//button[text()='Open Menu']";
    private final String logOutBtn = "//a[text()='Logout']";

    public MainPage(Page page) {
        this.page = page;
    }

    public String getHeader() {
        return page.locator(header).getAttribute("text");
    }

    public MainPage addToCartFirstItem() {
        page.locator(addToCartFirstItem).click(new Locator.ClickOptions().setDelay(50));
        return this;
    }

    public MainPage removeFromCartFirstItem() {
        page.locator(removeFromCartFirstItem).click();
        return this;
    }

    public MainPage clickOnMenuBtb() {
        page.locator(menuBtn).click();
        return this;
    }

    public MainPage clickOnLogOut() {
        page.locator(logOutBtn).click();
        return this;
    }

    public MainPage addAllVisibleItemsToCart() {
        List<ElementHandle> addToCartBtns = page.querySelectorAll(addToCartBtnList);
//        addToCartBtns.forEach(ElementHandle::click);
        addToCartBtns.forEach(x -> x.click(new ElementHandle.ClickOptions().setDelay(150)));
        return this;
    }

    public CartPage navigateToCartPage() {
        page.locator(cartBtn).click();
        return new CartPage(page);
    }
}
