package com.alexandnova.dharapatel.testcases;

import com.alexandnova.dharapatel.pages.LoginPage;
import com.alexandnova.dharapatel.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginNegativeTest extends BaseTest{

    LoginPage loginPage;

    RegistrationPage registrationPage;

    @Test(priority = 7)
    public void tc0007_login_with_invalid_credentials_test() throws InterruptedException {
        driver.get("https://www.alexandnova.com/account/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        loginPage = new LoginPage(driver);
        loginPage.setInvalidLoginEmail("Testing@gmail.com");
        loginPage.setInvalidLoginPassword("pass");
        loginPage.clickLoginButton();
        Thread.sleep(20000);
        registrationPage= new RegistrationPage(driver);
        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = registrationPage.getInvalidEmailErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage);

    }
}



