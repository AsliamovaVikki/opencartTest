package org.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.opencart.locators.ProductLocators.*;


public class PageProduct extends BasePage {

    public PageProduct(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void openPage() {
        clickAndWaitForUrl(PRODUCT_LINK, "route=product/product&product_id=40");
    }

    public boolean checkCurrency(String value) {
        String currency = findElement(CURRENCY).getText();
        return currency.equals(value);
    }

    public void switchCurrency() {
        click(CURRENCY_DD);
    }

    public void switchCurrencyToEuro() {
        switchCurrency();
        click(CURRENCY_EURO);
        waitSwitch(CURRENCY, "€");
    }

    public void switchCurrencyToPound() {
        switchCurrency();
        click(CURRENCY_POUND);
        waitSwitch(CURRENCY, "£");
    }

    public boolean checkPrice(String value) {
        return findElement(PRODUCT_PRICE).getText().equals(value);
    }


}
