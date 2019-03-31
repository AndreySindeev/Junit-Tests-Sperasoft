import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CreateNewAccountTests {

    private WebDriver driver;
    private PersonalInformation information;
    private AuthenticationPage authPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\IdeaProjects\\SeleniumTest\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");

        information = new PersonalInformation(driver);
        authPage = new AuthenticationPage(driver);

        authPage.enterOnNewAccountPage("testUser123456788@yahoo.com");





    }


    @Test
    public void createNewAccountSuccess(){
        information.selectGender();
        information.typeFirstName("Gena");
        information.typeLastName("Bukin");
        information.typePassword("random1987");
        information.selectDateOfBirth();
        information.typeAddr("103 Student Drive, PO BOX 2603,North West Council of Local Governments");
        information.typeCity("Baltimor");
        information.selectState();
        information.typePostCode("36118");
        information.selectCountry();
        information.typeAddirionalInformation("random text Lorem Ipsum!");
        information.typeHomePhone("+1-541-754-3020");
        information.typeMobilePhone("+1-541-754-3020");
        information.Allias("North West Council of Local Governments");
        information.clickRegisterButton();

    }


}
