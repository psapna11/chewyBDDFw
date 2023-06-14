package stepDef;

import base.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.login_page;




public class loginSteps extends Config {

   private static WebDriver driver;
    private static final String driverType = System.getProperty("browser");
   private login_page sp;




    @Before
    public void setup(){
        driver = setupBrowser (driverType);
        sp = new login_page(driver);

    }
    @After
    public void teardown(){
        if(driver!=null){
            // driver.quit();
        }}



    @Given("user on Target Homepage")
    public void userOnTargetHomepage() {
        driver.get("https://www.target.com/");
        driver.findElement(By.xpath("//*[@id='headerPrimary']/a[4]/span")).click();
        driver.findElement(By.xpath("//*[@id='listaccountNav-signIn']/a/span")).click();
    }
    @Given("user enter valid email address")
    public void user_enter_valid_email_address() {sp.enterEmailAddress(Email_Address);}
    @Given("user enter valid password")
    public void user_enter_valid_password() {sp.enterPassword(password);}
    @When("user clicks on Log In button")
    public void user_clicks_on_log_in_button() {sp.clickOnLoginButton();}

    @Then("user should be able to successfully login")
    public void user_should_be_able_to_successfully_login() { sp.verifyloggedInSuccessfully();}


    @And("login")
    public void login() {
        sp.enterEmailAddress(Email_Address);
        sp.enterPassword(password);
        sp.clickOnLoginButton();
    }

    @And("user enter invalid password")
    public void userEnterInvalidPassword() {
        sp.enterPassword("fakeemailPass");
        
    }

    @Then("user should be able see {string} message")
    public void userShouldBeAbleSeeMessage(String errorMsg) {
        sp.verifyErrorMessageForInvalidEmailOrPassword(errorMsg);
    }


    @And("user enter invalid email address")
    public void userEnterInvalidEmailAddress() {
        sp.enterEmailAddress("fakeemail1578@gmail.com");
    }
}
