package org.opencart.pages;

import static org.opencart.locators.ProductsLocators.CAMERAS_BUTTON;
import static org.opencart.locators.ProductsLocators.xPathProduct;
import static org.opencart.locators.ShowAllDesktopsLocators.PRODUCTS;
import static org.opencart.pages.Routers.CAMERAS_URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageProducts extends BasePage {

  public PageProducts(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void openPage() {
    clickAndWaitForUrl(CAMERAS_BUTTON, CAMERAS_URL);
  }

  public boolean checkCountProducts(String value) {
    return checkCount(PRODUCTS, value);
  }

  public boolean checkPriceProduct(String nameProduct, String methodPrice, String price) {
    String priceProduct = findElement(xPathProduct(nameProduct, methodPrice)).getText();
    return priceProduct.equals(price);
  }
}
