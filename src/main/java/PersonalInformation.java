import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class PersonalInformation {

    WebDriver driver;

    public PersonalInformation(WebDriver driver){
        this.driver = driver;
    }

    private By genderMale = By.xpath(".//*[@id='uniform-id_gender1']");
    private By firstName = By.xpath(".//*[@id='customer_firstname']");
    private By lastName = By.xpath(".//*[@id='customer_lastname']");
    private By passwd = By.xpath(".//*[@id='passwd']");
    private By day = By.xpath("//*[@id='days']/option[2]");
    private By month = By.xpath("//*[@id='months']/option[2]");
    private By year = By.xpath("//*[@id='years']/option[26]");
    private By addr = By.xpath(".//*[@id='address1']");
    private By city = By.xpath(".//*[@id='city']");
    private By state = By.xpath("//*[@id='id_state']/option[6]");
    private By postcode = By.xpath("//*[@id='postcode']");
    private By country = By.xpath("//*[@id='id_country']/option[2]");
    private By additionalInformation = By.xpath("//*[@id='other']");
    private By mobilePhone = By.xpath("//*[@id='phone_mobile']");
    private By allias = By.xpath("//*[@id='alias']");
    private By registerButton = By.xpath(".//*[@id='submitAccount']");

    public PersonalInformation selectGender(){
        driver.findElement(genderMale).click();
        return this;
    }

    public PersonalInformation typeFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
        return this;
    }
    public PersonalInformation typeLastName(String lastname){
        driver.findElement(lastName).sendKeys(lastname);
        return this;
    }
    public PersonalInformation typePassword(String password){
        driver.findElement(passwd).sendKeys(password);
        return this;
    }
    public PersonalInformation selectDateOfBirth(){
        driver.findElement(day).click();
        driver.findElement(month).click();
        driver.findElement(year).click();
        return this;
    }

    public PersonalInformation typeAddr(String address){
        driver.findElement(addr).sendKeys(address);
        return this;
    }

    public PersonalInformation typeCity(String cityName){
        driver.findElement(city).sendKeys(cityName);
        return this;
    }
    public PersonalInformation selectState(){
        driver.findElement(state).click();
        return this;
    }

    public PersonalInformation typePostCode(String postcodeNumber){
        driver.findElement(postcode).sendKeys(postcodeNumber);
        return this;
    }

    public PersonalInformation selectCountry(){
        driver.findElement(country).click();
        return this;
    }

    public PersonalInformation typeAddirionalInformation(String randomText){
        driver.findElement(additionalInformation).sendKeys(randomText);
        return this;
    }

    public PersonalInformation typeMobilePhone(String mobphone){
        driver.findElement(mobilePhone).sendKeys(mobphone);
        return this;
    }

    public PersonalInformation Allias(String alliasAddress){
        driver.findElement(allias).sendKeys(alliasAddress);
        return this;
    }

    public MyAccountPage clickRegisterButton(){
        driver.findElement(registerButton).click();
        return new MyAccountPage(driver);
    }

    public PersonalInformation typeHomePhone(String homePhone) {
        driver.findElement(mobilePhone).sendKeys(homePhone);
        return this;
    }
}
