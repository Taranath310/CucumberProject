package org.firecrowd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By emailInputLocator = By.id("email");
    private By passwordInputLocator = By.id("email-helper-text");
    private By loginButtonLocator = By.xpath("//button[text()='Sign in']");
    private By allProjectsTitle = By.xpath("//div[@class='col-span-8 header_text pl-4 pt-2']");
    private By allSampleLinks = By.xpath("//div[@class='col-span-8 header_text pl-4 pt-2']");


    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }
    //above method will enter the given password

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean verifyUserLoggedInSuccessfully(){
        return driver.findElement(allProjectsTitle).isDisplayed();
    }

}
