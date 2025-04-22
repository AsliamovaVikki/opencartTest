import org.junit.jupiter.api.Test;
import org.opencart.pages.PageProduct;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestProduct extends BaseTest<PageProduct> {

    public TestProduct() {
        this.classPage = PageProduct.class;
    }

    @Test
    public void testCheckCurrencyOnMainPage() {
        String value = "$";
        assertTrue(page.checkCurrency(value), "Currency is not " + value);
    }

    @Test
    public void testCheckPriceOfProduct() {
        String value = "$123.20";
        page.openPage();
        assertTrue(page.checkPrice(value), "Price is not " + value);
    }

    @Test
    public void testCheckPriceOfProductAfterSwitchCurrencyToEuro() {
        String value = "96.66€";
        page.openPage();
        page.switchCurrencyToEuro();
        assertTrue(page.checkPrice(value), "Price is not " + value);
    }

    @Test
    public void testCheckPriceOfProductAfterSwitchCurrencyToPound() {
        String value = "£75.46";
        page.openPage();
        page.switchCurrencyToPound();
        assertTrue(page.checkPrice(value), "Price is not " + value);
    }

}

