package org.opencart.pages;

import static org.opencart.locators.ShowAllDesktopsLocators.*;
import static org.opencart.pages.Routers.SHOW_ALL_URL;
import static org.opencart.scripts.JavaScripts.SCROLL_TO_DOWN_PAGE_JS;
import static org.opencart.utils.Utils.isSortedAscending;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageShowAllDesktops extends BasePage {

  public PageShowAllDesktops(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void openPage() {
    cursorGuidance(DESKTOPS);
    clickAndWaitForUrl(SHOW_ALL, SHOW_ALL_URL);
  }

  public boolean checkInShow(String value) {
    return dropdownSelectCheck(OPTION_SHOW, value);
  }

  public boolean checkInSortBy(String value) {
    return dropdownSelectCheck(OPTION_SORT, value);
  }

  public boolean checkCountProducts(String value) {
    return checkCount(PRODUCTS, value);
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
    executeScript(SCROLL_TO_DOWN_PAGE_JS);
  }

  public boolean checkPaginationLocate() {
    WebElement pagination = getPagination();
    return pagination.isDisplayed();
  }

  public boolean checkAlphabetOrder() {
    List<WebElement> products = findElements(PRODUCTS_NAMES);
    List<String> productNames =
        products.stream().map(e -> e.getText().trim()).collect(Collectors.toList());
    return isSortedAscending(productNames, String.CASE_INSENSITIVE_ORDER);
  }

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
