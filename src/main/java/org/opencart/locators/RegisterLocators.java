package org.opencart.locators;

import org.openqa.selenium.By;

public class RegisterLocators {
  public static final By DD_MY_ACCOUNT = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
  public static final By FIRST_NAME = By.id("input-firstname");
  public static final By LAST_NAME = By.id("input-lastname");
  public static final By EMAIL = By.id("input-email");
  public static final By PHONE = By.id("input-telephone");
  public static final By PASSWORD = By.id("input-password");
  public static final By CONFIRM = By.id("input-confirm");
  public static final By REG_BUTTON = By.linkText("Register");
  public static final By CHECKBOX_AGREE = By.name("agree");
  public static final By CONTINUE_BUTTON = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
  public static final By SUBMIT_TEXT = By.tagName("h1");
}
