import org.junit.jupiter.api.Test;
import org.opencart.pages.PageRegistration;
import org.opencart.utils.RandomUser;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestRegister extends BaseTest<PageRegistration> {
    private final RandomUser user = new RandomUser();

    public TestRegister() {
        this.classPage = PageRegistration.class;
    }

    @Test
    public void testRegisterAccount() {
        String expectedText = "Your Account Has Been Created!";

        page.openPage();

        page.fillRegisterForm(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                user.getPassword());

        page.confirmForm();
        assertTrue(page.checkRegister(expectedText), "Register is successful");
    }

}

