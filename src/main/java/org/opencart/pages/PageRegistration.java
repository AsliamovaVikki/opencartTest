package org.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.opencart.locators.RegisterLocators.*;

public class PageRegistration extends BasePage {

    public PageRegistration(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openPage() {
        click(DD_MY_ACCOUNT);
        clickAndWaitForUrl(REG_BUTTON, "route=account/register");

    }

    public void fillRegisterForm(String firstName, String lastName, String email, String telephone, String password, String confirm) {
        Map<By, String> fieldData = Map.of(
                FIRST_NAME, firstName,
                LAST_NAME, lastName,
                EMAIL, email,
                PHONE, telephone,
                PASSWORD, password,
                CONFIRM, confirm
        );

        fieldData.forEach(this::fillFields);
    }

    public void confirmForm() {
        click(CHECKBOX_AGREE);
        clickAndWaitForUrl(CONTINUE_BUTTON, "route=account/success");
    }

    public boolean checkRegister(String expectedText) {
        String currentText = getText(SUBMIT_TEXT);
        return currentText.equals(expectedText);
    }

}
