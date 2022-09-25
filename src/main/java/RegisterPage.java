import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class RegisterPage {
   private WebDriver driver;
   public RegisterPage (WebDriver driver) {
      this.driver = driver;
   }

   private By nameField = By.xpath(".//div[@class = 'input pr-6 pl-6 input_type_text input_size_default']/label[text() = 'Имя']");
   private By emailField = By.xpath(".//div[@class = 'input pr-6 pl-6 input_type_text input_size_default']/label[text() = 'Email']");
   private By passwordField = By.xpath(".//div[@class = 'input pr-6 pl-6 input_type_text input_size_default']/label[text() = 'Пароль']");
   private By registerButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Зарегистрироваться']");
   private By enterButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");

   public void clickOnRegisterButton(){
      driver.findElement(registerButton).click();
   }

   public void clickOnEnterButton(){
      driver.findElement(enterButton).click();
   }

   public void setNameToNameField(String name) {
      Faker faker = new Faker(Locale.forLanguageTag("ru"));
      name = faker.name().firstName();
      driver.findElement(nameField).sendKeys(name);
   }

   public void setEmailToEmailField(String email) {
      Faker faker = new Faker();
      email = faker.internet().emailAddress();
      driver.findElement(emailField).sendKeys(email);
   }

   public void setPasswordToPasswordField(String password) {
      driver.findElement(passwordField).sendKeys(password);

   }
}
