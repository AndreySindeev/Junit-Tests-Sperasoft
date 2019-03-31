import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

//test for main page
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\IdeaProjects\\SeleniumTest\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php");

        mainPage = new MainPage(driver);

    }

    @Test
    public void checkAuthemticationPage(){
        /*
        Что бы получить переход на AuthPage
        мы вызываем clickSignInPage из метода mainPage,
        который и возвращает нам AuthenticationPage
        */
        AuthenticationPage authPage = mainPage.clickSignIn();
        String heading = authPage.getHeadingText();
        Assert.assertEquals("AUTHENTICATION", heading);

    }



/*
    @After
    public void tearDown(){
        driver.quit();
    }
*/
}
