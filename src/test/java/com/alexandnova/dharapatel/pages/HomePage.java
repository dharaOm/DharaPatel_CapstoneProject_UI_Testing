package com.alexandnova.dharapatel.pages;

import com.alexandnova.dharapatel.testcases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class HomePage {

    WebDriver driver;

    By accountButton = By.id("customer_login_link");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccountLink ()
    {
        driver.findElement(accountButton).click();
        //Assert.assertTrue(driver.findElement(By.xpath("h1[contains(text(),'Log in'")).isDisplayed());
    }

    //h1[contains(text(),'Log in')]



}
