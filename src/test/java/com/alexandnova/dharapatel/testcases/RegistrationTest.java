package com.alexandnova.dharapatel.testcases;

import com.alexandnova.dharapatel.pages.HomePage;
import com.alexandnova.dharapatel.pages.LoginPage;
import com.alexandnova.dharapatel.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class RegistrationTest  extends BaseTest{

    HomePage homePage;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @BeforeClass
    public void launch_application() {
        driver.get("https://www.alexandnova.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }
    @Test(priority = 1)
    public void tc0001_new_user_registration_page_test() throws IOException {

            homePage = new HomePage(driver);
            homePage.clickAccountLink();
            registrationPage = new RegistrationPage(driver);
            registrationPage.clickRegisterButton();

            String actualPageTitle = registrationPage.checkSignUpPageTitle();
            String expectedPageTitle = "Sign up";
           Assert.assertEquals(actualPageTitle ,expectedPageTitle);

    }
    @Test(priority = 2,enabled = true)
    public void tc0002_new_user_registration_test() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickAccountLink();
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterButton();
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Fink");
        registrationPage.setEmail("IamTesting17@gmail.com");
        registrationPage.setPassword("P@ssword");
        registrationPage.createNewUser();
        Thread.sleep(800);
        loginPage =new LoginPage(driver);

        String actualPageTitle = loginPage.verifyPageTitle();
        String expectedPageTitle = "Log in";

        Assert.assertEquals(actualPageTitle ,expectedPageTitle);
        System.out.println(actualPageTitle);


    }




}













//driver.findElement(By.id("navigation-home")).click();
