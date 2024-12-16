package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;

public class SeleniumGridTest {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) throws Exception {
        // Declare WebDriver capabilities and options
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");  // Essential for running in Docker
            options.addArguments("--disable-dev-shm-usage");  // Avoid memory issues in Docker
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } else {
            throw new Exception("Browser not supported: " + browser);
        }
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        System.out.println("Google URL: " + driver.getCurrentUrl());
        System.out.println("Google Title: " + driver.getTitle());
    }

    @Test
    public void testWikipediaSearch() {
        driver.get("https://www.wikipedia.org");
        System.out.println("Wikipedia URL: " + driver.getCurrentUrl());
        System.out.println("Wikipedia Title: " + driver.getTitle());
    }

    @Test
    public void testYahooSearch() {
        driver.get("https://www.yahoo.com");
        System.out.println("Yahoo URL: " + driver.getCurrentUrl());
        System.out.println("Yahoo Title: " + driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
