import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opencart.pages.PageProduct;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Product")
@Feature("Product info")
@ExtendWith(AllureJunit5.class)

public class TestProduct extends BaseTest<PageProduct> {

	public TestProduct() {
		this.classPage = PageProduct.class;
	}

	@Test
	@Story("Checking currency")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Check currency on main page")
	public void testCheckCurrencyOnMainPage() {
		String value = "$";
		assertTrue(page.checkCurrency(value), "Currency is not " + value);
	}

	@Test
	@Story("Checking price")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Check price of product on the Product page")
	public void testCheckPriceOfProduct() {
		String value = "$123.20";
		page.openPage();
		assertTrue(page.checkPrice(value), "Price is not " + value);
	}

	@Test
	@Story("Corrective Currency Change to Euro")
	@Severity(SeverityLevel.CRITICAL)
	@DisplayName("Checking the correct reflection of the price of goods after changing currency to euro")
	public void testCheckPriceOfProductAfterSwitchCurrencyToEuro() {
		String value = "96.66€";
		page.openPage();
		page.switchCurrencyToEuro();
		assertTrue(page.checkPrice(value), "Price is not " + value);
	}

	@Test
	@Story("Corrective Currency Change to Pound")
	@Severity(SeverityLevel.CRITICAL)
	@DisplayName("Checking the correct reflection of the price of goods after changing currency to pound")
	public void testCheckPriceOfProductAfterSwitchCurrencyToPound() {
		String value = "£75.46";
		page.openPage();
		page.switchCurrencyToPound();
		assertTrue(page.checkPrice(value), "Price is not " + value);
	}
}
