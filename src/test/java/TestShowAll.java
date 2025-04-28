import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opencart.pages.PageShowAllDesktops;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Products")
@Feature("Sorting")
@ExtendWith(AllureJunit5.class)
public class TestShowAll extends BaseTest<PageShowAllDesktops> {

	public TestShowAll() {
		this.classPage = PageShowAllDesktops.class;
	}

	@Test
	@Story("Checking sorting inShow")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Correct display of the quantity of goods on page by value of 20 filter of inShow")
	public void testValueInShowDropdown() {
		String value = "20";

		page.openPage();

		assertTrue(page.checkInShow(value), "Value is invalid: " + value);
	}

	@Test
	@Story("Checking sorting inSortBy")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Correct sorting on page by default value of the InSortedBy filter")
	public void testValueInSortByDropdown() {
		String value = "Default";
		page.openPage();

		assertTrue(page.checkInSortBy(value), "Value is invalid: " + value);
	}

	@Test
	@Story("Checking sorting inShow")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Correct display of the quantity of goods on page by value of 12 filter of inShow")
	public void testCountProducts() {
		String value = "12";
		page.openPage();

		assertTrue(page.checkCountProducts(value), "Value is invalid: " + value);
	}

	@Test
	@Story("Checking sorting inShow")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Correct display of the quantity of goods on page by value of 25 filter of inShow")
	public void testSwitchShowDD() {
		String value = "25";
		String currentProducts = "12";
		page.openPage();
		page.switchShowDD(value);

		assertTrue(page.checkInShow(value), "Value is invalid: " + value);
		assertTrue(page.checkCountProducts(currentProducts), "Value is invalid: " + value);
	}

	@Test
	@Story("Pagination")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Correct display of the pagination on page")
	public void testCheckPaginationText() {
		String value = "Showing 1 to 12 of 12 (1 Pages)";
		page.openPage();
		assertTrue(page.checkPaginationText(value), "Value is invalid: " + value);
		page.scrollPage();
		assertTrue(page.checkPaginationLocate(), "Pagination is not on down page");
	}

	@Test
	@Story("Correct alphabet sorting")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Correct alphabet sorting on page FROM A to Z")
	public void testSortByAlphabetOrder() {
		String value = "Name (A - Z)";
		page.openPage();
		page.switchSortByDD(value);
		assertTrue(page.checkAlphabetOrder(), "Products is not sorted: " + value);
	}

	@Test
	@Story("Correct price sorting")
	@Severity(SeverityLevel.CRITICAL)
	@DisplayName("Correct price sorting on page FROM LOW TO HIGH")
	public void testSortByPriceOrder() {
		String value = "Price (Low > High)";
		page.openPage();
		page.switchSortByDD(value);
		assertTrue(page.checkPriceOrder(), "Products is not sorted: " + value);
	}
}
