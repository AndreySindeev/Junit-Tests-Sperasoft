import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;

    // Конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");



    public AuthenticationPage clickSignIn(){
        driver.findElement(signInButton).click();
        return  new AuthenticationPage(driver);
    }



}
