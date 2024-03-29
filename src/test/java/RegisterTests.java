import com.github.javafaker.Faker;
import Api.UserMethods;
import Api.User;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegisterTests {
    private WebDriver driver;
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(6, 10);
    String passwordInvalid = faker.internet().password(1, 5);


    @Before
    public void openStellaBurger() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdriver/bin/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }


    @Test
    public void registerIsSuccessfulWithValidPassword() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnAccountButton();

        EnterPage objEnterPage = new EnterPage(driver);
        objEnterPage.clickOnRegisterButton();

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.setRegisterForm(name, email, password);
        objRegisterPage.clickOnRegisterButton();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", objEnterPage.getPageUrl());

        User user = new User(email, password);
        UserMethods userMethods = new UserMethods();
        ValidatableResponse response = userMethods.login(user);
        String accessToken = response.extract().path("accessToken");
        userMethods.delete(accessToken);

    }

    @Test
    public void registerIsImpossibleWithIncorrectPasswordTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnAccountButton();

        EnterPage objEnterPage = new EnterPage(driver);
        objEnterPage.clickOnRegisterButton();

        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.setRegisterForm(name, email, passwordInvalid);
        objRegisterPage.clickOnRegisterButton();
        String actual = objRegisterPage.getTextErrorPassword();
        Assert.assertEquals("Некорректный пароль", actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
