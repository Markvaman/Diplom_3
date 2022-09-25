import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //кнопка Войти ClassName button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg
    private By enterButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg");
    //кнопка Личный кабинет ClassName AppHeader_header__linkText__3q_va ml-2
    private By accountButton = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный кабинет']");
    //кнопка Конструктор xpath AppHeader_header__linkText__3q_va ml-2
    private By constructorButton = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text = 'Конструктор']");
    //кнопка Логотип classname AppHeader_header__logo__2D0X2
    private By headerLogo = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка Булочки в конструкторе className tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect
    private By bunsButton = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Булки']");
    //Кнопка Соусы
    private By sousesButton = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Соусы']");
    //Кнопка Начинки
    private By fillingButton = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Начинки']");
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

}
