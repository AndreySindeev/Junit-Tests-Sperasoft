import org.omg.CORBA.PERSIST_STORE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage {

    WebDriver driver;

    public AuthenticationPage(WebDriver driver){
        this.driver = driver;
    }

    /*
        Для перехода на страницу создания аккаунта
     */
    private By EmailFieldforCreateAccount = By.xpath(".//*[@id='email_create']");
    private By createAccountButton = By.xpath(".//*[@id='SubmitCreate']");

    /*
        Для перехода в существующий профиль
     */

    private By alreadyRegistredEmailField = By.xpath(".//*[@id='email']");
    private By alreadyTextfieldPassword = By.xpath("//*[@id='passwd']");
    private By SignInButtonOnAuthPAge = By.xpath(".//*[@id='SubmitLogin']");

    /*
        Для проверки что находимся на странице аутентификации
     */

    private By headingText = By.xpath("//div[contains(@class, 'center_column')]/h1");

    //при неправильном логине появляется данный элемент
    private By error = By.xpath("//*[@id='center_column']/div[1]/ol/li");

    //при неправильном указании email когда хотим создать новый аккаунт.
    private By errorMail = By.xpath("//*[@id='create_account_error']/ol/li");


    public AuthenticationPage typeEmail(String email){
        driver.findElement(alreadyRegistredEmailField).sendKeys(email);
        return this;
    }

    public AuthenticationPage typePassword(String password){
        driver.findElement(alreadyTextfieldPassword).sendKeys(password);
        return this;
    }

    public AuthenticationPage autWithInvaildCreds(String email, String password){
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(SignInButtonOnAuthPAge).click();
        return new AuthenticationPage(driver);
    }

    public MyAccountPage authWithValidCreds(String email, String password){
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(SignInButtonOnAuthPAge).click();
        return new MyAccountPage(driver);
    }


    public String getHeadingText(){
        return driver.findElement(headingText).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public AuthenticationPage typeNewEmail(String neweMail){
        driver.findElement(EmailFieldforCreateAccount).sendKeys(neweMail);
        return this;
    }

    public PersonalInformation clickCreateAccBtn(){
        driver.findElement(createAccountButton).click();
        return new PersonalInformation(driver);
    }

    public String getErrorTextCreateAcc(){
        return driver.findElement(errorMail).getText();
    }

    public PersonalInformation enterOnNewAccountPage(String email){
        this.typeNewEmail(email);
        this.clickCreateAccBtn();
        return new PersonalInformation(driver);
    }

}
