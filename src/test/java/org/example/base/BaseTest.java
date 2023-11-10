package org.example.base;

import com.microsoft.playwright.*;
import org.example.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;
import java.util.List;

public class BaseTest {

    public Page page;
    public LoginPage loginPage;
    private Browser browser;
    private BrowserContext context;
    List<String> arguments = Arrays.asList("--start-maximized");

    public void setUp() {
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setArgs(arguments)
                        .setHeadless(false)
                        .setChannel("chrome"));

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        page = context.newPage();
    }

    @BeforeMethod
    public void launchBrowser(){
        setUp();
        page.navigate("https://www.saucedemo.com/");
        loginPage = new LoginPage(page);
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        browser.close();
    }
}