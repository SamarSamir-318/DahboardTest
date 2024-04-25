package org.example.Pages;
import org.example.Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class LoginPage{

    private WebDriver driver;

    //webelement required in the login page screen
    WebElement usernameField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    WebElement loginButton = driver.findElement(By.className("Button_root__0RbKd"));
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    // Method to click login button
    public void clickLoginButton() {
        loginButton.click();
    }

    Public void Completelogin()
    {
        enterUsername('TestUser');
        enterPassword('s8IfNMhKr');
        clickLoginButton();
        clickSkipButtonforTest();
    }

    public void clickSkipButtonforTest() {
        // Click on the "skip" button
        WebElement skipButton = driver.findElement(By.className("Button_root__0RbKd"));
        skipButton.click();
    }
}