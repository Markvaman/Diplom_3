import Api.User;
import Api.UserMethods;
import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTests {
    private WebDriver driver;
    private static User user;
    private static UserMethods userMethods;
    private static String accessToken;
    public static Faker faker = new Faker();
    static String email = faker.name().lastName() + "@mail.ru";
    static String password = faker.internet().password();
    static String name = faker.name().firstName();

    @BeforeClass
    public static void createUser() {
        userMethods = new UserMethods();
        ValidatableResponse response = userMethods.create(name, email, password);
        accessToken = response.extract().path("accessToken").toString();
    }

    @Before
    public void openStellaBurger() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdriver/bin/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    }

    @Test
    public void loginClickEnterButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        EnterPage objEnterPage = new EnterPage(driver);
        objMainPage.clickOnEnterButton();
        objEnterPage.setEnterForm(email, password);
        String actual = objMainPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", actual);


    }

    @Test
    public void loginClickAccountButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnAccountButton();
        EnterPage objEnterPage = new EnterPage(driver);
        objEnterPage.setEnterForm(email, password);
        String actual = objMainPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", actual);
    }

    @Test
    public void loginClickRegisterButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnEnterButton();
        EnterPage objEnterPage = new EnterPage(driver);
        objEnterPage.clickOnRegisterButton();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.clickOnEnterButton();
        objEnterPage.setEnterForm(email, password);
        String actual = objMainPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", actual);
    }

    @Test
    public void loginClickForgetPasswordButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnEnterButton();
        EnterPage objEnterPage = new EnterPage(driver);
        objEnterPage.clickOnForgetPasswordButton();
        ChangePassPage objChangePassPage = new ChangePassPage(driver);
        objChangePassPage.clickToEnterButton();
        objEnterPage.setEnterForm(email, password);
        String actual = objMainPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", actual);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void deleteUser() {
        userMethods.delete(accessToken);
    }

}
