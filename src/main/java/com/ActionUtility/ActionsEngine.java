package com.ActionUtility;

import java.time.Duration;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager; // Correct Log4j 2.x import
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsEngine {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor jse;

    // Correct Log4j 2.x logger initialization
    private static final Logger logger = LogManager.getLogger(ActionsEngine.class);

    public ActionsEngine(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    public void sendKeys_Custom(WebElement webElement, String valueToBeSent, String inputBoxFieldName)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.sendKeys(valueToBeSent);
            // Log the actions performed
            logger.info(inputBoxFieldName + " value has been entered in the input box");
        } catch (Exception e) {
            logger.error(inputBoxFieldName + " unable to enter the value in the field", e);
        }
    }

    public String getTitle_Custom()
    {
        String actualTitle = null;
        try {
            actualTitle = driver.getTitle();
            logger.info("Title is retrieved");
        } catch (Exception e) {
            logger.error("Unable to retrieve the title", e);
        }
        return actualTitle;
    }

    public void click_Custom(WebElement webElement, String fieldName)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.click();
            logger.info(fieldName + " is clicked");
        } catch (Exception e) {
            logger.error(fieldName + " is not clicked", e);
        }
    }
}
