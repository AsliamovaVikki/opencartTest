import org.junit.jupiter.api.Test;
import org.opencart.pages.PageProducts;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProducts extends BaseTest<PageProducts> {

    public TestProducts() {
        this.classPage = PageProducts.class;
    }

    @Test
    public void testCheckExistProduct() {
        String value = "2";
        page.openPage();
        assertTrue(page.checkCountProducts(value), "Value is invalid: " + value);
    }

    @Test
    public void testCheckProductPriceNew() {
        String productName = "Canon EOS 5D";
        String methodPrice = "new";
        String price = "$98.00";

        page.openPage();
        assertTrue(page.checkPriceProduct(productName, methodPrice, price), "Price is not correct " + price);
    }

    @Test
    public void testCheckProductPriceOld() {
        String productName = "Canon EOS 5D";
        String methodPrice = "old";
        String price = "$122.00";

        page.openPage();
        assertTrue(page.checkPriceProduct(productName, methodPrice, price), "Price is not correct " + price);
    }

    @Test
    public void testCheckProductPriceTax() {
        String productName = "Nikon D300";
        String methodPrice = "tax";
        String price = "Ex Tax: $80.00";

        page.openPage();
        assertTrue(page.checkPriceProduct(productName, methodPrice, price), "Price is not correct " + price);
    }
}

