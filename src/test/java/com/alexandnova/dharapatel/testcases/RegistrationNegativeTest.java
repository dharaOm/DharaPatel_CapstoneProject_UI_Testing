package com.alexandnova.dharapatel.testcases;

import com.alexandnova.dharapatel.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationNegativeTest extends BaseTest{

    RegistrationPage registrationPage;


    @Test(priority = 3)
    public void tc0003_register_with_invalid_email_test(){
        driver.get("https://www.alexandnova.com/account/register");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Fink");
        registrationPage.setInvalidEmail("Testing@gmailcom");
        registrationPage.setPassword("P@ssword");
        registrationPage.createNewUser();

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = registrationPage.getInvalidEmailErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test(priority = 4)
    public void tc0004_registration_with_mandatory_field_blank_test(){
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();
        registrationPage.setFirstNameBlank("");
        registrationPage.setLastName("Fink");
        registrationPage.setEmail("IamTesting@gmail.com");
        registrationPage.setPassword("P@ssword");
        registrationPage.createNewUser();

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = registrationPage.getInvalidEmailErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage);

    }
    @Test(priority = 5)
    public void tc0005_register_with_invalid_password_test() throws InterruptedException {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();
        Thread.sleep(400);
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Fink");
        registrationPage.setEmail("IamTesting@gmail.com");
        registrationPage.setInvalidPassword("pass");
        registrationPage.createNewUser();
        Thread.sleep(300);

        String expectedMessage = "Sorry! Please try that again.";
        String actualMessage = registrationPage.getInvalidEmailErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

}

