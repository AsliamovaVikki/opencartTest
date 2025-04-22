import org.junit.jupiter.api.Test;
import org.opencart.pages.PageShowAllDesktops;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestShowAll extends BaseTest<PageShowAllDesktops> {

    public TestShowAll() {
        this.classPage = PageShowAllDesktops.class;
    }

    @Test
    public void testValueInShowDropdown() {
        String value = "20";

        page.openPage();

        assertTrue(page.checkInShow(value), "Value is invalid: " + value);

    }

    @Test
    public void testValueInSortByDropdown() {
        String value = "Default";
        page.openPage();

        assertTrue(page.checkInSortBy(value), "Value is invalid: " + value);
    }

    @Test
    public void testCountProducts() {
        String value = "12";
        page.openPage();

        assertTrue(page.checkCountProducts(value), "Value is invalid: " + value);
    }

    @Test
    public void testSwitchShowDD() {
        String value = "25";
        String currentProducts = "12";
        page.openPage();
        page.switchShowDD(value);

        assertTrue(page.checkInShow(value), "Value is invalid: " + value);
        assertTrue(page.checkCountProducts(currentProducts), "Value is invalid: " + value);


    }

    @Test
    public void testCheckPaginationText() {
        String value = "Showing 1 to 12 of 12 (1 Pages)";
        page.openPage();
        assertTrue(page.checkPaginationText(value), "Value is invalid: " + value);
        page.scrollPage();
        assertTrue(page.checkPaginationLocate(), "Pagination is not on down page");


    }


}
