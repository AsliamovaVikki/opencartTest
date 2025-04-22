package org.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.opencart.locators.ProductsLocators.CAMERAS_BUTTON;
import static org.opencart.locators.ProductsLocators.xPathProduct;
import static org.opencart.locators.ShowAllDesktopsLocators.PRODUCTS;


public class PageProducts extends BasePage {

    public PageProducts(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void openPage() {
        clickAndWaitForUrl(CAMERAS_BUTTON, "route=product/category&path=33");
    }

    public boolean checkCountProducts(String value) {
        return checkCount(PRODUCTS, value);
    }

    public boolean checkPriceProduct(String nameProduct, String methodPrice, String price) {
        String priceProduct = findElement(xPathProduct(nameProduct, methodPrice)).getText();
        return priceProduct.equals(price);
    }


}

