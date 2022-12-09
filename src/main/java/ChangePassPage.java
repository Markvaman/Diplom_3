import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassPage {
    private WebDriver driver;
    public ChangePassPage(WebDriver driver) {
        this.driver = driver;
    }

    private By enterButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");

    public void clickToEnterButton() {
        driver.findElement(enterButton).click();
    }
}
