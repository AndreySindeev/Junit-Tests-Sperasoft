import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AuthenticationPageTests {

    private WebDriver driver;
    private AuthenticationPage authPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\IdeaProjects\\SeleniumTest\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        authPage = new AuthenticationPage(driver);



    }



    @Test
    public void signInFailTest(){


        authPage.autWithInvaildCreds("test", "12738");
        String errorLogin =  authPage.getErrorText();
        Assert.assertEquals("Invalid email address.", errorLogin);

    }

    @Test
    public void signInSuccessTest(){
        authPage.authWithValidCreds("21412@mail.com", "8LwX6eL5TXvYbzY");
    }

    @Test
    public void createAccountWithInvalidEmail(){
        authPage.typeNewEmail("test1");
        authPage.clickCreateAccBtn();
        String errorText = authPage.getErrorTextCreateAcc();
        Assert.assertEquals("Invalid email address.", errorText);


    }

    @Test
    public void createAccountWithValidEmail(){
        authPage.typeNewEmail("randomMan@gmail.com");
        authPage.clickCreateAccBtn();
    }



}
