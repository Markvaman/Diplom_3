import Api.UserMethods;
import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AccountTests {
    private static UserMethods userMethods;
    private static String accessToken;
    private static WebDriver driver;
    static Faker faker = new Faker();
    static String name = faker.name().firstName();
    static String email = faker.internet().emailAddress();
    static String password = faker.internet().password(6, 10);

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

        MainPage objMainPage = new MainPage(driver);
        EnterPage objEnterPage = new EnterPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objMainPage.clickOnEnterButton();
        objEnterPage.setEnterForm(email, password);
        objRegisterPage.clickOnHeaderButton();
    }

    @Test
    public void openUserAccountToClickAccountButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAccountButtonForLoginUser();
        String actual = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account/profile", actual);
    }

    @Test
    public void openConstructorToClickConstructorButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAccountButtonForLoginUser();
        objMainPage.clickOnConstructorButton();
        String actual = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", actual);
    }

    @Test
    public void openConstructorToClickHeaderButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAccountButtonForLoginUser();
        objMainPage.clickOnLogoButton();
        String actual = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", actual);
    }

    @Test
    public void exitUserAccountTest() {
        MainPage objMainPage = new MainPage(driver);
        EnterPage objEnterPage = new EnterPage(driver);
        objMainPage.clickAccountButtonForLoginUser();
        objEnterPage.clickExitButton();
        String actual = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", actual);
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
