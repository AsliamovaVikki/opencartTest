package org.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.opencart.locators.ShowAllDesktopsLocators.*;


public class PageShowAllDesktops extends BasePage {

    public PageShowAllDesktops(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openPage() {
        cursorGuidance(DESKTOPS);
        clickAndWaitForUrl(SHOW_ALL, "route=product/category&path=20");

    }

    public boolean checkInShow(String value) {
        return dropdownSelectCheck(OPTION_SHOW, value);
    }

    public boolean checkInSortBy(String value) {
        return dropdownSelectCheck(OPTION_SORT, value);
    }

    public boolean checkCountProducts(String value) {
        String currentCountProducts = Integer.toString(findElements(PRODUCTS).size());
        return currentCountProducts.equals(value);
    }

    public void switchShowDD(String value) {
        switchSelect(OPTION_SHOW, value);
    }

    public void switchSortByDD(String value) {
        switchSelect(OPTION_SORT, value);
    }

    public WebElement getPagination() {
        return findElement(PAGINATION);
    }


    public boolean checkPaginationText(String value) {
        String textPagination = getPagination().getText();
        return textPagination.equals(value);
    }

    public void scrollPage() {
        executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public boolean checkPaginationLocate() {
        WebElement pagination = getPagination();
        return pagination.isDisplayed();
    }

}