package org.opencart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.opencart.locators.ProductsLocators.CAMERAS_BUTTON;
import static org.opencart.locators.ProductsLocators.xPathProduct;
import static org.opencart.locators.ShowAllDesktopsLocators.PRODUCTS;
import static org.opencart.pages.Routers.CAMERAS_URL;

public class PageProducts extends BasePage {

	public PageProducts(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void openPage() {
		clickAndWaitForUrl(CAMERAS_BUTTON, CAMERAS_URL);
	}

	@Step("Check count products")
	public boolean checkCountProducts(String value) {
		return checkCount(PRODUCTS, value);
	}

	@Step("Check price product")
	public boolean checkPriceProduct(String nameProduct, String methodPrice, String price) {
		String priceProduct = findElement(xPathProduct(nameProduct, methodPrice)).getText();
		return priceProduct.equals(price);
	}
}
