package org.firecrowd.stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.firecrowd.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.security.PrivateKey;

public class LoginPageStepDef {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("http://app.firecrowd.com/");
    }

    @Given("I have entered valid {string} and {string}>")
    public void i_have_entered_valid_and(String string, String string2) {
        loginPage=new LoginPage(driver);
        loginPage.login(string,string2);
    }

    @When("I clicked on signin button")
    public void i_clicked_on_signin_button() {
      loginPage.clickLoginButton();
    }

    @Then("I should logged in successfully")
    public void i_should_logged_in_successfully() {
        Assert.assertEquals(loginPage.verifyUserLoggedInSuccessfully(),true);
    }
}
