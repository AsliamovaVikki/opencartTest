import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opencart.pages.PageRegistration;
import org.opencart.utils.RandomUser;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Авторизація/Автентифікація")
@Feature("Реєстрація")
@ExtendWith(AllureJunit5.class)

public class TestRegister extends BaseTest<PageRegistration> {
	private final RandomUser user = new RandomUser();

	public TestRegister() {
		this.classPage = PageRegistration.class;
	}

	@Test
	@Story("Successful user registration")
	@Severity(SeverityLevel.CRITICAL)
	@DisplayName("Checking successful registration and transition to user's personal account")
	public void testRegisterAccount() {
		String expectedText = "Your Account Has Been Created!";
		Allure.step("Opening the site page");
		page.openPage();

		Allure.step("Creating random user data");
		page.fillRegisterForm(
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getPhone(),
				user.getPassword(),
				user.getPassword());
		Allure.step("Fill in all fields of registration form and transition to a personal page!");
		page.confirmForm();
		assertTrue(page.checkRegister(expectedText), "Register is successful");
	}
}
