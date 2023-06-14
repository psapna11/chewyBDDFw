package pageObject;

import base.Config;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class signup_page extends Config {
    //Create a constructor of this class
    public signup_page(WebDriver driver){
        PageFactory.initElements(driver,this);
        Config.driver=driver;
    }
    //Java faker class object

    Faker faker = new Faker();

    //Locator
    @FindBy(how = How.ID,using = "createAccount")
    public WebElement createButtonLocator;
    @FindBy(how = How.ID, using = "username")
    public WebElement emailLocator;
    @FindBy(how = How.ID, using = "firstname")
    public WebElement fnLocator;
    @FindBy(how = How.ID, using = "lastname")
    public WebElement lnLocator;
    @FindBy(how = How.ID,using = "password")
    public WebElement passwordLocator;
    @FindBy(how = How.ID,using = "createAccount")
    public  WebElement submitButtonLocator;
    @FindBy(how = How.ID, using = "circle-join-free")
    public WebElement joinFreeButtonLocator;






    // Functions
    public void createAccountButton(){createButtonLocator.click();}
    public void enterEmail() {
    //emailLocator.sendkeys(faker.internet().emailAddress();
        String gmail_domain = "@gmail.com";
        String firstName = faker.name().firstName().toLowerCase();
        String lastName = faker.name().lastName().toLowerCase();
        String randumNum = faker.number().digits(6);
        String fullEmail = firstName + lastName + randumNum + gmail_domain;
        System.out.println(fullEmail);
        emailLocator.sendKeys(fullEmail);}

        public void enterFirstName(){fnLocator.sendKeys(faker.name().firstName());}
        public void enterLastName(){lnLocator.sendKeys(faker.name().lastName());}

        public void enterPassword() {
        String pass = faker.internet().password(8, 12);
        passwordLocator.sendKeys(pass);}
        public void submitButton() {submitButtonLocator.click();}
        public void joinFreeButton(){joinFreeButtonLocator.click();}

        }

