package org.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.opencart.locators.BrandsLocators.BRANDS_ELEMENTS;
import static org.opencart.locators.BrandsLocators.BRANDS_LINK;

/**
 * Brands Page Page.
 * Contains methods to open a page and obtain a brand list.
 */
public class PageBrands extends BasePage {

    public PageBrands(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Click on the link in the "Brands" foot and waiting for a transition to a brand page.
     */
    public void openPage() {
        clickAndWaitForUrl(BRANDS_LINK, "route=product/manufacturer");
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
