package org.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Brands Page Page.
 * Contains methods to open a page and obtain a brand list.
 */
public class PageBrands extends BasePage {

    private final By footerBrandsLink = By.xpath("//footer//a[text()='Brands']");
    private final By brandElements = By.cssSelector(".col-sm-3 a");

    public PageBrands(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Click on the link in the "Brands" foot and waiting for a transition to a brand page.
     */
    public void openBrandsPage() {
        clickAndWaitForUrl(footerBrandsLink, "route=product/manufacturer");
    }

    /**
     * Get a list of brands that are present on the page.
     *
     * @return List of brand names
     */
    public List<String> getBrandNames() {
        return getElementsText(brandElements);
    }
}
