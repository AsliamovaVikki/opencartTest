package org.opencart.pages;

import org.opencart.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;


public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
    }

    public abstract void openPage();

    public void click(By locator) {
        try {
            log.info("Clicking on element: {}", locator);
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            log.error("Failed to click on element: {}", locator, e);
            throw e;
        }
    }

    public void clickAndWaitForUrl(By locator, String expectedUrlSubstring) {
        try {
            log.info("Clicking on '{}' and waiting for URL to contain: '{}'", locator, expectedUrlSubstring);
            click(locator);
            wait.until(ExpectedConditions.urlContains(expectedUrlSubstring));
            log.info("URL matched expected substring: {}", expectedUrlSubstring);
        } catch (TimeoutException e) {
            String msg = String.format("URL did not contain '%s' within %d seconds", expectedUrlSubstring, Config.TIMEOUT);
            log.error(msg);
            throw new TimeoutException(msg);
        }
    }

    public void select(By locator, String visibleText) {
        log.info("Selecting '{}' in dropdown: {}", visibleText, locator);
        Select dropdown = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
        dropdown.selectByVisibleText(visibleText);
    }

    public void switchSelect(By locator, String value) {
        log.info("Selecting value {} from dropdown: {}", value, locator);
        Select dropdown = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
        dropdown.selectByVisibleText(value);
    }

    public boolean dropdownSelectCheck(By locator, String value) {
        String currentOption = getFirstSelectedOption(locator);
        return currentOption.equals(value);
    }

    public String getFirstSelectedOption(By locator) {
        log.info("Getting first selected option from dropdown: {}", locator);
        Select dropdown = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
        return dropdown.getFirstSelectedOption().getText();
    }

    public WebElement findElement(By locator) {
        log.info("Finding element: {}", locator);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        log.info("Finding all elements: {}", locator);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public List<String> getElementsText(By locator) {
        log.info("Getting visible text for all elements with locator: {}", locator);
        return findElements(locator).stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }

    public void cursorGuidance(By locator) {
        log.info("Moving cursor to element: {}", locator);
        WebElement element = findElement(locator);
        actions.moveToElement(element).perform();
    }

    public void fillFields(By locator, String value) {
        log.info("Filling field {} with value: {}", locator, value);
        WebElement field = findElement(locator);
        field.clear();
        field.sendKeys(value);
    }

    public Object executeScript(String script, Object... args) {
        try {
            log.info("Executing JavaScript: {}", script);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript(script, args);
        } catch (Exception e) {
            log.error("Failed to execute JavaScript: {}", script, e);
            throw e;
        }
    }

    public String getText(By locator) {
        try {
            log.info("Getting text from element: {}", locator);
            return findElement(locator).getText();
        } catch (Exception e) {
            log.error("Failed to get text from element: {}", locator, e);
            throw e;
        }
    }
}
