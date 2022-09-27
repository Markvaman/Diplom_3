import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class ConstructorTests {
    public static WebDriver driver;
    String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    @Before
    public void openStellaBurger() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdriver/bin/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }
    @Test
    public void bunMenuTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnFilling();
        objMainPage.clickOnBun();
        Assert.assertEquals(expected, objMainPage.getClassNameBun());
    }
    @Test
    public void sauceMenuTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnFilling();
        objMainPage.clickOnSauce();
        Assert.assertEquals(expected, objMainPage.getClassNameSauce());
    }
    @Test
    public void fillingMenuTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSauce();
        objMainPage.clickOnFilling();
        Assert.assertEquals(expected, objMainPage.getClassNameFilling());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
