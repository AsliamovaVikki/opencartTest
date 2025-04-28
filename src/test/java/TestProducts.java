import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opencart.pages.PageProducts;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Epic("Product")
@Feature("Product info")
@ExtendWith(AllureJunit5.class)
public class TestProducts extends BaseTest<PageProducts> {

	public TestProducts() {
		this.classPage = PageProducts.class;
	}

	@Test
	@Story("Checking the number of products available")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Коректне відображення кількості товару за значенням {value} на сторінці Cameras")
	public void testCheckExistProduct() {
		String value = "2";
		page.openPage();
		assertTrue(page.checkCountProducts(value), "Value is invalid: " + value);
	}

	@Test
	@Story("Successful Check of a new product price")
	@Severity(SeverityLevel.CRITICAL)
	@DisplayName("Successful Check of a new product Canon EOS 5D  price 98.00$ ")
	public void testCheckProductPriceNew() {
		String productName = "Canon EOS 5D";
		String methodPrice = "new";
		String price = "$98.00";

		page.openPage();
		assertTrue(
				page.checkPriceProduct(productName, methodPrice, price), "Price is not correct " + price);
	}

	@Test
	@Story("Successful Check of an old product price")
	@Severity(SeverityLevel.CRITICAL)
	@DisplayName("Successful Check of an old product Canon EOS 5D  price $122.00$ ")
	public void testCheckProductPriceOld() {
		String productName = "Canon EOS 5D";
		String methodPrice = "old";
		String price = "$122.00";

		page.openPage();
		assertTrue(
				page.checkPriceProduct(productName, methodPrice, price), "Price is not correct " + price);
	}

	@Test
	@Story("Successful Check of a tax product price")
	@Severity(SeverityLevel.CRITICAL)
	@DisplayName("Successful Check of a tax product Nikon D300  price Ex Tax: $80.00$ ")
	public void testCheckProductPriceTax() {
		String productName = "Nikon D300";
		String methodPrice = "tax";
		String price = "Ex Tax: $80.00";

		page.openPage();
		assertTrue(
				page.checkPriceProduct(productName, methodPrice, price), "Price is not correct " + price);
	}
}
