package pageObject;

import base.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class login_page extends Config {
    private WebDriver driver;

    public login_page(WebDriver driver) {


        PageFactory.initElements(driver, this);
        Config.driver = driver;
    }


    //Locators
    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    public WebElement emailLocator;
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    public WebElement passwordLocator;
    @FindBy(how = How.XPATH, using = "//button[@id='login']")
    public WebElement loginButtonLocator;

    @FindBy(how = How.XPATH, using = "//*[@id='headerPrimary']/a[4]/span")
    public WebElement welcomeMsgLocator;
    @FindBy(how = How.XPATH, using = "//*[@id='__next']/div/div/div[1]/div/div[2]/div/div")
    public WebElement invalidEmailOrPassErrorMsgLocator;

    //*[@id="__next"]/div/div/div[1]/div/div[2]/div/div
    //*[@id="__next"]/div/div/div[1]/div/div[2]/div/div
    //*[@id="__next"]/div/div/div[1]/div/div[2]/div/div
    //method
    public void enterEmailAddress(String email) {
        emailLocator.sendKeys(email);
    }

    public void enterPassword(String pass) {
        passwordLocator.sendKeys(pass);
    }

    public void clickOnLoginButton() {
        loginButtonLocator.click();
    }
    //public void clickOnSkipMobilePhone(){SkipButtonLocator.click();}
    // public void clicksOnSkipBenefits(){SkipBenefitButtonLocator.click();}

    public void verifyloggedInSuccessfully() {
        String act = welcomeMsgLocator.getText();
        String exp = "Hi, ssss";
        Assert.assertEquals(act, exp);
    }

        public void verifyErrorMessageForInvalidEmailOrPassword(String errorMsg){
            String fullText = invalidEmailOrPassErrorMsgLocator.getText();
            String act = fullText.substring(1, fullText.length()-1);
            Assert.assertEquals(act, errorMsg);
        }

    }



