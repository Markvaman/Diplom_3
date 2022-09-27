import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
   private WebDriver driver;
   public RegisterPage (WebDriver driver) {
      this.driver = driver;
   }

   private By nameField = By.xpath(".//fieldset[1]//input");
   private By emailField = By.xpath(".//fieldset[2]//input");
   private By passwordField = By.xpath(".//fieldset[3]//input");
   private By registerButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться']");
   private By enterButton = By.xpath(".//a[text()='Войти']");

   private final By errorPassword = By.xpath(".//*[@class='input__error text_type_main-default']");
   private By headerLogo = By.xpath("//*[@class='AppHeader_header__logo__2D0X2']");

   public EnterPage clickOnRegisterButton(){
      driver.findElement(registerButton).click();
      return new EnterPage(driver);
   }

   public EnterPage clickOnEnterButton(){
      driver.findElement(enterButton).click();
      return new EnterPage(driver);
   }

   public void setNameToNameField(String name) {
      driver.findElement(nameField).sendKeys(name);
   }

   public void setEmailToEmailField(String email) {
      driver.findElement(emailField).sendKeys(email);
   }

   public void setPasswordToPasswordField(String password) {
      driver.findElement(passwordField).sendKeys(password);

   }
   public void setRegisterForm(String name, String email, String password) {
      setNameToNameField(name);
      setEmailToEmailField(email);
      setPasswordToPasswordField(password);
      clickOnRegisterButton();
   }
   public String getTextErrorPassword() {
      return driver.findElement(errorPassword).getText();
   }

   public MainPage clickOnHeaderButton() {
      driver.findElement(headerLogo).click();
      return new MainPage(driver);
   }
}
