import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    WebDriver driver;
    public MyAccountPage(WebDriver driver){
        this.driver = driver;
    }

    private By homepage = By.xpath("//*[@id='center_column']/ul/li/a");
    private By heading = By.xpath("//*[@id='center_column']/h1");

    public MainPage clickHomeButton(){
        driver.findElement(homepage).click();
        return new MainPage(driver);
    }


    public String getTextInAccount(){

        return driver.findElement(heading).getText();
    }



}
