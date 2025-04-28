package org.opencart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.opencart.locators.ShowAllDesktopsLocators.*;
import static org.opencart.pages.Routers.SHOW_ALL_URL;
import static org.opencart.scripts.JavaScripts.SCROLL_TO_DOWN_PAGE_JS;
import static org.opencart.utils.Utils.isSortedAscending;

public class PageShowAllDesktops extends BasePage {

	public PageShowAllDesktops(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void openPage() {
		cursorGuidance(DESKTOPS);
		clickAndWaitForUrl(SHOW_ALL, SHOW_ALL_URL);
	}

	@Step("Check in show value in the dropdown inShow")
	public boolean checkInShow(String value) {
		return dropdownSelectCheck(OPTION_SHOW, value);
	}

	@Step("Check in sort value in the dropdown inSort")
	public boolean checkInSortBy(String value) {
		return dropdownSelectCheck(OPTION_SORT, value);
	}

	@Step("Check count products")
	public boolean checkCountProducts(String value) {
		return checkCount(PRODUCTS, value);
	}

	@Step("Switch show dropdown")
	public void switchShowDD(String value) {
		switchSelect(OPTION_SHOW, value);
	}

	@Step("Switch sortBy dropdown")
	public void switchSortByDD(String value) {
		switchSelect(OPTION_SORT, value);
	}

	@Step("Get pagination")
	public WebElement getPagination() {
		return findElement(PAGINATION);
	}

	@Step("Check pagination text")
	public boolean checkPaginationText(String value) {
		String textPagination = getPagination().getText();
		return textPagination.equals(value);
	}

	@Step("Scroll page")
	public void scrollPage() {
		executeScript(SCROLL_TO_DOWN_PAGE_JS);
	}

	@Step("Check pagination locate")
	public boolean checkPaginationLocate() {
		WebElement pagination = getPagination();
		return pagination.isDisplayed();
	}

	@Step("Check alphabet order")
	public boolean checkAlphabetOrder() {
		List<WebElement> products = findElements(PRODUCTS_NAMES);
		List<String> productNames =
				products.stream().map(e -> e.getText().trim()).collect(Collectors.toList());
		return isSortedAscending(productNames, String.CASE_INSENSITIVE_ORDER);
	}

	@Step("Check price order")
	public boolean checkPriceOrder() {
		List<WebElement> products = findElements(PRODUCTS_PRICE);
		List<Double> productsPrice = new ArrayList<>();

		for (WebElement el : products) {
			String priceText = el.getText().replace("$", "").trim();
			double price = Double.parseDouble(priceText);
			productsPrice.add(price);
		}
		return isSortedAscending(productsPrice, Comparator.naturalOrder());
	}
}
