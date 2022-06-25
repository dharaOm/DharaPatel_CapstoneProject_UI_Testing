package com.alexandnova.dharapatel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By loginPageTitle = By.cssSelector("#keyboard-nav-3 > h1");
    //*[@id="keyboard-nav-3"]/h1

    By loginEmailField = By.id("ispbxii_1");
    By loginPasswordField = By.name("customer[password]");
    By loginButton = By.xpath("//*[@id=\"customer_login\"]/div[3]/input");
    By welcomeMessage = By.xpath("//*[@id=\"keyboard-nav-3\"]/h1");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLoginEmail(String email)
    {
        driver.findElement(loginEmailField).sendKeys(email);
    }
    public void setInvalidLoginEmail(String invalidEmail)
    {
        driver.findElement(loginEmailField).sendKeys(invalidEmail);
    }
    public void setLoginPassword(String password)
    {
        driver.findElement(loginPasswordField).sendKeys(password);
    }
    public void setInvalidLoginPassword(String wrongPass)
    {
        driver.findElement(loginPasswordField).sendKeys(wrongPass);
    }
    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
    }
    public String getWelcomeNewUserMessage()
    {
        return driver.findElement(welcomeMessage).getText();
    }

    public String verifyPageTitle()
    {
        return driver.findElement(loginPageTitle).getText();
    }



}
