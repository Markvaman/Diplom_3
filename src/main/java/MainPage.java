import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //кнопка Войти ClassName button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg
    private By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка Личный кабинет
    private By accountButton = By.xpath("//*[@href='/account']");
    //кнопка Конструктор xpath AppHeader_header__linkText__3q_va ml-2
    private By constructorButton = By.xpath("//*[text()='Конструктор']");
    //кнопка Логотип classname AppHeader_header__logo__2D0X2
    private By headerLogo = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка Булочки в конструкторе className tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect
    private By bunsButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Булки']/parent::div");
    //Кнопка Соусы
    private By saucesButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Соусы']/parent::div");
    //Кнопка Начинки
    private By fillingButton = By.xpath(".//span[@class = 'text text_type_main-default' and text()='Начинки']/parent::div");
    //Форма конструктора
    private By constructorField = By.className("BurgerIngredients_ingredients__menuContainer__Xu3Mo");



    public void clickOnEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void clickOnAccountButton() {
        driver.findElement(accountButton).click();

    }

    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickOnHeaderButton() {
        driver.findElement(headerLogo).click();
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

}
