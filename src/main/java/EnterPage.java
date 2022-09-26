import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterPage {
    private WebDriver driver;

    public EnterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath(".//fieldset[1]//input");
    private By passwordField = By.xpath(".//fieldset[2]//input");
    private By authButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']");
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

    public String getPageUrl() {
        WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(authButton));
        return driver.getCurrentUrl();
    }
}
