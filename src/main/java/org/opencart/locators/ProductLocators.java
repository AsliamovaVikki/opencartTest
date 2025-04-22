package org.opencart.locators;

import org.openqa.selenium.By;

public class ProductLocators {
    public static final By CURRENCY = By.tagName("strong");
    public static final By CURRENCY_DD = By.className("fa-caret-down");
    public static final By CURRENCY_EURO = By.name("EUR");
    public static final By CURRENCY_POUND = By.name("GBP");
    public static final By PRODUCT_LINK = By.linkText("iPhone");
    public static final By PRODUCT_PRICE = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2");
}
