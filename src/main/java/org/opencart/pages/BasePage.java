package org.opencart.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Basic class for all pages. Contains general methods of interaction with page element
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void select(By locator, String visibleText) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(visibleText);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void cursorGuidance(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public void fillFields(By locator, String value) {
        WebElement field = driver.findElement(locator);
        field.clear();
        field.sendKeys(value);
    }

    public void switchSelect(By locator, int index) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(index);
    }

    public String getFirstSelectedOption(By locator) {
        Select dropdown = new Select(driver.findElement(locator));
        return dropdown.getFirstSelectedOption().getText();
    }

    public Object executeScript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script, args);
    }

    public void clickAndWaitForUrl(By locator, String expectedUrlSubstring, int timeoutSeconds) {
        driver.findElement(locator).click();
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(d -> d.getCurrentUrl().contains(expectedUrlSubstring));
    }
}
