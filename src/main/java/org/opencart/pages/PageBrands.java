package org.opencart.pages;

import static org.opencart.locators.BrandsLocators.BRANDS_ELEMENTS;
import static org.opencart.locators.BrandsLocators.BRANDS_LINK;
import static org.opencart.pages.Routers.BRANDS_URL;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Brands Page Page. Contains methods to open a page and obtain a brand list. */
public class PageBrands extends BasePage {

  public PageBrands(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  /** Click on the link in the "Brands" foot and waiting for a transition to a brand page. */
  public void openPage() {
    clickAndWaitForUrl(BRANDS_LINK, BRANDS_URL);
  }

  /**
   * Get a list of brands that are present on the page.
   *
   * @return List of brand names
   */
  public List<String> getBrandNames() {
    return getElementsText(BRANDS_ELEMENTS);
  }
}
