import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class EnterPage {
    private WebDriver driver;

    public EnterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.className("input pr-6 pl-6 input_type_text input_size_default");
    private By passwordField = By.className("input pr-6 pl-6 input_type_password input_size_default");
    private By authButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Войти']");
    private By registerButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Зарегистрироваться']");
    private By forgetPasswordButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Восстановить пароль']");

    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickOnForgetPasswordButton() {
        driver.findElement(forgetPasswordButton).click();
    }

    public void clickOnAuthButton() {
        driver.findElement(authButton).click();
    }

    public void setEmailToEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordToPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
}
