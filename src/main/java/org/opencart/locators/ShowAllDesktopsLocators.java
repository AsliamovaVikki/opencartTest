package org.opencart.locators;

import org.openqa.selenium.By;

public class ShowAllDesktopsLocators {
  public static final By DESKTOPS = By.linkText("Desktops");
  public static final By SHOW_ALL = By.linkText("Show All Desktops");
  public static final By OPTION_SHOW = By.id("input-limit");
  public static final By OPTION_SORT = By.id("input-sort");
  public static final By PRODUCTS = By.className("product-layout");
  public static final By PRODUCTS_NAMES = By.tagName("h4");
  public static final By PRODUCTS_PRICE = By.className("price-new");
  public static final By PAGINATION = By.cssSelector("div.col-sm-6.text-right");
}
