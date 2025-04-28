package org.opencart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.opencart.locators.ProductLocators.*;
import static org.opencart.pages.Routers.IPHONE_URL;

public class PageProduct extends BasePage {

	public PageProduct(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@Step("Open product page")
	public void openPage() {
		clickAndWaitForUrl(PRODUCT_LINK, IPHONE_URL);
	}

	@Step("Currency check")
	public boolean checkCurrency(String value) {
		String currency = findElement(CURRENCY).getText();
		return currency.equals(value);
	}

	@Step("Switch currency")
	public void switchCurrency() {
		click(CURRENCY_DD);
	}

	@Step("Switch currency to EUR")
	public void switchCurrencyToEuro() {
		switchCurrency();
		click(CURRENCY_EURO);
		waitSwitch(CURRENCY, "€");
	}

	@Step("Switch currency to GBP")
	public void switchCurrencyToPound() {
		switchCurrency();
		click(CURRENCY_POUND);
		waitSwitch(CURRENCY, "£");
	}

	@Step("Check price")
	public boolean checkPrice(String value) {
		return findElement(PRODUCT_PRICE).getText().equals(value);
	}
}
