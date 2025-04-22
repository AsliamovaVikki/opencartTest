package org.opencart.locators;

import org.openqa.selenium.By;

public class ProductsLocators {
    public static final By CAMERAS_BUTTON = By.linkText("Cameras");
    public static final By PRODUCTS = By.className("product-layout");

    public static By xPathProduct(String product, String methodPrice) {
        String method;
        switch (methodPrice) {
            case "new":
                method = "price-new";
                break;
            case "old":
                method = "price-old";
                break;
            case "tax":
                method = "price-tax";
                break;
            default:
                throw new IllegalArgumentException("Unsupported price method: " + methodPrice);
        }

        String xpath = String.format(
                "//div[@class='caption' and .//a[contains(text(), \"%s\")]]//span[@class='%s']",
                product,
                method
        );

        return By.xpath(xpath);
    }

}
