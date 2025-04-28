import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opencart.pages.PageBrands;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Library")
@Feature("Filter by Brands")

public class TestBrands extends BaseTest<PageBrands> {

	public TestBrands() {
		this.classPage = PageBrands.class;
	}


	@Test
	@Story("Checking brands")
	@Severity(SeverityLevel.NORMAL)
	@DisplayName("Check successfully display brands list on Brands page")
	@Description("The test checks the successful opening of the Brands page and availability on the list of the required brands")
	@ExtendWith(AllureJunit5.class)
	@Tag("smoke")
	public void testBrandsAreDisplayed() {
		List<String> expectedBrands =
				List.of("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm", "Sony");

		Allure.step("The Brands page opens");
		page.openPage();


		Allure.step("Check the availability of brands on the page");
		List<String> actualBrands = page.getBrandNames();

		for (String brand : expectedBrands) {
			assertTrue(actualBrands.contains(brand), "Brand not found: " + brand);
		}
	}


}
