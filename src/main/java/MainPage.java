import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //кнопка Войти ClassName button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg
    private By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка Личный кабинет
    private By accountButton = By.xpath("//*[@href='/account']");
    //кнопка Логотипа
    private By headerLogo = By.xpath("//*[@class='AppHeader_header__logo__2D0X2']");
    //кнопка Оформить заказ
    private By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    //кнопка Конструктор xpath AppHeader_header__linkText__3q_va ml-2
    private By constructorButton = By.xpath("//*[text()='Конструктор']");

    //Кнопка Булочки в конструкторе className tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect
    private By bunsButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Булки']/parent::div");
    //Кнопка Соусы
    private By saucesButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Соусы']/parent::div");
    //Кнопка Начинки
    private By fillingButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Начинки']/parent::div");
    //Форма конструктора



    public void clickOnLogoButton() {
        driver.findElement(headerLogo).click();
    }

    public EnterPage clickOnEnterButton() {
        driver.findElement(enterButton).click();
        return new EnterPage(driver);
    }

    public EnterPage clickOnAccountButton() {
        driver.findElement(accountButton).click();
        return new EnterPage(driver);
    }

    public EnterPage clickAccountButtonForLoginUser() {
        driver.findElement(accountButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class ='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']")));
        return new EnterPage(driver);
    }

    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public String getClassNameBun() {
        return driver.findElement(bunsButton).getAttribute("class");
    }

    public String getClassNameSauce() {
        return driver.findElement(saucesButton).getAttribute("class");
    }

    public String getClassNameFilling() {
        return driver.findElement(fillingButton).getAttribute("class");
    }

    public String getTextOrderButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver.findElement(orderButton).getText();
    }

    public void clickOnBun() {
        driver.findElement(bunsButton).click();
    }
    public void clickOnSauce() {
        driver.findElement(saucesButton).click();
    }
    public void clickOnFilling() {
        driver.findElement(fillingButton).click();
    }

}
