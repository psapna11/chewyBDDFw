package stepDef;

import base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObject.signup_page;

public class SignupSteps extends Config {
    //create an object of signup_page class to use the locators from there
    signup_page su = new signup_page(driver);
    @And("user clicks on {string} button")
    public void user_clicks_on_button(String createButton) {
        su.createAccountButton();
    }

    @And("user enter their valid email address")
    public void user_enter_their_valid_email_address() {
        su.enterEmail();
    }

    @And("user enters First and Last Name")
    public void user_enters_first_and_last_name() {
       su.enterFirstName();
       su.enterLastName();
    }

    @And("user enter Password")
    public void user_enter_password() {
       su.enterPassword();
    }

    @When("user clicks on Create my account button")
    public void userClicksOnCreateMyAccountButton() {
        su.submitButton();
    }
    @And("user clicks on {string}")
    public void userClicksOn(String JF) {
        su.joinFreeButton();
    }


    @Then("user should be able to successfully Create Target Account")
    public void userShouldBeAbleToSuccessfullyCreateTargetAccount() {
        String act = driver.getTitle();
        String exp = "Login: Target";
        Assert.assertEquals(act, exp);

    }
}


