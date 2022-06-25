package com.alexandnova.dharapatel.testcases;

import com.alexandnova.dharapatel.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest{

    LoginPage loginPage;


    @Test(priority = 6)
    public void tc0006_login_with_valid_credentials_test() throws InterruptedException, IOException {

        driver.get("https://www.alexandnova.com/account/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        loginPage = new LoginPage(driver);
        loginPage.setLoginEmail("IamTesting@gmail.com");
        loginPage.setLoginPassword("P@ssword");
        loginPage.clickLoginButton();
        Thread.sleep(2000);

        String expectedMessage = "Welcome, John";
        String actualMessage = loginPage.getWelcomeNewUserMessage();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

}

