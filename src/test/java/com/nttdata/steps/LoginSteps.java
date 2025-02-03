package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSteps {
    private WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void typeUser(String user) {
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
    }

    public void typePassword(String password) {
        driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    public void login() {
        driver.findElement(LoginPage.loginButton).click();
    }

}
