package com.alexandnova.dharapatel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClearancePage {

    WebDriver driver;

    By selectProduct = By.linkText("Skipper Mesh First Walker Sneakers Shoes");

    public ClearancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProduct()
    {
        driver.findElement(selectProduct).click();
    }


}
