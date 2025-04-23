package org.opencart.utils;

import com.github.javafaker.Faker;

/**
 * Модель випадкового користувача для автотестів.
 *
 * <p>Генерує випадкові значення імені, прізвища, email, телефону та пароля за допомогою бібліотеки
 * {@link Faker}.
 *
 * <p>Використовується для заповнення форм реєстрації та інших сценаріїв, де потрібні
 * унікальні/рандомні користувачі.
 *
 * @author Viki
 * @version 1.0
 */
public class RandomUser {
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String phone;
  private final String password;

  /**
   * Конструктор, що генерує нового випадкового користувача. Всі поля створюються автоматично за
   * допомогою {@link Faker}.
   */
  public RandomUser() {
    Faker faker = new Faker();
    this.firstName = faker.name().firstName();
    this.lastName = faker.name().lastName();
    this.email = faker.internet().emailAddress();
    this.phone = faker.phoneNumber().cellPhone();
    this.password = faker.internet().password();
  }

  /**
   * @return Імʼя користувача
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return Прізвище користувача
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return Email користувача
   */
  public String getEmail() {
    return email;
  }

  /**
   * @return Номер телефону користувача
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @return Пароль користувача
   */
  public String getPassword() {
    return password;
  }
}
