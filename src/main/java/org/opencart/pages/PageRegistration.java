package org.opencart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.opencart.locators.RegisterLocators.*;
import static org.opencart.pages.Routers.REGISTER_URL;
import static org.opencart.pages.Routers.SUBMIT_REGISTER_URL;

public class PageRegistration extends BasePage {


	public PageRegistration(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@Step("Open registration page")
	public void openPage() {
		click(DD_MY_ACCOUNT);
		clickAndWaitForUrl(REG_BUTTON, REGISTER_URL);
	}

	@Step("Fill registration form")
	public void fillRegisterForm(
			String firstName,
			String lastName,
			String email,
			String telephone,
			String password,
			String confirm) {
		Map<By, String> fieldData =
				Map.of(
						FIRST_NAME, firstName,
						LAST_NAME, lastName,
						EMAIL, email,
						PHONE, telephone,
						PASSWORD, password,
						CONFIRM, confirm);

		fieldData.forEach(this::fillFields);
	}

	@Step("Confirm registration form")
	public void confirmForm() {
		click(CHECKBOX_AGREE);
		clickAndWaitForUrl(CONTINUE_BUTTON, SUBMIT_REGISTER_URL);
	}

	@Step("Check registration form")
	public boolean checkRegister(String expectedText) {
		String currentText = getText(SUBMIT_TEXT);
		return currentText.equals(expectedText);
	}
}
