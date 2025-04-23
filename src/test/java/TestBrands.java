import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.opencart.pages.PageBrands;

public class TestBrands extends BaseTest<PageBrands> {

  public TestBrands() {
    this.classPage = PageBrands.class;
  }

  @Test
  public void testBrandsAreDisplayed() {
    List<String> expectedBrands =
        List.of("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm", "Sony");

    page.openPage();

    List<String> actualBrands = page.getBrandNames();

    for (String brand : expectedBrands) {
      assertTrue(actualBrands.contains(brand), "Brand not found: " + brand);
    }
  }
}
